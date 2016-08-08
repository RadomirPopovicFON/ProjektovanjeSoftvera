package db;

import domen.Mesto;
import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Prijava;
import domen.Student;
import domen.StudentPredmet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnalogika.Kontroler;
import util.FileUtil;

/**
 *
 * @author student1
 */
public class DatabaseBroker {

    private Connection connection;
    private static DatabaseBroker instance;
    
    private DatabaseBroker() {
        try {
            ucitajDriver();
            otvoriKonekciju();
        } catch (Exception ex) {
            System.out.println("Greska u konstruktoru");
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static DatabaseBroker getInstance() {
        if (instance == null) {
            instance = new DatabaseBroker();
        }
        return instance;
    }

    public void ucitajDriver() throws Exception {
        Class.forName(FileUtil.getInstance().get("driver"));
    }

    public void otvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection(FileUtil.getInstance().get("url"),
                    FileUtil.getInstance().get("user"), FileUtil.getInstance().get("password"));
            connection.setAutoCommit(false);
            // Zahteva eksplicitnu potvrdu transakcije
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }

    public void obrisi(OpstiDomenskiObjekat o) throws Exception{
        Statement stmt = null;
        String naziv = o.getIdKlase();
        try
        {
            stmt = connection.createStatement();
            stmt.execute("DELETE FROM "+o.vratiNazivTabele()+" WHERE "+naziv);
            
        } 
        catch (Exception e) {
            throw new Exception("Neuspesno brisanje studenta!", e);
        }
    }
    
    public void izmeni(OpstiDomenskiObjekat o) throws SQLException, Exception{
        String naziv = o.vratiNazivTabele();
        
        int kejs = 1;
        if(naziv.equals("Student")) kejs = 1;
        if(naziv.equals("StudentPredmet")) kejs = 2;
        if(naziv.equals("Prijava")) kejs = 3;
        
        System.out.println("Usao u metodu menjanja");
        try
        {
            PreparedStatement ps = null;
            switch(kejs){
                case 1: 
                    System.out.println("Menjanje studenta");
                    ps = connection.prepareStatement(
            "UPDATE Student SET StudentID = ?, brIndeksa = ?, Ime = ?, Prezime = ?, godina = ?, smer=?, "
                    + "JMBG = ?, Kontakt = ?, "
                    + "Mail = ?, Ulica = ?, Broj = ?, MestoID = ? WHERE StudentID = "+((Student)o).getStudentID());
            
            
                    
            Student s = (Student)o;
            ps.setInt(1,s.getStudentID());
            ps.setInt(5,s.getGodina());
            ps.setInt(7,s.getJMBG());
            ps.setInt(11,s.getM().getId());
            ps.setString(2,s.getBrIndeksa());
            ps.setString(3,s.getIme());
            ps.setString(4,s.getPrezime());
            ps.setString(6,s.getSmer());
            ps.setString(8,s.getKontakt());
            ps.setString(9,s.getMail());
            ps.setString(10,s.getUlica());
            ps.setString(11,s.getBroj());  
            ps.setInt(12, s.getM().getId());
                    System.out.println("UPIT:");
            System.out.println(""+ps.toString());
            
            ps.executeUpdate();
            ps.close(); break;     
                case 2: 
                    System.out.println("Menjanje predmeta za slusanje");
                    int stID = ((StudentPredmet)o).getS().getStudentID();
                    int prID = ((StudentPredmet)o).getP().getPredmetID();
                    ps = connection.prepareStatement(
            "UPDATE StudentPredmet SET predmetID = ? "
                    + " WHERE idPrijavljenogPredmeta = "
                    +((StudentPredmet)o).getId());
            StudentPredmet sp = ((StudentPredmet)o);
                   
            ps.setInt(1, sp.getPrivremeni().getPredmetID());
            System.out.println(""+ps.toString());
            ps.executeUpdate();
            ps.close();
           // System.out.println(""+ps.toString());
            break; 
                    
                case 3: 
                    System.out.println("Upis ocene");
                    Prijava prijava = ((Prijava)o);
                    ps = connection.prepareStatement(
            "UPDATE Prijava SET ocena = ? WHERE predmetID = " 
                    + prijava.getP().getPredmetID()+" AND ispitniRokID = "+prijava.getR().getIspitniRokID());
                ps.setInt(1, prijava.getOcena());
                    System.out.println("<> "+ps.toString());
                ps.executeUpdate();
                ps.close(); 
                System.out.println(""+ps.toString());
                break;
            }
        }
        catch (SQLException se)
        {
             Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, se);
          // log the exception
          throw new Exception("Neuspesno menjanje",se);
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        
        try {
            String sql = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
            if(odo.vratiNazivTabele()=="StudentPredmet")
                sql = "INSERT INTO " + odo.vratiNazivTabele() + "(`StudentID`,`predmetID`) VALUES (" + odo.vratiVrednostiZaInsert() + ")";
            System.out.println("Naredba je dakle: "+sql);
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } 
                catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno cuvanje objekta!", ex);
        }
//        catch (SQLException ex) {
//            
//            throw new Exception("Neuspesno cuvanje objekta!", ex);
//        }
//        catch (SQLException ex) {
//            
//            throw new Exception("Neuspesno cuvanje objekta!", ex);
//        }
    }
    public void obrisi(OpstiDomenskiObjekat odo,int idParametar) throws Exception {
//        System.out.println("id parametar: "+idParametar);
//        System.out.println("odo je: "+odo);
        try {
            String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE " + odo.getIdKlase()+ "="+idParametar;
            System.out.println("Naredba je dakle: "+sql);
            Statement sqlStatement = connection.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } 
        catch (SQLException ex) {
            
            throw new Exception("Neuspesno brisanje!", ex);
        }
    }
    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele();
            System.out.println("Naredba: "+sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    public List<OpstiDomenskiObjekat> vratiSveJoin(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat odo2) throws Exception {
        try {
            
            String sql = "SELECT t1.*, t2.*"
                    + " FROM "+odo.vratiNazivTabele()+" t1 join "+odo2.vratiNazivTabele()+" t2 on(t1."+odo.getSpoljniKljucKlase()+"=t2."+odo2.getIdKlase()+")";
            //sql = "SELECT * FROM "+odo.vratiNazivTabele()+", "+odo2.vratiNazivTabele();
            if(odo.vratiNazivTabele()=="StudentPredmet"){
                Student s = ((StudentPredmet)odo).getS();
                sql = "SELECT t1.*, t2.*, t3.*"
                    + " FROM "+odo.vratiNazivTabele()+
                        " t1 inner join "+odo2.vratiNazivTabele()+
                        " t2 on(t1."+odo2.getIdKlase()+"=t2."+odo2.getIdKlase()+")"+
                        " inner join "+s.vratiNazivTabele()+
                        " t3 on(t1."+s.getIdKlase()+"=t3."+s.getIdKlase()+")";
            }
            System.out.println("Naredba: "+sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    public List<OpstiDomenskiObjekat> vratiSveJoin2(OpstiDomenskiObjekat odo, OpstiDomenskiObjekat odo2,
            OpstiDomenskiObjekat odo3,OpstiDomenskiObjekat odo4) throws Exception {
        try {
            
            //NAPRAVLJENO ZA POTREBU PRIJAVE, DRUGACIJI JOIN!!!!
            //SELECT t1.*, t2.*, t3.* FROM Student t1 inner join Predmet t2 on(t1.StudentID=t2.predmetID) inner join Prijava t3 on(t2.predmetID=t3.predmetID)
            String sql = "SELECT t1.*, t2.*, t3.*, t4.*"
                    + " FROM "+odo.vratiNazivTabele()+" t1 "
                    +" inner join "+odo2.vratiNazivTabele()
                    //OVAJ OVDE DEO PROMENLJIV
                    +" t2 on(t1."+odo.getSpoljniKljucKlase().split(",")[1]+"=t2."+odo2.getIdKlase()
                     +") inner join "+odo3.vratiNazivTabele()
                    +" t3 on(t1."+odo.getSpoljniKljucKlase().split(",")[0]+"=t3."+odo3.getIdKlase()
                    +") inner join "+odo4.vratiNazivTabele()
                    +" t4 on(t1."+odo.getSpoljniKljucKlase().split(",")[2]+"=t4."+odo4.getSpoljniKljucKlase()
                    + ") ";
            //U PRVA DVA NAVRATA STAVLJA SE SPOLJNI KLJUC, JER JE SLAB OBJEKAT 
            
            System.out.println("Naredba: "+sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (Exception ex) {
             Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    public List<OpstiDomenskiObjekat> vratiIzUpita(OpstiDomenskiObjekat o, String where) throws Exception{
        try {
            
            String sql = "SELECT * FROM " + o.vratiNazivTabele()+" where "+where;
            System.out.println("Upit je: "+sql);
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            List<OpstiDomenskiObjekat> lista = o.ucitaj(rs);
            
//            System.out.println("Velicina liste:");
//            System.out.println(lista.size());
//            System.out.println("sql: "+sql);
//            if(o.vratiNazivTabele()=="StudentPredmet"){
//                for(OpstiDomenskiObjekat ooooooo:lista){
//                    System.out.println(((StudentPredmet)ooooooo).getS().getIme());
//                }
//            }
            return lista;
        } catch (Exception ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
                throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    
    
}
