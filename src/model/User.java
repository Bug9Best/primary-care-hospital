package model;

public class User {
  private String name, roll, username, password;

  public User() {
    this("", "", "", "");
  }

  public User(String name, String roll, String username, String password) {
    this.name = name;
    this.roll = roll;
    this.username = username;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRoll() {
    return roll;
  }

  public void setRoll(String roll) {
    this.roll = roll;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
