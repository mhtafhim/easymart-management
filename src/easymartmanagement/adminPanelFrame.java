/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymartmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tafhim
 */
public class adminPanelFrame extends javax.swing.JFrame {

    /**
     * Creates new form adminPanelFrame
     */
    Connection con;

    public adminPanelFrame() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/easymart");
            if (con != null) {
                System.out.println("connection establised");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error in connection", JOptionPane.INFORMATION_MESSAGE);
        }
        showAll();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void showAll() {
        try {
            String sql = "SELECT * FROM LOGINDATA WHERE ROLE = 'admin'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            adminPanelTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

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

        emailField = new textfield.TextField();
        addAdminButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        UpdateAdminButton = new javax.swing.JButton();
        DeleteAdminButton = new javax.swing.JButton();
        RefreshButton = new javax.swing.JButton();
        JscrollPane = new javax.swing.JScrollPane();
        adminPanelTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailField.setBackground(new java.awt.Color(140, 207, 207));
        emailField.setLabelText("Admin Email");
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 890, -1));

        addAdminButton.setBackground(new java.awt.Color(140, 207, 207));
        addAdminButton.setText("Add New Admin");
        addAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 170, 40));

        jPanel1.setBackground(new java.awt.Color(140, 207, 207));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UpdateAdminButton.setBackground(new java.awt.Color(140, 207, 207));
        UpdateAdminButton.setText("Update Admin Info");
        UpdateAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAdminButtonActionPerformed(evt);
            }
        });
        jPanel1.add(UpdateAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 180, 40));

        DeleteAdminButton.setBackground(new java.awt.Color(140, 207, 207));
        DeleteAdminButton.setText("Delete Admin");
        DeleteAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAdminButtonActionPerformed(evt);
            }
        });
        jPanel1.add(DeleteAdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, 190, 40));

        RefreshButton.setBackground(new java.awt.Color(140, 207, 207));
        RefreshButton.setText("Refresh");
        RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshButtonActionPerformed(evt);
            }
        });
        jPanel1.add(RefreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 210, 40));

        adminPanelTable.setBackground(new java.awt.Color(140, 207, 207));
        adminPanelTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        JscrollPane.setViewportView(adminPanelTable);

        jPanel1.add(JscrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 890, 340));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminButtonActionPerformed
        // TODO add your handling code here:
        new RegisterPage(5).setVisible(true);

    }//GEN-LAST:event_addAdminButtonActionPerformed

    private void UpdateAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAdminButtonActionPerformed
        // TODO add your handling code here:
           if (emailField.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Input the Email/username of Admin you want to update info.");
        } else {
            new RegisterPage(emailField.getText(),10).setVisible(true);
        }
    }//GEN-LAST:event_UpdateAdminButtonActionPerformed

    private void deleteButtonAction() {
        int row = -1;
        try {
            String email = toLowerCase(emailField.getText());
            String sql = "DELETE FROM LOGINDATA WHERE EMAIL = '" + email + "'";

            Statement st = con.createStatement();

            row = st.executeUpdate(sql);
            emailField.setText("");
            System.out.println("Deletion successful. Row:" + row + " Information");
            //  JOptionPane.showMessageDialog(null, "Deletion successful. Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        showAll();
    }


    private void DeleteAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAdminButtonActionPerformed
        // TODO add your handling code here:
        String email = emailField.getText();

        if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Input the Email of admin you want to delete.");
        } else {
            int choose = JOptionPane.showConfirmDialog(null,
                    "Do you really want to delete ('" + email + "') ?",
                    "Confirm Remove", JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE);
            if (choose == JOptionPane.YES_OPTION) {

                deleteButtonAction();

            } else {
                System.out.println("do nothing");
            }
        }
    }//GEN-LAST:event_DeleteAdminButtonActionPerformed

    private void RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshButtonActionPerformed
        // TODO add your handling code here:
        showAll();
    }//GEN-LAST:event_RefreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(adminPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanelFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanelFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteAdminButton;
    private javax.swing.JScrollPane JscrollPane;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JButton UpdateAdminButton;
    private javax.swing.JButton addAdminButton;
    private javax.swing.JTable adminPanelTable;
    private textfield.TextField emailField;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
