package controller;

import java.awt.event.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListsController implements ActionListener, ListSelectionListener {

  public ListsController() {
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      System.out.println("Add List");
    } else if (e.getActionCommand() == "Delete") {
      System.out.println("Delete List");
    }
  }

  public void valueChanged(ListSelectionEvent e) {
    System.out.println("Selected List");
  }
}