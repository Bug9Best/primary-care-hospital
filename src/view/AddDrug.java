package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddDrug implements ActionListener {

    // Declare Attributes
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelName, panelCoC, panelDrug, panelDrugDose, panelSupply, panelSupplyAmount, panelButton;
    private JLabel labelDateVisit, labelName, labelDescription, labelSideEffects, labelDose, labelStorage;
    private JTextField textFieldName, textFieldDrugDose, textFieldSideEffects, textFieldStorage;
    private JTextArea textFieldDescription;
    private JButton buttonAddList, buttonCancel;

    public AddDrug() {
        // Create Objects
        frame = new JFrame("Add List");
        panelForm = new JPanel();
        panelName = new JPanel();
        panelCoC = new JPanel();
        panelDrug = new JPanel();
        panelDrugDose = new JPanel();
        panelSupply = new JPanel();
        panelSupplyAmount = new JPanel();
        panelButton = new JPanel();
        labelDateVisit = new JLabel("Date of Visit");
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
        panelForm.setLayout(new GridLayout(7, 1));
        panelName.setLayout(new GridLayout(2, 1));
        panelCoC.setLayout(new GridLayout(2, 1));
        panelDrug.setLayout(new GridLayout(2, 1));
        panelDrugDose.setLayout(new GridLayout(2, 1));
        panelSupply.setLayout(new GridLayout(2, 1));
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
        panelCoC.add(labelDescription);
        panelCoC.add(textFieldDescription);
        panelDrug.add(labelSideEffects);
        panelDrug.add(textFieldSideEffects);
        panelDrugDose.add(labelDose);
        panelDrugDose.add(textFieldDrugDose);
        panelSupply.add(labelStorage);
        panelSupply.add(textFieldStorage);
        panelButton.add(buttonCancel);
        panelButton.add(buttonAddList);
        panelForm.add(panelName);
        panelForm.add(panelCoC);
        panelForm.add(panelDrug);
        panelForm.add(panelDrugDose);
        panelForm.add(panelSupply);
        panelForm.add(panelSupplyAmount);
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
            System.out.println("Add List");
        } else if (e.getSource() == buttonCancel) {
            frame.dispose();
        }
    }

    public JTextField getTextFieldName() {
        return textFieldName;
    }

    public void setTextFieldName(JTextField textFieldName) {
        this.textFieldName = textFieldName;
    }

    public JTextField getTextFieldDrugDose() {
        return textFieldDrugDose;
    }

    public void setTextFieldDrugDose(JTextField textFieldDrugDose) {
        this.textFieldDrugDose = textFieldDrugDose;
    }

    public JTextField getTextFieldSideEffects() {
        return textFieldSideEffects;
    }

    public void setTextFieldSideEffects(JTextField textFieldSideEffects) {
        this.textFieldSideEffects = textFieldSideEffects;
    }

    public JTextField getTextFieldStorage() {
        return textFieldStorage;
    }

    public void setTextFieldStorage(JTextField textFieldStorage) {
        this.textFieldStorage = textFieldStorage;
    }

    public JTextArea getTextFieldDescription() {
        return textFieldDescription;
    }

    public void setTextFieldDescription(JTextArea textFieldDescription) {
        this.textFieldDescription = textFieldDescription;
    }

    public JButton getButtonAddList() {
        return buttonAddList;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
