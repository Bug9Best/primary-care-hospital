package controller;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SuppliesController implements ActionListener, ListSelectionListener {

  public SuppliesController() {

  }

  public void actionPerformed(ActionEvent e) {
    System.out.println("SuppliesController");
  }

  public void valueChanged(ListSelectionEvent e) {

  }

}
