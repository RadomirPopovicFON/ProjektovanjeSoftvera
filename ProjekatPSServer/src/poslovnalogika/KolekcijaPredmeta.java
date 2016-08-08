/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.Predmet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radomir
 */
class KolekcijaPredmeta {
    
    //Smer moze biti pod oznakom ISiT, Men, Oba
    
    private List<Predmet> predmeti;

    public KolekcijaPredmeta() {
        predmeti = new ArrayList<>();
    }
    
    public void dodajPredmet(Predmet p) {
        predmeti.add(p);
    }
    
    public List<Predmet> vratiPredmete() {
        return predmeti;
    }


}
