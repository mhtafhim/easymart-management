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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tafhim
 */
public class MembersFrame extends javax.swing.JFrame {

    /**
     * Creates new form MembersFrame
     */
   Connection con;

    public MembersFrame() {
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
            String sql = "SELECT * FROM MEMBERS ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            MEMBERTABLE.setModel(DbUtils.resultSetToTableModel(rs));
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

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        memberIDField = new javax.swing.JTextField();
        memberField = new javax.swing.JTextField();
        addressField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MEMBERTABLE = new javax.swing.JTable();
        addMember = new javax.swing.JButton();
        updateMember = new javax.swing.JButton();
        deleteMember = new javax.swing.JButton();
        searchMember = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Member ID");
        jButton1.setActionCommand("memberid");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 16, 125, -1));

        jButton2.setText("Member Name");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 63, 125, -1));

        jButton3.setText("Address");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 110, 125, -1));

        jButton5.setText("Email");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 16, 139, -1));

        jButton6.setText("Phone Number");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 63, -1, -1));

        memberIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberIDFieldActionPerformed(evt);
            }
        });
        getContentPane().add(memberIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 17, 225, -1));
        getContentPane().add(memberField, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 64, 225, -1));
        getContentPane().add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 111, 225, -1));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 17, 301, -1));
        getContentPane().add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(647, 64, 301, -1));

        MEMBERTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MEMBERID", "MEMBERNAME", "ADDRESS", "REGISTERDATE", "EMAIL", "PHONE"
            }
        ));
        jScrollPane1.setViewportView(MEMBERTABLE);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 212, 895, -1));

        addMember.setText("Add Member");
        addMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMemberActionPerformed(evt);
            }
        });
        getContentPane().add(addMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 240, 30));

        updateMember.setText("Update Member Info");
        updateMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateMemberActionPerformed(evt);
            }
        });
        getContentPane().add(updateMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 210, -1));

        deleteMember.setText("Delete Member");
        deleteMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteMemberActionPerformed(evt);
            }
        });
        getContentPane().add(deleteMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 240, -1));

        searchMember.setText("Search ");
        searchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMemberActionPerformed(evt);
            }
        });
        getContentPane().add(searchMember, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 159, 210, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void memberIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_memberIDFieldActionPerformed

    private void addMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMemberActionPerformed
        // TODO add your handling code here:
         int row = -1;
        String memberID = toUpperCase(memberIDField.getText());
        memberIDField.setText("");
        String memberName = memberField.getText();
        String address = addressField.getText();
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-M-dd");   
        String register2 = dateFormat.format(date);
        
        String mail = emailField.getText();
        String phone = phoneField.getText();
        memberField.setText("");
        addressField.setText("");
      
        emailField.setText("");
        phoneField.setText("");
      //  System.out.println(register2);
        try {
            String sql = "INSERT INTO MEMBERS(MEMBERID,MEMBERNAME, ADDRESS,REGISTERDATE,EMAIL,PHONE) VALUES( ?,  ?,  ?,  ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, memberID);
            ps.setString(2, memberName);
            ps.setString(3, address);
            ps.setString(4, register2);
            ps.setString(5, mail);
            ps.setString(6, phone);

            row = ps.executeUpdate();

            System.out.println("Data insertionsuccessful.Row:" + row + "Information");
            //  JOptionPane.showMessageDialog(null, "Data insertionsuccessful.Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);

        }
        showAll();
    }//GEN-LAST:event_addMemberActionPerformed

    private void deleteMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteMemberActionPerformed
        // TODO add your handling code here:
         int row = -1;
        try {
            String memberID = toUpperCase(memberIDField.getText());
            String sql = "DELETE FROM MEMBERS WHERE MEMBERID = '" + memberID + "'";

            Statement st = con.createStatement();

            row = st.executeUpdate(sql);

            System.out.println("Deletion successful. Row:" + row + " Information");
            //  JOptionPane.showMessageDialog(null, "Deletion successful. Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        showAll();
    }//GEN-LAST:event_deleteMemberActionPerformed

    private void updateMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateMemberActionPerformed
        // TODO add your handling code here:
         int row = -1;
         String memberID = toUpperCase(memberIDField.getText());
      //  memberIDField.setText("");
        String memberName = memberField.getText();
        String address = addressField.getText();
      
        String mail = emailField.getText();
        String phone = phoneField.getText();
  //      memberField.setText("");
  //      addressField.setText("");
   //     registerdateField.setText("");
  //     emailField.setText("");
   //     phoneField.setText("");
        
        
        try {
            String sql = "UPDATE MEMBERS SET MEMBERNAME = '" + memberName + "', ADDRESS = '" + address +  "', EMAIL = '" + mail + "', PHONE = '" + phone + "' WHERE MEMBERID = '" + memberID+ "'";
            Statement st = con.createStatement();
            row = st.executeUpdate(sql);

            
            System.out.println( "Data update successful. Row:" + row+ " Information");
        //    JOptionPane.showMessageDialog(null, "Data update successful. Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }
        showAll();
    }//GEN-LAST:event_updateMemberActionPerformed

    private void searchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMemberActionPerformed
        // TODO add your handling code here:
          try {
            // TODO add your handling code here:
            String memberID = toUpperCase(memberIDField.getText());
            String sql = "SELECT * FROM MEMBERS WHERE MEMBERID = '" +memberID +"'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
          //  SimpleDateFormat formatter = null;
          DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
            while(rs.next())
            {
                
                memberField.setText(rs.getString("MEMBERNAME"));
                addressField.setText(rs.getString("ADDRESS"));
                String strDate = dateFormat.format(rs.getDate("REGISTERDATE"));
                
                emailField.setText(rs.getString("EMAIL"));
                phoneField.setText(rs.getString("PHONE"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchMemberActionPerformed

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
            java.util.logging.Logger.getLogger(MembersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MembersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MembersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MembersFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MembersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MEMBERTABLE;
    private javax.swing.JButton addMember;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton deleteMember;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField memberField;
    private javax.swing.JTextField memberIDField;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton searchMember;
    private javax.swing.JButton updateMember;
    // End of variables declaration//GEN-END:variables
}
