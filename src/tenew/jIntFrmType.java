/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tenew;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joel
 */
public class jIntFrmType extends javax.swing.JInternalFrame {

    /**
     * Creates new form jIntFrmType
     */
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
    String query = null;
    DefaultTableModel model1 = null;
    String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    int i = 0, rowcount = 0, type_no = 0;
    String text = "";

    public jIntFrmType() {
        initComponents();
        model1 = (DefaultTableModel) jtblType.getModel();
        populatetable();
        jcmbType.addItem("");
        jcmbType.addItem("CASUAL");
        jcmbType.addItem("PRIVILEGE");
        jcmbType1.addItem("");
        jcmbType1.addItem("CASUAL");
        jcmbType1.addItem("PRIVILEGE");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtxtAddName = new javax.swing.JTextField();
        jbtnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblType = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jbtnEdit = new javax.swing.JButton();
        jtxtEditType = new javax.swing.JTextField();
        jbtnSave = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jcmbType1 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jtxtValidity1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jbtnDelete = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcmbType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jtxtValidity = new javax.swing.JTextField();

        setClosable(true);
        setTitle("CUSTOMER TYPE");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setText("NAME");

        jtxtAddName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtAddNameKeyPressed(evt);
            }
        });

        jbtnAdd.setText("ADD");
        jbtnAdd.setToolTipText("Click this button to add the type");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jtblType.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "NAME", "TYPE", "VALIDITY"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtblType);
        jtblType.getColumnModel().getColumn(0).setMinWidth(0);
        jtblType.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtblType.getColumnModel().getColumn(0).setMaxWidth(0);
        jtblType.getColumnModel().getColumn(2).setMinWidth(90);
        jtblType.getColumnModel().getColumn(2).setPreferredWidth(90);
        jtblType.getColumnModel().getColumn(2).setMaxWidth(90);
        jtblType.getColumnModel().getColumn(3).setMinWidth(75);
        jtblType.getColumnModel().getColumn(3).setPreferredWidth(75);
        jtblType.getColumnModel().getColumn(3).setMaxWidth(75);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("EDIT"));

        jbtnEdit.setText("EDIT");
        jbtnEdit.setToolTipText("Select the record to edit from the above table and click the edit button below");
        jbtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditActionPerformed(evt);
            }
        });

        jtxtEditType.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtEditTypeKeyPressed(evt);
            }
        });

        jbtnSave.setText("SAVE");
        jbtnSave.setToolTipText("Click this button to save changes made");
        jbtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSaveActionPerformed(evt);
            }
        });

        jLabel3.setText("NAME");

        jLabel4.setText("TYPE");

        jLabel6.setText("VALIDITY");

        jtxtValidity1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtValidity1KeyPressed(evt);
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
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtValidity1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtEditType)
                            .addComponent(jcmbType1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtnEdit)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtEditType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcmbType1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtValidity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbtnSave)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("DELETE"));

        jbtnDelete.setText("DELETE");
        jbtnDelete.setToolTipText("Select the record from the above table and click this button to delete");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("TYPE");

        jLabel5.setText("VALIDITY");

        jtxtValidity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtValidityKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtValidity, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtxtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jbtnAdd))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 37, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtxtAddName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnAdd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jcmbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtxtValidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void populatetable() {
        try {
            rowcount = model1.getRowCount();
            for (int j = 0; j < rowcount; j++) {
                model1.removeRow(0);
            }
            con = new DBConnection().connect();
            query = "select TYPE_NO,NAME,TYPE,VALIDITY from mst_TYPE where flag != 'D' order by TYPE_NO desc";
            pstmt = con.prepareStatement(query);
            rs = pstmt.executeQuery(query);
            while (rs.next()) {
                rowcount = model1.getRowCount();
                model1.addRow(new Object[]{""});
                jtblType.setValueAt(rs.getString(1), rowcount, 0);
                jtblType.setValueAt(rs.getString(2), rowcount, 1);
                jtblType.setValueAt(rs.getString(3), rowcount, 2);
                jtblType.setValueAt(rs.getString(4), rowcount, 3);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } finally {
            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
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
    }
    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        try {
            if (jtxtAddName.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a type (name) to add", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jcmbType.getSelectedItem().toString().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select type", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                i = 0;
                con = new DBConnection().connect();
                con.setAutoCommit(false);
                query = "select NAME  from mst_type where flag!='D' and NAME = '" + jtxtAddName.getText().trim() + "' and TYPE = '" + jcmbType.getSelectedItem() + "'";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                if (!rs.next()) {
                    query = "INSERT INTO mst_type(NAME,TYPE,VALIDITY,FLAG,DATE_CREATED) VALUES (?,?,?,?,?)";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, jtxtAddName.getText().toUpperCase().trim());
                    pstmt.setString(2, jcmbType.getSelectedItem().toString());
                    pstmt.setString(3, jtxtValidity.getText());
                    pstmt.setString(4, "I");
                    pstmt.setString(5, today);
                    i = pstmt.executeUpdate();
                    if (i > 0) {
                        con.commit();
                        JOptionPane.showMessageDialog(this, "Added Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        populatetable();
                        jtxtAddName.setText("");
                        jcmbType.setSelectedItem("");                        
                        jtxtValidity.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "This type already exist!", "Info", JOptionPane.INFORMATION_MESSAGE);
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
        if (jtblType.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to edit!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            type_no = Integer.parseInt(jtblType.getValueAt(jtblType.getSelectedRow(), 0).toString());
            jtxtEditType.setText(jtblType.getValueAt(jtblType.getSelectedRow(), 1).toString());
            jcmbType1.setSelectedItem(jtblType.getValueAt(jtblType.getSelectedRow(), 2).toString());
            jtxtValidity1.setText(jtblType.getValueAt(jtblType.getSelectedRow(), 3).toString());
            jbtnEdit.setEnabled(false);
        }
    }//GEN-LAST:event_jbtnEditActionPerformed

    private void jbtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSaveActionPerformed
        try {
            if (type_no == 0) {
                JOptionPane.showMessageDialog(this, "Please select a record to edit!", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtEditType.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter a value to save", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jcmbType1.getSelectedItem().equals("")) {
                JOptionPane.showMessageDialog(this, "Please select a type", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (jtxtValidity1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter validity", "Info", JOptionPane.INFORMATION_MESSAGE);
            } else {
                i = 0;
                con = new DBConnection().connect();
                con.setAutoCommit(false);
                query = "UPDATE mst_type set NAME = ?,TYPE = ?,VALIDITY = ?,FLAG = ?,DATE_UPDATED = ? where TYPE_NO = ?";
                pstmt = con.prepareStatement(query);
                pstmt.setString(1, jtxtEditType.getText().toUpperCase().trim());
                pstmt.setString(2, jcmbType1.getSelectedItem().toString());
                pstmt.setString(3, jtxtValidity1.getText().trim());
                pstmt.setString(4, "U");
                pstmt.setString(5, today);
                pstmt.setInt(6, type_no);
                i = pstmt.executeUpdate();
                if (i > 0) {
                    con.commit();
                    type_no = 0;
                    JOptionPane.showMessageDialog(this, "Updated Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                    populatetable();
                    jbtnEdit.setEnabled(true);
                    jtxtEditType.setText("");
                    jcmbType1.setSelectedItem("");
                    jtxtValidity1.setText("");
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
        if (jtblType.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a record to delete!", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int opt = JOptionPane.showConfirmDialog(this, "Do you want to delete this record?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (opt == JOptionPane.YES_OPTION) {
                    type_no = Integer.parseInt(jtblType.getValueAt(jtblType.getSelectedRow(), 0).toString());
                    i = 0;
                    con = new DBConnection().connect();
                    con.setAutoCommit(false);
                    query = "UPDATE mst_type set FLAG = ?,DATE_DELETED = ? where TYPE_NO = ?";
                    pstmt = con.prepareStatement(query);
                    pstmt.setString(1, "D");
                    pstmt.setString(2, today);
                    pstmt.setInt(3, type_no);
                    i = pstmt.executeUpdate();
                    if (i > 0) {
                        con.commit();
                        type_no = 0;
                        JOptionPane.showMessageDialog(this, "Deleted Successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);
                        populatetable();
                        jbtnEdit.setEnabled(true);                        
                        jcmbType1.setSelectedItem("");
                        jtxtEditType.setText("");
                        jtxtValidity1.setText("");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jtxtAddNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtAddNameKeyPressed
        text = jtxtAddName.getText();
        if (text.length() == 20) {
            jtxtAddName.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtAddName.setEditable(true);
            }
        } else {
            jtxtAddName.setEditable(true);
        }
    }//GEN-LAST:event_jtxtAddNameKeyPressed

    private void jtxtEditTypeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtEditTypeKeyPressed
        text = jtxtEditType.getText();
        if (text.length() == 20) {
            jtxtEditType.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtEditType.setEditable(true);
            }
        } else {
            jtxtEditType.setEditable(true);
        }
    }//GEN-LAST:event_jtxtEditTypeKeyPressed

    private void jtxtValidityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValidityKeyPressed
        text = "";
        text = jtxtValidity.getText();
        if (text.length() == 3) {
            jtxtValidity.setEditable(false);
            if (evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
                jtxtValidity.setEditable(true);
            }
        } else if (evt.getKeyChar() >= evt.VK_0 && evt.getKeyChar() <= evt.VK_9 || evt.getKeyChar() == evt.VK_BACK_SPACE || evt.getKeyChar() == evt.VK_DELETE || evt.getKeyChar() == evt.VK_LEFT || evt.getKeyChar() == evt.VK_RIGHT) {
            jtxtValidity.setEditable(true);
        } else {
            jtxtValidity.setEditable(false);
        }
    }//GEN-LAST:event_jtxtValidityKeyPressed

    private void jtxtValidity1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtValidity1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtValidity1KeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnEdit;
    private javax.swing.JButton jbtnSave;
    private javax.swing.JComboBox jcmbType;
    private javax.swing.JComboBox jcmbType1;
    private javax.swing.JTable jtblType;
    private javax.swing.JTextField jtxtAddName;
    private javax.swing.JTextField jtxtEditType;
    private javax.swing.JTextField jtxtValidity;
    private javax.swing.JTextField jtxtValidity1;
    // End of variables declaration//GEN-END:variables
}
