/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import application.InterfaceCode;
import application.InterfaceFunctions;

/**
 *
 * @author carri
 */
public class searchKeyWords extends javax.swing.JFrame {

    /**
     * Creates new form addSummary
     */
    public searchKeyWords() {
        initComponents();
        resumenesTextArea.setLineWrap(true);
        resumenesTextArea.setEditable(false);
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
        selectedRutesLabel = new javax.swing.JLabel();
        backToTheMenuButton = new javax.swing.JButton();
        SearchSummarryButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        keywordsTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenesTextArea = new javax.swing.JTextArea();
        transmitterStorage1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 119, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setMinimumSize(new java.awt.Dimension(440, 313));
        jPanel2.setPreferredSize(new java.awt.Dimension(440, 313));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectedRutesLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectedRutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedRutesLabel.setText(" Resumen:");
        jPanel2.add(selectedRutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, -1));

        backToTheMenuButton.setBackground(new java.awt.Color(153, 0, 0));
        backToTheMenuButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        backToTheMenuButton.setForeground(new java.awt.Color(255, 255, 255));
        backToTheMenuButton.setText("<Menu");
        backToTheMenuButton.setBorder(null);
        backToTheMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToTheMenuButtonActionPerformed(evt);
            }
        });
        jPanel2.add(backToTheMenuButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 150, 40));

        SearchSummarryButton.setBackground(new java.awt.Color(0, 0, 0));
        SearchSummarryButton.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        SearchSummarryButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchSummarryButton.setText("Buscar");
        SearchSummarryButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        SearchSummarryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchSummarryButtonActionPerformed(evt);
            }
        });
        jPanel2.add(SearchSummarryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 150, 40));

        jPanel2.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        keywordsTextField.setBackground(new java.awt.Color(255, 255, 255));
        keywordsTextField.setForeground(new java.awt.Color(0, 0, 0));
        keywordsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordsTextFieldActionPerformed(evt);
            }
        });
        jPanel2.add(keywordsTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, 70));

        resumenesTextArea.setBackground(new java.awt.Color(255, 255, 255));
        resumenesTextArea.setColumns(20);
        resumenesTextArea.setRows(5);
        jScrollPane1.setViewportView(resumenesTextArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 420, 110));

        transmitterStorage1.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        transmitterStorage1.setForeground(new java.awt.Color(255, 255, 255));
        transmitterStorage1.setText("Buscar Palabras Claves");
        jPanel2.add(transmitterStorage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTheMenuButtonActionPerformed
        InterfaceCode.returnToMainPage();
    }//GEN-LAST:event_backToTheMenuButtonActionPerformed

    private void SearchSummarryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSummarryButtonActionPerformed
        String palabra = " " + keywordsTextField.getText();
        if (!palabra.equals("")) {
            InterfaceFunctions iF = new InterfaceFunctions();
            String resumenes = iF.deKeywordAString(palabra);
            if (!resumenes.equals("")) {
                resumenesTextArea.setText(resumenes);
            }else{
                resumenesTextArea.setText("No se encontro ningun resumen asociado a esa palabra.");
            }
        }
    }//GEN-LAST:event_SearchSummarryButtonActionPerformed

    public void vaciarTodo(){
        keywordsTextField.setText("");
        resumenesTextArea.setText("");
    }
    
    private void keywordsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordsTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(searchKeyWords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchKeyWords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchKeyWords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchKeyWords.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchKeyWords().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton SearchSummarryButton;
    private javax.swing.JButton backToTheMenuButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField keywordsTextField;
    private javax.swing.JTextArea resumenesTextArea;
    private javax.swing.JLabel selectedRutesLabel;
    private javax.swing.JLabel transmitterStorage1;
    // End of variables declaration//GEN-END:variables
}
