package controller;

import view.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class SignInController implements ActionListener {
  private SignIn signIn = new SignIn();
  private SignUp signup = new SignUp();


  public SignInController() {
    signIn.getButtonLogin().addActionListener(this);
    signIn.getButtonRegister().addActionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == signIn.getButtonLogin()) {
      new HomeController();
      signIn.getFrame().dispose();
    } else if (e.getSource() == signIn.getButtonRegister()) {
      this.changeContent(signup);
    }
  }

  public void changeContent(JPanel next) {
    signIn.getPanelMain().removeAll();
    signIn.getPanelMain().add(next);
    signIn.getPanelMain().revalidate();
    signIn.getPanelMain().repaint();
  }
}
