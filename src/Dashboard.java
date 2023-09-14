import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

public class Dashboard extends JFrame implements ActionListener, MouseListener {
    private JLabel logo, trip, bookging, buses, users, settings, welcomeing;
    private JPanel trip_panel, bookging_panel, buses_panel, users_panel, settings_panel, trip_panel_bar;
    public static JPanel right_side, left_side;
    public static Color bkColor = new Color(20, 20, 20);
    public static Color wColor = new Color(240, 238, 238);
    private User user = LoginPanel.user;
    //
    public JPanel[] bars;

    TripPanelBar tb;
    BookingPanelBar bb;
    BusesPanelBar bub;

    // public Dashboard(User user) {
    // // this();
    // this.user = user;
    // System.out.println(user.getFname());
    // new Dashboard();

    // }

    public Dashboard() {
        // ****************** Prepare The Frame******************
        setSize(1200, 700);
        // remove the title bar
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the JFrame to the center of the screan
        setLocationRelativeTo(null);
        // setForeground(new Color(45, 45, 45));
        // set backgorond of the frame
        getContentPane().setBackground(new Color(45, 45, 45));
        // setVisible(true);
        // ******************************************************

        Container c = getContentPane();
        c.setLayout(null);

        bars = new JPanel[3];
        bars[0] = new TripPanelBar();

        bars[1] = new BookingPanelBar();
        bars[2] = new BusesPanelBar();

        // ****************** Prepare The Left panel******************
        left_side = new JPanel();
        // left_side.setBounds(0, 0, WIDTH, HEIGHT);
        left_side.setBounds(0, 0, 100, 700);
        left_side.setBackground(new Color(20, 20, 20));
        left_side.setLayout(null);

        // add the logo
        logo = new JLabel(new ImageIcon("F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\logo.png"));
        logo.setBounds(15, 15, 70, 70);
        left_side.add(logo);

        welcomeing = new JLabel(LoginPanel.user.getFname());

        welcomeing.setForeground(Color.white);
        welcomeing.setFont(new Font("Open Sans", Font.BOLD, 10));
        welcomeing.setBounds(30, 75, 98, 30);
        left_side.add(welcomeing);

        try {
            if (user.getRole().equals("admin")) {
                // add the all icons
                trip_panel = addSideIconPanel(
                        "F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\trips.png",
                        "\tTrips", 0, 100, 98, 80);
                left_side.add(trip_panel);
                trip_panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getComponent() == trip_panel) {
                            setVivibleFalse(bars);
                            bars[0].setVisible(true);

                            TripPanelBar x = (TripPanelBar) bars[0];
                            setVivibleFalse(x.plist);
                            x.setVisible(true);
                            x.plist[0].setVisible(true);
                            bars[0] = x;

                            BookingPanelBar y = (BookingPanelBar) bars[1];
                            setVivibleFalse(y.list);
                            bars[1] = y;

                            BusesPanelBar z = (BusesPanelBar) bars[2];
                            setVivibleFalse(z.plist);
                            bars[2] = z;

                            right_side.add(bars[0]);
                            invalidate();
                            validate();
                            repaint();
                        }
                    }
                });
                bookging_panel = addSideIconPanel(
                        "F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\booking.png",
                        "\tBooking", 0, 180, 98, 80);
                bookging_panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getComponent() == bookging_panel) {
                            setVivibleFalse(bars);
                            bars[1].setVisible(true);

                            TripPanelBar x = (TripPanelBar) bars[0];
                            setVivibleFalse(x.plist);
                            bars[0] = x;

                            // TripPanelBar y = (TripPanelBar) bars[1];
                            // setVivibleFalse(y.plist);
                            // bars[0] = y;

                            BusesPanelBar z = (BusesPanelBar) bars[2];
                            setVivibleFalse(z.plist);
                            bars[2] = z;

                            right_side.add(bars[1]);
                            invalidate();
                            validate();
                            repaint();
                        }
                    }
                });
                left_side.add(bookging_panel);

                buses_panel = addSideIconPanel("F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\bus.png",
                        "\tBuses", 0, (180 + 80), 98, 80);
                left_side.add(buses_panel);
                buses_panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getComponent() == buses_panel) {
                            setVivibleFalse(bars);
                            bars[2].setVisible(true);

                            TripPanelBar x = (TripPanelBar) bars[0];
                            setVivibleFalse(x.plist);
                            bars[0] = x;

                            BookingPanelBar y = (BookingPanelBar) bars[1];
                            setVivibleFalse(y.list);
                            bars[1] = y;

                            right_side.add(bars[2]);
                            invalidate();
                            validate();
                            repaint();
                        }
                    }
                });

                // users_panel =
                // addSideIconPanel("F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\users.png",
                // "\tUsers", 0, (180 + 2 * 80), 100, 80);
                // left_side.add(users_panel);
                // // add the left side to the container
                left_side.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.white));
                c.add(left_side);
                System.out.println("first if");
            } else if (user.getRole().equals("user")) {
                bookging_panel = addSideIconPanel(
                        "F:\\@OMER_Files\\MyBackUp\\2023\\01\\20\\19+16\\SBC\\src\\img\\booking.png",
                        "\tBooking", 0, 180, 98, 80);
                bookging_panel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (e.getComponent() == bookging_panel) {
                            setVivibleFalse(bars);
                            bars[1].setVisible(true);

                            TripPanelBar x = (TripPanelBar) bars[0];
                            setVivibleFalse(x.plist);
                            bars[0] = x;

                            // TripPanelBar y = (TripPanelBar) bars[1];
                            // setVivibleFalse(y.plist);
                            // bars[0] = y;

                            BusesPanelBar z = (BusesPanelBar) bars[2];
                            setVivibleFalse(z.plist);
                            bars[2] = z;

                            right_side.add(bars[1]);
                            invalidate();
                            validate();
                            repaint();
                        }
                    }
                });
                left_side.add(bookging_panel);
                left_side.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.white));
                c.add(left_side);
                System.out.println("second if");
            } else if (user.getRole() == null) {
                JOptionPane.showMessageDialog(Dashboard.this,
                        "Please Login Correctly!",
                        "Try again",
                        JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // TODO: handle exception
        }
        // ****************** Prepare The Right Side Panel******************

        right_side = new JPanel();
        right_side.setBounds(100, 0, 1100, 700);
        right_side.setLayout(null);
        right_side.setSize(1100, 700);
        right_side.setBackground(new Color(45, 45, 45));

        JButton quitButton = new JButton("X");
        quitButton.setFont(new Font("Open Sans", Font.PLAIN, 16));
        quitButton.setForeground(Color.white);
        quitButton.setBorderPainted(false);
        quitButton.setContentAreaFilled(false);
        quitButton.setFocusable(false);
        quitButton.setBounds(1050, 10, 50, 10);

        quitButton.addActionListener((event) -> System.exit(0));
        right_side.add(quitButton);

        // display on start

        // TripPanelBar x = (TripPanelBar) bars[0];
        // x.setVisible(true);
        // x.plist[0].setVisible(true);
        // bars[0] = x;
        // right_side.add(bars[0]);

        // trip_panel_bar = addTripPanel();
        // right_side.add(trip_panel_bar);

        // right_side.add(body);
        c.add(right_side);

        setVisible(false);
    }

    public static JPanel addSideIconPanel(String iconPath, String text, int x, int y, int width, int hight) {
        JPanel trip_panel = new JPanel();
        trip_panel.setSize(100, 80);
        trip_panel.setBackground(new Color(20, 20, 20));
        trip_panel.setBounds(x, y, width, hight);
        trip_panel.setLayout(new BorderLayout());
        JLabel trip = new JLabel(new ImageIcon(iconPath));

        trip.setText(text);
        trip.setForeground(Color.WHITE);
        trip.setFont(new Font("Open Sans", Font.BOLD, 12));
        trip_panel.add(trip, BorderLayout.CENTER);
        return trip_panel;
    }

    public static JTextField addTextFieldBody(int x, int y, int width, int hight) {
        JTextField tf = new JTextField(20);

        tf.setBounds(x, y, width, hight);
        tf.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        tf.setForeground(Color.WHITE);
        tf.setFont(new Font("Open Sans", Font.PLAIN, 15));
        tf.setBackground(new Color(45, 45, 45));
        return tf;
    }

    public static JComboBox addComboBox(int x, int y, int width, int hight) {
        JComboBox cb = new JComboBox<String>();
        cb.setBackground(bkColor);
        cb.setBackground(new Color(45, 45, 45));
        cb.setRenderer(new DefaultListCellRenderer());
        Object child = cb.getAccessibleContext().getAccessibleChild(0);
        BasicComboPopup popup = (BasicComboPopup) child;
        JList list = popup.getList();
        list.setSelectionBackground(Color.orange);
        cb.setForeground(wColor);
        cb.setBounds(x, y, width, hight);
        return cb;
    }

    public static JLabel addTitle(String text, int x, int y, int width, int hight) {
        JLabel add_trips = new JLabel(text);
        add_trips.setFont(new Font("Open Sans", Font.BOLD, 14));
        add_trips.setForeground(wColor);
        add_trips.setBounds(x, y, width, hight);
        return add_trips;
    }

    public static JLabel addTextFieldLable(String text, int x, int y, int width, int hight) {
        JLabel pk = new JLabel(text);
        pk.setFont(new Font("Open Sans", Font.BOLD, 12));
        pk.setForeground(wColor);
        pk.setBounds(x, y, width, hight);
        return pk;

    }

    public static void setVivibleFalse(JPanel[] barElents) {
        for (JPanel x : barElents) {
            x.setVisible(false);
        }
    }

    static Dashboard x = new Dashboard();

    // String pickup_station, String drop_staion, int bus_num, String driver_num,
    // int cost,int seats_num

    public static void main(String[] args) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // if (e.getSource() == trip_panel_bar.)
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent() == trip_panel) {
            JPanel p = new TripPanelAdd();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
