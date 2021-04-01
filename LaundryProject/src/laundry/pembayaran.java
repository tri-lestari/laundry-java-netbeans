/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.awt.Desktop;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author User
 */
public class pembayaran extends javax.swing.JFrame {
    model model = new model();
java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private final String tanggal = smpdtfmt.format(tglsekarang);
    private Statement st;
    private Connection con;
    private ResultSet rs;
    public DefaultTableModel tabmodel;
    public DefaultTableModel tabmodel2;
    public DefaultTableModel tbldata;


    private Object displaytext;
    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/laundry_pro", "root", "");
            st = (Statement) con.createStatement();
            System.out.println("berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }
    String hasil;
    /**
     * Creates new form pembayaran
     */
    public pembayaran() throws SQLException {
        initComponents();
        koneksi();
        judul();
        tampildata();
        judul1();
        tampildata1();
        tgl.setText(tanggal);
    }
    /**
     * throw SQLException
     */
    public void tampildata(){
        try{
           st = con.createStatement();
           tabmodel.getDataVector().removeAllElements();
           tabmodel.fireTableDataChanged();
           rs = st.executeQuery("SELECT * FROM tbl_pesan");
           while(rs.next()){
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("j_cucian"),
                    rs.getString("jumlah"),
                    rs.getString("harga"),
                    rs.getString("tanggal")
                };                
                tabmodel.addRow(data);
    }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    
    private void judul(){
        Object[] judul = {"No Antrian","Nama", "No Telepon", "Alamat", "Jenis Cucian", "Jumlah", "Harga", "Tanggal"};
        tabmodel = new DefaultTableModel(null, judul);
        table1.setModel(tabmodel);
    }
    
    public void tampildata1(){
        try {
            st = con.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tbl_ambil");
            while (rs.next()) {                
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("j_cucian"),
                    rs.getString("jumlah"),
                    rs.getString("harga"),
                    rs.getString("tanggal"),
                    rs.getString("total"),
                    rs.getString("bayar"),
                    rs.getString("kembali")};
                tabmodel2.addRow(data);
            }
    } catch (Exception e) {
            e.printStackTrace();
    }
    }
    
    private void judul1(){ 
        Object[] judul = {"Nomor Antrian","Nama","No Telepon","Alamat","Jenis Cucian","Jumlah","Harga","Tanggal","Total","Bayar","Kembalian"};
        tabmodel2 = new DefaultTableModel(null,judul);
        table2.setModel(tabmodel2);
}
    
    private void reset()
     { 
        no_transaksi.setText(""); 
        tgl.setText("");
        nama.setText("");
        j_cucian.setSelectedIndex(-1); 
        jumlah.setText("");
        j_cucian.setSelectedItem("");
        nama.setText("");
        no_telp.setText("");
        alamat.setText("");
        ttanggal.setText("");
        harga.setText("");
        totall.setText("");
        bayar.setText("");
        kembalian.setText("");
        no_transaksi.requestFocus();
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        no_transaksi = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        j_cucian = new javax.swing.JComboBox<>();
        no_telp = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        harga = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        totall = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        ttanggal = new javax.swing.JTextField();
        btreset = new javax.swing.JButton();
        btkembali = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        btselesai = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("LAUNDRY");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 11, -1, -1));

        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Pengambilan");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 340, 10));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nama");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Nomor Antrian");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("No Telp");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Jenis Cucian");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Alamat");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        tgl.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tgl.setForeground(new java.awt.Color(255, 255, 255));
        tgl.setText("jLabel13");
        jPanel2.add(tgl, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));
        jPanel2.add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 210, 50));

        no_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                no_transaksiActionPerformed(evt);
            }
        });
        no_transaksi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                no_transaksiKeyReleased(evt);
            }
        });
        jPanel2.add(no_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 210, 30));

        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 210, 30));

        j_cucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Express", "Reguler" }));
        jPanel2.add(j_cucian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 140, 30));
        jPanel2.add(no_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 210, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("/KG");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 100, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Tanggal");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Jumlah Pakaian");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));
        jPanel2.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 210, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Harga");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));
        jPanel2.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 210, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));
        jPanel2.add(totall, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 210, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Bayar");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, -1, -1));

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });
        jPanel2.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 210, 30));

        ttanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttanggalActionPerformed(evt);
            }
        });
        jPanel2.add(ttanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 210, 30));

        btreset.setText("RESET");
        btreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btresetActionPerformed(evt);
            }
        });
        jPanel2.add(btreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        btkembali.setText("Kembali");
        btkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(btkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 610, 80, 40));

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 950, 110));

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 950, 110));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Kembalian");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 260, -1, -1));

        kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembalianActionPerformed(evt);
            }
        });
        jPanel2.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 210, 30));

        btselesai.setText("SELESAI");
        btselesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btselesaiActionPerformed(evt);
            }
        });
        jPanel2.add(btselesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 300, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void no_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_transaksiActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_no_transaksiActionPerformed

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKeyTyped

    private void btresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btresetActionPerformed

    private void btkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkembaliActionPerformed
        // TODO add your handling code here:
        new menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkembaliActionPerformed

    private void ttanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttanggalActionPerformed

    private void kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembalianActionPerformed

    private void no_transaksiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_no_transaksiKeyReleased
        // TODO add your handling code here:
        if (!no_transaksi.getText().equals("")) {
            try {
                st = con.createStatement();
                rs = st.executeQuery("select * from tbl_pesan where no_antrian ='"+no_transaksi.getText()+"'");
                if (rs.next()) {
                    nama.setText(rs.getString("nama"));
                    no_telp.setText(rs.getString("no_telp"));
                    alamat.setText(rs.getString("alamat"));
                    j_cucian.setSelectedItem(rs.getString("j_cucian"));
                    jumlah.setText(rs.getString("jumlah"));
                    harga.setText(rs.getString("harga"));
                    ttanggal.setText(rs.getString("tanggal"));
                    totall.setText(rs.getString("harga"));
                }else{
                    nama.setText("");
                    no_telp.setText("");
                    alamat.setText("");
                    j_cucian.setSelectedItem("");
                    jumlah.setText("");
                    harga.setText("");
                    ttanggal.setText("");
                    totall.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_no_transaksiKeyReleased

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        // TODO add your handling code here:
        if (Integer.parseInt(totall.getText())>Integer.parseInt(bayar.getText())) {
            kembalian.setText("Uang Kurang!");
        }else{
            Integer kembali = Integer.parseInt(bayar.getText())-Integer.parseInt(totall.getText());
            kembalian.setText(kembali.toString());
        }
    }//GEN-LAST:event_bayarKeyReleased

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table1MouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table2MouseClicked
    
    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(new URL("http://localhost:82/Laporanjava/laporan.php").toURI());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    } 
    
    private void btselesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btselesaiActionPerformed
        // TODO add your handling code here:
        int a,b;
        a = Integer.parseInt(totall.getText());
        b = Integer.parseInt(bayar.getText());
        if (b < a) {
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang");
        }else{
        String sql = "no_antrian ='"+ no_transaksi.getText() +"',nama='"+nama.getText()+"',no_telp='"+no_telp.getText()+"',alamat='"+ alamat.getText() +"',j_cucian='"+j_cucian.getSelectedItem()+"',jumlah='"+jumlah.getText()+"',harga='"+harga.getText()+"',tanggal='"+ttanggal.getText()+"',total='"+totall.getText()+"',bayar='"+bayar.getText()+"',kembali='"+kembalian.getText()+"'";
        if (model.hapus("tbl_pesan", "no_antrian", no_transaksi.getText())) {
            if (model.simpan("tbl_ambil", sql)) {
                JOptionPane.showMessageDialog(null, "Berhasil");
                tampildata();
                tampildata1();
                if(Desktop.isDesktopSupported()){
                    try{
                        Desktop.getDesktop().browse(new URL("http://localhost/Laporanjava/struk.php?id="+ no_transaksi.getText()).toURI());
                } catch(Exception e){
                        e.printStackTrace();
                }
        }
            }else{
                JOptionPane.showMessageDialog(null, "gagal simpan");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Hapus");
        }
        }   
    }//GEN-LAST:event_btselesaiActionPerformed

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
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new pembayaran().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField bayar;
    private javax.swing.JButton btkembali;
    private javax.swing.JButton btreset;
    private javax.swing.JButton btselesai;
    private javax.swing.JTextField harga;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> j_cucian;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no_telp;
    private javax.swing.JTextField no_transaksi;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField totall;
    private javax.swing.JTextField ttanggal;
    // End of variables declaration//GEN-END:variables

}
