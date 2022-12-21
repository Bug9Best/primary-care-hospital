package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddSupply implements ActionListener {

    // Declare Attributes
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelName, panelCoC, panelDrug, panelDrugDose, panelSupply, panelSupplyAmount, panelButton;
    private JLabel labelNameSupply, labelDescriptionSupply, labelStorageSupply;
    private JTextField textFieldNameSupply, textFieldStorageSupply;
    private JTextArea textFieldDescriptionSupply;
    private JButton buttonAddList, buttonCancel;

    public AddSupply() {
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
        labelNameSupply = new JLabel("Name");
        labelDescriptionSupply = new JLabel("Description");
        labelStorageSupply = new JLabel("Storage");
        textFieldNameSupply = new JTextField(20);
        textFieldStorageSupply = new JTextField(20);
        textFieldDescriptionSupply = new JTextArea(3, 20);
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
        panelName.add(labelNameSupply);
        panelName.add(textFieldNameSupply);
        panelCoC.add(labelDescriptionSupply);
        panelCoC.add(textFieldDescriptionSupply);
        panelSupply.add(labelStorageSupply);
        panelSupply.add(textFieldStorageSupply);
        panelButton.add(buttonCancel);
        panelButton.add(buttonAddList);
        panelForm.add(panelName);
        panelForm.add(panelCoC);
        //panelForm.add(panelDrug);
        //panelForm.add(panelDrugDose);
        panelForm.add(panelSupply);
        //panelForm.add(panelSupplyAmount);
        panelForm.add(panelButton);
        frame.add(panelForm);

        // Frame Configurations
        frame.setSize(600, 400);
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

    public JTextField getTextFieldNameSupply() {
        return textFieldNameSupply;
    }

    public void setTextFieldNameSupply(JTextField textFieldNameSupply) {
        this.textFieldNameSupply = textFieldNameSupply;
    }

    public JTextField getTextFieldStorageSupply() {
        return textFieldStorageSupply;
    }

    public void setTextFieldStorageSupply(JTextField textFieldStorageSupply) {
        this.textFieldStorageSupply = textFieldStorageSupply;
    }

    public JTextArea getTextFieldDescriptionSupply() {
        return textFieldDescriptionSupply;
    }

    public void setTextFieldDescriptionSupply(JTextArea textFieldDescriptionSupply) {
        this.textFieldDescriptionSupply = textFieldDescriptionSupply;
    }

    public JButton getButtonAddList() {
        return buttonAddList;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }
}
