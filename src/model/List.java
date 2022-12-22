package model;

public class List {
  private String name, coc, dateVisit;

  public List() {
    this(" ", " ", "");
  }

  public List(String name, String coc, String dateVisit) {
    this.name = name;
    this.coc = coc;
    this.dateVisit = dateVisit;
  }

  public String getName() {
    return name;
  }

  public String getCoc() {
    return coc;
  }

  public String getDateVisit() {
    return dateVisit;
  }

  public void setDateVisit(String dateVisit) {
    this.dateVisit = dateVisit;
  }

}
