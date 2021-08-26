/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketkereta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author TOSHIBA
 */
public class KoneksiDB {
private static Connection KoneksiDB;
public static Connection ConnectDb(){
    if (KoneksiDB == null){
        try{
            String url;
            url="jdbc:mysql://localhost:3306/tiketingkai";
            String username ="root";
            String password ="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDB = DriverManager.getConnection(url,username,password);
        }catch (SQLException t){
            JOptionPane.showMessageDialog(null, "error koneksi");
        }
} return KoneksiDB;
}static Object getConnection(){
    throw new UnsupportedOperationException ("Not yet implemented");
}
}
    
   
