package tenew;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tenew.DBConnection;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Joel
 */
public class jIntFrmMinSC extends javax.swing.JInternalFrame {

    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    ResultSet rs1 = null;
    Statement stmt = null;
    Statement stmt1 = null;
    String query = null;
    DefaultTableModel model1 = null;
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    int i = 0, rowcount = 0, sl_no = 0;
    String[] type;
    String text;
    boolean flag = true;

    public jIntFrmMinSC() {
        try {
            initComponents();
            model1 = (DefaultTableModel) jtblTicketPrice.getModel();
            con = new DBConnection().connect();
            query = "select TYPE_NO,NAME from MST_TYPE where TYPE = 'PRIVILEGE' and FLAG != 'D'";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery();
            jcmbType.addItem("");
            while (rs.next()) {
                jcmbType.addItem(rs.getString(1) + "   " + rs.getString(2));
            }
            populatetable();
        } catch (SQLException ex) {
            Logger.getLogger(jIntFrmMinSC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void populatetable() {
        try {
            rowcount = model1.getRowCount();
            for (int j = 0; j < rowcount; j++) {
                model1.removeRow(0);
            }
            con = new DBConnection().connect();
            query = "select SL_NO,TYPE_NO,FEE from MST_MIN_SC where flag != 'D'";
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                rowcount = model1.getRowCount();
                model1.addRow(new Object[]{""});
                query = "SELECT NAME from MST_TYPE where TYPE_NO = '" + rs.getString(2) + "' and flag!='D'";
                stmt1 = con.createStatement();
                rs1 = stmt1.executeQuery(query);
                rs1.next();
                jtblTicketPrice.setValueAt(rs.getString(1), rowcount, 0);
                jtblTicketPrice.setValueAt(rs1.getString(1), rowcount, 1);
                jtblTicketPrice.setValueAt(rs.getString(3), rowcount, 2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        jcmbType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jtxtAddPrice = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTicketPrice = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbtnEdit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtxtEditPrice = new javax.swing.JTextField();
        jbtnSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jbtnDelete = new javax.swing.JButton();

        setClosable(true);
        setTitle("MINIMUM STORE CREDIT");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("TYPE");

        jLabel3.setText("TICKET PRICE");

        jtxtAddPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtAddPriceKeyPressed(evt);
            }
        });

        jbtnAdd.setText("ADD");
        jbtnAdd.setToolTipText("Click this button to add ticket prices");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jtblTicketPrice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "TYPE", "PRICES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblTicketPrice);
        jtblTicketPrice.getColumnModel().getColumn(0).setMinWidth(0);
        jtblTicketPrice.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtblTicketPrice.getColumnModel().getColumn(0).setMaxWidth(0);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("EDIT"));

        jbtnEdit.setText("EDIT");
        jbtnEdit.setToolTipText("Select a record from the above table and click on this button to edit");
        jbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditActionPerformed(evt);
            }
        });

        jLabel5.setText("TICKET PRICE");

        jtxtEditPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtEditPriceKeyPressed(evt);
            }
        });

        jbtnSave.setText("SAVE");
        jbtnSave.setToolTipText("Make changes to the data and click on this button to save");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtnEdit)
                    .addComponent(jbtnSave)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtEditPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnEdit)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtEditPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSave)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DELETE"));

        jbtnDelete.setText("DELETE");
        jbtnDelete.setToolTipText("Click this button to delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnDelete)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtAddPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(jbtnAdd))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtxtAddPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jtxtAddPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAddPriceKeyPressed
        text = "";
        text = jtxtAddPrice.getText();
        if (text.length() == 5) {
            jtxtAddPrice.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtAddPrice.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtAddPrice.setEditable(true);
        } else {
            jtxtAddPrice.setEditable(false);
        }
    }//GEN-LAST:event_jtxtAddPriceKeyPressed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try {
            if (jcmbType.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select customer type to add", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtAddPrice.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter ticket price to add", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                i = 0;
                type = jcmbType.getSelectedItem().toString().split("   ");
                con = new DBConnection().connect();
                con.setAutoCommit(false);
                query = "select TYPE_NO  from mst_min_sc where flag!='D' and type_no = '" + type[0] + "'";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                if (rs.next()) {
                    flag = false;
                } else {
                    flag = true;
                }
                if (flag) {
                    query = "INSERT INTO mst_min_sc(TYPE_NO,FEE,FLAG,DATE_CREATED) VALUES (?,?,?,?)";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, type[0]);
                    pstmt.setString(2, jtxtAddPrice.getText().trim());                    
                    pstmt.setString(3, "I");
                    pstmt.setString(4, today);
                    i = pstmt.executeUpdate();
                    if (i > 0) {
                        con.commit();
                        JOptionPane.showMessageDialog(this, "Added Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        populatetable();                        
                        jtxtAddPrice.setText("");
                        jcmbType.setSelectedItem("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Record for type already exist", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
                if (!pstmt.isClosed()) {
                    pstmt.isClosed();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditActionPerformed
        if (jtblTicketPrice.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to edit!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            sl_no = Integer.parseInt(jtblTicketPrice.getValueAt(jtblTicketPrice.getSelectedRow(), 0).toString());            
            jtxtEditPrice.setText(jtblTicketPrice.getValueAt(jtblTicketPrice.getSelectedRow(), 2).toString());
            jbtnEdit.setEnabled(false);
        }
    }//GEN-LAST:event_jbtnEditActionPerformed

    private void jtxtEditPriceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEditPriceKeyPressed
        text = "";
        text = jtxtEditPrice.getText();
        if (text.length() == 5) {
            jtxtEditPrice.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtEditPrice.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtEditPrice.setEditable(true);
        } else {
            jtxtEditPrice.setEditable(false);
        }
    }//GEN-LAST:event_jtxtEditPriceKeyPressed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        try {
            if (sl_no == 0) {
                JOptionPane.showMessageDialog(this, "Please select a record to edit!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtEditPrice.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter price to save", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                i = 0;
                con = new DBConnection().connect();
                con.setAutoCommit(false);
                query = "UPDATE mst_min_sc set FEE = ?,FLAG = ?,DATE_UPDATED = ? where SL_NO = ?";
                pstmt = con.prepareStatement(query);                
                pstmt.setString(1, jtxtEditPrice.getText().trim());
                pstmt.setString(2, "U");
                pstmt.setString(3, today);
                pstmt.setInt(4, sl_no);
                i = pstmt.executeUpdate();
                if (i > 0) {
                    con.commit();
                    sl_no = 0;
                    JOptionPane.showMessageDialog(this, "Updated Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    populatetable();
                    jbtnEdit.setEnabled(true);                    
                    jtxtEditPrice.setText("");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            try {
                if (!con.isClosed()) {
                    con.close();
                }
                if (!pstmt.isClosed()) {
                    pstmt.isClosed();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnSaveActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        if (jtblTicketPrice.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int opt = JOptionPane.showConfirmDialog(this, "Do you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (opt == JOptionPane.YES_OPTION) {
                    sl_no = Integer.parseInt(jtblTicketPrice.getValueAt(jtblTicketPrice.getSelectedRow(), 0).toString());
                    i = 0;
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);
                    query = "UPDATE mst_min_sc set FLAG = ?,DATE_DELETED = ? where SL_NO = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, "D");
                    pstmt.setString(2, today);
                    pstmt.setInt(3, sl_no);
                    i = pstmt.executeUpdate();
                    if (i > 0) {
                        con.commit();
                        sl_no = 0;
                        JOptionPane.showMessageDialog(this, "Deleted Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        populatetable();
                        jbtnEdit.setEnabled(true);                        
                        jtxtEditPrice.setText("");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox jcmbType;
    private javax.swing.JTable jtblTicketPrice;
    private javax.swing.JTextField jtxtAddPrice;
    private javax.swing.JTextField jtxtEditPrice;
    // End of variables declaration//GEN-END:variables
}
