/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.nadleznolice;

import db.DatabaseBroker;
import domen.Mesto;
import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiNLSO extends OpstaSO {
    
    NadleznoLice nlo;

    public NadleznoLice getNlo() {
        return nlo;
    }

    public void setNlo(NadleznoLice nlo) {
        this.nlo = nlo;
    }
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        String upit = "korisnickoIme ='"+((NadleznoLice)obj).getKorisnickoIme()+"' and korisnickaSifra = '"+((NadleznoLice)obj).getKorisnickaSifra()+"'";
        System.out.println("pre metode"+upit);
        List<OpstiDomenskiObjekat> listaa = DatabaseBroker.getInstance().vratiIzUpita((NadleznoLice)obj, upit);
        System.out.println(listaa.get(0));
        setNlo((NadleznoLice)listaa.get(0));
        
    }

   
}
