package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Drugs extends JPanel implements ActionListener, ListSelectionListener {
  // Declare Attributes
  private JPanel panelAction, panelButton, panelTable;
  private JLabel labelTitle;
  private JButton btnAdd;
  private JTable drugTable;
  private String data[][] = {};
  private String header[] = { "No.", "Drug Name", "Description", "Side Effects", "In Stock" };

  public Drugs() {
    // Create Objects
    panelAction = new JPanel();
    panelTable = new JPanel();
    panelButton = new JPanel();
    labelTitle = new JLabel("Drugs List");
    btnAdd = new JButton("Add");
    // ArrayList<Drug> drugs = DrugModel.getDrugsDB();
    // data = new String[drugs.size()][];
    // for (int i = 0; i < drugs.size(); i++) {
    // data[i] = new String[] { String.valueOf(i + 1), drugs.get(i).getName(),
    // drugs.get(i).getDescription(),
    // drugs.get(i).getSideEffects(), String.valueOf(drugs.get(i).getStorage()) };
    // }

    drugTable = new JTable(data, header) {
      public boolean isCellEditable(int row, int column) {
        return false;
      }
    };
    JScrollPane acrollPaneTable = new JScrollPane(drugTable);

    // Set Layout
    this.setLayout(new BorderLayout());
    panelAction.setLayout(new BorderLayout());
    panelTable.setLayout(new GridLayout(1, 1));

    // Set Style
    btnAdd.setPreferredSize(new Dimension(200, 30));

    // Conponent Configuration
    labelTitle.setFont(new Font("InaiMathi", Font.BOLD, 24));
    btnAdd.setPreferredSize(new Dimension(200, 30));

    // Table Configuration
    drugTable.getTableHeader().setReorderingAllowed(false);
    drugTable.setRowHeight(30);
    // drugTable.getColumnModel().getColumn(0).setPreferredWidth(50);

    // Add Action Listener
    btnAdd.addActionListener(this);
    drugTable.getSelectionModel().addListSelectionListener(this);


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
    System.out.println("Selected Drug");
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand() == "Add") {
      new AddDrug();
    }
  }

  public JButton getBtnAdd() {
    return btnAdd;
  }

  public JTable getDrugTable() {
    return drugTable;
  }

}
