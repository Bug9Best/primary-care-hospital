package controller;

import view.Home;
import view.Lists;
import view.Drugs;
import view.Supplies;
import view.Settings;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomeController implements ActionListener, TreeSelectionListener {
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
}
