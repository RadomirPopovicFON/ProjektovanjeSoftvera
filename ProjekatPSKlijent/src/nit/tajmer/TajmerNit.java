/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit.tajmer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Radomir
 */
public class TajmerNit extends Thread{
    
    int brojac;

    JFrame fk;

    public JFrame getFk() {
        return fk;
    }

    public void setFk(JFrame fk) {
        this.fk = fk;
    }
    
    private static TajmerNit timer;
    TajmerNit(){
        brojac = 0;
    }

    public int getBrojac() {
        return brojac;
    }

    public void setBrojac(int brojac) {
        this.brojac = brojac;
    }
    
    @Override
    public void run() {
        while(true){
            try {
                if(brojac==6) {System.out.println("prosao timer");return;}
                this.sleep(1000);
                brojac++;
                if(brojac==5) getFk().metodaTimer();
            } catch (InterruptedException ex) {
                Logger.getLogger(TajmerNit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
