
import java.awt.*;

import javax.swing.*;

public class REGEST extends JFrame {

  JLabel fname, lname, password, user, fone, pass;
  final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
  JTextField firstname, lastname, userr, fon, compass;
  JPasswordField txtpassword;

  public REGEST() {
    super("BUS SYSTEM");

    /******************* Form Panel *******************/
    fname = new JLabel("FIRST NAME");
    fname.setFont(mainFont);
    fname.setForeground(Color.WHITE);

    firstname = new JTextField();
    firstname.setFont(mainFont);

    lname = new JLabel("LAST NAME");
    lname.setFont(mainFont);
    lname.setForeground(Color.WHITE);

    lastname = new JTextField();
    lastname.setFont(mainFont);

    user = new JLabel("USER");
    user.setFont(mainFont);
    user.setForeground(Color.WHITE);

    userr = new JTextField();
    userr.setFont(mainFont);

    password = new JLabel("PASSWORD");
    password.setFont(mainFont);
    password.setForeground(Color.WHITE);

    txtpassword = new JPasswordField();
    txtpassword.setFont(mainFont);

    pass = new JLabel("CONFIRM PASSWORD");
    pass.setFont(mainFont);
    pass.setForeground(Color.WHITE);

    compass = new JPasswordField();
    compass.setFont(mainFont);

    fone = new JLabel("PHONE");
    fone.setFont(mainFont);
    fone.setForeground(Color.WHITE);

    fon = new JTextField();
    fon.setFont(mainFont);

    JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));

    formPanel.setOpaque(false);
    formPanel.add(fname);
    formPanel.add(firstname);
    formPanel.add(lname);
    formPanel.add(lastname);
    formPanel.add(user);
    formPanel.add(userr);
    formPanel.add(fone);
    formPanel.add(fon);
    formPanel.add(password);
    formPanel.add(txtpassword);
    formPanel.add(pass);
    formPanel.add(compass);

    /******************* Buttons Panel *******************/
    JButton btnSignIn = new JButton("sign in");
    btnSignIn.setFont(mainFont);
    btnSignIn.setForeground(Color.WHITE);
    btnSignIn.setBackground(new Color(114, 134, 211));

    JButton btnSignUp = new JButton("Sign Up");
    btnSignUp.setFont(mainFont);
    btnSignUp.setForeground(Color.WHITE);
    btnSignUp.setBackground(new Color(114, 134, 211));

    JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));
    buttonPanel.setOpaque(false);
    buttonPanel.add(btnSignIn);
    buttonPanel.add(btnSignUp);

    /******************* Main Panel *******************/

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout(0, 20));
    mainPanel.setBackground(Color.DARK_GRAY);
    mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    mainPanel.add(formPanel, BorderLayout.NORTH);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH);

    add(mainPanel);

    setSize(500, 600);
    setResizable(false);
    setMinimumSize(new Dimension(300, 400));

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    REGEST a = new REGEST();
  }

}