package model;

public class SupplyModel {
  private DrugModel drugModel;
  private int quantity;

  public SupplyModel(DrugModel drugModel, int quantity) {
    this.drugModel = drugModel;
    this.quantity = quantity;
  }

  public DrugModel getDrugModel() {
    return drugModel;
  }

  public void setDrugModel(DrugModel drugModel) {
    this.drugModel = drugModel;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
