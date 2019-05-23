/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Koneksi {

    static String url = "jdbc:mysql://localhost:3306/sewaalatdiving";
    static String pass = "";
    static String username = "root";
    static Connection connection=null;
    static Statement statement=null;
    //buat koneksi untuk ormlite
    public static ConnectionSource cs() {
        ConnectionSource csinit = null;
        try {
            csinit=new JdbcConnectionSource(url, username, pass);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return csinit;
    }
    //membuat koneksi untuk mencetak dokumen
    public Koneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection(url, username, pass);
                statement=(Statement)connection.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public Connection connection(){
    return connection;
    }
}
