package model;

import java.sql.*;
public class ConnnectDB {
    public static void ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/waido_db";
            DriverManager.getConnection(url, "root", "");
            System.out.println("Connect Suuccess!!!");
        } catch (SQLException e) {
            System.out.println("Connect Failed!!!");
            System.exit(0);
        } catch (ClassNotFoundException ex) {
            System.out.println("Please Install Driver");
        }
    }
}
