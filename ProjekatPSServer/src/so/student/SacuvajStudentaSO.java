/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.student;

import db.DatabaseBroker;
import domen.Student;
import so.OpstaSO;



/**
 *
 * @author student1
 */
public class SacuvajStudentaSO extends OpstaSO {

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DatabaseBroker.getInstance().sacuvaj((Student) obj);
    }
    
}
