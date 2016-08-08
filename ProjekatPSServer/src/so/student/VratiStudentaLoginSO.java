/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.student;

import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Student;
import java.util.List;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class VratiStudentaLoginSO extends OpstaSO {

    Student s;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        // Proveriti preduslov za sistemsku operaciju
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        
         List<OpstiDomenskiObjekat> lista = DatabaseBroker.getInstance().vratiIzUpita
        ((Student) obj,"brIndeksa = '"+((Student) obj).getBrIndeksa()+
                "' and sifra = '"+((Student) obj).getSifra()+"'");
         this.setStudent((Student)lista.get(0));
    }
    public Student getStudent() {
        return s;
    }

    public void setStudent(Student s) {
        this.s = s;
    }
}
