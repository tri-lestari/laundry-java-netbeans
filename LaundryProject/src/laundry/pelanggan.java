/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;

import java.sql.Connection;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
/**
 *
 * @author User
 */
public class pelanggan extends javax.swing.JFrame {
 
    private static final DateTimeFormatter smpdtfmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime tglsekarang = LocalDateTime.now();
    private final String ltanggal = smpdtfmt.format(tglsekarang);
    private Statement st;
    private Connection con;
    private ResultSet rs;
    public DefaultTableModel tabmodel;
    public long total;
    public long cucian;
    private Object displaytext;

    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/laundry_pro", "root", "");
            st = (Statement) con.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    int harga_cucian = 0;
    /**
     * Creates new form pelanggan
     */
    public pelanggan() {
        initComponents();
        koneksi();
        judul();
        tampildata();
        Date date = new Date();
        get_antrian();
        
        tgl.setText(date.toString());


        reset();
//        auto();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(
                (screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
    }
    
    public void get_antrian() {
        try {
            st = con.createStatement();
            rs = st.executeQuery("select max(no_antrian) from tbl_pesan");
            int jumlah = rs.getRow()+ 1;
            no_transaksi.setText(""+jumlah);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void tampildata() {
        try {
            st = con.createStatement();
            tabmodel.getDataVector().removeAllElements();
            tabmodel.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tbl_pesan");
            while (rs.next()) {
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
            tbl_pesan.setModel(tabmodel);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void judul() {
        Object[] judul = {"Nomor Antrian", "Nama", "Nomor Telepon", "Alamat", "Jenis_cucian", "Jumlah", "Harga", "Tanggal"};
        tabmodel = new DefaultTableModel(null, judul);
        tbl_pesan.setModel(tabmodel);
    }

    private void reset() {
        no_transaksi.setText("");
        tgl.setText("");
        nama.setText("");
        jumlah.setText("");
        j_cucian.setSelectedIndex(0);
        nama.setText("");
        no_telp.setText("");
        alamat.setText("");
        tottal.setText("");
        no_transaksi.requestFocus();
        btsimpan.setEnabled(true);
        bthapus.setEnabled(false);
    }
    
    public void FilterAngka(KeyEvent b) {
        if (Character.isAlphabetic(b.getKeyChar())) {
            b.consume();
            JOptionPane.showMessageDialog(null, "Masukkan angka saja!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void FilterHuruf(KeyEvent a) {
        if (Character.isDigit(a.getKeyChar())) {
            a.consume();
            JOptionPane.showMessageDialog(null, "Masukkan huruf saja!", "Peringatan", JOptionPane.WARNING_MESSAGE);
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tgl = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        no_transaksi = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jumlah = new javax.swing.JTextField();
        j_cucian = new javax.swing.JComboBox<>();
        tottal = new javax.swing.JTextField();
        no_telp = new javax.swing.JTextField();
        bthitung = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_pesan = new javax.swing.JTable();
        btsimpan = new javax.swing.JButton();
        bthapus = new javax.swing.JButton();
        btreset = new javax.swing.JButton();
        btkembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LAUNDRY");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 11, -1, -1));

        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Pemesanan");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, -1, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 340, 10));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nomor Antrian");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No Telp");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("/KG");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Jenis Cucian");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Alamat");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Harga");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jumlah Pakaian");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, -1));

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
        jPanel2.add(no_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 210, 30));

        nama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                namaKeyTyped(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 210, 30));
        jPanel2.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 210, 30));

        j_cucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- PILIH --", "Express", "Reguler" }));
        jPanel2.add(j_cucian, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 140, 30));
        jPanel2.add(tottal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 140, 30));
        jPanel2.add(no_telp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 210, 30));

        bthitung.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bthitung.setText("HITUNG");
        bthitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthitungActionPerformed(evt);
            }
        });
        jPanel2.add(bthitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 70, 80, 30));

        tbl_pesan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_pesan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_pesanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_pesan);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 790, 150));

        btsimpan.setText("SIMPAN");
        btsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btsimpanActionPerformed(evt);
            }
        });
        jPanel2.add(btsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 270, 80, 40));

        bthapus.setText("HAPUS");
        bthapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bthapusActionPerformed(evt);
            }
        });
        jPanel2.add(bthapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, 80, 40));

        btreset.setText("Reset");
        btreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btresetActionPerformed(evt);
            }
        });
        jPanel2.add(btreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 320, 70, -1));

        btkembali.setText("Kembali");
        btkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btkembaliActionPerformed(evt);
            }
        });
        jPanel2.add(btkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 350, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1161, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btsimpanActionPerformed
        // TODO add your handling code here:
        if(j_cucian.equals("") || jumlah.getText().equals("") || nama.equals("") || no_telp.equals("") || alamat.equals("") || tottal.equals("")){
            JOptionPane.showMessageDialog(null, "Data perlu diisi!");
        }else{
            String sql = "no_antrian=NULL,nama='"+nama.getText()+"',no_telp='"+no_telp.getText()+"',alamat='"+ alamat.getText() +"',j_cucian='"+j_cucian.getSelectedItem()+"',jumlah='"+jumlah.getText()+"',harga='"+tottal .getText()+"',tanggal='"+smpdtfmt.format(tglsekarang).toString()+"'";
            model model =  new model();
            if (model.simpan("tbl_pesan", sql)) {
            reset();
            tampildata();
            JOptionPane.showMessageDialog(null, "Berhasil Menyimpan Data");
        }
        } 
    }//GEN-LAST:event_btsimpanActionPerformed

    private void bthapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthapusActionPerformed
        // TODO add your handling code here:
        try {
            st.executeUpdate("delete from tbl_pesan where " + "no_antrian='" + no_transaksi.getText() + "'");
            reset();
            JOptionPane.showMessageDialog(null, "Berhasil");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "pesan salah : " + e);
        } catch (SQLException ex) {
            Logger.getLogger(pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            tampildata();
        }
    }//GEN-LAST:event_bthapusActionPerformed

    private void btkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btkembaliActionPerformed
        // TODO add your handling code here:
        new menu().setVisible(true);
        dispose();
    }//GEN-LAST:event_btkembaliActionPerformed

    private void tbl_pesanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_pesanMouseClicked
        // TODO add your handling code here:
        no_transaksi.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 0) + "");
        j_cucian.setSelectedItem(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 1) + "");
        jumlah.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 2) + "");
        nama.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 3) + "");
        no_telp.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 4) + "");
        alamat.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 5) + "");
        tottal.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 6) + "");
        tgl.setText(tabmodel.getValueAt(tbl_pesan.getSelectedRow(), 7) + "");

        btsimpan.setEnabled(false);
        bthapus.setEnabled(true);
    }//GEN-LAST:event_tbl_pesanMouseClicked

    private void bthitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bthitungActionPerformed
        // TODO add your handling code here:
        if (j_cucian.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Isi data!");
        } else if (j_cucian.getSelectedIndex() == 1) {
            harga_cucian = 10000;
        } else if (j_cucian.getSelectedIndex() == 2 ){
            harga_cucian = 7000;
        }
        int totall = 0;
        totall = Integer.parseInt(String.valueOf(jumlah.getText()));
        int total = (int) ((totall * 10000) + harga_cucian);
        tottal.setText(String.valueOf(total));
    }//GEN-LAST:event_bthitungActionPerformed

    private void btresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btresetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btresetActionPerformed

    private void namaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_namaKeyTyped
        // TODO add your handling code here:
        FilterHuruf(evt);
    }//GEN-LAST:event_namaKeyTyped

    private void no_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_no_transaksiActionPerformed
        // TODO add your handling code here:
        get_antrian();
    }//GEN-LAST:event_no_transaksiActionPerformed
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        tampildata();
        no_transaksi.disable();
    } 
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
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pelanggan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pelanggan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JButton bthapus;
    private javax.swing.JButton bthitung;
    private javax.swing.JButton btkembali;
    private javax.swing.JButton btreset;
    private javax.swing.JButton btsimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> j_cucian;
    private javax.swing.JTextField jumlah;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no_telp;
    private javax.swing.JTextField no_transaksi;
    private javax.swing.JTable tbl_pesan;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField tottal;
    // End of variables declaration//GEN-END:variables
}
