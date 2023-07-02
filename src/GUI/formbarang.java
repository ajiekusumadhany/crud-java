/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import static GUI.KoneksiDb.conn;
import static GUI.KoneksiDb.stm;
import static GUI.pelanggan.conn;
import static GUI.pelanggan.stm;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class formbarang extends javax.swing.JFrame {
    public static Connection conn;
    public static Statement stm;
    DefaultTableModel tabmodel;
    ResultSet rs;
    
    public formbarang() {
        initComponents();
        try {
           //Server Udinus
           /*conn=DriverManager.getConnection("jdbc:mysql://192.168.10.253/a112113379",
                    "a112113379","polke001");*/
           
           //Localhost
            conn=DriverManager.getConnection("jdbc:mysql://localhost/a112113379","root","");
            stm=conn.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(formbarang.class.getName()).log(Level.SEVERE, null, ex);
       }
        tampildata();
        atur_akses(false);
        atur_tombol(true,false,true,true,true,true);
    }
    
        private void atur_akses(boolean b) {
        xkdbrg.setEnabled(b);
        xnmbrg.setEnabled(b);
        xsatbrg.setEnabled(b);
        xjmlbrg.setEnabled(b);
        xhrgbrg.setEnabled(b);
    }
        
    private void atur_tombol(boolean b, boolean b0, boolean b1, boolean b2, boolean b3, boolean b4) {
        btnnew.setEnabled(b);
        btnsave.setEnabled(b0);
        btnupdate.setEnabled(b1);
        btndelete.setEnabled(b2);
        btnprint.setEnabled(b3);
        btnexit.setEnabled(b4);
    }

    private void tampildata() {
        tabmodel=new DefaultTableModel();
        tabmodel.addColumn("Kode");
        tabmodel.addColumn("Nama Barang");
        tabmodel.addColumn("Satuan");
        tabmodel.addColumn("Jumlah");
        tabmodel.addColumn("Harga");
        jTable1.setModel(tabmodel);
        String kueri="select * from barang";
        try {
            stm=conn.createStatement();
            rs=stm.executeQuery(kueri);
            while (rs.next())
            {
                tabmodel.addRow(new Object[]{rs.getString("kode"),
                    rs.getString("nama_barang"),
                    rs.getString("satuan"),
                    rs.getString("jumlah"),
                    rs.getString("harga")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(formbarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        xkdbrg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        xnmbrg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        xsatbrg = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        xjmlbrg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        xhrgbrg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnnew = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnprint = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Entry Data Barang");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 669, -1));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Kode Barang");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 9, -1, -1));

        xkdbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkdbrgKeyPressed(evt);
            }
        });
        jPanel2.add(xkdbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 6, 160, -1));

        jLabel3.setText("Nama Barang");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 37, -1, -1));

        xnmbrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xnmbrgFocusGained(evt);
            }
        });
        jPanel2.add(xnmbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 34, 271, -1));

        jLabel4.setText("Satuan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 65, -1, -1));

        xsatbrg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kilo", "meter", "lusin", "gross", "botol", "liter", "unit", "doz", "pcs", "sacet", " " }));
        jPanel2.add(xsatbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 62, 104, -1));

        jLabel5.setText("Jumlah");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 93, -1, -1));
        jPanel2.add(xjmlbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 90, 104, -1));

        jLabel6.setText("Harga");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 121, -1, -1));
        jPanel2.add(xhrgbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 118, 104, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 43, 669, -1));

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, 669, 207));

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnnew.setText("New");
        btnnew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnewMouseClicked(evt);
            }
        });
        jPanel3.add(btnnew, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 85, 36));

        btnsave.setText("Save");
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });
        jPanel3.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 6, 84, 36));

        btnupdate.setText("Update");
        btnupdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnupdateMouseClicked(evt);
            }
        });
        jPanel3.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 6, -1, 36));

        btndelete.setText("Delete");
        btndelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndeleteMouseClicked(evt);
            }
        });
        jPanel3.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 6, 84, 36));

        btnprint.setText("Print");
        jPanel3.add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 6, 83, 36));

        btnexit.setText("Exit");
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        jPanel3.add(btnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 6, 81, 36));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 402, -1, 52));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        
        int pilih=JOptionPane.showConfirmDialog(null,
                "Yakin Keluar ?","Perhatian !",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (pilih==0)
        {
             System.exit(0);
        }
       
    }//GEN-LAST:event_btnexitMouseClicked

    private void xkdbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkdbrgKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            xnmbrg.requestFocus();
        }
    }//GEN-LAST:event_xkdbrgKeyPressed

    private void xnmbrgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xnmbrgFocusGained
        // TODO add your handling code here:
        if (xkdbrg.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "KOde Barang Masih Kosong !");
            xkdbrg.requestFocus();
        }
    }//GEN-LAST:event_xnmbrgFocusGained

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnnewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnewMouseClicked
        atur_akses(true);
        xkdbrg.requestFocus();
        atur_tombol(false,true,false,false,false,true);
    }//GEN-LAST:event_btnnewMouseClicked

    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked
         // Membuat perintah SQL INSERT INTO
        String kueri2 = "insert into barang values('" + xkdbrg.getText() + "',"+
             "'" + xnmbrg.getText() + "'," +
             "'" + xsatbrg.getSelectedItem()+ "'," +
             "'" + xjmlbrg.getText() + "'," + 
             "'" + xhrgbrg.getText() + "')";

        try {
        // Menjalankan perintah SQL INSERT INTO
        stm=conn.createStatement();
        stm.executeUpdate(kueri2);
        // Menampilkan pesan sukses
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan ke database.");
        // Mengosongkan input fields
        xkdbrg.setText("");
        xnmbrg.setText("");
        xsatbrg.setSelectedItem("kilo");
        xjmlbrg.setText("");
        xhrgbrg.setText("");
        
        //Atur akses field dan button
        atur_akses(false);
        xkdbrg.requestFocus();
        atur_tombol(true,false,true,true,true,true);
        
        // Memanggil method tampildata() untuk menampilkan data terbaru
        tampildata();
    } catch (SQLException ex) {
        Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menambahkan data ke database.");
    }
    }//GEN-LAST:event_btnsaveMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        xkdbrg.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 0));
        xnmbrg.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 1));
        xsatbrg.setSelectedItem((String) jTable1.getValueAt(jTable1.getSelectedRow(), 2));
        xjmlbrg.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 3));
        xhrgbrg.setText((String) jTable1.getValueAt(jTable1.getSelectedRow(), 4));
        
        //atur akses
        atur_akses(true);
        xkdbrg.requestFocus();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnupdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnupdateMouseClicked
        // Membuat perintah SQL UPDATE
        String kueri4 = "update barang set nama_barang = '" + xnmbrg.getText() + "',"
                + "satuan = '" + xsatbrg.getSelectedItem().toString()+ "',"
                + "jumlah = '" + xjmlbrg.getText() + "',"
                + "harga = '" + xhrgbrg.getText() + "' where kode = '" + xkdbrg.getText() + "'";
        try {
            // Menjalankan perintah SQL UPDATE
            stm = conn.createStatement();
            stm.executeUpdate(kueri4);
            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate.");
            // Mengosongkan input fields
            xkdbrg.setText("");
            xnmbrg.setText("");
            xsatbrg.setSelectedItem("kilo");
            xjmlbrg.setText("");
            xhrgbrg.setText("");
            //Atur akses field dan button
            atur_akses(false);
            // Memanggil method tampildata() untuk menampilkan data terbaru
            tampildata();

        } catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnupdateMouseClicked

    private void btndeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndeleteMouseClicked
        //Konfirmasi delete
        int pilih2 = JOptionPane.showConfirmDialog(null,
                "Yakin Hapus ?", "Delete !",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            // Membuat perintah SQL DELETE
            String kueri3 = "delete from barang where kode = '" + xkdbrg.getText() + "'";
            if (pilih2 == 0) {
            try {
                // Menjalankan perintah SQL DELETE
                stm = conn.createStatement();
                stm.executeUpdate(kueri3);
                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus dari database.");
                // Mengosongkan input fields
                xkdbrg.setText("");
                xnmbrg.setText("");
                xsatbrg.setSelectedItem("kilo");
                xjmlbrg.setText("");
                xhrgbrg.setText("");
                //Atur akses field dan button
                atur_akses(false);
                // Memanggil method tampildata() untuk menampilkan data terbaru
                tampildata();
            } catch (SQLException ex) {
                Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btndeleteMouseClicked

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
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formbarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formbarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnnew;
    private javax.swing.JButton btnprint;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnupdate;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField xhrgbrg;
    private javax.swing.JTextField xjmlbrg;
    private javax.swing.JTextField xkdbrg;
    private javax.swing.JTextField xnmbrg;
    private javax.swing.JComboBox<String> xsatbrg;
    // End of variables declaration//GEN-END:variables


}
