package model;

import java.sql.*;

import javax.swing.JOptionPane;
import view.SignIn;

public class ConnnectDB {
    public static Connection ConnectDB() {
        String url = "jdbc:mysql://localhost/primary_care_hospital";
        String username = "root";
        String password = "";
        try {
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(SignIn.frame, "You're not connect to database.Please open MySQL and Import primary_care_hospital.sql before using thisapplication.", "Error!", JOptionPane.ERROR_MESSAGE);
             System.exit(0);
        }
        return null;
    }
}
