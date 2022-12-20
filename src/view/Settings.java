package view;

import java.awt.*;
import javax.swing.*;

public class Settings extends JPanel {
  // Declare Attributes
  private JPanel panelForm, panelButton;
  private JLabel labelTitle, labelName, labelRoll, labelPassword, labeloldPassword;
  private JTextField textFieldName, textFieldRoll;
  private JPasswordField textFieldOldPassword, textFieldPassword;
  private JButton buttonConfirm, bttonCancle;

  public Settings() {
    // Create Objects
    panelForm = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Settings");
    labelName = new JLabel("Name");
    labelRoll = new JLabel("Roll");
    labeloldPassword = new JLabel("Old Password");
    labelPassword = new JLabel("Password");
    textFieldName = new JTextField();
    textFieldRoll = new JTextField();
    textFieldOldPassword = new JPasswordField();
    textFieldPassword = new JPasswordField();
    buttonConfirm = new JButton("Confirm");
    bttonCancle = new JButton("Cancle");

    // Set Layout
    this.setLayout(new BorderLayout());
    panelForm.setLayout(new GridLayout(11, 1));
    panelButton.setLayout(new GridLayout(1, 2));

    // Set Style
    buttonConfirm.setPreferredSize(new Dimension(200, 35));
    bttonCancle.setPreferredSize(new Dimension(200, 35));
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    labelTitle.setHorizontalAlignment(JLabel.CENTER);
    panelForm.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));


    // Add Components
    panelForm.add(labelTitle);
    panelForm.add(labelName);
    panelForm.add(textFieldName);
    panelForm.add(labelRoll);
    panelForm.add(textFieldRoll);
    panelForm.add(labeloldPassword);
    panelForm.add(textFieldOldPassword);
    panelForm.add(labelPassword);
    panelForm.add(textFieldPassword);
    panelButton.add(bttonCancle);
    panelButton.add(buttonConfirm);
    panelForm.add(new JLabel());
    panelForm.add(panelButton);
    this.add(panelForm, BorderLayout.NORTH);

    // Panel Settings
    setPreferredSize(new Dimension(850, 720));
    setVisible(true);
  }
}
