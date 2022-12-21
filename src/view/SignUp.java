package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

public class SignUp extends JFrame implements ActionListener {
    // Declare Attributes
    private JPanel panelImg, panelForm, form, panelText, panelButton;
    private JLabel img, labelName, labelRoll, labelUsername, labelPassword;
    private JTextField textFieldName, textFieldUsername;
    private JComboBox<String> comboBoxRoll;
    private JPasswordField textFieldPassword;
    private JButton buttonSignUp, buttonCancel;
    private SignIn signin;

    public SignUp() {
        // Create Objects
        panelImg = new JPanel();
        panelForm = new JPanel();
        form = new JPanel();
        panelText = new JPanel();
        panelButton = new JPanel();
        img = new JLabel();
        labelName = new JLabel("Name");
        labelRoll = new JLabel("Roll");
        labelUsername = new JLabel("Username");
        labelPassword = new JLabel("Password");
        textFieldName = new JTextField(40);
        comboBoxRoll = new JComboBox<String>(new String[] { "Doctor", "Pharmacist", "Registered Nurse", "Technical Nurse", "Nursing Assistant" });
        textFieldUsername = new JTextField(40);
        textFieldPassword = new JPasswordField(40);
        buttonSignUp = new JButton("Confirm");
        buttonCancel = new JButton("Cancel");

        // Set Layout
        form.setLayout(new GridLayout(2, 1, 0, 20));
        panelText.setLayout(new GridLayout(8, 1));
        this.setLayout(new BorderLayout());

        // Set Style
        buttonSignUp.setPreferredSize(new Dimension(200, 35));
        buttonCancel.setPreferredSize(new Dimension(200, 35));
        img.setIcon(new ImageIcon("src/assets/register.png"));
        panelImg.setSize(720, 720);
        panelImg.setPreferredSize(new Dimension(720, 720));
        form.setBorder(BorderFactory.createEmptyBorder(220, 50, 220, 50));
        form.setBackground(Color.WHITE);
        panelText.setBackground(Color.WHITE);
        panelButton.setBackground(Color.WHITE);
        panelImg.setBackground(Color.WHITE);
        panelForm.setBackground(Color.WHITE);
        this.setBackground(Color.WHITE);

        // Add Action Listener
        buttonSignUp.addActionListener(this);
        buttonCancel.addActionListener(this);

        // Add Components
        panelText.add(labelName);
        panelText.add(textFieldName);
        panelText.add(labelRoll);
        panelText.add(comboBoxRoll);
        panelText.add(labelUsername);
        panelText.add(textFieldUsername);
        panelText.add(labelPassword);
        panelText.add(textFieldPassword);
        panelButton.add(buttonCancel);
        panelButton.add(buttonSignUp);
        form.add(panelText);
        form.add(panelButton);
        panelForm.add(form);
        panelImg.add(img);
        this.add(panelImg, BorderLayout.EAST);
        this.add(panelForm);

        // Frame Config
        this.setResizable(false);
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonSignUp) {
            User user = new User(getTextFieldNameValue(), getTextFieldRollValue(), getTextFieldUsernameValue(), getTextFieldPasswordValue());
            signUp(user);
        } else if (e.getSource() == buttonCancel) {
            new SignIn();
            this.dispose();
        }
    }

    public void signUp(User user) {
        String sql = "INSERT INTO users (name, roll, username, password) VALUES (?, ?, ?, ?)";
        try (Connection con = ConnnectDB.ConnectDB()) {

        try (PreparedStatement statement = con.prepareStatement(sql)) {
        con.prepareStatement(sql);
        statement.setString(1, getTextFieldNameValue());
        statement.setString(2, getTextFieldRollValue());
        statement.setString(3, getTextFieldUsernameValue());
        statement.setString(4, getTextFieldPasswordValue());
        statement.execute();
        JOptionPane.showMessageDialog(SignIn.frame, "You're Sign Up success. Let go to Sign in.", "Success!", JOptionPane.INFORMATION_MESSAGE);
        new SignIn();
        this.dispose();
        resetField();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(SignIn.frame, "You're Sign Up fail. Please import primary_care_hospital.sql before using thisapplication.", "Error!",JOptionPane.ERROR_MESSAGE);
        }

        } catch (SQLException e) {
        System.out.println("Connect Failed!!!");
        }
    }
    
  public void resetField() {
    getTextFieldName().setText("");
    getTextFieldRoll().setSelectedIndex(0);
    getTextFieldUsername().setText("");
    getTextFieldPassword().setText("");
  }
    

    public JButton getButtonSignUp() {
        return buttonSignUp;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JComboBox<String> getTextFieldRoll() {
        return comboBoxRoll;
    }

    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public JPasswordField getTextFieldPassword() {
        return textFieldPassword;
    }

    public String getTextFieldNameValue() {
        return textFieldName.getText();
    }

    public String getTextFieldRollValue() {
        return comboBoxRoll.getSelectedItem().toString();
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