/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easymartmanagement;

import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Tafhim
 */
public class PlaceOrderFrame extends javax.swing.JFrame {

    /**
     * Creates new form PlaceOrderFrame
     */
    int totalQuantity = 0;
    double totalPriceInTotalSection = 0;
    double discount = 0;
    double totalWithVATAmount = 0;

    Connection con;

    public PlaceOrderFrame() {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/easymart");
            if (con != null) {
                System.out.println("connection establised");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error in connection", JOptionPane.INFORMATION_MESSAGE);
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the application ?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                    System.out.println("close");
                    removeAllListedItemButtonActionPerformed();

                } else {
                    System.out.println("do nothing");
                }
            }
        });

        dt(); // daet

        times(); // time

        OrderIDSet();

        cashierNameLabel.setText("Please Log in for cashier Name.");

    }

    public PlaceOrderFrame(String cashier) {
        initComponents();
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/easymart");
            if (con != null) {
                System.out.println("connection establised");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error in connection", JOptionPane.INFORMATION_MESSAGE);
        }

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int choose = JOptionPane.showConfirmDialog(null,
                        "Do you really want to exit the application ?",
                        "Confirm Close", JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (choose == JOptionPane.YES_OPTION) {
                    e.getWindow().dispose();
                    System.out.println("close");
                    removeAllListedItemButtonActionPerformed();

                } else {
                    System.out.println("do nothing");
                }
            }
        });

        dt(); // daet

        times(); // time

        OrderIDSet();

        cashierNameLabel.setText(cashier);

    }

    private void OrderIDSet() {
        try {
            String sql = "SELECT MAX(ORDERID) FROM ALLREPORTTABLE";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //  SimpleDateFormat formatter = null;
            int orderID = 0;
            while (rs.next()) {

                orderID = rs.getInt(1);

            }

            orderID++;

            System.out.println(orderID);
            orderIDLabel.setText("000" + Integer.toString(orderID));

        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void dt() {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

        String dd = sdf.format(d);
        dateLabel.setText(dd);

    }

// time
    Timer t;
    SimpleDateFormat st;
    Date date;
    Time time;

    public void times() {

        t = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

                Date dt = new Date();
                st = new SimpleDateFormat("hh:mm:ss a");

                String tt = st.format(dt);
                timeLabel.setText(tt);

            }

        });

        t.start();

    }

    private void showAll() {
        try {
            String sql = "SELECT * FROM PLACEORDER ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            PLACEORDERTABLE.setModel(DbUtils.resultSetToTableModel(rs));
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
        jTable1 = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogoutButton = new button.MyButton();
        myButton8 = new button.MyButton();
        myButton9 = new button.MyButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        orderIDLabel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        itemNameField = new textfield.TextField();
        itemCodeField = new textfield.TextField();
        quantityField = new textfield.TextField();
        priceField = new textfield.TextField();
        searchItemButton = new button.MyButton();
        addCartButton = new button.MyButton();
        packsizeField = new textfield.TextField();
        jLabel16 = new javax.swing.JLabel();
        totalPriceLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        itemCountField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        totalAmount = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        discountField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        totalWithVAT = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        memberIDField = new textfield.TextField();
        searchMember = new button.MyButton();
        CustomerNameField = new textfield.TextField();
        phoneField = new textfield.TextField();
        addressField = new textfield.TextField();
        emailField = new textfield.TextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        PLACEORDERTABLE = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cashierNameLabel = new javax.swing.JLabel();
        PlaceOrderButton = new button.MyButton();
        removeAllListedItemButton = new button.MyButton();

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

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("MV Boli", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Easy Mart");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 100));

        LogoutButton.setText("Log Out");
        LogoutButton.setRadius(20);
        LogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButtonActionPerformed(evt);
            }
        });
        jPanel1.add(LogoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 250, 40));

        myButton8.setText("Add Easy Member");
        myButton8.setRadius(80);
        myButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(myButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 250, 70));

        myButton9.setText("Add New Items");
        myButton9.setRadius(80);
        myButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton9ActionPerformed(evt);
            }
        });
        jPanel1.add(myButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 250, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Place Order");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 210, 30));

        jPanel4.setBackground(new java.awt.Color(153, 204, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Order ID :");

        orderIDLabel.setFont(new java.awt.Font("Lucida Console", 0, 18)); // NOI18N
        orderIDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        orderIDLabel.setText("0001");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Order Date :");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("2022-02-03 ");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Time ");

        timeLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        timeLabel.setText("00: 00 : 00");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(orderIDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(orderIDLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));

        itemNameField.setBackground(new java.awt.Color(153, 255, 204));
        itemNameField.setLabelText("Item Name");

        itemCodeField.setBackground(new java.awt.Color(153, 255, 204));
        itemCodeField.setLabelText("Item Code");
        itemCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemCodeFieldKeyPressed(evt);
            }
        });

        quantityField.setBackground(new java.awt.Color(153, 255, 204));
        quantityField.setLabelText("Quantity");
        quantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                quantityFieldKeyPressed(evt);
            }
        });

        priceField.setBackground(new java.awt.Color(153, 255, 204));
        priceField.setLabelText("Price(tk.)");

        searchItemButton.setText("Search");
        searchItemButton.setBorderColor(new java.awt.Color(204, 204, 204));
        searchItemButton.setRadius(30);
        searchItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchItemButtonActionPerformed(evt);
            }
        });

        addCartButton.setText("Add Cart");
        addCartButton.setBorderColor(new java.awt.Color(204, 204, 204));
        addCartButton.setRadius(30);
        addCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCartButtonActionPerformed(evt);
            }
        });

        packsizeField.setBackground(new java.awt.Color(153, 255, 204));
        packsizeField.setLabelText("Pack Size");

        jLabel16.setText("Total Price(tk.) : ");

        totalPriceLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalPriceLabel.setText("0.00");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(itemNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(itemCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPriceLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(packsizeField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(addCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packsizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalPriceLabel))
                    .addComponent(addCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total ");

        jLabel6.setText("Item count : ");

        itemCountField.setBackground(new java.awt.Color(153, 255, 204));
        itemCountField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        itemCountField.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Total Amount : ");

        totalAmount.setBackground(new java.awt.Color(153, 255, 204));
        totalAmount.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        totalAmount.setOpaque(false);

        jLabel8.setText("Discount : ");

        discountField.setBackground(new java.awt.Color(153, 255, 204));
        discountField.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        discountField.setOpaque(false);
        discountField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                discountFieldKeyPressed(evt);
            }
        });

        jLabel9.setText("Total with Discount + VAT 15% : ");

        totalWithVAT.setBackground(new java.awt.Color(153, 255, 204));
        totalWithVAT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        totalWithVAT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        totalWithVAT.setOpaque(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalWithVAT)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(discountField)
                            .addComponent(totalAmount)
                            .addComponent(itemCountField)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(itemCountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totalAmount)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(discountField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(totalWithVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));

        memberIDField.setBackground(new java.awt.Color(153, 255, 204));
        memberIDField.setLabelText("Member ID");
        memberIDField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                memberIDFieldKeyPressed(evt);
            }
        });

        searchMember.setText("Search");
        searchMember.setBorderColor(new java.awt.Color(204, 204, 204));
        searchMember.setRadius(30);
        searchMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchMemberActionPerformed(evt);
            }
        });

        CustomerNameField.setBackground(new java.awt.Color(153, 255, 204));
        CustomerNameField.setLabelText("Customer Name");

        phoneField.setBackground(new java.awt.Color(153, 255, 204));
        phoneField.setLabelText("Phone Number");

        addressField.setBackground(new java.awt.Color(153, 255, 204));
        addressField.setLabelText("Address");

        emailField.setBackground(new java.awt.Color(153, 255, 204));
        emailField.setLabelText("Email");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(memberIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(phoneField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchMember, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PLACEORDERTABLE.setBackground(new java.awt.Color(0, 153, 204));
        PLACEORDERTABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ITEMCODE", "ITEMNAME", "ITEMPRICE", "QUANTITY", "TOTALPRICE"
            }
        ));
        PLACEORDERTABLE.setGridColor(new java.awt.Color(0, 0, 0));
        PLACEORDERTABLE.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(PLACEORDERTABLE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cashier Name : ");

        cashierNameLabel.setBackground(new java.awt.Color(204, 204, 255));
        cashierNameLabel.setText("Tafhim");

        PlaceOrderButton.setText("Place Order");
        PlaceOrderButton.setBorderColor(new java.awt.Color(204, 204, 204));
        PlaceOrderButton.setRadius(30);
        PlaceOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaceOrderButtonActionPerformed(evt);
            }
        });

        removeAllListedItemButton.setText("Remove");
        removeAllListedItemButton.setBorderColor(new java.awt.Color(204, 204, 204));
        removeAllListedItemButton.setRadius(30);
        removeAllListedItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAllListedItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(16, 16, 16)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashierNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeAllListedItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(175, 175, 175)
                        .addComponent(PlaceOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cashierNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlaceOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAllListedItemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 830, 570));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchMemberActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String memberID = toUpperCase(memberIDField.getText());
            String sql = "SELECT * FROM MEMBERS WHERE MEMBERID = '" + memberID + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //  SimpleDateFormat formatter = null;

            while (rs.next()) {

                CustomerNameField.setText(rs.getString("MEMBERNAME"));
                addressField.setText(rs.getString("ADDRESS"));
                emailField.setText(rs.getString("EMAIL"));
                phoneField.setText(rs.getString("PHONE"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchMemberActionPerformed

    private void calculateTotalPrice() {
        double quantity = Double.parseDouble(quantityField.getText());
        double price = Double.parseDouble(priceField.getText());
        String totalPrice = Double.toString(quantity * price);

        totalPriceLabel.setText(totalPrice);
    }

    private void searchItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchItemButtonActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            String itemCode = toUpperCase(itemCodeField.getText());
            String sql = "SELECT * FROM ITEMTABLE WHERE ITEMCODE = '" + itemCode + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String UnitPrice = null;
            while (rs.next()) {

                itemNameField.setText(rs.getString("ITEMDESCRIPTION"));
                packsizeField.setText(rs.getString("PACKSIZE"));
                UnitPrice = rs.getString("UNITPRICE");

            }
            quantityField.setText("1");
            priceField.setText(UnitPrice);
            totalPriceLabel.setText(UnitPrice);

        } catch (SQLException ex) {
            Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchItemButtonActionPerformed

    private void quantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityFieldKeyPressed
        // TODO add your handling code here: 
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            calculateTotalPrice();
        }
    }//GEN-LAST:event_quantityFieldKeyPressed

    private void itemCodeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCodeFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                // TODO add your handling code here:
                String itemCode = toUpperCase(itemCodeField.getText());
                String sql = "SELECT * FROM ITEMTABLE WHERE ITEMCODE = '" + itemCode + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                String UnitPrice = null;
                while (rs.next()) {

                    itemNameField.setText(rs.getString("ITEMDESCRIPTION"));
                    packsizeField.setText(rs.getString("PACKSIZE"));
                    UnitPrice = rs.getString("UNITPRICE");

                }
                quantityField.setText("1");
                priceField.setText(UnitPrice);
                totalPriceLabel.setText(UnitPrice);

            } catch (SQLException ex) {
                Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_itemCodeFieldKeyPressed

    private void memberIDFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberIDFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                // TODO add your handling code here:
                String memberID = toUpperCase(memberIDField.getText());
                String sql = "SELECT * FROM MEMBERS WHERE MEMBERID = '" + memberID + "'";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                //  SimpleDateFormat formatter = null;

                while (rs.next()) {

                    CustomerNameField.setText(rs.getString("MEMBERNAME"));
                    addressField.setText(rs.getString("ADDRESS"));
                    emailField.setText(rs.getString("EMAIL"));
                    phoneField.setText(rs.getString("PHONE"));
                }

            } catch (SQLException ex) {
                Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_memberIDFieldKeyPressed

    private void addItemInCartIfitsNotInCart() {
        int row = -1;
        String itemCode = toUpperCase(itemCodeField.getText());
        itemCodeField.setText("");
        String packSize = packsizeField.getText();
        String itemName = itemNameField.getText() + "  " + packSize;

        String quantity = quantityField.getText();
        int quantityint = Integer.parseInt(quantity);
        String unitPrice = priceField.getText();
        String totalPrice = totalPriceLabel.getText();
        itemNameField.setText("");
        packsizeField.setText("");
        quantityField.setText("");
        priceField.setText("");
        totalPriceLabel.setText("0.00");
        totalQuantity = totalQuantity + Integer.parseInt(quantity);

        itemCountField.setText(Integer.toString(totalQuantity));

        totalPriceInTotalSection = totalPriceInTotalSection + Double.parseDouble(totalPrice);
        totalAmount.setText(Double.toString(totalPriceInTotalSection));

        double calculateValue = calculateDiscountAndVat(0, 15);
        totalWithVAT.setText(Double.toString(calculateValue));

        try {
            String sql = "INSERT INTO PLACEORDER(ITEMCODE,ITEMNAME, ITEMPRICE,TOTALPRICE,QUANTITY) VALUES( ?,  ?,  ?,  ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, itemCode);
            ps.setString(2, itemName);
            ps.setString(3, unitPrice);
            ps.setString(4, totalPrice);
            ps.setString(5, quantity);

            row = ps.executeUpdate();

            System.out.println("Inserted successfully");
            //  JOptionPane.showMessageDialog(null, "Data insertionsuccessful.Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);

        }

        showAll();
    }

    private void UpdateItemInCartIfitsInCart() {
        try {
            // TODO add your handling code here:
            String itemCode = toUpperCase(itemCodeField.getText());
            String sql = "SELECT * FROM PLACEORDER WHERE ITEMCODE = '" + itemCode + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                itemNameField.setText(rs.getString("ITEMNAME"));
                //    packsizeField.setText(rs.getString("PACKSIZE"));
                quantityField.setText(rs.getString("QUANTITY"));
                priceField.setText(rs.getString("ITEMPRICE"));
                totalPriceLabel.setText(rs.getString("TOTALPRICE"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void addCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCartButtonActionPerformed

        checkIsItinStack();

    }//GEN-LAST:event_addCartButtonActionPerformed

    private void updateQuantityAfterAddingCart(String itemCode , int quantity){
          int row = -1;
     
        
        try {
            String sql = "UPDATE ITEMTABLE SET  QUANTITY = " + quantity + "WHERE ITEMCODE = '" + itemCode+ "'";
            Statement st = con.createStatement();
            row = st.executeUpdate(sql);

         //   JOptionPane.showMessageDialog(null, "Data updated successfully. Row:" + row, "Information", JOptionPane.INFORMATION_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }
    
    
    private void checkIsItinStack() {
        try {
            // TODO add your handling code here:
            String itemCode = toUpperCase(itemCodeField.getText());
            String sql = "SELECT QUANTITY,ITEMDESCRIPTION FROM ITEMTABLE WHERE ITEMCODE = '" + itemCode + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int quantity=0;
            String name = null;
            while (rs.next()) {

               quantity = rs.getInt("QUANTITY");
               name = rs.getString("ITEMDESCRIPTION");
            
            }
            
            int QuantityInCart = Integer.parseInt(quantityField.getText());
            
            if(quantity<QuantityInCart){
                JOptionPane.showMessageDialog(null, "You dont have enough Stock for "+ name + ". You have "+ quantity + " piece of stock for this item." );
            }else{
                addItemInCartIfitsNotInCart();
                updateQuantityAfterAddingCart(itemCode, (quantity-QuantityInCart));
            }
            

        } catch (SQLException ex){
            Logger.getLogger(ItemListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

    private void removeAllListedItemButtonActionPerformed() {
        int row = -1;

        totalQuantity = 0;

        itemCountField.setText(Integer.toString(totalQuantity));

        totalPriceInTotalSection = 0.00;
        totalAmount.setText(Double.toString(totalPriceInTotalSection));

        try {
            // TODO add your handling code here:

            String sql = "DELETE FROM PLACEORDER ";

            Statement st = con.createStatement();

            row = st.executeUpdate(sql);

            System.out.println("deleted row : " + row);

            CustomerNameField.setText("");
            emailField.setText("");
            addressField.setText("");
            phoneField.setText("");
            memberIDField.setText("");
            itemCodeField.setText("");
            itemNameField.setText("");
            itemCountField.setText("");
            priceField.setText("");
            packsizeField.setText("");
            totalPriceLabel.setText("");
            quantityField.setText("");

        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        showAll();
    }


    private void removeAllListedItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAllListedItemButtonActionPerformed
        int choose = JOptionPane.showConfirmDialog(null,
                "Do you really want to remove all item from cart ?",
                "Confirm Remove", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {

            removeAllListedItemButtonActionPerformed();

        } else {
            System.out.println("do nothing");
        }
    }//GEN-LAST:event_removeAllListedItemButtonActionPerformed

    private void LogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButtonActionPerformed
        // TODO add your handling code here:
        int choose = JOptionPane.showConfirmDialog(null,
                "Do you really want to Logging out ?",
                "Confirm Close", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            new LoginPage().setVisible(true);
            dispose();
            System.out.println("close");

        } else {
            System.out.println("do nothing");
        }
    }//GEN-LAST:event_LogoutButtonActionPerformed

    private double calculateDiscountAndVat(double discount, double VAT) {

        double totalParcentage = VAT - discount;

        double parcentageValue = (totalParcentage * Double.parseDouble(totalAmount.getText())) / 100;

        double ans = Double.parseDouble(totalAmount.getText()) + parcentageValue;

        return ans;
    }


    private void discountFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            double calculateValue = calculateDiscountAndVat(Double.parseDouble(discountField.getText()), 15);
            totalWithVAT.setText(Double.toString(calculateValue));
        }
    }//GEN-LAST:event_discountFieldKeyPressed

    private String concateTheWholeItemDescription() {
        String description = " ";
        try {
            String sql2 = "SELECT * FROM PLACEORDER ";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql2);

            while (rs.next()) {
                String tempDescription = rs.getString("ITEMNAME");
                String tempQuantity = rs.getString("QUANTITY");
                description = description + tempDescription + " x" + tempQuantity + ", ";

            }
        } catch (SQLException ex) {
            Logger.getLogger(PlaceOrderFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return description;
    }

    private void PlaceOrderButtonActionPerformed() {

        int row = -1;
        String tempOderID = orderIDLabel.getText();
        int orderID = Integer.parseInt(tempOderID);

        String phone = phoneField.getText();
        //    String packSize = packsizeField.getText();
        //    String quantity = quantityField.getText();
        String itemName = concateTheWholeItemDescription();

        String totalItem = itemCountField.getText();
        String totalPrice = totalWithVAT.getText();
        String cashierName = cashierNameLabel.getText();

        String name = CustomerNameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        /*   
        SimpleDateFormat orderdateformat = new SimpleDateFormat("yyyy-M-dd");
        
        String OrderDate = st.format(date);
        
        SimpleDateFormat time = new SimpleDateFormat("hh:mm[:ss]");
        Date timeDate = new Date();
        String orderTime = time.format(timeDate);
        
        
        itemNameField.setText("");
        packsizeField.setText("");
        quantityField.setText("");
        priceField.setText("");
        totalPriceLabel.setText("0.00");
        totalQuantity = totalQuantity + Integer.parseInt(quantity);

        itemCountField.setText(Integer.toString(totalQuantity));

        totalPriceInTotalSection = totalPriceInTotalSection + Double.parseDouble(totalPrice);
        totalAmount.setText(Double.toString(totalPriceInTotalSection));
         */
        try {
            String sql = "INSERT INTO ALLREPORTTABLE(ORDERID,CUSTOMERNUMBER, ITEMDESCRIPTIONS,TOTALITEM,TOTALPRICE,CASHIER,ORDERDATE,ORDERTIME,CUSTOMERNAME,CUSTOMERADDRESS,CUSTOMEREMAIL) VALUES( ?,  ?,  ?,  ?, ?,?,CURRENT_DATE,CURRENT_TIME,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setString(2, phone);
            ps.setString(3, itemName);
            ps.setString(4, totalItem);
            ps.setString(5, totalPrice);
            ps.setString(6, cashierName);
            ps.setString(7, name);
            ps.setString(8, address);
            ps.setString(9, email);
            //    ps.setString(7, OrderDate);
            //   ps.setString(8, orderTime);

            row = ps.executeUpdate();

            System.out.println("Inserted successfully into all report database");

            OrderIDSet();

            //  JOptionPane.showMessageDialog(null, "Order Successfully Placed", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                    "Error", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    private void PlaceOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaceOrderButtonActionPerformed
        // TODO add your handling code here:

        int choose = JOptionPane.showConfirmDialog(null,
                "Are you sure about placing your order?",
                "Confirm Order", JOptionPane.YES_NO_OPTION,
                JOptionPane.INFORMATION_MESSAGE);
        if (choose == JOptionPane.YES_OPTION) {
            PlaceOrderButtonActionPerformed();
            removeAllListedItemButtonActionPerformed();

        } else {
            System.out.println("do nothing");
        }


    }//GEN-LAST:event_PlaceOrderButtonActionPerformed

    private void myButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton8ActionPerformed
        // TODO add your handling code here:
        new MembersFrame(5).setVisible(true);
    }//GEN-LAST:event_myButton8ActionPerformed

    private void myButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton9ActionPerformed
        // TODO add your handling code here:
        new ItemListFrame(5).setVisible(true);
    }//GEN-LAST:event_myButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(PlaceOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaceOrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaceOrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField CustomerNameField;
    private button.MyButton LogoutButton;
    private javax.swing.JTable PLACEORDERTABLE;
    private button.MyButton PlaceOrderButton;
    private button.MyButton addCartButton;
    private textfield.TextField addressField;
    private javax.swing.JLabel cashierNameLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField discountField;
    private textfield.TextField emailField;
    private textfield.TextField itemCodeField;
    private javax.swing.JTextField itemCountField;
    private textfield.TextField itemNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private textfield.TextField memberIDField;
    private button.MyButton myButton8;
    private button.MyButton myButton9;
    private javax.swing.JLabel orderIDLabel;
    private textfield.TextField packsizeField;
    private textfield.TextField phoneField;
    private textfield.TextField priceField;
    private textfield.TextField quantityField;
    private button.MyButton removeAllListedItemButton;
    private button.MyButton searchItemButton;
    private button.MyButton searchMember;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField totalAmount;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JTextField totalWithVAT;
    // End of variables declaration//GEN-END:variables
}
