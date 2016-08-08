/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.mesto;

import db.DatabaseBroker;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import java.util.List;
import so.OpstaSO;


/**
 *
 * @author student1
 */
public class VratiMestaSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> mesta;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        mesta = DatabaseBroker.getInstance().vratiSve((Mesto)obj);
                //DatabaseBroker.getInstance().vratiSve((Mesto) obj);
    }

    public List<OpstiDomenskiObjekat> getMesta() {
        return mesta;
    }

    public void setMesta(List<OpstiDomenskiObjekat> mesta) {
        this.mesta = mesta;
    }
}
