/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table.model;

import domen.Mesto;
import domen.Predmet;
import domen.Prijava;
import domen.Rok;
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
public class PrijavaIspitaTableModel extends AbstractTableModel {

    //       int prijavaID;
//    Rok r;
//    int ocena;
//    Student s;
//    Predmet p;
    
    
    private List<Prijava> lp;
    private final String[] kolone = new String[]{"Rok", "Predmet"};
    
    public PrijavaIspitaTableModel(List<Prijava> lp) {
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
        Prijava p = lp.get(rowIndex);
        
        switch (columnIndex) {
            case 0:
                return p.getR().getIspitniRokNaziv();
            case 1:
                return p.getP().getNazivPredmeta();
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


    public Prijava getPrijava(int red) {
        return lp.get(red);
    }
    
    
    public List<Prijava> vratiPrijave() {
        return lp;
    }


}
