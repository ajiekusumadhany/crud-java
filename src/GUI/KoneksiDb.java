package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class KoneksiDb {
   public static Connection conn;
   public static Statement stm;
   public String usr;

    public KoneksiDb(String usr) {
       try {
           conn=DriverManager.getConnection("jdbc:mysql://192.168.10.253/a112113379",
                    "a112113379","polke001");
           stm=conn.createStatement();
           JOptionPane.showMessageDialog(null, 
                   "Koneksi Berhasil !");
       } catch (SQLException ex) {
           Logger.getLogger(KoneksiDb.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    public static Connection getConn() {
        return conn;
    }
   
    public static void main(String[] args) {
        KoneksiDb konn=new KoneksiDb("a112113379");
    }
 
}
