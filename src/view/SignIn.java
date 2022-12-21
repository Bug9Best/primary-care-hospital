package view;

import javax.swing.*;
import java.awt.*;

public class SignIn {
  // Declare Attributes
  public static JFrame frame;
  private JPanel panelMain, panelSignin, panelImg, panelForm, form, panelText, panelButton;
  private JLabel img, labelUsername, labelPassword;
  private JTextField textFieldUsername;
  private JPasswordField textFieldPassword;
  private JButton buttonLogin, buttonRegister;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem itemAbout, itemExit;

  public SignIn() {
    // Create Objects
    frame = new JFrame("Primary Care Hospital Management System");
    panelMain = new JPanel();
    panelSignin = new JPanel();
    panelImg = new JPanel();
    panelForm = new JPanel();
    form = new JPanel();
    panelText = new JPanel();
    panelButton = new JPanel();
    img = new JLabel();
    labelUsername = new JLabel("Username");
    labelPassword = new JLabel("Password");
    textFieldUsername = new JTextField(40);
    textFieldPassword = new JPasswordField(40);
    buttonLogin = new JButton("Login");
    buttonRegister = new JButton("Register");
    menuBar = new JMenuBar();
    file = new JMenu("About");
    itemAbout = new JMenuItem("About this Program");
    itemExit = new JMenuItem("Exit Program");

    // Set Layout
    form.setLayout(new GridLayout(2, 1, 0, 20));
    panelText.setLayout(new GridLayout(4, 1));
    panelSignin.setLayout(new BorderLayout());

    // Set Style
    buttonLogin.setPreferredSize(new Dimension(200, 35));
    buttonRegister.setPreferredSize(new Dimension(200, 35));
    img.setIcon(new ImageIcon("src/assets/login.png"));
    panelImg.setSize(720, 720);
    panelImg.setPreferredSize(new Dimension(720, 720));
    form.setBorder(BorderFactory.createEmptyBorder(220, 50, 220, 50));
    form.setBackground(Color.WHITE);
    panelText.setBackground(Color.WHITE);
    panelButton.setBackground(Color.WHITE);
    panelImg.setBackground(Color.WHITE);
    panelForm.setBackground(Color.WHITE);
    panelMain.setBackground(Color.WHITE);

    // Add Components
    panelText.add(labelUsername);
    panelText.add(textFieldUsername);
    panelText.add(labelPassword);
    panelText.add(textFieldPassword);
    panelButton.add(buttonLogin);
    panelButton.add(buttonRegister);
    form.add(panelText);
    form.add(panelButton);
    panelForm.add(form);
    panelImg.add(img);
    panelSignin.add(panelImg, BorderLayout.WEST);
    panelSignin.add(panelForm);
    panelMain.add(panelSignin);
    frame.add(panelMain);
    frame.setJMenuBar(menuBar);
    file.add(itemAbout);
    file.addSeparator();
    file.add(itemExit);
    menuBar.add(file);

    // Frame Configurations
    frame.setResizable(false);
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
  }

  public JFrame getFrame() {
    return frame;
  }

  public JPanel getPanelMain() {
    return panelMain;
  }

  public JPanel getPanelSignin() {
    return panelSignin;
  }

  public JButton getButtonLogin() {
    return buttonLogin;
  }

  public JButton getButtonRegister() {
    return buttonRegister;
  }

  public JTextField getTextFieldUsername() {
    return textFieldUsername;
  }

  public JPasswordField getTextFieldPassword() {
    return textFieldPassword;
  }

  public JMenuItem getItemAbout() {
    return itemAbout;
  }

  public JMenuItem getItemExit() {
    return itemExit;
  }

  public String getTextFieldUsernameValue() {
    return textFieldUsername.getText();
  }

  public String getTextFieldPasswordValue() {
    String value = "";
    for (int i = 0; i < textFieldPassword.getPassword().length; i++) {
      value += textFieldPassword.getPassword()[i];
    }
    return value;
  }

}
