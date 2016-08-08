/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.prijava;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Prijava;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class UnesiOcenuSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().izmeni((OpstiDomenskiObjekat) obj);
    }


}
