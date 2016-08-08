/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Radomir
 */
public class NadleznoLice implements OpstiDomenskiObjekat{
    int nadleznoLiceID;
    String ime;
    String prezime;
    String korisnickoIme;
    String korisnickaSifra;
    JFrame f;

    public NadleznoLice(int nadleznoLiceID, String ime, String prezime, String korisnickoIme, String korisnickaSifra) {
        this.nadleznoLiceID = nadleznoLiceID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
    }

    public NadleznoLice() {
    }

    public int getNadleznoLiceID() {
        return nadleznoLiceID;
    }

    public void setNadleznoLiceID(int nadleznoLiceID) {
        this.nadleznoLiceID = nadleznoLiceID;
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

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    void setForma(JFrame aThis) {
        this.f = aThis;
    }

    public JFrame getForma() {
        return f;
    }

    @Override
    public String vratiNazivTabele() {
        return "NadleznoLice";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return null;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                
                int id = rs.getInt(1);
                String ime = rs.getString(2);
                String prezime = rs.getString(3);
                String korisnickoIme = rs.getString(4);
                String korisnickaSifra = rs.getString(5);
                
                //Mesto m = rs.
                NadleznoLice n = new NadleznoLice(id, ime, prezime, korisnickoIme, korisnickaSifra);
                
                lo.add(n);
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "nadLiceID";
    }
    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
}
