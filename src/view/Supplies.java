package view;

import model.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Supplies extends JPanel implements ActionListener, ListSelectionListener {
  // Declare Attributes
  private JPanel panelAction, panelButton, panelTable;
  private JLabel labelTitle;
  private JButton btnAdd;
  private JTable supplyTable;
  private List<Object[]> rows = new ArrayList<Object[]>();

  public Supplies() {
    // Create Objects
    panelAction = new JPanel();
    panelTable = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Supplies List");
    btnAdd = new JButton("Add");
    getSupplies();
    String[] columnNames = { "No.", "Supply Name", "Description", "In Stock" };
    DefaultTableModel model = new DefaultTableModel(rows.toArray(new Object[rows.size()][]), columnNames);
    supplyTable = new JTable(model) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    JScrollPane acrollPaneTable = new JScrollPane(supplyTable);

    // Set Layout
    this.setLayout(new BorderLayout());
    panelAction.setLayout(new BorderLayout());
    panelTable.setLayout(new GridLayout(1, 1));

    // Conponent Configuration
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    btnAdd.setPreferredSize(new Dimension(200, 30));

    // Table Configuration
    supplyTable.getTableHeader().setReorderingAllowed(false);
    supplyTable.setRowHeight(30);

    // Add Action Listener
    btnAdd.addActionListener(this); 
    supplyTable.getSelectionModel().addListSelectionListener(this);

    // Add Components
    panelButton.add(btnAdd);
    panelAction.add(labelTitle, BorderLayout.WEST);
    panelAction.add(panelButton, BorderLayout.EAST);
    panelTable.add(acrollPaneTable);
    this.add(panelAction, BorderLayout.NORTH);
    this.add(panelTable, BorderLayout.CENTER);

    // Panel Configuration
    this.setPreferredSize(new Dimension(1020, 648));
    this.setVisible(true);
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      new AddSupply();
    }
  }

  public JButton getBtnAdd() {
    return btnAdd;
  }

  public JTable getSupplyTable() {
    return supplyTable;
  }

  public void getSupplies() {
    String sql = "SELECT * FROM drugs";
    try (Connection con = ConnnectDB.ConnectDB()) {
      try (PreparedStatement statement = con.prepareStatement(sql)) {
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
          Object[] row = new Object[result.getMetaData().getColumnCount()];
          for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
            row[i - 1] = result.getObject(i);
          }
          rows.add(row);
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
