/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ounis.replacechars;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author AndroidAppsPlatform
 */
    /**
     * @param args the command line arguments
     */
public class ReplaceChars {
    

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>1

        /* Create and display the form */
        
        System.out.println("Wybierz ramkę do wyświetlenia:\n1 - ReplaceChars"+
                      "\n2 - DocSizeFilterDemoFrm");
        System.out.print(">");
        
        
        Scanner scnr = new Scanner(System.in);
        
        String input;
//        if (scnr != null) 
        input = scnr.next();
        

//        System.out.println(input);
        int value;
        try {
            value = Integer.parseInt(input);
        }
        catch (NumberFormatException nfe) {
            value = -1;
            System.err.println(input);
        }
        
        //JOptionPane.showMessageDialog(null, value);
        
//        int value = scnr.nextInt();
        
        switch (value)
        {
            case 1 : 
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new MainFrame().setVisible(true);
                
                        }
                    });
                    break;
            case 2 : 
                       java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new DocSizeFilterDemoFrm().setVisible(true);
                
                        }
                    });
                    break;
            default: JOptionPane.showMessageDialog(null,"Nic? Szkoda...");
        }
        

    }
    
}