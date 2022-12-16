package model;

public class Drug {

  private String name;
  private String description;
  private String sideEffects;
  private String dosage;
  private String storage;
  private String price;

  public Drug() {
    this("", "", "", "", "", "");
  }

  public Drug(
      String name,
      String description,
      String sideEffects,
      String dosage,
      String storage,
      String price) {
    this.name = name;
    this.description = description;
    this.sideEffects = sideEffects;
    this.dosage = dosage;
    this.storage = storage;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public String getSideEffects() {
    return sideEffects;
  }

  public String getDosage() {
    return dosage;
  }

  public String getStorage() {
    return storage;
  }

  public String getPrice() {
    return price;
  }
}
