/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenew;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ItemEvent;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class jIntFrmMainScreen extends javax.swing.JInternalFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    ResultSet rs1 = null;
    Statement stmt = null;
    Statement stmt1 = null;
    String query = null;
    DefaultTableModel model1 = null;
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    String time = new SimpleDateFormat("HH:mm").format(new Date());
    int i = 0, rowcount = 0, sl_no = 0, cust_no = 0, NOT = 0, bill_no = 0;
    String[] typename;
    String type, fee;
    String ticket, amount;
    DecimalFormat df = new DecimalFormat("0.00");
    double SC = 0, TP = 0, ET = 0;
    String text = "";
    boolean phone = true, brcode = true, email = true;

    public jIntFrmMainScreen() {
        try {
            initComponents();
            con = new DBConnection().connect();
            query = "select TYPE_NO,NAME from MST_TYPE where flag != 'D'";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            jcmbType.addItem("");
            while (rs.next()) {
                jcmbType.addItem(rs.getString(1) + "   " + rs.getString(2));
            }
            ButtonGroup type = new ButtonGroup();
            type.add(jrbtnBarcode);
            type.add(jrbtnPhone);

            query = "select TYPE_NO,NAME from MST_TYPE where flag != 'D'";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            jcmbType1.addItem("");
            while (rs.next()) {
                jcmbType1.addItem(rs.getString(1) + "   " + rs.getString(2));
            }


            jlblCredit.setVisible(false);
            jtxtCredit.setVisible(false);
            jlblCode.setVisible(false);
            jtxtBRCode.setVisible(false);
            jdteMD.setVisible(false);
            jlblMD.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(jIntFrmMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class MyTraversalPolicy extends FocusTraversalPolicy {

        @Override
        public Component getComponentAfter(Container aContainer, Component aComponent) {
            if (aComponent.equals(jcmbType)) {
                return jtxtBRCode;
            } else if (aComponent.equals(jtxtBRCode)) {
                return jtxtName;
            } else if (aComponent.equals(jtxtName)) {
                return jdteDOB;
            } else if (aComponent.equals(jdteDOB)) {
                return jtxtPhone;
            } else if (aComponent.equals(jtxtPhone)) {
                return jtxtEmail;
            } else if (aComponent.equals(jtxtEmail)) {
                return jtxtCredit;
            } else if (aComponent.equals(jtxtCredit)) {
                return jcmbType;
            } else if (aComponent.equals(jcmbType1)) {
                return jtxtSearch;
            } else if (aComponent.equals(jtxtSearch)) {
                return jbtnSearch;
            } else if (aComponent.equals(jbtnSearch)) {
                return jcmbNOL1;
            } else if (aComponent.equals(jcmbNOL1)) {
                return jbtnAdd;
            } else if (aComponent.equals(jbtnAdd)) {
                return jbtnPrint1;
            } else if (aComponent.equals(jbtnPrint1)) {
                return jcmbType1;
            } else {
                return jcmbType;
            }
        }

        @Override
        public Component getComponentBefore(Container aContainer, Component aComponent) {
            if (aComponent.equals(jcmbType)) {
                return jtxtCredit;
            } else if (aComponent.equals(jtxtBRCode)) {
                return jcmbType;
            } else if (aComponent.equals(jtxtName)) {
                return jtxtBRCode;
            } else if (aComponent.equals(jdteDOB)) {
                return jtxtName;
            } else if (aComponent.equals(jtxtPhone)) {
                return jdteDOB;
            } else if (aComponent.equals(jtxtEmail)) {
                return jtxtPhone;
            } else if (aComponent.equals(jtxtCredit)) {
                return jcmbType;
            } else if (aComponent.equals(jcmbType1)) {
                return jbtnPrint1;
            } else if (aComponent.equals(jtxtSearch)) {
                return jcmbType1;
            } else if (aComponent.equals(jbtnSearch)) {
                return jtxtSearch;
            } else if (aComponent.equals(jcmbNOL1)) {
                return jbtnSearch;
            } else if (aComponent.equals(jbtnAdd)) {
                return jcmbNOL1;
            } else if (aComponent.equals(jbtnPrint1)) {
                return jbtnAdd;
            } else {
                return jcmbType;
            }
        }

        @Override
        public Component getFirstComponent(Container aContainer) {
            return jcmbType;
        }

        @Override
        public Component getLastComponent(Container aContainer) {
            return jtxtCredit;
        }

        @Override
        public Component getDefaultComponent(Container aContainer) {
            return jcmbType;
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

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlblType = new javax.swing.JLabel();
        jcmbType = new javax.swing.JComboBox();
        jlblCode = new javax.swing.JLabel();
        jtxtBRCode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblCredit = new javax.swing.JLabel();
        jtxtPhone = new javax.swing.JTextField();
        jtxtEmail = new javax.swing.JTextField();
        jdteDOB = new com.toedter.calendar.JDateChooser();
        jtxtPrice = new javax.swing.JTextField();
        jtxtCredit = new javax.swing.JTextField();
        jbtnPrint = new javax.swing.JButton();
        jcmbNOL = new javax.swing.JComboBox();
        jtxtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtxtNOT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jlblType1 = new javax.swing.JLabel();
        jcmbType1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jtxtName1 = new javax.swing.JTextField();
        jdteDOB1 = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtPhone1 = new javax.swing.JTextField();
        jtxtEmail1 = new javax.swing.JTextField();
        jcmbNOL1 = new javax.swing.JComboBox();
        jtxtPrice1 = new javax.swing.JTextField();
        jtxtCredit1 = new javax.swing.JTextField();
        jlblCredit1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtSearch = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jbtnAdd = new javax.swing.JButton();
        jbtnPrint1 = new javax.swing.JButton();
        jrbtnBarcode = new javax.swing.JRadioButton();
        jrbtnPhone = new javax.swing.JRadioButton();
        jlblBRCode1 = new javax.swing.JLabel();
        jtxtBRCode1 = new javax.swing.JTextField();
        jlblMD = new javax.swing.JLabel();
        jdteMD = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jtxtNOT1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jtxtTotal1 = new javax.swing.JTextField();

        setClosable(true);
        setTitle("BILL PRINTER");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jlblType.setText("TYPE");

        jcmbType.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbTypeItemStateChanged(evt);
            }
        });

        jlblCode.setText("CODE");

        jtxtBRCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtBRCodeKeyPressed(evt);
            }
        });

        jLabel3.setText("NAME");

        jLabel4.setText("DOB");

        jLabel5.setText("PHONE");

        jLabel6.setText("EMAIL");

        jLabel7.setText("NO. OF LAPS");

        jLabel8.setText("RENT");

        jlblCredit.setText("STORE CREDIT");

        jtxtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtPhoneKeyPressed(evt);
            }
        });

        jtxtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtEmailKeyPressed(evt);
            }
        });

        jtxtPrice.setEditable(false);

        jtxtCredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtCreditKeyPressed(evt);
            }
        });

        jbtnPrint.setText("PRINT");
        jbtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrintActionPerformed(evt);
            }
        });

        jcmbNOL.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbNOLItemStateChanged(evt);
            }
        });

        jtxtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNameKeyPressed(evt);
            }
        });

        jLabel2.setText("NO. OF PEOPLE");

        jtxtNOT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNOTKeyPressed(evt);
            }
        });

        jLabel16.setText(" TOTAL");

        jtxtTotal.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblType)
                            .addComponent(jlblCode)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtBRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdteDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcmbNOL, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(36, 36, 36)
                        .addComponent(jtxtNOT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jlblCredit)
                            .addComponent(jLabel16))
                        .addGap(38, 38, 38)
                        .addComponent(jbtnPrint)))
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblType)
                    .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCode)
                    .addComponent(jtxtBRCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jdteDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNOT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcmbNOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblCredit)
                    .addComponent(jtxtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnPrint)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("NEW", jPanel2);

        jlblType1.setText("TYPE");

        jcmbType1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbType1ItemStateChanged(evt);
            }
        });

        jLabel9.setText("NAME");

        jtxtName1.setEditable(false);

        jdteDOB1.setEnabled(false);

        jLabel10.setText("DOB");

        jLabel11.setText("PHONE");

        jtxtPhone1.setEditable(false);

        jtxtEmail1.setEditable(false);

        jcmbNOL1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcmbNOL1ItemStateChanged(evt);
            }
        });

        jtxtPrice1.setEditable(false);

        jtxtCredit1.setEditable(false);

        jlblCredit1.setText("STORE CREDIT");

        jLabel12.setText("RENT");

        jLabel13.setText("NO. OF LAPS");

        jLabel14.setText("EMAIL");

        jLabel1.setText("SEARCH");

        jtxtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtSearchKeyPressed(evt);
            }
        });

        jbtnSearch.setText("SEARCH");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
            }
        });

        jbtnAdd.setText("ADD");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnPrint1.setText("PRINT");
        jbtnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPrint1ActionPerformed(evt);
            }
        });

        jrbtnBarcode.setSelected(true);
        jrbtnBarcode.setText("BAR CODE");
        jrbtnBarcode.setName("type"); // NOI18N

        jrbtnPhone.setText("PHONE");
        jrbtnPhone.setName("type"); // NOI18N

        jlblBRCode1.setText("BR CODE");

        jtxtBRCode1.setEditable(false);

        jlblMD.setText("MEMBERSHIP DATE");

        jdteMD.setEnabled(false);

        jLabel15.setText("NO OF RECEIPT");

        jtxtNOT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtNOT1KeyPressed(evt);
            }
        });

        jLabel17.setText(" TOTAL");

        jtxtTotal1.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblType1)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jlblCredit1)
                    .addComponent(jLabel12)
                    .addComponent(jlblBRCode1)
                    .addComponent(jlblMD)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jtxtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcmbNOL1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtNOT1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtxtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jtxtCredit1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jbtnAdd))
                                    .addComponent(jtxtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdteDOB1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jrbtnBarcode)
                                        .addGap(10, 10, 10)
                                        .addComponent(jrbtnPhone))
                                    .addComponent(jtxtName1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtBRCode1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdteMD, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jbtnSearch)
                                    .addComponent(jbtnPrint1)))
                            .addComponent(jcmbType1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(55, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblType1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jrbtnBarcode)
                            .addComponent(jrbtnPhone))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jbtnSearch))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addComponent(jdteDOB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtPhone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtBRCode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblBRCode1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdteMD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblMD))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtxtNOT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbNOL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtPrice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtxtTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtCredit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblCredit1)
                    .addComponent(jbtnAdd)
                    .addComponent(jbtnPrint1))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("EXISTING", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcmbTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbTypeItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!jcmbType.getSelectedItem().equals("")) {
                try {
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);
                    typename = jcmbType.getSelectedItem().toString().split("   ");
                    query = "select type from mst_type where type_no = '" + typename[0] + "' and flag != 'D'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        type = rs.getString(1);
                    }

                    query = "select distinct(NO_OF_LAPS) from MST_LAP where type_no =  ? and flag != 'D'";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, typename[0]);
                    rs = pstmt.executeQuery();
                    jcmbNOL.removeAllItems();
                    jcmbNOL.addItem("");
                    while (rs.next()) {
                        jcmbNOL.addItem(rs.getString(1));
                    }
                    if (type.equals("PRIVILEGE")) {
                        jlblCredit.setVisible(true);
                        jtxtCredit.setVisible(true);
                        jlblCode.setVisible(true);
                        jtxtBRCode.setVisible(true);
                        jcmbNOL.setSelectedItem("");
                        jtxtPrice.setText("");
                        query = "select fee from mst_min_sc where type_no = '" + typename[0] + "' and flag != 'D'";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            fee = rs.getString(1);
                        }
                        jtxtCredit.setText(fee);
                    } else {
                        jlblCredit.setVisible(false);
                        jtxtCredit.setVisible(false);
                        jlblCode.setVisible(false);
                        jtxtBRCode.setVisible(false);
                        jcmbNOL.setSelectedItem("");
                        jtxtPrice.setText("");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(jIntFrmMainScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jcmbTypeItemStateChanged

    private void jbtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrintActionPerformed
        try {
            if (jcmbType.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select a type!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                con = new DBConnection().connect();
                con.setAutoCommit(false);
                typename = jcmbType.getSelectedItem().toString().split("   ");
                query = "select type from mst_type where type_no = '" + typename[0] + "'  and flag != 'D'";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    type = rs.getString(1);
                }
                if (type.equals("PRIVILEGE")) {
                    if (jtxtBRCode.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter the BR code!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    } else if (jtxtCredit.getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(this, "Please enter the credit!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                if (jtxtName.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the name!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jdteDOB.getDate() == null) {
                    JOptionPane.showMessageDialog(this, "Please enter the DOB!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jtxtPhone.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the phone number!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jtxtEmail.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the email!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jcmbNOL.getSelectedItem().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please select NOL!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jtxtPrice.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter the price!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else if (jtxtNOT.getText().trim().equals("")) {
                    JOptionPane.showMessageDialog(this, "Please enter no. of tickets!", "Info", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    i = 0;
                    NOT = 0;
                    typename = jcmbType.getSelectedItem().toString().split("   ");
                    query = "select PHONE from mst_customer where flag!='D' and PHONE = '" + jtxtPhone.getText().trim() + "'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        phone = false;
                    } else {
                        phone = true;
                    }

                    query = "select email from mst_customer where flag!='D' and email = '" + jtxtEmail.getText().trim() + "'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        email = false;
                    } else {
                        email = true;
                    }

                    if (type.equals("PRIVILEGE")) {
                        query = "select BR_NO from mst_customer where flag!='D' and BR_NO = '" + jtxtBRCode.getText().trim() + "'";

                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            brcode = false;
                        } else {
                            brcode = true;
                        }
                    }
                    if (phone && brcode && email) {
                        if (type.equals("PRIVILEGE")) {
                            query = "INSERT INTO mst_customer(BR_NO,NAME,DOB,PHONE,EMAIL,TYPE_NO,FLAG,DATE_CREATED,MEMBERSHIP_DATE) VALUES (?,?,?,?,?,?,?,?,?)";
                            pstmt = con.prepareStatement(query);
                            pstmt.setString(1, jtxtBRCode.getText().trim());
                            pstmt.setString(2, jtxtName.getText().trim());
                            pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(jdteDOB.getDate()));
                            pstmt.setString(4, jtxtPhone.getText().trim());
                            pstmt.setString(5, jtxtEmail.getText().trim());
                            pstmt.setString(6, typename[0]);
                            pstmt.setString(7, "I");
                            pstmt.setString(8, today);
                            pstmt.setString(9, today);
                        } else {
                            query = "INSERT INTO mst_customer(BR_NO,NAME,DOB,PHONE,EMAIL,TYPE_NO,FLAG,DATE_CREATED) VALUES (?,?,?,?,?,?,?,?)";
                            pstmt = con.prepareStatement(query);
                            pstmt.setString(1, jtxtBRCode.getText().trim());
                            pstmt.setString(2, jtxtName.getText().trim());
                            pstmt.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(jdteDOB.getDate()));
                            pstmt.setString(4, jtxtPhone.getText().trim());
                            pstmt.setString(5, jtxtEmail.getText().trim());
                            pstmt.setString(6, typename[0]);
                            pstmt.setString(7, "I");
                            pstmt.setString(8, today);
                        }
                        i = pstmt.executeUpdate();

                        query = "select max(customer_no) from mst_customer where flag!='D'";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            cust_no = rs.getInt(1);
                        }
                        query = "select tax from mst_tax where flag!='D' and tax_no = 1";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            ET = rs.getDouble(1);
                        }
                        NOT = Integer.parseInt(jtxtNOT.getText());
                        time = new SimpleDateFormat("HH:mm").format(new Date());
                        for (int k = 0; k < NOT; k++) {
                            query = "INSERT INTO trn_history(CUSTOMER_NO,DATE,NO_OF_LAPS,FEE,FLAG,DATE_CREATED) VALUES (?,?,?,?,?,?)";
                            pstmt = con.prepareStatement(query);
                            pstmt.setInt(1, cust_no);
                            pstmt.setString(2, today);
                            pstmt.setString(3, jcmbNOL.getSelectedItem().toString());
                            pstmt.setDouble(4, Double.valueOf(jtxtPrice.getText()) + (Double.valueOf(jtxtPrice.getText()) * ET / 100));
                            pstmt.setString(5, "I");
                            pstmt.setString(6, today);
                            i = i + pstmt.executeUpdate();
                            query = "select max(sl_no) from trn_history where flag!='D'";
                            stmt = con.createStatement();
                            rs = stmt.executeQuery(query);
                            if (rs.next()) {
                                bill_no = rs.getInt(1);
                            }
                            ticket = "     TUNER'S EDGE MOTORSPORTS HUB          ;"
                                    + "                     SPEEDWAY KOCHI     ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  Date: " + today + "  Time: " + time + "  Bill # : " + bill_no + "   ;"
                                    + "  Name: " + jtxtName.getText() + ";"
                                    + "  Phone: " + jtxtPhone.getText() + "  ;"
                                    + "  Email: " + jtxtEmail.getText() + "  ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  Laps      Amount    ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  " + jcmbNOL.getSelectedItem() + "             " + df.format(Double.valueOf(jtxtPrice.getText())) + ";"
                                    + "  --------------------------------------------------------------;"
                                   // + "  Entertainment tax @ " + df.format(ET) + " % : " + df.format(Double.valueOf(jtxtPrice.getText()) * ET / 100) + ";"
                                    + "  Total Amount : " + df.format(Double.valueOf(jtxtPrice.getText()) + (Double.valueOf(jtxtPrice.getText()) * ET / 100)) + "  ;"
                                    + "  --------------------------------------------------------------;";
                            if (type.equals("PRIVILEGE")) {
                                query = "INSERT INTO trn_account(CUSTOMER_NO,DATE,AMOUNT,FLAG,DATE_CREATED) VALUES (?,?,?,?,?)";
                                pstmt = con.prepareStatement(query);
                                pstmt.setInt(1, cust_no);
                                pstmt.setString(2, today);
                                pstmt.setDouble(3, Double.valueOf(jtxtCredit.getText().trim()));
                                pstmt.setString(4, "I");
                                pstmt.setString(5, today);
                                i = i + pstmt.executeUpdate();
                                ticket = "     TUNER'S EDGE MOTORSPORTS HUB          ;"
                                        + "                     SPEEDWAY KOCHI     ;"
                                        + "  --------------------------------------------------------------;"
                                        + "   Date: " + today + "  Time: " + time + "  Bill # : " + bill_no + "   ;"
                                        + "   Name: " + jtxtName.getText() + ";"
                                        + "   Phone: " + jtxtPhone.getText() + "  ;"
                                        + "   Email: " + jtxtEmail.getText() + "  ;"
                                        + "  --------------------------------------------------------------;"
                                        + "   Laps      Amount    ;"
                                        + "  --------------------------------------------------------------;"
                                        + "   " + jcmbNOL.getSelectedItem() + "             " + df.format(Double.valueOf(jtxtPrice.getText())) + ";"
                                        + "  --------------------------------------------------------------;"
                                        //+ "   Entertainment tax @ " + df.format(ET) + " % : " + df.format(Double.valueOf(jtxtPrice.getText()) * ET / 100) + ";"
                                        + "   Total Amount : " + df.format(Double.valueOf(jtxtPrice.getText()) + (Double.valueOf(jtxtPrice.getText()) * ET / 100)) + "  ;"
                                        + "  --------------------------------------------------------------;"
                                        + "   Total Store Credit : " + df.format(Double.valueOf(jtxtCredit.getText()) - (Double.valueOf(jtxtPrice.getText()) + (Double.valueOf(jtxtPrice.getText()) * ET / 100))) + "  ;"
                                        + "  --------------------------------------------------------------;";
                            }
                            Printer.setmText(ticket);
                            new Printer().PrintTicket();
                        }
                        if (i >= 2) {
                            if (Global.update) {
                                con.commit();
                            }
                            i = 0;
                            JOptionPane.showMessageDialog(this, "Added Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                            clear();
                        }
                    } else {
                        if (!phone) {
                            JOptionPane.showMessageDialog(this, "This phone number already exist", "Info", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "This email id already exist", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(jIntFrmMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PrinterException ex) {
            Logger.getLogger(jIntFrmMainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbtnPrintActionPerformed
    private void clear() {
        jcmbType.setSelectedItem("");
        jtxtBRCode.setText("");
        jtxtCredit.setText("");
        jtxtEmail.setText("");
        jcmbNOL.setSelectedItem("");
        jtxtName.setText("");
        jtxtPhone.setText("");
        jtxtPrice.setText("");
        jdteDOB.setDate(null);
        jdteMD.setDate(null);
        jtxtNOT.setText("");
    }
    private void jcmbNOLItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbNOLItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!jcmbNOL.getSelectedItem().equals("")) {
                if (!jcmbType.getSelectedItem().equals("")) {
                    if (!jtxtNOT.getText().equals("")) {
                        try {

                            typename = jcmbType.getSelectedItem().toString().split("   ");
                            con = new DBConnection().connect();
                            query = "select fee from MST_LAP where flag != 'D' and NO_OF_LAPS = ? and TYPE_NO = ?";
                            pstmt = con.prepareStatement(query);
                            pstmt.setString(1, jcmbNOL.getSelectedItem().toString());
                            pstmt.setString(2, typename[0]);
                            rs = pstmt.executeQuery();
                            if (rs.next()) {
                                jtxtPrice.setText(rs.getString(1));
                            }
                            jtxtTotal.setText(String.valueOf(Integer.parseInt(jtxtNOT.getText()) * Integer.parseInt(jtxtPrice.getText())));
                        } catch (SQLException ex) {
                            Logger.getLogger(jIntFrmMainScreen.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                jtxtPrice.setText("");
                jtxtTotal.setText("");
            }
        }
    }//GEN-LAST:event_jcmbNOLItemStateChanged
    private void jcmbType1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbType1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!jcmbType1.getSelectedItem().equals("")) {
                try {
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);
                    typename = jcmbType1.getSelectedItem().toString().split("   ");
                    query = "select type from mst_type where type_no = '" + typename[0] + "'  and flag != 'D'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        type = rs.getString(1);
                    }
                    query = "select distinct(NO_OF_LAPS) from MST_LAP where type_no = ?  and flag != 'D'";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, typename[0]);
                    rs = pstmt.executeQuery();
                    jcmbNOL1.removeAllItems();
                    jcmbNOL1.addItem("");
                    while (rs.next()) {
                        jcmbNOL1.addItem(rs.getString(1));
                    }
                    if (type.equals("PRIVILEGE")) {
                        jlblCredit1.setVisible(true);
                        jtxtCredit1.setVisible(true);
                        jbtnAdd.setVisible(true);
                        jtxtSearch.setText("");
                        jrbtnBarcode.setVisible(true);
                        jrbtnPhone.setVisible(true);
                        jtxtBRCode1.setVisible(true);
                        jlblBRCode1.setVisible(true);
                        jdteMD.setVisible(true);
                        jlblMD.setVisible(true);
                        clear1();
                    } else {
                        jlblCredit1.setVisible(false);
                        jtxtCredit1.setVisible(false);
                        jbtnAdd.setVisible(false);
                        jtxtSearch.setText("");
                        jrbtnBarcode.setVisible(false);
                        jrbtnPhone.setVisible(false);
                        jtxtBRCode1.setVisible(false);
                        jlblBRCode1.setVisible(false);
                        jdteMD.setVisible(false);
                        jlblMD.setVisible(false);
                        clear1();


                    }
                } catch (SQLException ex) {
                    Logger.getLogger(jIntFrmMainScreen.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jcmbType1ItemStateChanged
    private void clear1() {
        jcmbNOL1.setSelectedItem("");
        jtxtPrice1.setText("");
        jtxtName1.setText("");
        jtxtPhone1.setText("");
        jtxtEmail1.setText("");
        jdteDOB1.setDate(null);
        jtxtCredit1.setText("");
        jtxtBRCode1.setText("");
        jdteMD.setDate(null);
    }
    private void jcmbNOL1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcmbNOL1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (!jcmbNOL1.getSelectedItem().equals("")) {
                if (!jcmbType1.getSelectedItem().equals("")) {
                    if (!jtxtNOT1.getText().equals("")) {
                        try {
                            typename = jcmbType1.getSelectedItem().toString().split("   ");
                            con = new DBConnection().connect();
                            query = "select fee from MST_LAP where flag != 'D' and NO_OF_LAPS = ? and TYPE_NO = ?";
                            pstmt = con.prepareStatement(query);
                            pstmt.setString(1, jcmbNOL1.getSelectedItem().toString());
                            pstmt.setString(2, typename[0]);
                            rs = pstmt.executeQuery();
                            if (rs.next()) {
                                jtxtPrice1.setText(rs.getString(1));
                            }
                            jtxtTotal1.setText(String.valueOf(Integer.parseInt(jtxtNOT1.getText()) * Integer.parseInt(jtxtPrice1.getText())));
                        } catch (SQLException ex) {
                            Logger.getLogger(jIntFrmMainScreen.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            } else {
                jtxtPrice1.setText("");
                jtxtTotal1.setText("");
            }
        }
    }//GEN-LAST:event_jcmbNOL1ItemStateChanged

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        if (!jcmbType1.getSelectedItem().equals("")) {
            try {
                if (!jtxtSearch.getText().trim().equals("")) {
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);
                    typename = jcmbType1.getSelectedItem().toString().split("   ");
                    query = "select type from mst_type where type_no = '" + typename[0] + "' and flag != 'D'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        type = rs.getString(1);
                    }
                    if (type.equals("PRIVILEGE")) {
                        if (jrbtnBarcode.isSelected()) {
                            query = "select CUSTOMER_NO,NAME,DOB,PHONE,EMAIL,BR_NO,MEMBERSHIP_DATE from mst_customer where br_no = ? and type_no = ? and flag!='D'";
                        } else if (jrbtnPhone.isSelected()) {
                            query = "select CUSTOMER_NO,NAME,DOB,PHONE,EMAIL,BR_NO,MEMBERSHIP_DATE from mst_customer where PHONE = ? and type_no = ? and flag!='D'";
                        }
                    } else {
                        query = "select CUSTOMER_NO,NAME,DOB,PHONE,EMAIL from mst_customer where PHONE = ? and type_no = ? and flag!='D'";
                    }
                    con = new DBConnection().connect();
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, jtxtSearch.getText().trim());
                    pstmt.setString(2, typename[0]);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        cust_no = rs.getInt(1);
                        jtxtName1.setText(rs.getString(2));
                        jdteDOB1.setDate(rs.getDate(3));
                        jtxtPhone1.setText(rs.getString(4));
                        jtxtEmail1.setText(rs.getString(5));
                        jtxtBRCode1.setText(rs.getString(6));
                        jdteMD.setDate(rs.getDate(7));

                        if (type.equals("PRIVILEGE")) {
                            query = "select sum(AMOUNT) from trn_account where FLAG!='D' and CUSTOMER_NO = ?";
                            pstmt1 = con.prepareStatement(query);
                            pstmt1.setInt(1, cust_no);
                            rs1 = pstmt1.executeQuery();
                            if (rs1.next()) {
                                SC = rs1.getDouble(1);
                            }
                            query = "select sum(FEE) from trn_history where FLAG!='D' and CUSTOMER_NO = ?";
                            pstmt1 = con.prepareStatement(query);
                            pstmt1.setInt(1, cust_no);
                            rs1 = pstmt1.executeQuery();
                            if (rs1.next()) {
                                TP = rs1.getDouble(1);
                            }
                            jtxtCredit1.setText(String.valueOf(SC - TP));
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Does not exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        clear1();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Please fill the search field!", "Info", JOptionPane.INFORMATION_MESSAGE);


                }
            } catch (SQLException ex) {
                Logger.getLogger(jIntFrmMainScreen.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select customer type!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void jbtnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPrint1ActionPerformed
        if (jcmbType1.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select a type!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            typename = jcmbType1.getSelectedItem().toString().split("   ");
            if (jtxtSearch.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter search parameter!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtName1.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please make a search!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jcmbNOL1.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select NOL!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtPrice1.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter the price!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtNOT1.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter no of tickets!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                try {
                    i = 0;
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);

                    query = "select type from mst_type where type_no = '" + typename[0] + "'  and flag != 'D'";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        type = rs.getString(1);
                    }

                    query = "select tax from mst_tax where flag!='D' and tax_no = 1";
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);
                    if (rs.next()) {
                        ET = rs.getDouble(1);
                    }
                    NOT = Integer.parseInt(jtxtNOT1.getText());
                    time = new SimpleDateFormat("HH:mm").format(new Date());
                    for (int k = 0; k < NOT; k++) {
                        query = "INSERT INTO trn_history(CUSTOMER_NO,DATE,NO_OF_LAPS,FEE,FLAG,DATE_CREATED) VALUES (?,?,?,?,?,?)";
                        pstmt = con.prepareStatement(query);
                        pstmt.setInt(1, cust_no);
                        pstmt.setString(2, today);
                        pstmt.setString(3, jcmbNOL1.getSelectedItem().toString());
                        pstmt.setDouble(4, Double.valueOf(jtxtPrice1.getText()) + (Double.valueOf(jtxtPrice1.getText()) * ET / 100));
                        pstmt.setString(5, "I");
                        pstmt.setString(6, today);
                        i = i + pstmt.executeUpdate();
                        query = "select max(sl_no) from trn_history where flag!='D'";
                        stmt = con.createStatement();
                        rs = stmt.executeQuery(query);
                        if (rs.next()) {
                            bill_no = rs.getInt(1);
                        }
                        ticket = "     TUNER'S EDGE MOTORSPORTS HUB          ;"
                                + "                     SPEEDWAY KOCHI     ;"
                                + "  --------------------------------------------------------------;"
                                + "  Date: " + today + "  Time: " + time + "  Bill # : "+bill_no+"   ;"
                                + "  Name: " + jtxtName1.getText() + ";"
                                + "  Phone: " + jtxtPhone1.getText() + "  ;"
                                + "  Email: " + jtxtEmail1.getText() + "  ;"
                                + "  --------------------------------------------------------------;"
                                + "  Laps      Amount    ;"
                                + "  --------------------------------------------------------------;"
                                + "  " + jcmbNOL1.getSelectedItem() + "             " + df.format(Double.valueOf(jtxtPrice1.getText())) + ";"
                                + "  --------------------------------------------------------------;"
                               // + "  Entertainment tax @ " + ET + " % : " + df.format(Double.valueOf(jtxtPrice1.getText()) * ET / 100) + ";"
                                + "  Total Amount : " + df.format(Double.valueOf(jtxtPrice1.getText()) + (Double.valueOf(jtxtPrice1.getText()) * ET / 100)) + "  ;"
                                + "  --------------------------------------------------------------;";
                        if (type.equals("PRIVILEGE")) {
                            ticket = "     TUNER'S EDGE MOTORSPORTS HUB          ;"
                                    + "                     SPEEDWAY KOCHI     ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  Date: " + today + "  Time: " + time + "  Bill # : "+bill_no+"  ;"
                                    + "  Name: " + jtxtName1.getText() + ";"
                                    + "  Phone: " + jtxtPhone1.getText() + "  ;"
                                    + "  Email: " + jtxtEmail1.getText() + "  ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  Laps      Amount    ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  " + jcmbNOL1.getSelectedItem() + "             " + df.format(Double.valueOf(jtxtPrice1.getText())) + ";"
                                    + "  --------------------------------------------------------------;"
                                   // + "  Entertainment tax @ " + ET + " % : " + df.format(Double.valueOf(jtxtPrice1.getText()) * ET / 100) + ";"
                                    + "  Total Amount : " + df.format(Double.valueOf(jtxtPrice1.getText()) + (Double.valueOf(jtxtPrice1.getText()) * ET / 100)) + "  ;"
                                    + "  --------------------------------------------------------------;"
                                    + "  Total Store Credit : " + df.format(Double.valueOf(jtxtCredit1.getText()) - (Double.valueOf(jtxtPrice1.getText()) + (Double.valueOf(jtxtPrice1.getText()) * ET / 100))) + "  ;"
                                    + "  --------------------------------------------------------------;";
                        }
                        Printer.setmText(ticket);
                        new Printer().PrintTicket();
                    }
                    if (i >= 0) {
                        if (Global.update) {
                            con.commit();
                        }
                        i = 0;
                        JOptionPane.showMessageDialog(this, "Added Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        jcmbType1.setSelectedItem("");
                        jtxtCredit1.setText("");
                        jtxtEmail1.setText("");
                        jcmbNOL1.setSelectedItem("");
                        jtxtName1.setText("");
                        jtxtPhone1.setText("");
                        jtxtPrice1.setText("");
                        jtxtSearch.setText("");
                        jtxtBRCode1.setText("");
                        jtxtNOT1.setText("");
                        jdteDOB1.setDate(null);


                    }
                } catch (SQLException ex) {
                    Logger.getLogger(jIntFrmMainScreen.class
                            .getName()).log(Level.SEVERE, null, ex);
                } catch (PrinterException ex) {
                    Logger.getLogger(jIntFrmMainScreen.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbtnPrint1ActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        if (jcmbType1.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(this, "Please select type and select the customer!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jtxtSearch.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Parameters missing in search field!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (jtxtName1.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Customer selection not made!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int opt = JOptionPane.showConfirmDialog(this, "Does you want to add store credit", "Info", JOptionPane.YES_NO_OPTION);
            if (opt == JOptionPane.YES_OPTION) {
                try {
                    amount = JOptionPane.showInputDialog(this, "Please enter amount", "info", JOptionPane.INFORMATION_MESSAGE);
                    SC = Double.valueOf(amount);
                    con = new DBConnection().connect();
                    query = "INSERT INTO trn_account(CUSTOMER_NO,DATE,AMOUNT,FLAG,DATE_CREATED) VALUES (?,?,?,?,?)";
                    pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, cust_no);
                    pstmt.setString(2, today);
                    pstmt.setDouble(3, SC);
                    pstmt.setString(4, "I");
                    pstmt.setString(5, today);
                    i = pstmt.executeUpdate();
                    if (i > 0) {
                        JOptionPane.showMessageDialog(this, "Store credit added!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                    query = "select sum(AMOUNT) from trn_account where FLAG!='D' and CUSTOMER_NO = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, cust_no);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        SC = rs.getDouble(1);
                    }
                    query = "select sum(FEE) from trn_history where FLAG!='D' and CUSTOMER_NO = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setInt(1, cust_no);
                    rs = pstmt.executeQuery();
                    if (rs.next()) {
                        TP = rs.getDouble(1);
                    }
                    jtxtCredit1.setText(String.valueOf(SC - TP));


                } catch (SQLException ex) {
                    Logger.getLogger(jIntFrmMainScreen.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jtxtBRCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBRCodeKeyPressed
        text = jtxtBRCode.getText();
        if (text.length() == 15) {
            jtxtBRCode.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtBRCode.setEditable(true);
            }
        } else {
            jtxtBRCode.setEditable(true);
        }
    }//GEN-LAST:event_jtxtBRCodeKeyPressed

    private void jtxtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtPhoneKeyPressed
        text = "";
        text = jtxtPhone.getText();
        if (text.length() == 10) {
            jtxtPhone.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtPhone.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtPhone.setEditable(true);
        } else {
            jtxtPhone.setEditable(false);
        }
    }//GEN-LAST:event_jtxtPhoneKeyPressed

    private void jtxtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEmailKeyPressed
        text = jtxtEmail.getText();
        if (text.length() == 40) {
            jtxtEmail.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtEmail.setEditable(true);
            }
        } else {
            jtxtEmail.setEditable(true);
        }
    }//GEN-LAST:event_jtxtEmailKeyPressed

    private void jtxtCreditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtCreditKeyPressed
        text = "";
        text = jtxtCredit.getText();
        if (text.length() == 8) {
            jtxtCredit.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtCredit.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtCredit.setEditable(true);
        } else {
            jtxtCredit.setEditable(false);
        }
    }//GEN-LAST:event_jtxtCreditKeyPressed

    private void jtxtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtSearchKeyPressed
        text = jtxtSearch.getText();
        if (text.length() == 15) {
            jtxtSearch.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtSearch.setEditable(true);
            }
        } else {
            jtxtSearch.setEditable(true);
        }
    }//GEN-LAST:event_jtxtSearchKeyPressed

    private void jtxtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNameKeyPressed
        text = jtxtName.getText();
        if (text.length() == 50) {
            jtxtName.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtName.setEditable(true);
            }
        } else {
            jtxtName.setEditable(true);
        }
    }//GEN-LAST:event_jtxtNameKeyPressed

    private void jtxtNOTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNOTKeyPressed
        text = "";
        text = jtxtNOT.getText();
        if (text.length() == 2) {
            jtxtNOT.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtNOT.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtNOT.setEditable(true);
        } else {
            jtxtNOT.setEditable(false);
        }
    }//GEN-LAST:event_jtxtNOTKeyPressed

    private void jtxtNOT1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtNOT1KeyPressed
        text = "";
        text = jtxtNOT1.getText();
        if (text.length() == 2) {
            jtxtNOT1.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtNOT1.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtNOT1.setEditable(true);
        } else {
            jtxtNOT1.setEditable(false);
        }
    }//GEN-LAST:event_jtxtNOT1KeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnPrint;
    private javax.swing.JButton jbtnPrint1;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JComboBox jcmbNOL;
    private javax.swing.JComboBox jcmbNOL1;
    private javax.swing.JComboBox jcmbType;
    private javax.swing.JComboBox jcmbType1;
    private com.toedter.calendar.JDateChooser jdteDOB;
    private com.toedter.calendar.JDateChooser jdteDOB1;
    private com.toedter.calendar.JDateChooser jdteMD;
    private javax.swing.JLabel jlblBRCode1;
    private javax.swing.JLabel jlblCode;
    private javax.swing.JLabel jlblCredit;
    private javax.swing.JLabel jlblCredit1;
    private javax.swing.JLabel jlblMD;
    private javax.swing.JLabel jlblType;
    private javax.swing.JLabel jlblType1;
    private javax.swing.JRadioButton jrbtnBarcode;
    private javax.swing.JRadioButton jrbtnPhone;
    private javax.swing.JTextField jtxtBRCode;
    private javax.swing.JTextField jtxtBRCode1;
    private javax.swing.JTextField jtxtCredit;
    private javax.swing.JTextField jtxtCredit1;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtEmail1;
    private javax.swing.JTextField jtxtNOT;
    private javax.swing.JTextField jtxtNOT1;
    private javax.swing.JTextField jtxtName;
    private javax.swing.JTextField jtxtName1;
    private javax.swing.JTextField jtxtPhone;
    private javax.swing.JTextField jtxtPhone1;
    private javax.swing.JTextField jtxtPrice;
    private javax.swing.JTextField jtxtPrice1;
    private javax.swing.JTextField jtxtSearch;
    private javax.swing.JTextField jtxtTotal;
    private javax.swing.JTextField jtxtTotal1;
    // End of variables declaration//GEN-END:variables
}
