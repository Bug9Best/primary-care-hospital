package view;

import model.*;
import model.List;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class AddList implements ActionListener {
    private List list;

    // Declare Attributes
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelDateVisit, panelName, panelCoC, panelButton;
    private JLabel labelDateVisit, labelName, labelCoC;
    private JTextField textFieldDateVisit, textFieldName;
    private JTextArea textFieldCoC;
    private JButton buttonAddList, buttonCancel;

    public AddList() {
        // Create Objects
        frame = new JFrame("Add List");
        panelForm = new JPanel();
        panelDateVisit = new JPanel();
        panelName = new JPanel();
        panelCoC = new JPanel();
        panelButton = new JPanel();
        labelDateVisit = new JLabel("Date of Visit");
        labelName = new JLabel("Name");
        labelCoC = new JLabel("Cheif of Complain");
        textFieldDateVisit = new JTextField("Auto", 20);
        textFieldName = new JTextField(20);
        textFieldCoC = new JTextArea(3, 20);
        buttonAddList = new JButton("Add Patient");
        buttonCancel = new JButton("Cancel");

        // Set Layout
        panelForm.setLayout(new GridLayout(4, 1));
        panelDateVisit.setLayout(new GridLayout(2, 1));
        panelName.setLayout(new GridLayout(2, 1));
        panelCoC.setLayout(new GridLayout(2, 1));
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Set Style
        textFieldDateVisit.setEditable(false);
        textFieldDateVisit.setBackground(new Color(239, 228, 176, 100));
        buttonAddList.setSize(200, 35);
        buttonAddList.setPreferredSize(new Dimension(200, 35));
        buttonCancel.setPreferredSize(new Dimension(200, 35));

        // Add Action Listener
        buttonAddList.addActionListener(this);
        buttonCancel.addActionListener(this);

        // Add Components
        panelDateVisit.add(labelDateVisit);
        panelDateVisit.add(textFieldDateVisit);
        panelName.add(labelName);
        panelName.add(textFieldName);
        panelCoC.add(labelCoC);
        panelCoC.add(textFieldCoC);
        panelButton.add(buttonCancel);
        panelButton.add(buttonAddList);
        panelForm.add(panelDateVisit);
        panelForm.add(panelName);
        panelForm.add(panelCoC);
        panelForm.add(panelButton);
        frame.add(panelForm);

        // Frame Configurations
        frame.setSize(600, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddList) {
            String pattern = "HH:mm:ss dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            this.AddDrugDB(getTextFieldNameValue(), getTextFieldCoCValue(), date);
        } else if (e.getSource() == buttonCancel) {
            frame.dispose();
        }
    }

    public void AddDrugDB(String name, String coc, String dateVisit) {
        String sql = "INSERT INTO lists (name, coc, dateVisit) VALUES (?, ?, ?)";
        try (Connection con = ConnnectDB.ConnectDB()) {

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                con.prepareStatement(sql);
                statement.setString(1, name);
                statement.setString(2, coc);
                statement.setString(3, dateVisit);
                statement.execute();
                System.out.println("Add to DB Successfully");
                getFrame().dispose();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getButtonAddList() {
        return buttonAddList;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextArea getTextFieldCoC() {
        return textFieldCoC;
    }

    public JTextField getTextFieldDateVisit() {
        return textFieldDateVisit;
    }

    public String getTextFieldNameValue() {
        return textFieldName.getText();
    }

    public String getTextFieldCoCValue() {
        return textFieldCoC.getText();
    }

    public String getTextFieldDateVisitValue() {
        return textFieldDateVisit.getText();
    }

    public void setTextFieldDateVisit(JTextField textFieldDateVisit) {
        this.textFieldDateVisit = textFieldDateVisit;
    }

}
