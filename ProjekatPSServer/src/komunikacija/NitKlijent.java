/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package komunikacija;

import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Prijava;
import domen.Student;
import domen.StudentPredmet;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import poslovnalogika.Kontroler;
import transfer.TransferObjekatOdgovor;
import transfer.TransferObjekatZahtev;
import util.Konstante;

/**
 *
 * @author student1
 */
public class NitKlijent extends Thread {

    private Socket socket;
    private boolean aktivna;
    Komunikacija k;

    public Komunikacija getK() {
        return k;
    }

    public void setK(Komunikacija k) {
        this.k = k;
    }
    

    public NitKlijent(Socket socket) {
        this.socket = socket;
        this.aktivna = true;
    }

    @Override
    public void run() {
        try {
            izvrsenjeOperacija();
        } catch (Exception ex) {
            ex.printStackTrace();
            aktivna = false;
        }
        System.out.println("Nit je regularno zavrsila rad.");
    }

    private void izvrsenjeOperacija() throws IOException, ClassNotFoundException {
        while (aktivna) {
            ObjectInputStream inSocket = new ObjectInputStream(socket.getInputStream());
            TransferObjekatZahtev toZahtev = (TransferObjekatZahtev) inSocket.readObject();
            System.out.println("Server:"+toZahtev.getOperacija());
            TransferObjekatOdgovor toOdgovor = new TransferObjekatOdgovor();
            try {
                System.out.println("Operacija: " + toZahtev.getOperacija());
                switch (toZahtev.getOperacija()) {
                    case Konstante.VRATI_NL:
                        
                        NadleznoLice nlc = (NadleznoLice) toZahtev.getParametar();
                        
                        NadleznoLice nl = (NadleznoLice) Kontroler.getInstance().vratiNadleznoLice(nlc);
                        
                        getK().
                                getSf().
                                dodajNaOnlinePrikaz(nl);
                        
                        toOdgovor.setRezultat(nl);
                        System.out.println(toOdgovor.getRezultat());
                        toOdgovor.setPoruka("Nadlezno lice je ulogovano.");
                        break;
                        
                    case Konstante.OBRISI_STUDENTA:
                        Student s = (Student) toZahtev.getParametar();
                        System.out.println("Ime mu je:"+s.getIme());
                        Kontroler.getInstance().obrisiStudenta(s);
                        toOdgovor.setRezultat(s);
                        toOdgovor.setPoruka("Student je obrisan.");
                        break;
                    case Konstante.VRATI_STUDENTE:
                        List<OpstiDomenskiObjekat> studenti = Kontroler.getInstance().vratiStudente();
                        toOdgovor.setRezultat(studenti);
                        toOdgovor.setPoruka("Studenti su vraceni.");
                        break;
                    case Konstante.VRATI_STUDENTA:
                        List<OpstiDomenskiObjekat> nadjeniStudenti = Kontroler.getInstance().nadjiStudente((String) toZahtev.getParametar());
                        toOdgovor.setRezultat(nadjeniStudenti);
                        toOdgovor.setPoruka("Trazeni student je vracen.");
                        break;
                    case Konstante.VRATI_STUDENTA_LOGIN:
                        OpstiDomenskiObjekat o = Kontroler.getInstance().vratiStudentaLogin((Student)toZahtev.getParametar());
                        System.out.println("Zatrazen je zahtev za : "+(Student)toZahtev.getParametar());
                        
                        getK().
                                getSf().
                                dodajNaOnlinePrikaz(o);
                        
                        toOdgovor.setRezultat(o);
                        toOdgovor.setPoruka("Uspesno ulogovan.");
                        break;
                    case Konstante.VRATI_IZ_KOLEKCIJE_PREDMETE:
                        System.out.println("VRATI_IZ_KOLEKCIJE_PREDMETE");
                        List<OpstiDomenskiObjekat> lista = (List<OpstiDomenskiObjekat>)Kontroler.getInstance().vratiPredmete();
                        
                        toOdgovor.setRezultat(lista);
                        toOdgovor.setPoruka("Uspesno vraceni predmeti.");
                        break;
                    case Konstante.VRATI_PREDMETE:
                        System.out.println("VRATI_PREDMETE");
                        Student stud = (Student)toZahtev.getParametar();
                        List<OpstiDomenskiObjekat> listaPredmeta = (List<OpstiDomenskiObjekat>)Kontroler.getInstance().vratiPredmete(stud);
                       
                        toOdgovor.setRezultat(listaPredmeta);
                        toOdgovor.setPoruka("Uspesno vraceni predmeti.");
                        break;
                    case Konstante.IZMENI_PREDMET:
                        StudentPredmet sp = (StudentPredmet)toZahtev.getParametar();
                        Kontroler.getInstance().izmeniPredmet(sp);
                        
                        toOdgovor.setPoruka("Uspesno zamenjeni predmeti.");
                        break;
                    case Konstante.IZMENI_STUDENTA:
                        System.out.println("IZMENI STUDENTA");
                        Student prijemStudenta = (Student)toZahtev.getParametar();
                        Kontroler.getInstance().izmeniStudenta(prijemStudenta);
                        toOdgovor.setPoruka("Uspesno zamenjeni predmeti.");
                        break;
                    case Konstante.SACUVAJ_PRIJAVU:
                        Prijava prij = (Prijava)toZahtev.getParametar();
                        Kontroler.getInstance().dodajPrijavu(prij);
                        toOdgovor.setPoruka("Uspesno uneta prijava.");
                        break;
                    case Konstante.VRATI_PRIJAVE:
                        Student student = (Student) toZahtev.getParametar();
                        List<OpstiDomenskiObjekat> prijaveStudenta= (List<OpstiDomenskiObjekat>) Kontroler.getInstance().vratiPrijave(student);
                        toOdgovor.setRezultat(prijaveStudenta);
                        toOdgovor.setPoruka("Vracene prijave za studenta!.");
                        break;
                    case Konstante.VRATI_MESTA:
                        List<OpstiDomenskiObjekat> lm = Kontroler.getInstance().vratiMesta();
                        toOdgovor.setRezultat(lm);
                        toOdgovor.setPoruka("Mesta su ucitana.");
                        break;
                        
                    case Konstante.SACUVAJ_STUDENTA:
                        System.out.println("Parametar je : "+toZahtev.getParametar().toString());
                        Student stt = (Student) toZahtev.getParametar();
                        Kontroler.getInstance().dodajStudenta(stt);
                        toOdgovor.setPoruka("Partner je uspesno sacuvan.");
                        break;
                    case Konstante.SACUVAJ_PREDMET:
                        System.out.println("Parametar je : "+toZahtev.getParametar().toString());
                        StudentPredmet pred = (StudentPredmet) toZahtev.getParametar();
                        Kontroler.getInstance().dodajPredmet(pred);
                        toOdgovor.setPoruka("Predmet je uspesno sacuvan.");
                        break;
                    case Konstante.VRATI_ROKOVE:
                        System.out.println("Parametar je : "+toZahtev.getParametar().toString());
                        List<OpstiDomenskiObjekat> rokovi;
                        rokovi = (List<OpstiDomenskiObjekat>) Kontroler.getInstance().vratiRokove();
                        toOdgovor.setRezultat(rokovi);
                        toOdgovor.setPoruka("Rokovi su uspesno vraceni.");
                        break;
                    case Konstante.UNESI_OCENU:
                        System.out.println("Parametar je : "+toZahtev.getParametar().toString());
                        
                        Kontroler.getInstance().unesiOcenu(toZahtev.getParametar());
                        
                        toOdgovor.setPoruka("Ocena je uspesno uneta.");
                        break;
                    case Konstante.KRAJ_RADA:
                        OpstiDomenskiObjekat izlazi = (OpstiDomenskiObjekat)toZahtev.getParametar();
                        getK().getSf().obrisiGa(izlazi);
                        
                        aktivna = false;
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(Komunikacija.class.getName()).log(Level.SEVERE, null, ex);
                toOdgovor.setPoruka(ex.getMessage());
                toOdgovor.setIzuzetak(ex);
            }
            posaljiOdgovor(toOdgovor);
        }
    }

    private void posaljiOdgovor(TransferObjekatOdgovor toOdgovor) throws IOException {
        ObjectOutputStream outSocket = new ObjectOutputStream(socket.getOutputStream());
        outSocket.writeObject(toOdgovor);
    }

}
