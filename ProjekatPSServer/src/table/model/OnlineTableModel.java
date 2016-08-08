/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import domen.Mesto;
import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import domen.Student;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student1
 */
public class OnlineTableModel extends AbstractTableModel {

    private List<OpstiDomenskiObjekat> lp;
    private final String[] kolone = new String[]{"ID", "Ime", "Prezime","Tip"};

    public OnlineTableModel(List<OpstiDomenskiObjekat> lp) {
        this.lp = lp;
    }

    @Override
    public int getRowCount() {
        if (lp == null) {
            return 0;
        }
        return lp.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        int kejs;
        OpstiDomenskiObjekat izabrani = lp.get(rowIndex);
        Student s = null;
        NadleznoLice nl = null;
        if(izabrani instanceof Student) {kejs = 0; s = (Student)lp.get(rowIndex);}
        else {kejs = 1; nl = (NadleznoLice)lp.get(rowIndex);}
        if(kejs == 0)
            switch (columnIndex) {
                case 0:
                    return s.getStudentID();
                case 1:
                    return s.getIme();
                case 2:
                    return s.getPrezime();
                case 3:
                    return "Student";
                    
                default:
                    return "n/a";
            }
        else
            switch (columnIndex) {
                
                case 0:
                    return nl.getNadleznoLiceID();
                case 1:
                    return nl.getIme();
                case 2:
                    return nl.getPrezime();
                case 3:
                    return "Studentska sluzba";

                default:
                    return "n/a";
            }
        
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }


    public void dodajRed(OpstiDomenskiObjekat o) {
        lp.add(o);
        fireTableDataChanged();
    }
    
    public void obrisiGaIzListe(OpstiDomenskiObjekat odo) {
        for(OpstiDomenskiObjekat odo2 : lp){
            if(odo==odo2){
            System.out.println("Obrisan je red!");
            lp.remove(odo);
            fireTableDataChanged();
             
            }
        }
        
    }
    
    public List<OpstiDomenskiObjekat> getLp() {
        return lp;
    }

    public void setLp(List<OpstiDomenskiObjekat> lp) {
        this.lp = lp;
    }
    
    

}
