package view;

import javax.swing.*;
import java.awt.*;

public class SignIn {
  // Declare Attributes
  private JFrame frame;
  private JPanel panelMain, panelImg, panelForm, form, panelText, panelButton;
  private JLabel img, labelUsername, labelPassword;
  private JTextField textFieldUsername;
  private JPasswordField texFieldPassword;
  private JButton buttonLogin, buttonRegister;

  public SignIn() {
    // Create Objects
    frame = new JFrame("Primary Care Hospital Management System");
    panelMain = new JPanel();
    panelImg = new JPanel();
    panelForm = new JPanel();
    form = new JPanel();
    panelText = new JPanel();
    panelButton = new JPanel();
    img = new JLabel();
    labelUsername = new JLabel("Username");
    labelPassword = new JLabel("Password");
    textFieldUsername = new JTextField(40);
    texFieldPassword = new JPasswordField(40);
    buttonLogin = new JButton("Login");
    buttonRegister = new JButton("Register");

    // Set Layout
    form.setLayout(new GridLayout(2, 1, 0, 20));
    panelText.setLayout(new GridLayout(4, 1));
    panelMain.setLayout(new BorderLayout());

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
    panelText.add(texFieldPassword);
    panelButton.add(buttonLogin);
    panelButton.add(buttonRegister);
    form.add(panelText);
    form.add(panelButton);
    panelForm.add(form);
    panelImg.add(img);
    panelMain.add(panelImg, BorderLayout.WEST);
    panelMain.add(panelForm);
    frame.add(panelMain);

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

  public JButton getButtonLogin() {
    return buttonLogin;
  }

  public JButton getButtonRegister() {
    return buttonRegister;
  }

}
