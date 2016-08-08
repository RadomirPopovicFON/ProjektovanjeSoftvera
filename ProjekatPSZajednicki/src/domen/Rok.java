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
public class Rok implements OpstiDomenskiObjekat{
    int ispitniRokID;
    String ispitniRokNaziv;
    String ispitniRokPeriod;

    public Rok(int ispitniRokID, String ispitniRokNaziv, String ispitniRokPeriod) {
        this.ispitniRokID = ispitniRokID;
        this.ispitniRokNaziv = ispitniRokNaziv;
        this.ispitniRokPeriod = ispitniRokPeriod;
    }

    public Rok() {
    }


    public int getIspitniRokID() {
        return ispitniRokID;
    }

    public void setIspitniRokID(int ispitniRokID) {
        this.ispitniRokID = ispitniRokID;
    }

    public String getIspitniRokNaziv() {
        return ispitniRokNaziv;
    }

    public void setIspitniRokNaziv(String ispitniRokNaziv) {
        this.ispitniRokNaziv = ispitniRokNaziv;
    }

    public String getIspitniRokPeriod() {
        return ispitniRokPeriod;
    }

    public void setIspitniRokPeriod(String ispitniRokPeriod) {
        this.ispitniRokPeriod = ispitniRokPeriod;
    }

    
    @Override
    public String vratiNazivTabele() {
        return "Rok";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return ispitniRokID + ",'" + ispitniRokNaziv + "'"+ ",'" + ispitniRokPeriod + "'";
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                int rokID = rs.getInt("ispitniRokID");
                String ispitniRokNaziv = rs.getString("ispitniRokNaziv");
                String ispitniRokPeriod = rs.getString("ispitniRokPeriod");
                Rok r = new Rok(rokID, ispitniRokNaziv, ispitniRokPeriod);
                lo.add(r);
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "ispitniRokID";
    }

    @Override
    public String getSpoljniKljucKlase() {
        return "ispitniRokID";
    }

    @Override
    public String toString() {
        return this.ispitniRokNaziv+" : "+this.getIspitniRokPeriod();
    }
    
    
    
}
