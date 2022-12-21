package controller;

import view.*;
import model.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SignInController implements ActionListener {
  private User user;
  private UserModel userModel;
  private SignIn signIn = new SignIn();
  private SignUp signup = new SignUp();
  private SignUpController signupController = new SignUpController();

  public SignInController() {
    signIn.getButtonLogin().addActionListener(this);
    signIn.getButtonRegister().addActionListener(this);
    signup.getButtonSignUp().addActionListener(this);
    signup.getButtonCancel().addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signIn.getButtonLogin()) {
      new HomeController();
      signIn.getFrame().dispose();
    } else if (e.getSource() == signIn.getButtonRegister()) {
      this.changeContent(signup);
    } else if (e.getSource() == signup.getButtonCancel()) {
      this.changeContent(signIn.getPanelSignin());
    } else if (e.getSource() == signup.getButtonSignUp()) {
      user = new User(signup.getTextFieldNameValue(), signup.getTextFieldRollValue(), signup.getTextFieldUsernameValue(), signup.getTextFieldPasswordValue());
      userModel = new UserModel(user);
      signupController.signUp(userModel);
      resetField();
      this.changeContent(signIn.getPanelSignin());
    }
  }

  public void changeContent(JPanel next) {
    signIn.getPanelMain().removeAll();
    signIn.getPanelMain().add(next);
    signIn.getPanelMain().revalidate();
    signIn.getPanelMain().repaint();
  }

  public void resetField() {
    signup.getTextFieldName().setText("");
    signup.getTextFieldRoll().setText("");
    signup.getTextFieldUsername().setText("");
    signup.getTextFieldPassword().setText("");
  }

  public boolean Signin(String username, String password) {
    String sql = "SELECT * FROM users WHERE username=? AND password=?";

    try (Connection con = ConnnectDB.ConnectDB()) {

      try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, userModel.getUser().getName());
        statement.setString(2, userModel.getUser().getRoll());
        statement.executeQuery();
        ResultSet result = statement.executeQuery();
        if (result.next()) {
          System.out.println("login successful");
          System.out.println("USERNAME : " + result.getString("Username"));
          System.out.println("Password : " + result.getString("Password"));
          // user = new UserModel(result.getString("Username"), result.getString("Password"), result.getInt("Level"));
          return true;
        } else {
          JOptionPane.showMessageDialog(SignIn.frame, "Your username or password are wrong", "Error!", JOptionPane.ERROR_MESSAGE);
          return false;
        }
      }
    } catch (SQLException ex) {
      // Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null,
      // ex);
      return false;
    }
  }
}
