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
  private UserModel userModel;

  public HomeController() {
    this.userModel = userModel;
    home.displayFrame();
    home.getFrame().addWindowListener(this);
    home.getitemAbout().addActionListener(this);
    home.getItemExit().addActionListener(this);
    home.getManageTree().addTreeSelectionListener(this);
    home.getButtonSignOut().addActionListener(this);
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
      new SignIn();
    }
  }

  @Override
  public void valueChanged(TreeSelectionEvent e) {
    if (e.getSource() == home.getManageTree()) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) home.getManageTree().getLastSelectedPathComponent();
      if (node.isLeaf()) {
        if (node == home.getList()) {
          this.changeContent(new Lists());
        } else if (node == home.getDrug()) {
          this.changeContent(new Drugs());
        } else if (node == home.getSupply()) {
          this.changeContent(new Supplies());
        } else if (node == home.getSetting()) {
          this.changeContent(new Settings(userModel));
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
