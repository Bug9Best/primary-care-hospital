
package controller;

import view.*;
import model.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DrugsController implements ActionListener, ListSelectionListener {
  private Drugs drugs;
  private ArrayList<Object[]> data = new ArrayList<Object[]>();
  // private DefaultTableModel model = (DefaultTableModel)drugs.getDrugTable().getModel();

  public DrugsController() {

  }

  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      AddDrug addDrug = new AddDrug();
    } else if (e.getActionCommand() == "Delete") {
      System.out.println("Delete Drug");
    }
  }

  public void valueChanged(ListSelectionEvent e) {
    System.out.println("Selected Drug");
  }
}