/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;

/**
 *
 * @author Radomir
 */
public class KomunikacijaKlijent {
    private Socket socket;
    private static KomunikacijaKlijent instance;
    
    private KomunikacijaKlijent() throws IOException {
        socket = new Socket("127.0.0.1", 9000);
    }
    
    public static KomunikacijaKlijent getInstance() throws IOException {
        if (instance == null) {
            instance = new KomunikacijaKlijent();
        }
        return instance;
    }
    
    public void posaljiZahtev(TransferObjekatZahtev toZahtev) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        System.out.println(toZahtev.getOperacija()+" --- "+toZahtev.getParametar());
       
        outSocket.writeObject(toZahtev);
    }
    
    public TransferObjekatOdgovor primiOdgovor() throws IOException, ClassNotFoundException {
        ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
        System.out.println(inSocket);
        return (TransferObjekatOdgovor) inSocket.readObject();
    }
    
}
