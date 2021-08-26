/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketkereta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author TOSHIBA
 */
public class input_data {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String ID_PEMESANAN;
    public String ID_KERETA;
    public String TGL_BERANGKAT;
    public String TGL_PESAN;
    public String JAM_BERANGKAT;
    public String HARGA_TIKET;
    public String STASIUN_AWAL;
    public String STASIUN_TUJUAN;
    public String NAMA_KERETA;
    public String GERBONG;
    public String NO_KURSI;
    public String NAMA;
    public String ALAMAT;
    public String GENDER;
    public String NO_TELP;
    
    public String ID_TRANSAKSI; 
    public String TGL_BAYAR;
    public String JUM_TIKET;
    public String TOTAL_BAYAR;
    public String CASH;
    public String TRANSAKSI;
    
    
    public void simpan()throws SQLException{
        conn = KoneksiDB.ConnectDb();
        sql = "INSERT INTO pemesan (ID_PEMESANAN,ID_KERETA,TGL_BERANGKAT,TGL_PESAN,JAM_BERANGKAT,"
                + "HARGA_TIKET,STASIUN_AWAL,STASIUN_TUJUAN,NAMA_KERETA,GERBONG,NO_KURSI,NAMA,"
                + "ALAMAT,GENDER,NO_TELP) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, ID_PEMESANAN);
        pst.setString(2, ID_KERETA);
        pst.setString(3, TGL_BERANGKAT);
        pst.setString(4, TGL_PESAN);
        pst.setString(5, JAM_BERANGKAT);
        pst.setString(6, HARGA_TIKET);
        pst.setString(7, STASIUN_AWAL);
        pst.setString(8, STASIUN_TUJUAN);
        pst.setString(9, NAMA_KERETA);
        pst.setString(10,GERBONG);
        pst.setString(11,NO_KURSI);
        pst.setString(12, NAMA);
        pst.setString(13, ALAMAT);
        pst.setString(14, GENDER);
        pst.setString(15, NO_TELP);
        pst.execute();
        pst.close();
    }
    public void bayar()throws SQLException{
        conn = KoneksiDB.ConnectDb();
        sql = "INSERT INTO transaksi (ID_TRANSAKSI, TGL_BAYAR,HARGA_TIKET,"
                + "CASH,TRANSAKSI) VALUES (?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1, ID_TRANSAKSI);
        pst.setString(2, TGL_BAYAR);
        pst.setString(3, HARGA_TIKET);
        pst.setString(4, CASH);
        pst.setString(5, TRANSAKSI);
        pst.execute();
        pst.close();
    }

    public ResultSet UpdateJTable()throws SQLException{
        conn = KoneksiDB.ConnectDb();
        sql = "select*from pemesan";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
