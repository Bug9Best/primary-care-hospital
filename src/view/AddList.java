package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddList implements ActionListener {

    // Declare Attributes
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelName, panelCoC, panelDrug, panelDrugDose, panelSupply, panelSupplyAmount, panelButton;
    private JLabel labelDateVisit, labelName, labelCoC, labelDrug, labelDose, labelSupply, labelSupplyAmount;
    private JTextField textFieldName, textFieldDrugDose, textFieldSupply;
    private JTextArea textFieldCoC;
    private JComboBox checkBoxDrug, checkBoxSuppl;
    private JButton buttonAddList, buttonCancel;

    public AddList() {
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
        labelCoC = new JLabel("Cheif of Complain");
        labelDrug = new JLabel("Drug");
        labelDose = new JLabel("Drug Dose");
        labelSupply = new JLabel("Supply");
        labelSupplyAmount = new JLabel("Supply Amount");
        textFieldName = new JTextField(20);
        textFieldCoC = new JTextArea(3, 20);
        textFieldDrugDose = new JTextField(20);
        textFieldSupply = new JTextField(20);
        checkBoxDrug = new JComboBox();
        checkBoxSuppl = new JComboBox();
        buttonAddList = new JButton("Add Patient");
        buttonCancel = new JButton("Cancel");

        // Set Layout
        panelForm.setLayout(new GridLayout(7, 1));
        panelName.setLayout(new GridLayout(2, 1));
        panelCoC.setLayout(new GridLayout(2, 1));
        panelDrug.setLayout(new GridLayout(2, 1));
        panelDrugDose.setLayout(new GridLayout(2, 1));
        panelSupply.setLayout(new GridLayout(2, 1));
        panelSupplyAmount.setLayout(new GridLayout(2, 1));
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
        panelCoC.add(labelCoC);
        panelCoC.add(textFieldCoC);
        panelDrug.add(labelDrug);
        panelDrug.add(checkBoxDrug);
        panelDrugDose.add(labelDose);
        panelDrugDose.add(textFieldDrugDose);
        panelSupply.add(labelSupply);
        panelSupply.add(checkBoxSuppl);
        panelSupplyAmount.add(labelSupplyAmount);
        panelSupplyAmount.add(textFieldSupply);
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

    public JButton getButtonAddList() {
        return buttonAddList;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
