/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.student;

import db.DatabaseBroker;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Student;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiStudenteSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> studenti;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        studenti = DatabaseBroker.getInstance().vratiSve((Student) obj);
    }
    @Override
    protected void izvrsiKonkretnuOperacijuJoin(Object obj,Object obj2) throws Exception {
        studenti = DatabaseBroker.getInstance().vratiSveJoin((Student) obj,(Mesto) obj2);
    }
    
    
    public List<OpstiDomenskiObjekat> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<OpstiDomenskiObjekat> mesta) {
        this.studenti = mesta;
    }
    
}
