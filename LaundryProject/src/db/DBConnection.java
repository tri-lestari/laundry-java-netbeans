package db;
import java.sql.*;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class DBConnection {
    private static Connection con;
    
    public static Connection getkoneksi(){
        if (con==null){
            try{
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                con = DriverManager.getConnection("jdbc:mysql://localhost/laundry_pro", "root", "");
                System.out.println("Berhasil");
            } catch (Exception e){
                e.getStackTrace();
            }
        }
        return con;
    }

    public static class con {

        public con() {
        }
    }
}
