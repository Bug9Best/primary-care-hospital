import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import controller.HomeController;

public class Main {
  public static void main(String[] args) {
    try {
      for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          new HomeController();
        }
      }
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
