/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ounis.replacechars;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.text.AbstractDocument;

//git token: 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
/**
 *
 * @author AndroidAppsPlatform
 */
public class MainFrame extends JFrame implements ActionListener {

    String[] aSpecialChars = {".", "^"};

    private String convertSpecChar2RegEx(String str) {
        String result = str;

        for (String s : aSpecialChars) {
            if (str.equals(s)) {
                result = "[" + s + "]+";
                break;
            }
        }
        return result;
    }

    private String safeBackSlashConv(String aValue) {
        String s = "";

        
        for (char c : aValue.toCharArray()) {
            s += (c == '\\')?String.valueOf(c) + "\\":c;
            
// rozszerzona wersja:            
//            if (c == '\\') {
//                s += String.valueOf(c) + "\\";
//            } else {
//                s += c;
//                
//                }
        }
        return s;
    }

    private String replacceChars(String aStr, String aChar2F, String aChar2R) {
        String result = "";

//        String s = "";
//        for (char c : aChar2F.toCharArray())
//        {
//            
//            if (c == '\\') s += c + "\\";
//            else s += c;
//        }
//        aChar2F = s;
        aChar2F = safeBackSlashConv(aChar2F);
        aChar2R = safeBackSlashConv(aChar2R);

        System.out.println(String.format("%s -> %s", aChar2F, aChar2R));
//        if (aChar2F.length() == 1 && aChar2F.charAt(0) == '\\') 
//            aChar2F += "\\";
//        if (aChar2R.length() == 1 && aChar2R.charAt(0) == '\\') 
//            aChar2R += "\\";

        result = aStr.replaceAll(convertSpecChar2RegEx(aChar2F), aChar2R);
//        result = aStr.replace(aChar2F.charAt(0), aChar2R.charAt(0));

//        for (String buff : aStr.split(aChar2F))
//        {
//            result += String.format("%s%s", buff, aChar2R);
//        }
//        
//        result = (String)result.subSequence(0, result.length() - 2);
//        
        return result;
    }

    private void centerFrameEx()
    {
// nie dzia??a dobrze        
//        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
//        setLocation(p);
       
        setLocationRelativeTo(this);
        
    }
    
    private void centerFrame() {

        // alternatywna wersja centrowania ramki
        Point p = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

        Toolkit kit = getToolkit();
        Dimension frmSize = kit.getScreenSize();

        Dimension scrSize = kit.getScreenSize();

        setLocation(frmSize.width / 2 - getWidth() / 2,
                      frmSize.height / 2 - getHeight() / 2);

    }

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();

        centerFrameEx();

        this.setTitle("ReplaceChars");

        AbstractDocument document;
        document = (AbstractDocument) edCharToFind.getDocument();
        document.setDocumentFilter(new LimitDocumentFilter(1));

        ((AbstractDocument) edCharToReplace.getDocument()).setDocumentFilter(
                      new LimitDocumentFilter(1));

        edCharToReplace.setText("");

        
//        btnGO.addActionListener(this);
//        btnTwist.addActionListener(this);
          btnGO.addActionListener(new btnGoClick());
//                new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (!edSrcString.getText().isEmpty()
//                              && !edCharToFind.getText().isEmpty()
//                              && !edCharToReplace.getText().isEmpty()) {
//
//                    String str = replacceChars(edSrcString.getText(), edCharToFind.getText(),
//                                  edCharToReplace.getText());
//                    edSrcString.setText(str);
//                };
//            }
//        });
        
        btnTwist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String buff = edCharToFind.getText();
                edCharToFind.setText(edCharToReplace.getText());
                edCharToReplace.setText(buff);
            }
        });
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        edSrcString = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        edCharToFind = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        edCharToReplace = new javax.swing.JTextField();
        btnGO = new javax.swing.JButton();
        btnTwist = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Ci??g znak??w:");

        edSrcString.setText("org.gjt.mm.mysql.Driver");

        jLabel2.setText("Szukany znak:");

        edCharToFind.setColumns(1);

        jLabel3.setText("Zast??pnik:");

        edCharToReplace.setColumns(1);

        btnGO.setText("GO!");

        btnTwist.setText("<->");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addComponent(edSrcString, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edCharToFind, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnTwist, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edCharToReplace)
                        .addGap(37, 37, 37)
                        .addComponent(btnGO)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(edSrcString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(edCharToFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(edCharToReplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTwist))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGO)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGO;
    private javax.swing.JButton btnTwist;
    private javax.swing.JTextField edCharToFind;
    private javax.swing.JTextField edCharToReplace;
    private javax.swing.JTextField edSrcString;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    
    //obs??uga klikni??cia przycisku btnGO
    class btnGoClick implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            if (!edSrcString.getText().isEmpty()
                          && !edCharToFind.getText().isEmpty()
                          && !edCharToReplace.getText().isEmpty()) {

                String str = replacceChars(edSrcString.getText(), edCharToFind.getText(),
                              edCharToReplace.getText());
                edSrcString.setText(str);
                
                JOptionPane.showMessageDialog(null,"Posz??o...");
                
            //};
            
        }
      }
    }
    
    
    // obs??uga klikni??cia przycisku btnTwist
    class btnTwistClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            String buff = edCharToFind.getText();
            edCharToFind.setText(edCharToReplace.getText());
            edCharToReplace.setText(buff);
            
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        JOptionPane.showMessageDialog(this, arg0.getSource().getClass());

        if (arg0.getSource()== btnGO) {
        }
        if (arg0.getSource().equals(btnTwist)) {
            
        }
        
    }


}
