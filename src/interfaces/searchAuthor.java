/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import application.Global;
import application.InterfaceCode;
import application.InterfaceFunctions;

/**
 *
 * @author carri
 */
public class searchAuthor extends javax.swing.JFrame {

    /**
     * Creates new form searchAuthor
     */
    public searchAuthor() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        selectedRutesLabel = new javax.swing.JLabel();
        transmitterStorage = new javax.swing.JLabel();
        backToTheMenuButton = new javax.swing.JButton();
        SearchSummarryButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();
        authorsComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        resumenesTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        selectedRutesLabel.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        selectedRutesLabel.setForeground(new java.awt.Color(255, 255, 255));
        selectedRutesLabel.setText(" Resumen:");
        jPanel2.add(selectedRutesLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, -1));

        transmitterStorage.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        transmitterStorage.setForeground(new java.awt.Color(255, 255, 255));
        transmitterStorage.setText("Buscar Autores:");
        jPanel2.add(transmitterStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 180, -1));

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

        authorsComboBox.setBackground(new java.awt.Color(255, 255, 255));
        authorsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        authorsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                authorsComboBoxActionPerformed(evt);
            }
        });
        jPanel2.add(authorsComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, 40));

        resumenesTextArea.setBackground(new java.awt.Color(255, 255, 255));
        resumenesTextArea.setColumns(20);
        resumenesTextArea.setRows(5);
        jScrollPane1.setViewportView(resumenesTextArea);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 213, 390, 100));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(315, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(187, 187, 187))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 502, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backToTheMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToTheMenuButtonActionPerformed
        InterfaceCode.returnToMainPage();
    }//GEN-LAST:event_backToTheMenuButtonActionPerformed

    private void SearchSummarryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchSummarryButtonActionPerformed
        this.resumenesTextArea.setText("");
        InterfaceFunctions iF = new InterfaceFunctions();
        String autor = this.authorsComboBox.getSelectedItem().toString();
        String texto = iF.deAutorAString(autor);
        this.resumenesTextArea.setText(texto);
    }//GEN-LAST:event_SearchSummarryButtonActionPerformed

    public void vaciar(){
        resumenesTextArea.setText("");
    }
    private void authorsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_authorsComboBoxActionPerformed
        
    }//GEN-LAST:event_authorsComboBoxActionPerformed

    public void llenarComboBox(){
        this.authorsComboBox.removeAllItems();
        InterfaceFunctions iF = new InterfaceFunctions();
        String[] itemsDelComboBox = iF.deListaDeAutoresAArray();
        for (int i = 0; i < itemsDelComboBox.length; i++) {
            this.authorsComboBox.addItem(itemsDelComboBox[i]);
        }
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
            java.util.logging.Logger.getLogger(searchAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(searchAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(searchAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(searchAuthor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new searchAuthor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton SearchSummarryButton;
    private javax.swing.JComboBox<String> authorsComboBox;
    private javax.swing.JButton backToTheMenuButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea resumenesTextArea;
    private javax.swing.JLabel selectedRutesLabel;
    private javax.swing.JLabel transmitterStorage;
    // End of variables declaration//GEN-END:variables
}
