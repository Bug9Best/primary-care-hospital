package controller;

import java.awt.event.*;

public class AddListController implements ActionListener {

    public AddListController() {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Add Patient") {
            System.out.println("Add List");
        } else if (e.getActionCommand() == "Cancel") {
            System.out.println("Cancel");
        }

    }

}
