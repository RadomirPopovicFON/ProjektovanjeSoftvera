/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.studentpredmet;

import so.predmet.*;
import db.DatabaseBroker;
import domen.Predmet;
import domen.StudentPredmet;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class IzmeniStudentPredmetSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
        System.out.println("Proverio preduslov");
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().izmeni((StudentPredmet) obj);
    }

    
    
    
}
