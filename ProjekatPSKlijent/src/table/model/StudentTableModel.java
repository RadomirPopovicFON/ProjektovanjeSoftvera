/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import domen.Mesto;
import domen.Student;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.value;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author student1
 */
public class StudentTableModel extends AbstractTableModel {

    private List<Student> lp;
    private final String[] kolone = new String[]{"StudentID", "Broj indeksa", "Ime", "Prezime", "Godina", "Smer","JMBG", "Kontakt", "Mejl", "Ulica", "Broj","Mesto"};
    private final DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
    
    
    
    public StudentTableModel(List<Student> lp) {
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
        Student s = lp.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return s.getStudentID();
            case 1:
                return s.getBrIndeksa();
            case 2:
                return s.getIme();
            case 3:
                return s.getPrezime();
            case 4:
                return s.getGodina();
            case 5:
                return s.getSmer();
            case 6:
                return s.getJMBG();
            case 7:
                return s.getKontakt();
            case 8:
                return s.getMail();
            case 9:
                return s.getUlica();
            case 10:
                return s.getBroj();
            case 11:
                
                return s.getM();
                
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
        return false;
    }
//    }
//
//    @Override
//    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        Student s = lp.get(rowIndex);
//        switch (columnIndex) {
//            case 0:
//                s.setStudentID(Integer.parseInt((String) aValue));
//                break;
//            case 1:
//                s.setBrIndeksa((String) aValue);
//                break;
//            case 2:
//                s.setIme((String) aValue);
//                break;
//            case 3:
//                s.setPrezime((String) aValue);
//                break;
//            case 4:
//                s.setGodina(Integer.parseInt((String) aValue));
//                break;
//            case 5:
//                s.setSmer((String) aValue);
//                break;
//            case 6:
//                s.setJMBG(rowIndex);
//                break;
//            case 7:
//                s.setKontakt((String) aValue);
//                break;
//            case 8:
//                s.setMail((String) aValue);
//                break;
//            case 9:
//                s.setUlica((String) aValue);
//                break;
//            case 10:
//                s.setBroj((String) aValue);
//                break;
//            case 11:
//                
//                s.setM((Mesto) aValue);
//                break;
//        }
//    }

    public Student getStudent(int red) {
        return lp.get(red);
    }
    
    public void dodajRed() {
        lp.add(new Student());
        //System.out.println("Dodat je novi student!");
        fireTableDataChanged();
    }
    
    public void dodajRed2(Student s) {
        lp.add(s);
        //System.out.println("Dodat je novi student!");
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        lp.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }
    
    public List<Student> vratiStudente() {
        return lp;
    }

    public void setujListu(List<Student> lista) {
        lp = lista;
        fireTableDataChanged();
    }

}
