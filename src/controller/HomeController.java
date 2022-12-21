package controller;

import view.*;
import model.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HomeController implements ActionListener, TreeSelectionListener, WindowListener {
  private Home home = new Home();
  private Lists lists = new Lists();
  private Drugs drugs = new Drugs();
  private Supplies supplies = new Supplies();
  private Settings settings = new Settings();
  private SignInController SignInController;
  private ListsController ListsController = new ListsController();
  private DrugsController DrugsController = new DrugsController();
  private SuppliesController SuppliesController = new SuppliesController();
  private User user;
  private UserModel userModel;

  public HomeController(UserModel userModel) {
    this.userModel = userModel;
    home.displayFrame();
    home.getFrame().addWindowListener(this);
    home.getitemAbout().addActionListener(this);
    home.getItemExit().addActionListener(this);
    home.getManageTree().addTreeSelectionListener(this);
    home.getButtonSignOut().addActionListener(this);

    lists.getBtnAdd().addActionListener(ListsController);
    lists.getBtnDelete().addActionListener(ListsController);
    lists.getListTable().getSelectionModel().addListSelectionListener(ListsController);

    drugs.getBtnAdd().addActionListener(DrugsController);
    drugs.getBtnDelete().addActionListener(DrugsController);
    drugs.getDrugTable().getSelectionModel().addListSelectionListener(DrugsController);

    supplies.getBtnAdd().addActionListener(SuppliesController);
    supplies.getBtnDelete().addActionListener(SuppliesController);
    supplies.getSupplyTable().getSelectionModel().addListSelectionListener(SuppliesController);
  }

  @Override
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
    } else if (e.getSource() == home.getButtonSignOut()) {
      home.getFrame().dispose();
      new SignInController();
    }
  }

  @Override
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

  @Override
  public void windowOpened(WindowEvent e) {
    home.getLabelName().setText(userModel.getUser().getName());
    home.getLabelRole().setText(userModel.getUser().getRole());
  }

  @Override
  public void windowClosing(WindowEvent e) {
  }

  @Override
  public void windowClosed(WindowEvent e) {
  }

  @Override
  public void windowIconified(WindowEvent e) {
  }

  @Override
  public void windowDeiconified(WindowEvent e) {
  }

  @Override
  public void windowActivated(WindowEvent e) {
  }

  @Override
  public void windowDeactivated(WindowEvent e) {
  }
}
