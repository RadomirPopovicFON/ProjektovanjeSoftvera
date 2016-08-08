/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.studentpredmet;

import so.predmet.*;
import db.DatabaseBroker;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.StudentPredmet;
import java.util.List;
import poslovnalogika.Kontroler;
import so.OpstaSO;

/**
 *
 * @author Radomir
 */
public class SacuvajStudentPredmet extends OpstaSO {

    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
       StudentPredmet studentPredmet = (StudentPredmet)obj;
       List<OpstiDomenskiObjekat> lista = DatabaseBroker.getInstance().vratiSveJoin(studentPredmet, studentPredmet.getP());
          for(OpstiDomenskiObjekat o : lista){
            if(((StudentPredmet)o).getS().getStudentID()==((StudentPredmet)obj).getS().getStudentID()&&
                    ((StudentPredmet)o).getP().getPredmetID()==((StudentPredmet)obj).getP().getPredmetID()){
                throw new Exception("Ne mozete dva puta isti predmet da dodajete!");
            }
        }
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        System.out.println("Usao ovde");
        DatabaseBroker.getInstance().sacuvaj((StudentPredmet) obj);
    }
    
}
