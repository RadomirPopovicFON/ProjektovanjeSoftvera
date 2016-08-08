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
public class Mesto implements OpstiDomenskiObjekat {
    int ptt;
    String naziv;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mesto(int id,int ptt,String naziv) {
        this.id = id;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public Mesto() {
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    @Override
    public String vratiNazivTabele() {
        return "Mesto";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ptt + ",'" + naziv + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                int idd = rs.getInt("MestoID");
                int ptt = rs.getInt("Ptt");
                String naziv = rs.getString("Naziv");
                Mesto m = new Mesto(idd,ptt, naziv);
                lo.add(m);
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "MestoID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }

    
}
