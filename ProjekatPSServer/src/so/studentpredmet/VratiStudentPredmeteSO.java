/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.studentpredmet;

import so.predmet.*;
import db.DatabaseBroker;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Prijava;
import domen.Rok;
import domen.Student;
import domen.StudentPredmet;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiStudentPredmeteSO extends OpstaSO {
    private List<OpstiDomenskiObjekat> StudentPredmeti;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
       //(List<OpstiDomenskiObjekat>) DatabaseBroker.getInstance().vratiSveJoin();
        System.out.println("Usao u metodu koja nista ne radi");
    }
    @Override
    protected void izvrsiKonkretnuOperacijuJoin(Object obj,Object obj2) throws Exception{
        StudentPredmeti = DatabaseBroker.getInstance().vratiSveJoin((StudentPredmet)obj, (Predmet)obj2);
   
    }
    
    public List<OpstiDomenskiObjekat> getPredmeti() {
        return StudentPredmeti;
    }

    public void setPredmeti(List<OpstiDomenskiObjekat> mesta) {
        this.StudentPredmeti = mesta;
    }
}
