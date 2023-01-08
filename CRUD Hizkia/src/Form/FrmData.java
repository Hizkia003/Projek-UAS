/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */ 
package Form;

/**
 *
 * @author HP
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FrmData extends javax.swing.JFrame {   
    public Statement st;
    public ResultSet rs;
    Connection cn = Koneksi.KoneksiDatabase.BukaKoneksi();
    
    public FrmData() {
        initComponents();
        TampilData();
    }
    
    private void Bersih(){
        txtNIK.setText("");
        txtNAMA.setText("");
        txttlp.setText("");
        txtalmt.setText("");
        
        btnSimpan.setText("Simpan");
        txtNIK.setEditable(true);
    }
    
    private void CariData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata WHERE 1 = '"
                    + cmbCari.getSelectedItem().toString() 
                    + " LIKE '%" + txtCari.getText() + "%'");
        
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("N I K");          
            model.addColumn("Nama");
            model.addColumn("No.Telp");
            model.addColumn("Alamat");
            
            int no = 1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
              Object[] data = {
                  no ++,
                rs.getString("N I K"),
                rs.getString("Nama"),
                rs.getString("No.Telp"),
                rs.getString("Alamat"),
              };
              model.addRow(data);
              tbData.setModel(model);
            }
        } catch (Exception e) {               
        }
    }
    private void TampilData(){
        try {
            st = cn.createStatement();
            rs = st.executeQuery("SELECT * FROM biodata");
        
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("No.");
            model.addColumn("N I K");          
            model.addColumn("Nama");
            model.addColumn("No.Telp");
            model.addColumn("Alamat");
            
            int no = 1;
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            model.setRowCount(0);
            
            while (rs.next()) {
              Object[] data = {
                  no ++,
                rs.getString("N I K"),
                rs.getString("Nama"),
                rs.getString("No.Telp"),
                rs.getString("Alamat"),
              };
              model.addRow(data);
              tbData.setModel(model);
            }
        } catch (Exception e) {               
        }
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNIK = new javax.swing.JTextField();
        txtNAMA = new javax.swing.JTextField();
        txttlp = new javax.swing.JTextField();
        txtalmt = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbData = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cmbCari = new javax.swing.JComboBox<>();
        txtCari = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("N I K");

        jLabel2.setText("Nama Lengkap");

        jLabel3.setText("No.Telp");

        jLabel4.setText("Alamat");

        txtNIK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNIKActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        tbData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "N I K", "Nama Lengkap", "No.Telp", "Alamat"
            }
        ));
        tbData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbData);

        jLabel5.setText("Cari Data");

        cmbCari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "N I K", "Nama", "No.Telp", "Alamat" }));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCariKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cmbCari, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNIK)
                            .addComponent(txtNAMA)
                            .addComponent(txttlp)
                            .addComponent(txtalmt))))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNIK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtalmt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnHapus)
                    .addComponent(btnBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(242, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(506, 682));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            st = cn.createStatement();
            if (txtNIK.getText().equals("") || 
                    txtNAMA.getText().equals("") || 
                    txttlp.getText().equals("") || 
                    txtalmt.getText().equals("")) {        
               JOptionPane.showMessageDialog(null, "Data tidak boleh kosong", "Validasi Data",JOptionPane.INFORMATION_MESSAGE);
               return; 
            }
            // aksi simpan data
            if (btnSimpan.getText() == "Simpan") {
                String cek = "SELECT * FROM biodata WHERE 1 = '" + txtNIK.getText() + "'";
                rs = st.executeQuery(cek);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Haaa... NIK ini sudah ada");                   
                }else {
                    String sql = "INSERT INTO biodata VALUES ('" + txtNIK.getText() + 
                           "','" + txtNAMA.getText() + 
                            "', '" + txttlp.getText() + 
                            "', '" + txtalmt.getText() + "')";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Data berhasil disimpan"); 
                    Bersih();
                }
            } else{
                // aksi ubah data
                String update = "UPDATE biodata SET Nama = '" + txtNAMA.getText() + 
                        "', No.Telp = '" + txttlp.getText() + 
                        "', Alamat = '" + txtalmt.getText() +
                        "' WHERE 1 = '" + txtNIK.getText() + "'";
                st.executeUpdate(update);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                Bersih();
                TampilData();
                        
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if (txtNIK.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Silahkan pilih data yang akan dihapus!");
        } else{
            int jawab = JOptionPane.showConfirmDialog(null, "Data ini akan dihapus, lanjutkan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
            if (jawab == 0) {
               try {
                   st = cn.createStatement();
                   String sql = "DELETE FROM biodata WHERE 0 = '" + txtNIK.getText() + "'";
                   st.executeUpdate(sql);
                   JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                   TampilData();
                   Bersih();
               } catch (Exception e) {  
                    JOptionPane.showMessageDialog(null, e);
               } 
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txtNIKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNIKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNIKActionPerformed

    private void tbDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDataMouseClicked
        // TODO add your handling code here:
        txtNIK.setText(tbData.getValueAt(tbData.getSelectedRow(),1).toString());
        txtNAMA.setText(tbData.getValueAt(tbData.getSelectedRow(),2).toString());
        txttlp.setText(tbData.getValueAt(tbData.getSelectedRow(),3).toString());
        txtalmt.setText(tbData.getValueAt(tbData.getSelectedRow(),4).toString());
        
        txtNIK.setEditable(false);
        btnSimpan.setText("Ubah");
    }//GEN-LAST:event_tbDataMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        Bersih();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void txtCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyPressed
        // TODO add your handling code here:
        CariData();
    }//GEN-LAST:event_txtCariKeyPressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmData.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cmbCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbData;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtNAMA;
    private javax.swing.JTextField txtNIK;
    private javax.swing.JTextField txtalmt;
    private javax.swing.JTextField txttlp;
    // End of variables declaration//GEN-END:variables
}


