package controller;

import view.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomeController implements ActionListener, TreeSelectionListener, ListSelectionListener {
  private Home home = new Home();
  private Lists lists = new Lists();
  private Drugs drugs = new Drugs();
  private Supplies supplies = new Supplies();
  private Settings settings = new Settings();

  public HomeController() {
    home.displayFrame();
    home.getitemAbout().addActionListener(this);
    home.getItemExit().addActionListener(this);
    home.getManageTree().addTreeSelectionListener(this);

    lists.getBtnAdd().addActionListener(this);
    lists.getBtnDelete().addActionListener(this);
    lists.getListTable().getSelectionModel().addListSelectionListener(this);

    drugs.getBtnAdd().addActionListener(this);
    drugs.getBtnDelete().addActionListener(this);
    drugs.getDrugTable().getSelectionModel().addListSelectionListener(this);

    supplies.getBtnAdd().addActionListener(this);
    supplies.getBtnDelete().addActionListener(this);
    supplies.getSupplyTable().getSelectionModel().addListSelectionListener(this);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == home.getitemAbout()) {
      try {
        Desktop.getDesktop().browse(new URI("https://github.com/Bug9Best/primary-care-hospital"));
      } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
      } catch (URISyntaxException ex) {
        System.out.println("Error: " + ex.getMessage());
      }
    } else if (e.getSource() == home.getItemExit()) {
      System.exit(0);
    } else if (e.getSource() == lists.getBtnAdd()) {
      System.out.println("Add button clicked");
    } else if (e.getSource() == lists.getBtnDelete()) {
      System.out.println("Delete button clicked");
    } else if (e.getSource() == drugs.getBtnAdd()) {
      System.out.println("Add button clicked");
    } else if (e.getSource() == drugs.getBtnDelete()) {
      System.out.println("Delete button clicked");
    } else if (e.getSource() == supplies.getBtnAdd()) {
      System.out.println("Add button clicked");
    } else if (e.getSource() == supplies.getBtnDelete()) {
      System.out.println("Delete button clicked");
    }
  }

  public void valueChanged(TreeSelectionEvent e) {
    if (e.getSource() == home.getManageTree()) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) home.getManageTree().getLastSelectedPathComponent();
      if (node.isLeaf()) {
        if (node == home.getList()) {
          this.changeContent(lists);
        } else if (node == home.getDrug()) {
          this.changeContent(drugs);
        } else if (node == home.getSupply()) {
          this.changeContent(supplies);
        } else if (node == home.getSetting()) {
          this.changeContent(settings);
        }
      } else {
        return;
      }
    }
  }

  public void changeContent(JPanel next) {
    home.getContentPanel().removeAll();
    home.getContentPanel().add(next);
    home.getContentPanel().revalidate();
    home.getContentPanel().repaint();
  }

  public void valueChanged(ListSelectionEvent e) {
    String Data = null;
    int[] row = drugs.getDrugTable().getSelectedRows();
    int[] columns = drugs.getDrugTable().getSelectedColumns();
    
    if (e.getSource() == lists.getListTable().getSelectionModel()) {
      System.out.println("List table selected");
    } else if (e.getSource() == drugs.getDrugTable().getSelectionModel()) {
      for (int i = 0; i < row.length; i++) {
        for (int j = 0; j < columns.length; j++) {
          Data = (String) drugs.getDrugTable().getValueAt(row[i], columns[j]);
        }
      }
      System.out.println("Table element selected is: " + Data);
    } else if (e.getSource() == supplies.getSupplyTable().getSelectionModel()) {
      System.out.println("Supply table selected");
    }

  }
}
