/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import so.student.VratiStudentaLoginSO;
import db.DatabaseBroker;
import domen.Mesto;
import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import domen.Predmet;
import domen.Prijava;
import domen.Rok;
import domen.Student;
import domen.StudentPredmet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import so.OpstaSO;
import so.mesto.VratiMestaSO;
import so.nadleznolice.VratiNLSO;
import so.predmet.VratiPredmeteSO;
import so.prijava.SacuvajPrijavu;
import so.prijava.UnesiOcenuSO;
import so.prijava.VratiPrijaveSO;
import so.rok.VratiRokoveSO;
import so.student.IzmeniStudentaSO;
import so.student.SacuvajStudentaSO;
import so.student.ObrisiStudentaSO;
import so.student.VratiStudenteSO;
import so.studentpredmet.IzmeniStudentPredmetSO;
import so.studentpredmet.SacuvajStudentPredmet;
import so.studentpredmet.VratiStudentPredmeteSO;

/**
 *
 * @author student1
 */
public class Kontroler {

    private KolekcijaStudenata ks;
    private KolekcijaMesta km;
    private KolekcijaPredmeta kp;
    private DatabaseBroker db;
    private static Kontroler instance;
    private Map<String, Object> map;
    
    private Kontroler() {
        ks = new KolekcijaStudenata();
        kp = new KolekcijaPredmeta();
        km = new KolekcijaMesta();
        
        db = DatabaseBroker.getInstance();
        map = new HashMap<>();
    }

    public static Kontroler getInstance() {
        if (instance == null) {
            instance = new Kontroler();
        }
        return instance;
    }

    public OpstiDomenskiObjekat vratiNadleznoLice(NadleznoLice n) throws Exception {
        OpstaSO vratiNadleznoLice = new VratiNLSO();
        vratiNadleznoLice.izvrsenjeSO(n);
        return ((VratiNLSO) vratiNadleznoLice).getNlo();
    }
    
    public OpstiDomenskiObjekat vratiStudentaLogin(Student s) throws Exception {
        OpstaSO vratiStudentaLOGIN = new VratiStudentaLoginSO();
        vratiStudentaLOGIN.izvrsenjeSO(s);
        Student student = ((VratiStudentaLoginSO) vratiStudentaLOGIN).getStudent();
        System.out.println("da li je student null?"+student.getIme());
        return student;
    }
    
    public void dodajStudenta(Student s) throws Exception {
        OpstaSO sacuvajStudentaSO = new SacuvajStudentaSO();
        sacuvajStudentaSO.izvrsenjeSO(s);
    }

    public void obrisiStudenta(Student s)  {
        try {
            OpstaSO obrisiStudentaSO = new ObrisiStudentaSO();
            obrisiStudentaSO.izvrsenjeSO(s);
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Student je obrisan");
    }
    public void izmeniStudenta(Student s) throws Exception {
        OpstaSO izmeniStudentaSO = new IzmeniStudentaSO();
        izmeniStudentaSO.izvrsenjeSO(s);
    }
    
    public void dodajPredmet(StudentPredmet p) throws Exception {
        OpstaSO sacuvajPredmetSO = new SacuvajStudentPredmet();
        sacuvajPredmetSO.izvrsenjeSO(p);
    }
    public void izmeniPredmet(StudentPredmet sp) throws Exception {
        OpstaSO izmeniPredmetSO = new IzmeniStudentPredmetSO();
        izmeniPredmetSO.izvrsenjeSO(sp);
    }
    public void dodajPrijavu(Prijava p) throws Exception {
        OpstaSO sacuvajPrijavuSO = new SacuvajPrijavu();
        sacuvajPrijavuSO.izvrsenjeSO(p);
    }
    
    public void dodajMesto(Mesto m) {
        km.dodajMesto(m);
    }

    public List<OpstiDomenskiObjekat> vratiMesta() throws Exception {
        OpstaSO vratiMestaSO = new VratiMestaSO();
        vratiMestaSO.izvrsenjeSO(new Mesto());
        List<OpstiDomenskiObjekat> lista = ((VratiMestaSO) vratiMestaSO).getMesta();
        for(OpstiDomenskiObjekat odo : lista){
            dodajMesto((Mesto)odo);
        }
        System.out.println("ulazimo u petlju:");
        
        for(Mesto m : km.vratiMesta()){
            System.out.println(""+m.getId());
        }
        return lista;
    }
    
    public List<OpstiDomenskiObjekat> vratiStudente() throws Exception {
        OpstaSO vratiStudenteSO = new VratiStudenteSO();
        vratiStudenteSO.izvrsenjeSOJoin(new Student(),new Mesto());
        return ((VratiStudenteSO) vratiStudenteSO).getStudenti();
    }
    public List<OpstiDomenskiObjekat> vratiPredmete() throws Exception {
        //System.out.println("debuger2");
        OpstaSO vratiPredmeteSO = new VratiPredmeteSO();
        vratiPredmeteSO.izvrsenjeSO(new Predmet());
        return ((VratiPredmeteSO) vratiPredmeteSO).getPredmeti();
        
    }   
    public List<OpstiDomenskiObjekat> vratiPredmete(Student s) throws Exception {
        
        StudentPredmet novi = new StudentPredmet(); novi.setS(s);
        
        OpstaSO vratiPredmetStudenteSO = new VratiStudentPredmeteSO();
        vratiPredmetStudenteSO.izvrsenjeSOJoin(novi, new Predmet());
        return ((VratiStudentPredmeteSO) vratiPredmetStudenteSO).getPredmeti();
        
    }   
    public List<OpstiDomenskiObjekat> vratiPrijave(Student s) throws Exception {
        Prijava p = new Prijava();
        p.setS(s);
        OpstaSO vratiPrijaveSO = new VratiPrijaveSO();
        vratiPrijaveSO.izvrsenjeSO(new Prijava());
        return ((VratiPrijaveSO) vratiPrijaveSO).getPrijave();
    }
    
    
    public Mesto nadjiMesto(int id){
        Mesto vracanje = null;
        for(Mesto mmm:km.vratiMesta()){
            if(mmm.getId()==id){
                vracanje = mmm;
            }
        }
        return vracanje;
    }
    
    public void put(String key, Object value) {
        map.put(key, value);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public void remove(String key) {
        map.remove(key);
    }

    

    public void unesiOcenu(Object prijava) throws Exception {
        OpstaSO unesiOcenuSO = new UnesiOcenuSO();
        unesiOcenuSO.izvrsenjeSO((OpstiDomenskiObjekat)prijava);
        
    }
    
    public List<OpstiDomenskiObjekat> vratiRokove() throws Exception {
        OpstaSO vratiRokove = new VratiRokoveSO();
        vratiRokove.izvrsenjeSO(new Rok());
        return ((VratiRokoveSO) vratiRokove).getRokovi();
    }
    public List<OpstiDomenskiObjekat> nadjiStudente(String ime) {
        List<OpstiDomenskiObjekat> studenti = new ArrayList<>();
        try {
            for(OpstiDomenskiObjekat o : Kontroler.getInstance().vratiStudente()){
                if(((Student)o).getIme().equals(ime)){
                    studenti.add(((Student)o));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return studenti;
    }
    
    
}
