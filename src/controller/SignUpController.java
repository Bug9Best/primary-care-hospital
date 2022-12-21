package controller;

import model.*;
import view.SignIn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SignUpController {
  public void signUp(UserModel userModel) {
    String sql = "INSERT INTO users (name, roll, username, password) VALUES (?, ?, ?, ?)";
    try (Connection con = ConnnectDB.ConnectDB()) {

      try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, userModel.getUser().getName());
        statement.setString(2, userModel.getUser().getRoll());
        statement.setString(3, userModel.getUser().getUsername());
        statement.setString(4, userModel.getUser().getPassword());
        statement.execute();
        JOptionPane.showMessageDialog(SignIn.frame, "You're Sign Up success. Let go to Sign in.", "Success!", JOptionPane.INFORMATION_MESSAGE);
      } catch (SQLException e) {
        System.out.println("Error inserting user into database: " + e);
      }

    } catch (SQLException e) {
      System.out.println("Connect Failed!!!");
    }
  }
}
