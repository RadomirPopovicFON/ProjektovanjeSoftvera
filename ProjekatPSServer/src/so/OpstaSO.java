/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DatabaseBroker;


/**
 *
 * @author student1
 */
public abstract class OpstaSO {
    
    public final void izvrsenjeSO(Object obj) throws Exception {
        try {
            
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperaciju(obj);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
        
    }
    
    public final void izvrsenjeSOJoin(Object obj,Object obj2) throws Exception {
        try {
            ucitajDriver();
            otvoriKonekciju();
            proveriPreduslov(obj);
            izvrsiKonkretnuOperacijuJoin(obj,obj2);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
    }
    public final void izvrsenjeSOJoin(Object obj,Object obj2,Object obj3) throws Exception {
        try {
            System.out.println("Usao u metodu"+obj+obj2+obj3);
            
            ucitajDriver();
            otvoriKonekciju();
            
            proveriPreduslov(obj);
            izvrsiKonkretnuOperacijuJoin2(obj,obj2,obj3);
            commitTransakcije();
        } catch (Exception ex) {
            rollbackTransakcije();
            throw ex;
        } finally {
            zatvoriKonekciju();
        }
        
    }
    

    private void ucitajDriver() throws Exception {
        DatabaseBroker.getInstance().ucitajDriver();
    }

    private void otvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().otvoriKonekciju();
    }

    // Specificno za svaku sistemsku operaciju
    protected abstract void proveriPreduslov(Object obj) throws Exception;

    // Specificno za svaku sistemsku operaciju
    protected abstract void izvrsiKonkretnuOperaciju(Object obj) throws Exception;

    protected void izvrsiKonkretnuOperacijuJoin(Object obj,Object obj2) throws Exception{};
    protected void izvrsiKonkretnuOperacijuJoin2(Object obj,Object obj2,Object obj3) throws Exception{};
    
    private void commitTransakcije() throws Exception {
        DatabaseBroker.getInstance().commitTransakcije();
    }

    private void rollbackTransakcije() throws Exception {
        DatabaseBroker.getInstance().rollbackTransakcije();
    }

    private void zatvoriKonekciju() throws Exception {
        DatabaseBroker.getInstance().zatvoriKonekciju();
    }

   
    
}
