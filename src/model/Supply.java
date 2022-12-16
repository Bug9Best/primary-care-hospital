package model;

public class Supply {

  private String name;
  private String description;
  private String storage;

  public Supply() {
    this("", "", "");
  }

  public Supply(String name, String description, String storage) {
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

  public String getStorage() {
    return storage;
  }

}
