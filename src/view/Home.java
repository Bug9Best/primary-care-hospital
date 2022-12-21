package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class Home {
  // Define Objects
  private static JFrame frame;
  private JPanel sideBar, contentPanel, pagePanel;
  private JPanel panelName, panelRoll, panelSignOut;
  private JTree manageTree;
  private DefaultMutableTreeNode manageMenu, list, drug, supply, setting;
  private JMenuBar menuBar;
  private JMenu file;
  private JMenuItem itemAbout, itemExit;
  private JLabel labelName, labelRole;
  private JButton buttonSignOut;

  public Home() {
    // Create Objects
    frame = new JFrame("Primary Care Hospital Management System");
    sideBar = new JPanel();
    contentPanel = new JPanel();
    pagePanel = new JPanel();
    panelName = new JPanel();
    panelRoll = new JPanel();
    panelSignOut = new JPanel();
    labelName = new JLabel("");
    labelRole = new JLabel("");
    buttonSignOut = new JButton("Sign Out");
    menuBar = new JMenuBar();
    file = new JMenu("About");
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
    pagePanel.setBackground(Color.WHITE);
    pagePanel.setLayout(new GridLayout(3, 1));
    pagePanel.setBorder(new TitledBorder(""));
    panelName.setLayout(new FlowLayout(FlowLayout.LEFT));
    panelName.setBackground(Color.WHITE);
    panelRoll.setLayout(new FlowLayout(FlowLayout.LEFT));
    panelRoll.setBackground(Color.WHITE);
    panelSignOut.setLayout(new GridLayout(1, 1));
    panelSignOut.setBackground(Color.WHITE);

    labelName.setFont(new Font("Arial", Font.BOLD, 16));
    labelRole.setFont(new Font("Arial", Font.PLAIN, 14));

    panelName.add(labelName);
    panelRoll.add(labelRole);
    panelSignOut.add(buttonSignOut);

    pagePanel.add(panelName);
    pagePanel.add(panelRoll);
    pagePanel.add(panelSignOut);

    // Tree
    manageMenu = new DefaultMutableTreeNode("Management");

    // Branch
    list = new DefaultMutableTreeNode("Patient List");
    drug = new DefaultMutableTreeNode("Drug");
    supply = new DefaultMutableTreeNode("Supply");
    setting = new DefaultMutableTreeNode("Settiings");

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

  public JButton getButtonSignOut() {
    return buttonSignOut;
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

  public JLabel getLabelName() {
    return labelName;
  }

  public JLabel getLabelRole() {
    return labelRole;
  }
}
