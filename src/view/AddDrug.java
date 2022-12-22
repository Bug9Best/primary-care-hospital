package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDrug implements ActionListener {

    // Declare Attributes
    private Drug drug;
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelName, panelDescription, panelSideEffects, panelDose, panelStorage, panelButton;
    private JLabel labelName, labelDescription, labelSideEffects, labelDose, labelStorage;
    private JTextField textFieldName, textFieldDrugDose, textFieldSideEffects, textFieldStorage;
    private JTextArea textFieldDescription;
    private JButton buttonAddList, buttonCancel;

    public AddDrug() {
        // Create Objects
        frame = new JFrame("Add List");
        panelForm = new JPanel();
        panelName = new JPanel();
        panelDescription = new JPanel();
        panelSideEffects = new JPanel();
        panelDose = new JPanel();
        panelStorage = new JPanel();
        panelButton = new JPanel();
        labelName = new JLabel("Name");
        labelDescription = new JLabel("Description");
        labelSideEffects = new JLabel("SideEffects");
        labelDose = new JLabel("Dosage");
        labelStorage = new JLabel("Storage");
        textFieldName = new JTextField(20);
        textFieldStorage = new JTextField(20);
        textFieldSideEffects = new JTextField();
        textFieldDescription = new JTextArea(3, 20);
        textFieldDrugDose = new JTextField(20);
        buttonAddList = new JButton("Add Drug");
        buttonCancel = new JButton("Cancel");

        // Set Layout
        panelForm.setLayout(new GridLayout(6, 1));
        panelName.setLayout(new GridLayout(2, 1));
        panelDescription.setLayout(new GridLayout(2, 1));
        panelSideEffects.setLayout(new GridLayout(2, 1));
        panelDose.setLayout(new GridLayout(2, 1));
        panelStorage.setLayout(new GridLayout(2, 1));
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Set Style
        buttonAddList.setSize(200, 35);
        buttonAddList.setPreferredSize(new Dimension(200, 35));
        buttonCancel.setPreferredSize(new Dimension(200, 35));

        // Add Action Listener
        buttonAddList.addActionListener(this);
        buttonCancel.addActionListener(this);

        // Add Components
        panelName.add(labelName);
        panelName.add(textFieldName);
        panelDescription.add(labelDescription);
        panelDescription.add(textFieldDescription);
        panelSideEffects.add(labelSideEffects);
        panelSideEffects.add(textFieldSideEffects);
        panelDose.add(labelDose);
        panelDose.add(textFieldDrugDose);
        panelStorage.add(labelStorage);
        panelStorage.add(textFieldStorage);
        panelButton.add(buttonCancel);
        panelButton.add(buttonAddList);
        panelForm.add(panelName);
        panelForm.add(panelDescription);
        panelForm.add(panelSideEffects);
        panelForm.add(panelDose);
        panelForm.add(panelStorage);
        panelForm.add(panelButton);
        frame.add(panelForm);

        // Frame Configurations
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonAddList) {
            drug = new Drug(getTextFieldNameValue(), getTextFieldDescriptionValue(), getTextFieldSideEffectsValue(),getTextFieldDrugDoseValue(), getTextFieldStorageValue());
            this.AddDrugDB(drug);
        } else if (e.getSource() == buttonCancel) {
            frame.dispose();
        }
    }

    public void AddDrugDB(Drug drug) {
        String sql = "INSERT INTO drugs (name, description, sideEffects, dosage, storage) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConnnectDB.ConnectDB()) {

            try (PreparedStatement statement = con.prepareStatement(sql)) {
                con.prepareStatement(sql);
                statement.setString(1, drug.getName());
                statement.setString(2, drug.getDescription());
                statement.setString(3, drug.getSideEffects());
                statement.setString(4, drug.getDosage());
                statement.setInt(5, drug.getStorage());
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

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public JTextField getTextFieldDrugDose() {
        return textFieldDrugDose;
    }

    public JTextField getTextFieldSideEffects() {
        return textFieldSideEffects;
    }

    public JTextField getTextFieldStorage() {
        return textFieldStorage;
    }

    public JTextArea getTextFieldDescription() {
        return textFieldDescription;
    }

    public String getTextFieldNameValue() {
        return textFieldName.getText();
    }

    public String getTextFieldDrugDoseValue() {
        return textFieldDrugDose.getText();
    }

    public String getTextFieldSideEffectsValue() {
        return textFieldSideEffects.getText();
    }

    public int getTextFieldStorageValue() {
        return Integer.parseInt(textFieldStorage.getText());
    }

    public String getTextFieldDescriptionValue() {
        return textFieldDescription.getText();
    }

    public JButton getButtonAddList() {
        return buttonAddList;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public static void main(String[] args) {
        new AddDrug();
    }
}
