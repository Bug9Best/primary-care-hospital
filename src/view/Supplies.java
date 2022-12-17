package view;

import java.awt.*;
import javax.swing.*;

public class Supplies extends JPanel {
  // Declare Attributes
  private JPanel panelAction, panelButton, panelTable;
  private JLabel labelTitle;
  private JButton btnAdd, btnDelete;
  private JTable supplyTable;

  String data[][] = {
      { "Row1/1", "Row1/2", "Row1/3", "Row1/3" },
      { "Row2/1", "Row2/2", "Row2/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row3/1", "Row3/2", "Row3/3", "Row1/3" },
      { "Row4/1", "Row4/2", "Row4/3", "Row1/3" },
  };
  String header[] = { "No.", "Supply Name", "In Stock", "Last Update" };

  public Supplies() {
    // Create Objects
    panelAction = new JPanel();
    panelTable = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Supplies List");
    btnAdd = new JButton("Add");
    btnDelete = new JButton("Delete");
   supplyTable = new JTable(data, header){
      public boolean isCellEditable(int row, int column) {
        return false;
      }
   };
    JScrollPane acrollPaneTable = new JScrollPane (supplyTable);

    // Set Layout 
    this.setLayout(new BorderLayout());
    panelAction.setLayout(new BorderLayout());
    panelTable.setLayout(new GridLayout(1, 1));

    // Conponent Configuration
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    btnAdd.setPreferredSize(new Dimension(100,30));
    btnDelete.setPreferredSize(new Dimension(100,30));
    

    // Table Configuration
   supplyTable.getTableHeader().setReorderingAllowed(false);
   supplyTable.setRowHeight(30);

    // Add Components
    panelButton.add(btnAdd);
    panelButton.add(btnDelete);
    panelAction.add(labelTitle, BorderLayout.WEST);
    panelAction.add(panelButton, BorderLayout.EAST);
    panelTable.add(acrollPaneTable);
    this.add(panelAction, BorderLayout.NORTH);
    this.add(panelTable, BorderLayout.CENTER);

    // Panel Configuration
    this.setPreferredSize(new Dimension(1020, 648));
    this.setVisible(true);
  }

  public JButton getBtnAdd() {
    return btnAdd;
  }

  public JButton getBtnDelete() {
    return btnDelete;
  }
  public JTable getSupplyTable() {
    return supplyTable;
  }
}
