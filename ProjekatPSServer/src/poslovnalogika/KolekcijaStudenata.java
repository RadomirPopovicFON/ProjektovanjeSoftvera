/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poslovnalogika;

import domen.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Radomir
 */
class KolekcijaStudenata {
   
    private List<Student> studenti;

    public KolekcijaStudenata() {
        studenti = new ArrayList<>();
    }
    
    public void dodajMesto(Student s) {
        studenti.add(s);
    }
    
    public List<Student> vratiPredmete() {
        return studenti;
    }
}
