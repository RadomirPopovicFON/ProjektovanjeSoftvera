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
public class StudentPredmet implements OpstiDomenskiObjekat{
    Student s;
    Predmet p;
    int id;
    
    
    

    public StudentPredmet(Student s, Predmet p) {
        this.s = s;
        this.p = p;
    }

    public StudentPredmet(Student s, Predmet p, int id) {
        this.s = s;
        this.p = p;
        this.id = id;
    }

    public StudentPredmet() {
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public Predmet getP() {
        return p;
    }

    public void setP(Predmet p) {
        this.p = p;
    }

    @Override
    public String vratiNazivTabele() {
        return "StudentPredmet";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return s.getStudentID() + "," + p.getPredmetID();
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
                
                Student studentt = new Student(idStudenta, brIndeksa, ime, prezime, godina, smer, jmbg, kontakt, mejl, ulica, broj, m);
                studentt.setSifra(sifra);
                
                int predmetId = rs.getInt("predmetID");
                String naziv = rs.getString("NazivPredmeta");
                int godinaPr = rs.getInt("godina");
                String smerPr = rs.getString("smer");
                int brESPB = rs.getInt("brESPB");
                int idStudentPredmet = rs.getInt("idPrijavljenogPredmeta");
                
                
                Predmet p = new Predmet(predmetId, naziv, godinaPr, smerPr, brESPB);
                
                StudentPredmet sp = new StudentPredmet(studentt,p);
                sp.setId(idStudentPredmet);
                lo.add(sp);
            }
            for(OpstiDomenskiObjekat odo : lo){
                System.out.println(((StudentPredmet)odo).getS().getIme());
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String getIdKlase() {
        return "StudentID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return "StudentID";
    }

    @Override
    public String toString() {
        return p.getNazivPredmeta(); //To change body of generated methods, choose Tools | Templates.
    }
    Predmet privremeni;

    public Predmet getPrivremeni() {
        return privremeni;
    }

    public void setPrivremeni(Predmet privremeni) {
        this.privremeni = privremeni;
    }
}
