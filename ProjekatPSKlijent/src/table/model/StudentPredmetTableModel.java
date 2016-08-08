/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import domen.Mesto;
import domen.Predmet;
import domen.Student;
import domen.StudentPredmet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Radomir
 */
public class StudentPredmetTableModel extends AbstractTableModel {

    Student s;

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }
    
    private List<StudentPredmet> lp;
    private final String[] kolone = new String[]{"Naziv predmeta", "Godina","Broj espb","Smer","Suma prijavljenih espb poena"};
    
    public StudentPredmetTableModel(List<StudentPredmet> lp) {
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
        StudentPredmet sp = lp.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sp.getP().getNazivPredmeta();
            case 1:
                return sp.getP().getGodina();
            case 2:
                return sp.getP().getBrojESPB();
            case 3:
                return sp.getP().getSmer();
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

    

    public StudentPredmet getStudent(int red) {
        return lp.get(red);
    }
    
    public void dodajRed() {
        lp.add(new StudentPredmet());
        //System.out.println("Dodat je novi student!");
        fireTableDataChanged();
    }
    
    public void obrisiRed(int red) {
        lp.remove(red);
        System.out.println("Obrisan je red!");
        fireTableDataChanged();
    }
    

}

