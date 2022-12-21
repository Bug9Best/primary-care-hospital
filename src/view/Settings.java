package view;

import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class Settings extends JPanel implements ActionListener {
  // Declare Attributes
  private JPanel panelForm, panelButton;
  private JLabel labelTitle, labelName, labelRole, labelPassword, labeloldPassword;
  private JTextField textFieldName, textFieldRole;
  private JPasswordField textFieldOldPassword, textFieldPassword;
  private JButton buttonConfirm;
  private UserModel userModel;

  public Settings(UserModel userModel) {
    this.userModel = userModel;
    // Create Objects
    panelForm = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Settings");
    labelName = new JLabel("Name");
    labelRole = new JLabel("Role");
    labeloldPassword = new JLabel("Old Password");
    labelPassword = new JLabel("Password");
    textFieldName = new JTextField();
    textFieldRole = new JTextField();
    textFieldOldPassword = new JPasswordField();
    textFieldPassword = new JPasswordField();
    buttonConfirm = new JButton("Confirm");

    // Set Layout
    this.setLayout(new BorderLayout());
    panelForm.setLayout(new GridLayout(11, 1));
    panelButton.setLayout(new GridLayout(1, 1));

    // Set Style
    buttonConfirm.setPreferredSize(new Dimension(200, 35));
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    labelTitle.setHorizontalAlignment(JLabel.CENTER);
    panelForm.setBorder(BorderFactory.createEmptyBorder(100, 50, 100, 50));

    // Add Action Listener
    buttonConfirm.addActionListener(this);

    // Add Components
    panelForm.add(labelTitle);
    panelForm.add(labelName);
    panelForm.add(textFieldName);
    panelForm.add(labelRole);
    panelForm.add(textFieldRole);
    panelForm.add(labeloldPassword);
    panelForm.add(textFieldOldPassword);
    panelForm.add(labelPassword);
    panelForm.add(textFieldPassword);
    panelButton.add(buttonConfirm);
    panelForm.add(new JLabel());
    panelForm.add(panelButton);
    this.add(panelForm, BorderLayout.NORTH);

    // Panel Settings
    setPreferredSize(new Dimension(850, 720));
    setVisible(true);

    // Set Default Value
    textFieldName.setText(userModel.getUser().getName());
    textFieldRole.setText(userModel.getUser().getRole());
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Confirm") {
      if (textFieldOldPassword.getPassword().length == 0) {
        JOptionPane.showMessageDialog(null, "Please enter old password");
      } else if (textFieldPassword.getPassword().length == 0) {
        JOptionPane.showMessageDialog(null, "Please enter new password");
      } else if (textFieldOldPassword.getPassword().length != 0 && textFieldPassword.getPassword().length != 0) {
        if (getTextFieldOldPasswordValue().equals(userModel.getUser().getPassword())) {
          updateUser(getTextFieldPasswordValue());
        } else {
          JOptionPane.showMessageDialog(null, "Old password is incorrect");
        }
      }
    }
    
  }
  
  public void updateUser(String newPassword) {
    String sql = "UPDATE users SET password = ? WHERE username = ?";
    try (Connection con = ConnnectDB.ConnectDB()) {
      try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, newPassword);
        statement.setString(2, userModel.getUser().getUsername());
        statement.execute();
        JOptionPane.showMessageDialog(null, "Update password successfully");
        userModel.getUser().setPassword(newPassword);
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }

    } catch (SQLException e) {
      System.out.println("Connect Failed!!!");
    }
  }

  public JTextField getTextFieldName() {
    return textFieldName;
  }

  public JTextField getTextFieldRole() {
    return textFieldRole;
  }

  public JButton getButtonConfirm() {
    return buttonConfirm;
  }

  public JPasswordField getTextFieldOldPassword() {
    return textFieldOldPassword;
  }

  public JPasswordField getTextFieldPassword() {
    return textFieldPassword;
  }

  public String getTextFieldOldPasswordValue() {
    String value = "";
    for (int i = 0; i < textFieldOldPassword.getPassword().length; i++) {
      value += textFieldOldPassword.getPassword()[i];
    }
    return value;
  }

  public String getTextFieldPasswordValue() {
    String value = "";
    for (int i = 0; i < textFieldPassword.getPassword().length; i++) {
      value += textFieldPassword.getPassword()[i];
    }
    return value;
  }
}
