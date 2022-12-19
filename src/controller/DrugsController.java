
package controller;

import java.awt.event.*;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class DrugsController implements ActionListener, ListSelectionListener {

  public DrugsController() {

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      System.out.println("Add Drug");
    } else if (e.getActionCommand() == "Delete") {
      System.out.println("Delete Drug");
    }
  }

  public void valueChanged(ListSelectionEvent e) {
    System.out.println("Selected Drug");
  }
}