package model;

public class Supply {

  private String name;
  private String description;
  private int storage;

  public Supply() {
    this("", "", 0);
  }

  public Supply(String name, String description, int storage) {
    this.name = name;
    this.description = description;
    this.storage = storage;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getStorage() {
    return storage;
  }

}
