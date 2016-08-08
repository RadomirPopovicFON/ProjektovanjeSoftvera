/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Radomir
 */
public class Prijava implements OpstiDomenskiObjekat{
    
    int prijavaID;
    Rok r;
    int ocena;
    Student s;
    Predmet p;

    public Prijava(Predmet p,int prijavaID, Rok r, int ocena, Student s) {
        this.p = p;
        this.prijavaID = prijavaID;
        this.r=r;
        this.ocena = ocena;
        this.s = s;
    }

    public Prijava() {
    }

    public int getPrijavaID() {
        return prijavaID;
    }

    public void setPrijavaID(int prijavaID) {
        this.prijavaID = prijavaID;
    }

    public Predmet getP() {
        return p;
    }

    public void setP(Predmet p) {
        this.p = p;
    }

    public Rok getR() {
        return r;
    }

    public void setR(Rok r) {
        this.r = r;
    }
    
    
    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }
     @Override
    public String vratiNazivTabele() {
        return "Prijava";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return p.getPredmetID()+","+prijavaID + "," + ocena + ","+ s.getStudentID()
                + "," + r.getIspitniRokID();
        //INSERT INTO Prijava VALUES (1, 3,0,'jun','period',-5,'1')
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                int idStudenta = rs.getInt("StudentID");
                String brIndeksa = rs.getString("brIndeksa");
                String ime = rs.getString("Ime");
                String prezime = rs.getString("Prezime");
                int godina = rs.getInt("godina");
                String smer = rs.getString("smer");
                int jmbg = rs.getInt("JMBG");
                String kontakt = rs.getString("Kontakt");
                String mejl = rs.getString("Mail");
                String ulica = rs.getString("Ulica");
                String broj = rs.getString("Broj");
                Mesto m = new Mesto();
                String sifra = rs.getString("sifra");
                //Mesto m = rs.
                if(m==null) System.out.println("ipak je null");
                
                Student stt = new Student(idStudenta, brIndeksa, ime, prezime, godina, smer, jmbg, kontakt, mejl, ulica, broj, m);
                stt.setSifra(sifra);
//                
                
                Rok r = new Rok(rs.getInt("ispitniRokID"),rs.getString("ispitniRokNaziv"),rs.getString("ispitniRokPeriod"));
                int predmetId = rs.getInt("predmetID");
                String naziv = rs.getString("NazivPredmeta");
                int godinaPr = rs.getInt("godina");
                String smerPr = rs.getString("smer");
                int brESPB = rs.getInt("brESPB");
                
                Predmet p = new Predmet(predmetId,naziv, godinaPr, smerPr,brESPB);
                
                
                int ispitID = rs.getInt("ispitID");
                String ispitniRokNaziv = rs.getString("ispitniRokNaziv");
                String ispitniRokPeriod = rs.getString("ispitniRokPeriod");
                int ocena = rs.getInt("ocena");
                
                Prijava prij = new Prijava(p, ispitID, r, ocena, stt);
                
                lo.add(prij);
                
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "ispitID";
    }
    @Override
    public String getSpoljniKljucKlase() {
        return "StudentID,predmetID,ispitniRokID";
    }

    @Override
    public String toString() {
        return r.getIspitniRokNaziv()+" "+
                p.getNazivPredmeta();
    }
    
    
}
