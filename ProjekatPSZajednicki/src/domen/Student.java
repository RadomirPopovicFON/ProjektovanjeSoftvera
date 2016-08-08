/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radomir
 */
public class Student implements OpstiDomenskiObjekat{
    int studentID;
    String brIndeksa;
    String ime;
    String prezime;
    int godina;
    String smer;
    int JMBG;
    String kontakt;
    String mail;
    String ulica;
    String broj;
    Mesto m;
    NadleznoLice n;
    String sifra;

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }


    public Student(int studentID, String brIndeksa, String ime, String prezime, int godina, String smer, int JMBG, String kontakt, String mail, String ulica, String broj, Mesto m, NadleznoLice n) {
        this.studentID = studentID;
        this.brIndeksa = brIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.godina = godina;
        this.smer = smer;
        this.JMBG = JMBG;
        this.kontakt = kontakt;
        this.mail = mail;
        this.ulica = ulica;
        this.broj = broj;
        this.m = m;
        this.n = n;
    }

    public Student(int studentID, String brIndeksa, String ime, String prezime, int godina, String smer, int JMBG, String kontakt, String mail, String ulica, String broj, Mesto m) {
        this.studentID = studentID;
        this.brIndeksa = brIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.kontakt = kontakt;
        this.mail = mail;
        this.ulica = ulica;
        this.broj = broj;
        this.m = m;
        this.godina = godina;
        this.smer = smer;
    }
    
    public NadleznoLice getN() {
        return n;
    }

    public void setN(NadleznoLice n) {
        this.n = n;
    }

    public Mesto getM() {
        return m;
    }

    public void setM(Mesto m) {
        this.m = m;
    }
    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    public Student() {
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getBrIndeksa() {
        return brIndeksa;
    }

    public void setBrIndeksa(String brIndeksa) {
        this.brIndeksa = brIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getJMBG() {
        return JMBG;
    }

    public void setJMBG(int JMBG) {
        this.JMBG = JMBG;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

   
    @Override
    public String vratiNazivTabele() {
        return "Student";
    }

    @Override
    public String vratiVrednostiZaInsert() {
//        System.out.println("Ima li ga?: "+n.getNadleznoLiceID());
        String zaVracanje = studentID + ",'" + brIndeksa + "','"+ ime +"'"
                + ",'" + prezime + "',"+ godina 
                + ", '" + smer + "',"+ JMBG + ",'"+ kontakt +"'"
                + ",'" + mail +"'"
                 + ",'" + ulica + "','"+ broj+"',"+ m.getId()+","+ n.getNadleznoLiceID()+", '123'";
        return zaVracanje;
                // + ",'" + m.getId() + ",'"+ n.getNadleznoLiceID() +"'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        System.out.println("usao u metodu ucitaj");
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
//                System.out.println("id: "+rs.getInt(1)+" - "+
//                        "brind: "+rs.getString(2)+" - "+
//                        "ime: "+rs.getString(3)+" - "+
//                        "prez: "+rs.getString(4)+" - "+
//                        "god: "+rs.getInt(5)+" - "+
//                        "smer: "+rs.getString(6)+" - "+
//                        "jmbg: "+rs.getInt(7)+" - "+
//                        "kont: "+rs.getString(8)+" - "+
//                        "mejl: "+rs.getString(9)+" - "+
//                        "ul: "+rs.getString(10)+" - "+
//                        "br: "+rs.getString(11)
//                        );
                int id = rs.getInt(1);
                String brIndeksa = rs.getString(2);
                String ime = rs.getString(3);
                String prezime = rs.getString(4);
                int godina = rs.getInt(5);
                String smer = rs.getString(6);
                int jmbg = rs.getInt(7);
                String kontakt = rs.getString(8);
                String mejl = rs.getString(9);
                String ulica = rs.getString(10);
                String broj = rs.getString(11);
               
                Mesto m = new Mesto(rs.getInt("MestoID"),rs.getInt("Ptt"),rs.getString("Naziv"));
                String sifra = rs.getString("sifra");
                //Mesto m = rs.
                if(m==null) System.out.println("ipak je null");
                
                Student s = new Student(id, brIndeksa, ime, prezime, godina, smer, jmbg, kontakt, mejl, ulica, broj, m);
                s.setSifra(sifra);
//                System.out.println(s.getBrIndeksa()+" / "+
//                        //s.getM().getNaziv()+" / "+
//                        s.getIme()+" / "+
//                        s.getPrezime()+" / "+
//                        s.getGodina()+" / "+
//                        s.getSmer()+" / "+
//                        s.getJMBG()+" / "+
//                        s.getKontakt()+" / "+
//                        s.getMail()+" / "+
//                        s.getUlica()+" / "+
//                        s.getBroj()+" / ");
                lo.add(s);
            }
            
            return lo;
        } catch (Exception ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "StudentID";
    }
    @Override
    public String getSpoljniKljucKlase() {
        return "MestoID";
    }
    
}
