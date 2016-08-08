/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.prijava;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Prijava;
import domen.Rok;
import domen.Student;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiPrijaveSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> prijave;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        //null je where uslov
        prijave = DatabaseBroker.getInstance().vratiSveJoin2((Prijava) obj,new Predmet(),new Student(),new Rok());
    }

    public List<OpstiDomenskiObjekat> getPrijave() {
        return prijave;
    }

    public void setPrijave(List<OpstiDomenskiObjekat> mesta) {
        this.prijave = mesta;
    }
    
}
