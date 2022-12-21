package controller;

import view.AddDrug;
import view.AddSupply;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SuppliesController implements ActionListener, ListSelectionListener {

  public SuppliesController() {

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      AddSupply addSupply = new AddSupply();
    } else if (e.getActionCommand() == "Delete") {
      System.out.println("Delete Supply");
    }
  }

  public void valueChanged(ListSelectionEvent e) {
    System.out.println("Selected Supply");
  }
}