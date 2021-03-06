/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.sun.prism.paint.Color;
import domen.NadleznoLice;
import domen.OpstiDomenskiObjekat;
import domen.Student;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import komunikacija.Komunikacija;
import poslovnalogika.Kontroler;
import table.model.OnlineTableModel;
import util.FileUtil;

/**
 *
 * @author Radomir
 */
public class ServerForma extends javax.swing.JFrame {
    Komunikacija k;
    OnlineTableModel tabelaModel = new OnlineTableModel(new ArrayList<OpstiDomenskiObjekat>());
    /**
     * Creates new form ServerForma
     */
    public ServerForma() {
        try {
            initComponents();
            inicijalizujKomponente();
            k = new Komunikacija();
            k.setSf(this);
            k.start();
            srediTabelu();
        }  catch (Exception ex) {
            Logger.getLogger(ServerForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jUrl = new javax.swing.JTextField();
        jUser = new javax.swing.JTextField();
        jPass = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Online korisnici:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("Parametri za pristup bazi:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 413, -1, -1));

        jLabel3.setText("url:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 441, -1, -1));

        jLabel5.setText("user:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 474, -1, -1));

        jLabel6.setText("password:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 474, -1, -1));

        jUrl.setEditable(false);
        getContentPane().add(jUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 441, 384, -1));

        jUser.setEditable(false);
        getContentPane().add(jUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 469, 129, -1));

        jPass.setEditable(false);
        getContentPane().add(jPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(305, 469, 167, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 640, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerForma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jPass;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jUrl;
    private javax.swing.JTextField jUser;
    // End of variables declaration//GEN-END:variables

    private void inicijalizujKomponente() {
        
        try {
            jUrl.setText(FileUtil.getInstance().get("url"));
            jUser.setText(FileUtil.getInstance().get("user"));
            jPass.setText(FileUtil.getInstance().get("password"));
        } catch (IOException ex) {
            Logger.getLogger(ServerForma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void srediTabelu(){
        this.jTable1.setModel(tabelaModel);
        
    }
    public void dodajNaOnlinePrikaz(OpstiDomenskiObjekat o){
        this.tabelaModel.dodajRed(o);
    }
    public void obrisiGa(OpstiDomenskiObjekat o){
        //this.tabelaModel.obrisiRed(tabelaModel.get);
    }
    
}
