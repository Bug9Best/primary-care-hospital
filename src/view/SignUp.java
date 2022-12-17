package view;

import javax.swing.*;
import java.awt.*;

public class SignUp {
    // Main Frame
    JFrame fr = new JFrame();

    // Panel
    JPanel MainPanel = new JPanel();
    JPanel IconPanel = new JPanel();
    JPanel FormPanel = new JPanel();

    GridLayout gridLayout = new GridLayout(6, 2);
    JPanel Form = new JPanel(gridLayout);
    // JLabel
    JLabel Icon = new JLabel();
    JLabel LabelRegis = new JLabel("Register");
    JLabel LabelUsername = new JLabel("Username");
    JLabel LabelPassword = new JLabel("Password");
    JLabel LabelFullname = new JLabel("Fullname");
    JLabel LabelRole = new JLabel("Role");
    // Text Field
    JTextField TFUsername = new JTextField();
    JPasswordField TFPassword = new JPasswordField();
    JTextField TFFullname = new JTextField();
    // Button
    JButton BtRegis = new JButton("Register");
    String[] role = { "Select Role", "Doctor", "Registered Nurse","Technical Nurse", "Nursing Assistant" }; // add role this

    JComboBox AllRole = new JComboBox(role);

    public SignUp() {
        gridLayout.setVgap(10);
        Icon.setIcon(new ImageIcon("C:/Users/Gun/work/OOP/Login/src/33777-smll.png"));
        IconPanel.add(Icon);
        IconPanel.setBorder(BorderFactory.createEmptyBorder(175, 0, 0, 0));
        IconPanel.setSize(640, 720);
        IconPanel.setPreferredSize(new Dimension(640, 720));

        FormPanel.setBackground(Color.GRAY);
        Form.setBackground(Color.CYAN);
        Form.add(LabelRegis);
        Form.add(new Label());
        Form.add(LabelFullname);
        Form.add(TFFullname);
        Form.add(LabelRole);
        Form.add(AllRole);
        Form.add(LabelUsername);
        Form.add(TFUsername);
        Form.add(LabelPassword);
        Form.add(TFPassword);
        Form.add(BtRegis);
        // Form.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));

        FormPanel.setLayout(new BoxLayout(FormPanel, BoxLayout.Y_AXIS));
        FormPanel.setSize(640, 520);
        FormPanel.setPreferredSize(new Dimension(640, 520));
        FormPanel.setBorder(BorderFactory.createEmptyBorder(300, 100, 300, 100));
        FormPanel.add(Form);

        MainPanel.setLayout(new BoxLayout(MainPanel, BoxLayout.X_AXIS));
        MainPanel.setSize(640, 520);
        MainPanel.setPreferredSize(new Dimension(640, 520));
        MainPanel.add(IconPanel);
        MainPanel.add(FormPanel);

        fr.add(MainPanel);
        fr.setBackground(Color.BLUE);
        fr.setSize(1280, 720);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
