/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.predmet;

import db.DatabaseBroker;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Student;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiPredmeteSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> predmeti;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        predmeti = DatabaseBroker.getInstance().vratiSve((Predmet) obj);
    }
  
    public List<OpstiDomenskiObjekat> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<OpstiDomenskiObjekat> mesta) {
        this.predmeti = mesta;
    }
}
