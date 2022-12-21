package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddSupply implements ActionListener {

    // Declare Attributes
    private JFrame frame;
    private JPanel panelForm;
    private JPanel panelName, panelDescription, panelStorage, panelButton;
    private JLabel labelNameSupply, labelDescription, labelStorage;
    private JTextField textFieldNameSupply, textFieldStorageSupply;
    private JTextArea textFieldDescription;
    private JButton buttonAddList, buttonCancel;

    public AddSupply() {
        // Create Objects
        frame = new JFrame("Add List");
        panelForm = new JPanel();
        panelName = new JPanel();
        panelDescription = new JPanel();
        panelStorage = new JPanel();
        panelButton = new JPanel();
        labelNameSupply = new JLabel("Name");
        labelDescription = new JLabel("Description");
        labelStorage = new JLabel("Storage");
        textFieldNameSupply = new JTextField(20);
        textFieldStorageSupply = new JTextField(20);
        textFieldDescription = new JTextArea(3, 20);
        buttonAddList = new JButton("Add Drug");
        buttonCancel = new JButton("Cancel");

        // Set Layout
        panelForm.setLayout(new GridLayout(7, 1));
        panelName.setLayout(new GridLayout(2, 1));
        panelDescription.setLayout(new GridLayout(2, 1));
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
        panelName.add(labelNameSupply);
        panelName.add(textFieldNameSupply);
        panelDescription.add(labelDescription);
        panelDescription.add(textFieldDescription);
        panelStorage.add(labelStorage);
        panelStorage.add(textFieldStorageSupply);
        panelButton.add(buttonCancel);
        panelButton.add(buttonAddList);
        panelForm.add(panelName);
        panelForm.add(panelDescription);
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
            System.out.println("Add List");
        } else if (e.getSource() == buttonCancel) {
            frame.dispose();
        }
    }

    public JTextField getTextFieldNameSupply() {
        return textFieldNameSupply;
    }

    public JTextField getTextFieldStorageSupply() {
        return textFieldStorageSupply;
    }

    public JTextArea getTextFieldDescription() {
        return textFieldDescription;
    }
}
