package view;

import javax.swing.*;
import java.awt.*;

public class SignIn {
    // Main Frame
    JFrame fr = new JFrame();

    // Panel
    JPanel MainPanel = new JPanel();
    JPanel IconPanel = new JPanel();
    JPanel FormPanel = new JPanel();

    GridLayout gridLayout = new GridLayout(4, 2);
    JPanel Form = new JPanel(gridLayout);
    // JLabel
    JLabel Icon = new JLabel();
    JLabel LabelLogin = new JLabel("Login");
    JLabel LabelUsername = new JLabel("Username");
    JLabel LabelPassword = new JLabel("Password");

    //Text Field
    JTextField TFUsername = new JTextField();
    JPasswordField TFPassword = new JPasswordField();

    //Button
    JButton BtLogin = new JButton("Login");
    JButton BtRegis = new JButton("Register");

    public SignIn(){
        gridLayout.setVgap(10);
        Icon.setIcon(new ImageIcon("C:/Users/Gun/work/OOP/Login/src/33777-smll.png"));
        IconPanel.add(Icon);
        IconPanel.setBorder(BorderFactory.createEmptyBorder(175,0,0,0));
        IconPanel.setSize(640, 720);
        IconPanel.setPreferredSize(new Dimension(640, 720));

        FormPanel.setBackground(Color.GRAY);
        Form.setBackground(Color.CYAN);
        Form.add(LabelLogin);
        Form.add(new Label());
        Form.add(LabelUsername);
        Form.add(TFUsername);
        Form.add(LabelPassword);
        Form.add(TFPassword);
        Form.add(BtLogin);
        Form.add(BtRegis);
        //Form.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));

        FormPanel.setLayout(new BoxLayout(FormPanel, BoxLayout.Y_AXIS));
        FormPanel.setSize(640, 520);
        FormPanel.setPreferredSize(new Dimension(640, 520));
        FormPanel.setBorder(BorderFactory.createEmptyBorder(300,100,300,100));
        FormPanel.add(Form);

        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.X_AXIS));
        MainPanel.setSize(640,520);
        MainPanel.setPreferredSize(new Dimension(640,520));
        MainPanel.add(IconPanel);
        MainPanel.add(FormPanel);

        fr.add(MainPanel);
        fr.setBackground(Color.BLUE);
        fr.setSize(1280, 720);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
    }
}
