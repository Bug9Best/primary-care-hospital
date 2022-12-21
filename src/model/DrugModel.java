package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DrugModel {
  private static Drug drug;

  public DrugModel(Drug drug) {
    this.drug = drug;
  }

  public Drug getDrug() {
    return drug;
  }

  public void setDrug(Drug drug) {
    this.drug = drug;
  }

  public static ArrayList<Drug> getDrugsDB() {
    ArrayList<Drug> drugList = new ArrayList();
    String sql = "SELECT * FROM drugs";
    try (Connection con = ConnnectDB.ConnectDB()) {
      try (PreparedStatement statement = con.prepareStatement(sql)) {
        ResultSet result = statement.executeQuery(sql);
        while (result.next()) {
          drug = new Drug(
              result.getString("name"),
              result.getString("description"),
              result.getString("sideEffects"),
              result.getString("dosage"),
              result.getInt("storage"));
        }
        drugList.add(drug);
        System.out.println("Get Drugs From Successfully");
      } catch (SQLException e) {
        System.out.println("Get Drugs From Failed");
      }

    } catch (SQLException e) {
      System.out.println("Connect Failed!!!");
    }
    return drugList;
  }
}
