package controller;

import view.*;
import model.*;
import java.awt.event.*;
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
}
