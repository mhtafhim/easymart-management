/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymartmanagement;

import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.toLowerCase;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tafhim
 */
public class allReportFrame extends javax.swing.JFrame {

    /**
     * Creates new form allReportFrame
     */
    Connection con;

    public allReportFrame() {
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

        this.setTitle("All Reports");

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dateChooser();
    }

    private void dateChooser() {

        DateChooser ch = new DateChooser();
        ch.setDateFormat(new SimpleDateFormat("dd-MMM-yyyy"));
        ch.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        ch.addActionDateChooserListener(
                new DateChooserAdapter() {
            @Override
            public void dateChanged(Date date, DateChooserAction action) {
                System.out.println("date single selected...");
            }

            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String toDate = df.format(date.getToDate());
                showAll2("SELECT * FROM ALLREPORTTABLE WHERE ORDERDATE BETWEEN '" + dateFrom + "' AND '" + toDate + "'");
            }
        });

        ch.setTextField(dateChooseField);

        /*    JButton cmd = new JButton("Selected Date");
        ch.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        ch.toDay();
        cmd.addActionListener(
                e -> {
                    // SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                    // DateBetween between = ch.getSelectedDateBetween();
                    //  System.out.println(df.format(between.getFromDate()) + " to " + df.format(between.getToDate()));
                    
                    //  System.out.println(df.format(ch.getSelectedDate()));
                    ch.setSelectedDateBetween(3, 3, 2022, 5, 7, 2022, true);
                    ch.setLabelCurrentDayVisible(false);
                });
        panel.add(cmd);
        
         */
    }

    private void showAll() {
        try {
            String sql = "SELECT * FROM ALLREPORTTABLE ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            allreporttable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void showAll2(String sql) {
        try {
            //  String sql = "SELECT * FROM ALLREPORTTABLE ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            allreporttable.setModel(DbUtils.resultSetToTableModel(rs));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        allreporttable = new javax.swing.JTable();
        orderIDField = new textfield.TextField();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        dateChooseField = new textfield.TextField();
        CloseButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        allreporttable.setModel(new javax.swing.table.DefaultTableModel(
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
        allreporttable.setGridColor(new java.awt.Color(140, 207, 207));
        jScrollPane1.setViewportView(allreporttable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 77, 1020, 390));

        orderIDField.setLabelText("OrderID");
        getContentPane().add(orderIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 320, -1));

        deleteButton.setText("Delete Report");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 480, 270, 40));

        jPanel1.setBackground(new java.awt.Color(140, 207, 207));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateChooseField.setBackground(new java.awt.Color(140, 207, 207));
        dateChooseField.setLabelText("Choose Date");
        jPanel1.add(dateChooseField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 530, 50));

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        jPanel1.add(CloseButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 260, 40));

        jButton1.setBackground(new java.awt.Color(140, 207, 207));
        jButton1.setText("Show All Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 19, 370, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonAction() {
        int row = -1;
        try {
            int orderID = Integer.parseInt(orderIDField.getText());
            String sql = "DELETE FROM ALLREPORTTABLE WHERE ORDERID = " + orderID + "";

            Statement st = con.createStatement();

            row = st.executeUpdate(sql);
            orderIDField.setText("");
            System.out.println("Deletion successful. Row:" + row + " Information");
            //  JOptionPane.showMessageDialog(null, "Deletion successful. Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        showAll();
    }


    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:

        String email = orderIDField.getText();

        if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "Please Input the Order ID you want to delete.");
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

    }//GEN-LAST:event_deleteButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        showAll();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(allReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(allReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(allReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(allReportFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new allReportFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JTable allreporttable;
    private textfield.TextField dateChooseField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private textfield.TextField orderIDField;
    // End of variables declaration//GEN-END:variables
}
