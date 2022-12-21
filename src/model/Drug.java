package model;

public class Drug {

  private String name;
  private String description;
  private String sideEffects;
  private String dosage;
  private int storage;

  public Drug() {
    this("", "", "", "", 0);
  }

  public Drug(
      String name,
      String description,
      String sideEffects,
      String dosage,
      int storage) {
    this.name = name;
    this.description = description;
    this.sideEffects = sideEffects;
    this.dosage = dosage;
    this.storage = storage;
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

  public int getStorage() {
    return storage;
  }
}
