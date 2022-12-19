package view;

import java.awt.*;
import javax.swing.*;

public class SignUp extends JPanel {
    // Declare Attributes
    private JPanel panelImg, panelForm, form, panelText, panelButton;
    private JLabel img, labelName, labelRoll, labelUsername, labelPassword;
    private JTextField textFieldName, textFieldRoll, textFieldUsername;
    private JPasswordField textFieldPassword;
    private JButton buttonSignUp, buttonCancel;

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
        textFieldRoll = new JTextField(40);
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

        // Add Components
        panelText.add(labelName);
        panelText.add(textFieldName);
        panelText.add(labelRoll);
        panelText.add(textFieldRoll);
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
    }

    public JButton getButtonSignUp() {
        return buttonSignUp;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

}