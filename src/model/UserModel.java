package model;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserModel {
  private User user;

  public UserModel(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void updateUser(String newPassword) {
    String sql = "UPDATE users SET password = ? WHERE username = ?";
    try (Connection con = ConnnectDB.ConnectDB()) {
      try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, newPassword);
        statement.setString(2, getUser().getUsername());
        statement.execute();
        System.out.println("Update password successfully");
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }

    } catch (SQLException e) {
      System.out.println("Connect Failed!!!");
    }
  }
}