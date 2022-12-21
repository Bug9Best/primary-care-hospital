package model;

public class UserModel {
  private User user;

  public UserModel(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }  
}