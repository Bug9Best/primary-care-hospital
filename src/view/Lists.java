package view;

import model.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Lists extends JPanel implements ActionListener, ListSelectionListener {

  // Declare Attributes
  private JPanel panelAction, panelButton, panelTable;
  private JLabel labelTitle;
  private JButton btnAdd;
  private JTable listTable;
  private List<Object[]> rows = new ArrayList<Object[]>();


  public Lists() {
    // Create Objects
    panelAction = new JPanel();
    panelTable = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Patients List");
    btnAdd = new JButton("Add");

    getLists();
    String[] columnNames = {"No.", "Patient Name", "Chief of Complaint", "Visit Time" };
    DefaultTableModel model = new DefaultTableModel(rows.toArray(new Object[rows.size()][]), columnNames);
     listTable = new JTable(model) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    JScrollPane acrollPaneTable = new JScrollPane(listTable);

    // Set Layout
    this.setLayout(new BorderLayout());
    panelAction.setLayout(new BorderLayout());
    panelTable.setLayout(new GridLayout(1, 1));

    // Set Style
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    btnAdd.setPreferredSize(new Dimension(200, 30));

    // Table Configuration
    listTable.getTableHeader().setReorderingAllowed(false);
    listTable.setRowHeight(30);
    // listTable.getColumnModel().getColumn(0).setPreferredWidth(50);

    // Add Action Listener
    btnAdd.addActionListener(this);
    listTable.getSelectionModel().addListSelectionListener(this);

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
    System.out.println("Selected List");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      new AddList();
    }
  }

  public void getLists() {
    String sql = "SELECT * FROM lists";
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
