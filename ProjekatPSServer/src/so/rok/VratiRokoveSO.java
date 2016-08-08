/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.rok;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Rok;
import domen.Student;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiRokoveSO extends OpstaSO {

    List<OpstiDomenskiObjekat> rokovi;
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        this.setRokovi(DatabaseBroker.getInstance().vratiSve((Rok) obj));
    }
    public List<OpstiDomenskiObjekat> getRokovi() {
        return rokovi;
    }

    public void setRokovi(List<OpstiDomenskiObjekat> rokovi) {
        this.rokovi = rokovi;
    }


}
