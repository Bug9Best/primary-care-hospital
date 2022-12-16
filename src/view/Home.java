package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class Home {
  // Define Objects
  private JFrame frame;
  private JPanel sideBar, contentPanel, pagePanel;
  private JTree manageTree;
  private DefaultMutableTreeNode manageMenu, list, drug, supply, setting;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem itemAbout, itemExit;
  private JLabel labelPage = new JLabel("Home");

  public Home() {
    // Create Objects
    frame = new JFrame("Primary Care Hospital Management System");
    sideBar = new JPanel();
    contentPanel = new JPanel();
    pagePanel = new JPanel();
    menuBar = new JMenuBar();
    file = new JMenu("File");
    itemAbout = new JMenuItem("About this Program");
    itemExit = new JMenuItem("Exit Program");

    frame.setLayout(new BorderLayout());

    displayMenuBar();
    displaySideBar();
    displayContent();
  }

  public void displayFrame() {
    // frame.setUndecorated(true);
    frame.setResizable(false);
    frame.setSize(1280, 720);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public void displaySideBar() {
    // Set Layout
    frame.add(sideBar, BorderLayout.WEST);
    sideBar.setLayout(new BorderLayout(5, 0));
    sideBar.setLayout(new BorderLayout());

    labelPage.setFont(new Font("Arial", Font.BOLD, 24));
    pagePanel.setBackground(Color.gray);
    pagePanel.add(labelPage);

    // Tree
    manageMenu = new DefaultMutableTreeNode("Management");

    // Branch
    list = new DefaultMutableTreeNode("Patient List");
    drug = new DefaultMutableTreeNode("Drug");
    supply = new DefaultMutableTreeNode("Supply");
    setting = new DefaultMutableTreeNode("Change Password");

    // Add Components
    manageMenu.add(list);
    manageMenu.add(drug);
    manageMenu.add(supply);
    manageMenu.add(setting);
    manageTree = new JTree(manageMenu);
    sideBar.add(pagePanel, BorderLayout.SOUTH);
    sideBar.add(manageTree, BorderLayout.CENTER);

    // Set Size
    sideBar.setSize(230, 720);
    sideBar.setPreferredSize(new Dimension(230, 720));
    sideBar.setBorder(new MatteBorder(0, 0, 0, 1, Color.GRAY));
    sideBar.setVisible(true);
  }

  public void displayMenuBar() {
    frame.setJMenuBar(menuBar);
    file.add(itemAbout);
    file.addSeparator();
    file.add(itemExit);
    menuBar.add(file);
  }

  public void displayContent() {
    frame.add(contentPanel, BorderLayout.CENTER);
  }

  public JFrame getFrame() {
    return frame;
  }

  public JPanel getContentPanel() {
    return contentPanel;
  }

  public JTree getManageTree() {
    return manageTree;
  }

  public JMenuItem getItemExit() {
    return itemExit;
  }

  public JMenuItem getitemAbout() {
    return itemAbout;
  }

  public DefaultMutableTreeNode getList() {
    return list;
  }

  public DefaultMutableTreeNode getDrug() {
    return drug;
  }

  public DefaultMutableTreeNode getSupply() {
    return supply;
  }

  public DefaultMutableTreeNode getSetting() {
    return setting;
  }

  public JLabel getLabelPage() {
    return labelPage;
  }

  public void setLabelPage(JLabel labelPage) {
    this.labelPage = labelPage;
  }
}
