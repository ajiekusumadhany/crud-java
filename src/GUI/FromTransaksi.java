/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import static GUI.KoneksiDb.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author D2A
 */
public class FromTransaksi extends javax.swing.JFrame {
    Connection conn;
    Statement stm;
    DefaultTableModel tabmodel;
    ResultSet rs;
    
    public FromTransaksi() {
        initComponents();
        grandtotfaktur.setText(""+0);
        diskonfak.setText(""+0);
        ppnfak.setText(""+0);
        totfak.setText(""+0);
       try {
           //Server Udinus
           /*conn=DriverManager.getConnection("jdbc:mysql://192.168.10.253/a112113379",
                    "a112113379","polke001");*/
           
           //Localhost
            conn=DriverManager.getConnection("jdbc:mysql://localhost/a112113379","root","");
            stm=conn.createStatement();
       } catch (SQLException ex) {
           Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);
       }
       tampiltempor();
    }
    
    private void tampiltempor() {
        try {
            tabmodel=new DefaultTableModel();
            tabmodel.addColumn("kode");
            tabmodel.addColumn("Nama Barang");
            tabmodel.addColumn("Satuan");
            tabmodel.addColumn("Jumlah");
            tabmodel.addColumn("Harga");
            tabmodel.addColumn("Total");
            jTable3.setModel(tabmodel);
            
            String kueri01="Select * from temporary";
            ResultSet rs=stm.executeQuery(kueri01);
            
            while(rs.next())
            {
                tabmodel.addRow(new Object[]{
                    rs.getString("kode"),
                    rs.getString("nama_barang"),
                    rs.getString("satuan"),
                    rs.getString("jumlah"),
                    rs.getString("harga"),
                    rs.getString("tot_jual")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void hitungtotal(){
        try {
            rs=stm.executeQuery("select SUM(tot_jual) as totalnya FROM temporary");
            while(rs.next())
            {
                grandtotfaktur.setText(rs.getString("totalnya"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        xtglfaktur = new javax.swing.JTextField();
        xnofak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        xkdpel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        xnmpel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        xkotapel = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        xkdbrg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        xnmbrg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        xsatbrg = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        xjmlbrg = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        xhrgbrg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        xtotbrg = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        grandtotfaktur = new javax.swing.JTextField();
        diskonfak = new javax.swing.JTextField();
        totfak = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        ppnfak = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Faktur Penjualan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Tanggal Faktur");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 15, -1, -1));

        xtglfaktur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xtglfakturFocusGained(evt);
            }
        });
        xtglfaktur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xtglfakturActionPerformed(evt);
            }
        });
        xtglfaktur.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xtglfakturKeyPressed(evt);
            }
        });
        jPanel2.add(xtglfaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 158, -1));

        xnofak.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xnofakFocusGained(evt);
            }
        });
        xnofak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xnofakKeyPressed(evt);
            }
        });
        jPanel2.add(xnofak, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 158, -1));

        jLabel3.setText("No. Faktur");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 43, -1, -1));

        xkdpel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xkdpelActionPerformed(evt);
            }
        });
        xkdpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkdpelKeyPressed(evt);
            }
        });
        jPanel2.add(xkdpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 12, 158, -1));

        jLabel4.setText("Kode. Pelanggan");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 15, -1, -1));

        jLabel5.setText("Nama. Pelanggan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 43, -1, -1));

        xnmpel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xnmpelFocusGained(evt);
            }
        });
        xnmpel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xnmpelKeyPressed(evt);
            }
        });
        jPanel2.add(xnmpel, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 40, 159, -1));

        jLabel6.setText("Kota");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 71, -1, -1));

        xkotapel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xkotapelFocusGained(evt);
            }
        });
        xkotapel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkotapelKeyPressed(evt);
            }
        });
        jPanel2.add(xkotapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(504, 68, 159, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel7.setText("Kode");

        xkdbrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xkdbrgFocusGained(evt);
            }
        });
        xkdbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xkdbrgActionPerformed(evt);
            }
        });
        xkdbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xkdbrgKeyPressed(evt);
            }
        });

        jLabel8.setText("Nama Barang");

        xnmbrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xnmbrgFocusGained(evt);
            }
        });
        xnmbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xnmbrgKeyPressed(evt);
            }
        });

        jLabel9.setText("Satuan");

        xsatbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xsatbrgActionPerformed(evt);
            }
        });
        xsatbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xsatbrgKeyPressed(evt);
            }
        });

        jLabel10.setText("Jumlah");

        xjmlbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xjmlbrgKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                xjmlbrgKeyReleased(evt);
            }
        });

        jLabel11.setText("Harga");

        xhrgbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                xhrgbrgKeyPressed(evt);
            }
        });

        jLabel12.setText("Total");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(xnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(64, 64, 64)
                        .addComponent(jLabel10))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(xsatbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(xjmlbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xhrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(xtotbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(xkdbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xnmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xsatbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xjmlbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xhrgbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xtotbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("New");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 14, -1, 41));

        jButton2.setText("Proses");
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 14, -1, 41));

        jLabel13.setText("PPN 10%");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 34, -1, 22));

        jButton3.setText("Delete");
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 14, -1, 41));

        jLabel14.setText("Diskon");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 67, -1, -1));

        jLabel15.setText("Total Faktur");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 95, -1, -1));
        jPanel4.add(grandtotfaktur, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 6, 140, -1));
        jPanel4.add(diskonfak, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 64, 140, -1));
        jPanel4.add(totfak, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 92, 140, -1));

        jButton4.setText("Exit");
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(267, 14, -1, 41));
        jPanel4.add(ppnfak, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 34, 140, -1));

        jLabel16.setText("Grand Total");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(445, 9, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void xtglfakturActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xtglfakturActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xtglfakturActionPerformed

    private void xkdpelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xkdpelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xkdpelActionPerformed

    private void xkdbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xkdbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xkdbrgActionPerformed

    private void xsatbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xsatbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_xsatbrgActionPerformed

    private void xkdpelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkdpelKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xnmpel.requestFocus();
        }
    }//GEN-LAST:event_xkdpelKeyPressed

    private void xnmpelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xnmpelFocusGained
        if (xkdpel.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Kode pelanggan masih kosong!");
            xkdpel.requestFocus();
        }else{
       
        try {
            String kueri="select * from pelanggan where kode_pel = '" + xkdpel.getText() + "'";
            rs=stm.executeQuery(kueri);
            while (rs.next())
            {                   
                xnmpel.setText(rs.getString("nama_pel"));
                xkotapel.setText(rs.getString("kota_pel"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_xnmpelFocusGained

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked

    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void xnmpelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xnmpelKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xkotapel.requestFocus();
        }        
    }//GEN-LAST:event_xnmpelKeyPressed

    private void xkotapelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xkotapelFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_xkotapelFocusGained

    private void xtglfakturKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xtglfakturKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xnofak.requestFocus();
        }  
    }//GEN-LAST:event_xtglfakturKeyPressed

    private void xnofakFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xnofakFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_xnofakFocusGained

    private void xtglfakturFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xtglfakturFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_xtglfakturFocusGained

    private void xnofakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xnofakKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xkdpel.requestFocus();
        }  
    }//GEN-LAST:event_xnofakKeyPressed

    private void xkdbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkdbrgKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xnmbrg.requestFocus();
        }  
    }//GEN-LAST:event_xkdbrgKeyPressed

    private void xnmbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xnmbrgKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xsatbrg.requestFocus();
        }  
    }//GEN-LAST:event_xnmbrgKeyPressed

    private void xsatbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xsatbrgKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xjmlbrg.requestFocus();
        }  
    }//GEN-LAST:event_xsatbrgKeyPressed

    private void xjmlbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xjmlbrgKeyPressed

    }//GEN-LAST:event_xjmlbrgKeyPressed

    private void xhrgbrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xhrgbrgKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xtotbrg.requestFocus();
        }  
    }//GEN-LAST:event_xhrgbrgKeyPressed

    private void xkotapelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xkotapelKeyPressed
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
            xkdbrg.requestFocus();
        }  
    }//GEN-LAST:event_xkotapelKeyPressed

    private void xkdbrgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xkdbrgFocusGained
        
    }//GEN-LAST:event_xkdbrgFocusGained

    private void xnmbrgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xnmbrgFocusGained
        if (xkdbrg.getText().equals(""))
        {
            JOptionPane.showMessageDialog(rootPane, "Kode barang masih kosong!");
            xkdbrg.requestFocus();
        }
        try {
            
            String kueri="select * from barang where kode = '" + xkdbrg.getText() + "'";
            rs=stm.executeQuery(kueri);
            while (rs.next())
            {                   
                xnmbrg.setText(rs.getString("nama_barang"));
                xsatbrg.setText(rs.getString("satuan"));
                xjmlbrg.setText(rs.getString("jumlah"));
                xhrgbrg.setText(rs.getString("harga"));
                xjmlbrg.requestFocus();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_xnmbrgFocusGained
   
    private void xjmlbrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_xjmlbrgKeyReleased

        if (xjmlbrg.getText().equals("")) {
            xjmlbrg.setText("" + 0);
        }
        if(evt.getKeyCode()==evt.VK_ENTER)
        {
        try {
            int jmlbrg = Integer.parseInt(xjmlbrg.getText().toString());
            int hrgbrg = Integer.parseInt(xhrgbrg.getText().toString());
            int totale = (jmlbrg * hrgbrg);
            xtotbrg.setText(Integer.toString(totale));
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat contoh2 = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal2 = contoh2.format(cal.getTime());
            xtglfaktur.setText(tanggal2);
            
            String kueri3 = "INSERT INTO temporary VALUES ("
                    + "'" + xkdbrg.getText() + "',"
                    + "'" + xnmbrg.getText() + "',"
                    + "'" + xsatbrg.getText() + "',"
                    + "'" + Integer.parseInt(xjmlbrg.getText()) + "',"
                    + "'" + Integer.parseInt(xhrgbrg.getText()) + "',"
                    + "'" + Integer.parseInt(xtotbrg.getText()) + "',"
                    + "'" + xkdpel.getText() + "',"
                    + "'" + xnofak.getText() + "',"
                    + "'" + tanggal2 + "',"
                    + "'" + Integer.parseInt(diskonfak.getText()) + "',"
                    + "'" + Integer.parseInt(totfak.getText()) + "',"
                    + "'" + xnmpel.getText() + "',"
                    + "'" + xnmpel.getText() + "',"
                    + "'" + xkotapel.getText() + "',"
                    + "'" + Integer.parseInt(grandtotfaktur.getText()) + "')";
                    
            stm.executeUpdate(kueri3);
            tampiltempor();
            hitungtotal();
        } catch (SQLException ex) {
            Logger.getLogger(FromTransaksi.class.getName()).log(Level.SEVERE, null, ex);            
        }
        }
    }//GEN-LAST:event_xjmlbrgKeyReleased

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
            java.util.logging.Logger.getLogger(FromTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FromTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FromTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FromTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FromTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField diskonfak;
    private javax.swing.JTextField grandtotfaktur;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField ppnfak;
    private javax.swing.JTextField totfak;
    private javax.swing.JTextField xhrgbrg;
    private javax.swing.JTextField xjmlbrg;
    private javax.swing.JTextField xkdbrg;
    private javax.swing.JTextField xkdpel;
    private javax.swing.JTextField xkotapel;
    private javax.swing.JTextField xnmbrg;
    private javax.swing.JTextField xnmpel;
    private javax.swing.JTextField xnofak;
    private javax.swing.JTextField xsatbrg;
    private javax.swing.JTextField xtglfaktur;
    private javax.swing.JTextField xtotbrg;
    // End of variables declaration//GEN-END:variables

}
