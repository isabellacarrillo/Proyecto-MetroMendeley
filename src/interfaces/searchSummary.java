/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import application.InterfaceCode;
import application.InterfaceFunctions;

/**
 *
 * @author Andres
 */
public class searchSummary extends javax.swing.JFrame {

    /**
     * Creates new form searchSummary
     */
    public searchSummary() {
        initComponents();
        resumenesTextArea.setEditable(false);
        resumenesTextArea.setLineWrap(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        summarylabel = new javax.swing.JLabel();
        searchdatalabel = new javax.swing.JLabel();
        backToTheMenuButton = new javax.swing.JButton();
        SearchSummarryButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenesTextArea = new javax.swing.JTextArea();
        resumenesComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        summarylabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        summarylabel.setForeground(new java.awt.Color(255, 255, 255));
        summarylabel.setText(" Resumen:");
        jPanel2.add(summarylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 180, -1));

        searchdatalabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        searchdatalabel.setForeground(new java.awt.Color(255, 255, 255));
        searchdatalabel.setText("Buscar datos del resumen :");
        jPanel2.add(searchdatalabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 230, -1));

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
        jPanel2.add(SearchSummarryButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 150, 40));

        jPanel2.add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        resumenesTextArea.setBackground(new java.awt.Color(255, 255, 255));
        resumenesTextArea.setColumns(20);
        resumenesTextArea.setRows(5);
        jScrollPane1.setViewportView(resumenesTextArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 400, 390));

        resumenesComboBox.setBackground(new java.awt.Color(255, 255, 255));
        resumenesComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel2.add(resumenesComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 440, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 898, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTheMenuButtonActionPerformed
        InterfaceCode.returnToMainPage();
    }//GEN-LAST:event_backToTheMenuButtonActionPerformed

        public void llenarComboBox(){
        this.resumenesComboBox.removeAllItems();
        InterfaceFunctions iF = new InterfaceFunctions();
        String[] itemsDelComboBox = iF.deListaDeResumenesAArray();
        for (int i = 0; i < itemsDelComboBox.length; i++) {
            this.resumenesComboBox.addItem(itemsDelComboBox[i]);
        }
    }
    
    private void SearchSummarryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSummarryButtonActionPerformed
        this.resumenesTextArea.setText("");
        InterfaceFunctions iF = new InterfaceFunctions();
        String resumen = this.resumenesComboBox.getSelectedItem().toString();
        String texto = iF.deSummaryAString(resumen);
        this.resumenesTextArea.setText(texto);
    }//GEN-LAST:event_SearchSummarryButtonActionPerformed

    public void vaciar(){
        resumenesTextArea.setText("");
    }
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
            java.util.logging.Logger.getLogger(searchSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchSummary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchSummary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton SearchSummarryButton;
    private javax.swing.JButton backToTheMenuButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> resumenesComboBox;
    private javax.swing.JTextArea resumenesTextArea;
    private javax.swing.JLabel searchdatalabel;
    private javax.swing.JLabel summarylabel;
    // End of variables declaration//GEN-END:variables
}
