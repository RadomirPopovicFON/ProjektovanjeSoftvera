/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import gui.ServerForma;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.TransferObjekatOdgovor;

/**
 *
 * @author student1
 */
public class Komunikacija extends Thread{
    private boolean kraj = false;
    
    
    ServerForma sf;

    public ServerForma getSf() {
        return sf;
    }

    public void setSf(ServerForma sf) {
        this.sf = sf;
    }
    
    public void run()  {
        try {
            ServerSocket ss = new ServerSocket(9000);
            System.out.println("Server je pokrenut.");
            TransferObjekatOdgovor o = new TransferObjekatOdgovor();
            
            //List<OpstiDomenskiObjekat> mas = Kontroler.getInstance().vratiMesta();
//        for(OpstiDomenskiObjekat mm : mas){
//            System.out.println(((Mesto)mm).vratiNazivTabele());
//        }
//        o.setRezultat(Kontroler.getInstance().vratiMesta());
//        for(Mesto m : ((List<Mesto>)o.getRezultat())){
//            System.out.println(m.getNaziv());
//        }
            
            
            
            while (!kraj) {
                Socket socket = ss.accept();
                System.out.println("Klijent se povezao.");
                
                NitKlijent nit = new NitKlijent(socket);
                nit.setK(this);
                nit.start();
            }
        } catch (IOException ex) {
            Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args)  {
        new Komunikacija().start();
    }
}
