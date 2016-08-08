/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Radomir
 */
public class Predmet implements OpstiDomenskiObjekat{
    
    int predmetID;
    String nazivPredmeta;
    int godina;
    String smer;
    int brojESPB;
    
    public int getPredmetID() {
        return predmetID;
    }

    public void setPredmetID(int predmetID) {
        this.predmetID = predmetID;
    }


    public Predmet(int predmetID,String nazivPredmeta, int godina, String smer,int brESPB) {
        this.predmetID = predmetID;
        this.nazivPredmeta = nazivPredmeta;
        this.godina = godina;
        this.smer = smer;
        this.brojESPB=brESPB;
    }
    
    
    public int getBrojESPB() {
        return brojESPB;
    }

    public void setBrojESPB(int brojESPB) {
        this.brojESPB = brojESPB;
    }
    
    public Predmet() {
    }

    
    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
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

    @Override
    public String vratiNazivTabele() {
        return "Predmet";
    }

    @Override
    public String vratiVrednostiZaInsert() {
        return predmetID+",'"+nazivPredmeta + "'," + godina + ",'"+ smer +"', "+brojESPB;
    }

    @Override
    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception {
        try {
            List<OpstiDomenskiObjekat> lo = new LinkedList<>();
            while (rs.next()) {
                
                int predmetId = rs.getInt("predmetID");
                String naziv = rs.getString("NazivPredmeta");
                int godinaPr = rs.getInt("godina");
                String smerPr = rs.getString("smer");
                int brESPB = rs.getInt("brESPB");
                
                Predmet p = new Predmet(predmetId,naziv, godina, smer,brESPB);
                lo.add(p);
            }
            return lo;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public String getIdKlase() {
        return "predmetID";
    }

    @Override
    public String toString() {
        return nazivPredmeta;
    }
    @Override
    public String getSpoljniKljucKlase() {
        return null;
    }
    
}
