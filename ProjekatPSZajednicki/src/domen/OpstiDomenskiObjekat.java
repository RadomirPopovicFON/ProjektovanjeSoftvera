/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Radomir
 */
public interface OpstiDomenskiObjekat extends Serializable {

    public String vratiNazivTabele();

    public String vratiVrednostiZaInsert();

    public List<OpstiDomenskiObjekat> ucitaj(ResultSet rs) throws Exception;

    public String getIdKlase();
    public String getSpoljniKljucKlase();
    
}
