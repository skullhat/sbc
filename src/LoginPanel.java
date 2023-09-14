import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.Random;

public class LoginPanel extends JFrame implements ActionListener {

    JLabel username, password, img;
    JButton loginpb, signpb, signupotp, send;
    final private Font mainFont = new Font("Open Sans", Font.PLAIN, 16);
    JTextField txtusername;
    JPanel loginp, regesp;
    JPasswordField txtpassword;
    User us = null;
    int otpcode;
    static JPanel mainPanel;
    static String fname1;
    static String lname1;
    static String un;
    static String pw;
    static String phone;

    static User user = new User();

    public LoginPanel() {
        // super("Bus System");
        user.setRole(null);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
        // setVisible(true);

        JPanel lrpanel = new JPanel();
        lrpanel.setLayout(null);
        lrpanel.setBackground(new Color(20, 20, 20));
        lrpanel.setBounds(750, 180, 400, 500);
        lrpanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white));

        JButton login = new JButton("Login");
        login.setBounds(40, 30, 150, 50);
        login.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        login.setForeground(Color.WHITE);
        login.setFont(new Font("Open Sans", Font.PLAIN, 16));
        login.setBackground(new Color(45, 45, 45));
        // login.setContentAreaFilled(false);
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                regesp.setVisible(false);

                loginp.setVisible(true);
            }
        });
        lrpanel.add(login);

        JButton signup = new JButton("Sign Up");
        signup.setBounds(200, 30, 150, 50);
        signup.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        signup.setForeground(Color.WHITE);
        signup.setFont(new Font("Open Sans", Font.PLAIN, 16));
        signup.setBackground(new Color(45, 45, 45));
        signup.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                regesp.setVisible(true);
                loginp.setVisible(false);
            }
        });
        lrpanel.add(signup);

        loginp = new JPanel();
        loginp.setLayout(null);
        loginp.setBounds(40, 100, 310, 380);
        //
        loginp.setBackground(new Color(45, 45, 45));
        // loginp.setOpaque(false);

        /******************* Form Panel *******************/
        username = Dashboard.addTextFieldLable("Username", 19, 30, 100, 40);
        username.setFont(new Font("Open Sans", Font.PLAIN, 16));
        txtusername = Dashboard.addTextFieldBody(30, 60, 250, 40);
        txtusername.setFont(new Font("Open Sans", Font.PLAIN, 16));

        password = Dashboard.addTextFieldLable("Password", 19, 120, 100, 40);
        password.setFont(mainFont);

        txtpassword = new JPasswordField();
        txtpassword.setBounds(30, 150, 250, 40);
        txtpassword.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        txtpassword.setForeground(Color.WHITE);
        txtpassword.setFont(new Font("Open Sans", Font.PLAIN, 15));
        txtpassword.setBackground(new Color(45, 45, 45));
        txtpassword.setFont(mainFont);

        loginpb = new JButton("Login");
        loginpb.setBounds(180, 320, 100, 40);
        loginpb.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        loginpb.setForeground(Color.WHITE);
        loginpb.setFont(new Font("Open Sans", Font.PLAIN, 16));
        loginpb.setBackground(new Color(45, 45, 45));

        loginpb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String un = txtusername.getText();
                String pw = String.valueOf(txtpassword.getPassword());

                user = getAuthenticatedUser(un, pw);

                if (user == null) {
                    // Dashboard db = new Dashboard();
                    // db.setVisible(false);
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Email or Password Invalid",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                } else if (txtpassword.getText().isEmpty() || txtusername.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Hack Me If You Can!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    Dashboard db = new Dashboard();
                    db.setVisible(true);
                    a.setVisible(false);

                }
            }

        });

        loginp.add(username);
        loginp.add(txtusername);
        loginp.add(password);
        loginp.add(txtpassword);
        loginp.add(loginpb);

        loginp.setVisible(true);
        lrpanel.add(loginp);

        regesp = new JPanel();
        regesp.setLayout(null);
        regesp.setBounds(40, 100, 310, 380);
        //
        regesp.setBackground(new Color(45, 45, 45));

        JLabel fname = Dashboard.addTextFieldLable("First Name", 19, 10, 100, 40);
        fname.setFont(new Font("Open Sans", Font.PLAIN, 16));
        regesp.add(fname);
        JTextField txtfname = Dashboard.addTextFieldBody(30, 40, 120, 40);
        txtfname.setFont(new Font("Open Sans", Font.PLAIN, 16));
        regesp.add(txtfname);

        JLabel lname = Dashboard.addTextFieldLable("Last Name", 155, 10, 100, 40);
        lname.setFont(mainFont);
        regesp.add(lname);

        JTextField lnametf = Dashboard.addTextFieldBody(160, 40, 120, 40);
        lnametf.setFont(new Font("Open Sans", Font.PLAIN, 16));
        regesp.add(lnametf);
        JLabel user = Dashboard.addTextFieldLable("Username", 19, 80, 100, 40);
        user.setFont(mainFont);
        regesp.add(user);

        JTextField usertf = Dashboard.addTextFieldBody(30, 110, 250, 40);
        usertf.setFont(new Font("Open Sans", Font.PLAIN, 16));
        regesp.add(usertf);

        JLabel passlb = Dashboard.addTextFieldLable("Password", 19, 160, 100, 40);
        passlb.setFont(mainFont);
        regesp.add(passlb);

        JPasswordField usernla = new JPasswordField();
        usernla.setBounds(30, 190, 250, 40);
        usernla.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        usernla.setForeground(Color.WHITE);
        usernla.setFont(new Font("Open Sans", Font.PLAIN, 15));
        usernla.setBackground(new Color(45, 45, 45));
        usernla.setFont(mainFont);
        regesp.add(usernla);

        JLabel phonelb = Dashboard.addTextFieldLable("Phone Number", 19, 230, 150, 40);
        phonelb.setFont(mainFont);
        regesp.add(phonelb);

        JTextField phonetf = Dashboard.addTextFieldBody(30, 260, 250, 40);
        phonetf.setFont(new Font("Open Sans", Font.PLAIN, 16));
        regesp.add(phonetf);
        signpb = new JButton("Sign Up");
        signpb.setBounds(180, 320, 100, 40);
        signpb.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        signpb.setForeground(Color.WHITE);
        signpb.setFont(new Font("Open Sans", Font.PLAIN, 16));
        signpb.setBackground(new Color(45, 45, 45));

        regesp.setVisible(false);
        JPanel otp = new JPanel();

        otp.setLayout(null);
        otp.setBounds(40, 100, 310, 380);

        JLabel l1 = Dashboard
                .addTextFieldLable("\tAn OTP Code Sent Your Phone", 19, 10, 300, 40);
        l1.setFont(new Font("Open Sans", Font.PLAIN, 19));
        otp.add(l1);

        JLabel otp_lable = Dashboard.addTextFieldLable("OTP Code:", 19, 50, 250, 40);

        otp_lable.setFont(new Font("Open Sans", Font.PLAIN, 16));
        otp.add(otp_lable);
        JTextField otp_TextField = Dashboard.addTextFieldBody(30, 90, 250, 40);
        otp_TextField.setFont(new Font("Open Sans", Font.PLAIN, 16));
        otp.add(otp_TextField);

        otp.setBackground(new Color(45, 45, 45));
        send = new JButton("Send");
        send.setBounds(30, 320, 100, 40);
        send.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("Open Sans", Font.PLAIN, 16));
        send.setBackground(new Color(45, 45, 45));

        send.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                otpcode = sendOTP();
            }
        });
        otp.add(send);

        signupotp = new JButton("Check");
        signupotp.setBounds(180, 320, 100, 40);
        signupotp.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        signupotp.setForeground(Color.WHITE);
        signupotp.setFont(new Font("Open Sans", Font.PLAIN, 16));
        signupotp.setBackground(new Color(45, 45, 45));
        signupotp.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (otp_TextField.getText().equals(Integer.toString(otpcode))) {

                    try {
                        fname1 = txtfname.getText();
                        lname1 = lnametf.getText();
                        un = usertf.getText();
                        pw = String.valueOf(usernla.getPassword());
                        phone = phonetf.getText();
                        System.out.println(fname1);

                        regesterUser(fname1, lname1, un, pw, phone);

                        JOptionPane.showMessageDialog(LoginPanel.this,
                                "User Regestered Successfuly",
                                "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(LoginPanel.this,
                                e1.getMessage(),
                                "Message",
                                JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(LoginPanel.this,
                            "Invalid OTP Code",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        otp.add(signupotp);
        otp.setVisible(false);
        lrpanel.add(otp);
        signpb.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (usertf.getText().isEmpty() || String.valueOf(usernla.getPassword()).isEmpty()) {
                        JOptionPane.showMessageDialog(LoginPanel.this,
                                "Don't Try To Be Cliver!",
                                "Message",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    otp.setVisible(true);

                } catch (Exception x) {

                }
            }
        });

        regesp.add(signpb);

        regesp.setVisible(false);

        lrpanel.add(regesp);

        // img = new JLabel(new
        // ImageIcon("C:\\Users\\0-11\\Downloads\\csm_eb6017_446a8eee59.jpg"));

        /******************* Main Panel *******************/

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(45, 45, 45));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(lrpanel);
        mainPanel.setBounds(0, 0, 1200, 700);
        // mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        // mainPanel.add(img, BorderLayout.CENTER);

        JLabel sbc = new JLabel("Sudanese Buses Company");
        sbc.setForeground(Color.white);
        sbc.setBounds(180, 10, 3000, 150);
        sbc.setFont(new Font("Open Sans", Font.BOLD, 55));
        mainPanel.add(sbc);

        JLabel createdby = new JLabel("     Developed by: Mohsin Aljili and Omer Khalid");
        createdby.setForeground(Color.white);
        createdby.setBounds(180, 50, 3000, 150);
        createdby.setFont(new Font("Open Sans", Font.PLAIN, 20));
        mainPanel.add(createdby);

        JLabel umg = new JLabel();
        umg.setBounds(60, 45, 100, 100);
        java.awt.image.BufferedImage img = null;
        try {
            img = ImageIO.read(new File("F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\i.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(umg.getWidth(), umg.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon imageIcon = new ImageIcon(dimg);

        umg.setIcon(imageIcon);
        mainPanel.add(umg);

        JLabel photo = new JLabel();
        photo.setBounds(10, 180, 720, 500);
        java.awt.image.BufferedImage phot = null;
        try {
            phot = ImageIO.read(new File("F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\sbc.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image ximg = phot.getScaledInstance(photo.getWidth(), photo.getHeight(),
                Image.SCALE_SMOOTH);

        ImageIcon im = new ImageIcon(ximg);

        photo.setIcon(im);
        mainPanel.add(photo);

        JButton quitButton = new JButton("X");
        quitButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        quitButton.setForeground(Color.white);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusable(false);
        quitButton.setBounds(1150, 10, 50, 10);

        quitButton.addActionListener((event) -> System.exit(0));

        mainPanel.add(quitButton);
        mainPanel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white));

        add(mainPanel);
        show();

    }

    static LoginPanel a;

    public static void main(String[] args) {
        a = new LoginPanel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public User getAuthenticatedUser(String un, String pwd) {

        User user = null;
        final String DB_URL = "jdbc:mysql://localhost/sbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, un);
            preparedStatement.setString(2, pwd);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setFname(resultSet.getString(2));
                user.setLname(resultSet.getString(3));
                user.setUsername(resultSet.getString(4));
                user.setPassword(resultSet.getString(5));
                user.setPhone(resultSet.getString(6));
                user.setRole(resultSet.getString(7));
            }
            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Database connexion failed!");
        }
        return user;

    }

    public static int sendOTP() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000, 50);

            // Start listening for connections on the server socket
            Socket connectToClient = serverSocket.accept();

            // Create an input stream to get data from the client
            DataInputStream input = new DataInputStream(connectToClient.getInputStream());

            // Create an output stream to send data to the client
            DataOutputStream output = new DataOutputStream(connectToClient.getOutputStream());

            // Continuously read from the client and process it,
            // and send result back to the client

            Random random = new Random();
            String id = String.format("%04d", random.nextInt(10000));
            int otp = 0;

            otp = new Integer(id).intValue();
            System.out.println("OTP sent sucessfully: " + otp);

            // Send the radius to the server
            output.writeInt(otp);
            output.flush();

            return otp;

            // Get area from the server

        } catch (IOException ex) {
            System.out.println(ex);
        }
        return 0;
    }

    private void regesterUser(String fname, String lname, String un, String pwd, String phone) throws Exception {

        final String DB_URL = "jdbc:mysql://localhost/sbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            String sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES ( ?,?, ?, ?, ?, ? )";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, ++new User().id);
            preparedStatement.setString(2, fname);
            preparedStatement.setString(3, lname);
            preparedStatement.setString(4, un);
            preparedStatement.setString(5, pwd);
            preparedStatement.setString(6, phone);

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }

    }
}