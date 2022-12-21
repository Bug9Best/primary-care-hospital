package controller;

import view.*;
import model.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.net.URI;
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
    signIn.getItemAbout().addActionListener(this);
    signIn.getItemExit().addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signIn.getButtonLogin()) {
      Signin(null, null);
    } else if (e.getSource() == signIn.getButtonRegister()) {
      this.changeContent(signup);
    } else if (e.getSource() == signup.getButtonCancel()) {
      this.changeContent(signIn.getPanelSignin());
    } else if (e.getSource() == signup.getButtonSignUp()) {
      user = new User(signup.getTextFieldNameValue(), signup.getTextFieldRollValue(), signup.getTextFieldUsernameValue(), signup.getTextFieldPasswordValue());
      signupController.signUp(user);
      resetField();
      this.changeContent(signIn.getPanelSignin());
    } else if (e.getSource() == signIn.getItemAbout()) {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/Bug9Best/primary-care-hospital"));
      } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
      } catch (URISyntaxException ex) {
        System.out.println("Error: " + ex.getMessage());
      }
    } else if (e.getSource() == signIn.getItemExit()) {
      System.exit(0);
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
    signup.getTextFieldRoll().setSelectedIndex(0);
    signup.getTextFieldUsername().setText("");
    signup.getTextFieldPassword().setText("");
  }

  public boolean Signin(String username, String password) {
    String sql = "SELECT * FROM users WHERE username=? AND password=?";

    try (Connection con = ConnnectDB.ConnectDB()) {

      try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, signIn.getTextFieldUsernameValue());
        statement.setString(2, signIn.getTextFieldPasswordValue());
        statement.executeQuery();
        ResultSet result = statement.executeQuery();
        if (result.next() && result != null) {
          User user = new User(result.getString("name"), result.getString("role"), result.getString("username"), result.getString("password"));
          userModel = new UserModel(user);
          new HomeController(userModel);
          signIn.getFrame().dispose();
          return true;
        } else {
          JOptionPane.showMessageDialog(SignIn.frame, "Your username or password are wrong", "Error!", JOptionPane.ERROR_MESSAGE);
          return false;
        }
      }
    } catch (SQLException ex) {
      return false;
    }
  }
}
