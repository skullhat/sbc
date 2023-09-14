import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;

public class TripPanelAdd extends JPanel {
    JLabel add_trip;

    TripPanelAdd() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        add_trip = Dashboard.addTitle("Add a Trip", 10, 10, 100, 40);
        this.add(add_trip);

        JLabel pks = Dashboard.addTextFieldLable("Pickup Station:", 20, 40, 100, 40);
        this.add(pks);

        JTextField pks_tk = Dashboard.addTextFieldBody(20, 75, 250, 35);
        this.add(pks_tk);

        JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 400, 40, 100, 40);
        this.add(ds);
        JTextField ds_tk = Dashboard.addTextFieldBody(400, 75, 250, 35);
        this.add(ds_tk);

        JLabel bno = Dashboard.addTextFieldLable("Bus Number:", 20, 140, 100, 40);
        this.add(bno);
        JTextField bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
        this.add(bno_tk);

        JLabel cost = Dashboard.addTextFieldLable("Trip Cost:", 20, 240, 100, 40);
        this.add(cost);
        JTextField cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
        this.add(cost_tk);

        JLabel drinum = Dashboard.addTextFieldLable("Driver Number:", 20, 350, 250, 40);
        this.add(drinum);

        JTextField drinum_tf = Dashboard.addTextFieldBody(20, 385, 380, 35);
        this.add(drinum_tf);

        JLabel seats = Dashboard.addTextFieldLable("Seats Number:", 20, 430 + 20, 300, 40);
        this.add(seats);

        JTextField sears_tf = Dashboard.addTextFieldBody(20, 465 + 20, 380, 35);
        this.add(sears_tf);

        JButton create = new JButton("Create");

        create.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        create.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        create.setContentAreaFilled(false);
        create.setBounds(800, 500 + 30, 80, 40);
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Trip t = new Trip();

                try {

                    String pickup_station = pks_tk.getText();
                    String drop_staion = ds_tk.getText();
                    String driver_num = drinum_tf.getText();
                    int bus_num, cost, seats_num = 0;
                    bus_num = Integer.parseInt(bno_tk.getText());
                    cost = Integer.parseInt(cost_tk.getText());
                    seats_num = Integer.parseInt(sears_tf.getText());
                    t.setPickup_station(pickup_station);
                    t.setDrop_staion(drop_staion);
                    t.setBus_num(bus_num);
                    t.setDriver_num(driver_num);
                    t.setCost(cost);
                    t.setSeats_num(seats_num);
                    addTrip(t);
                    JOptionPane.showMessageDialog(TripPanelAdd.this,
                            "Trip Added Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    pks_tk.setText("");
                    ds_tk.setText("");
                    drinum_tf.setText("");
                    bno_tk.setText("");
                    cost_tk.setText("");
                    sears_tf.setText("");
                    // refresh the panels
                    TripPanelBar.plist[2] = new TripPanelEdit();
                    TripPanelBar.plist[3] = new TripPanelDelete();
                    BookingPanelBar.list[0] = new BookingPanelDisplay();
                    BookingPanelBar.list[1] = new BookingPanelAdd();
                    // TripPanelBar.plist[1] = new TripPanelAdd();
                    TripPanelBar.plist[0] = new TripPanelDisplay();
                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(TripPanelAdd.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TripPanelAdd.this,
                            ex.getMessage(),
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        this.add(create);
    }

    // JPanel addTripPanel() {
    // body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // add_trip = Dashboard.addTitle("Add a Trip", 10, 10, 100, 40);
    // body.add(add_trip);

    // JLabel pks = Dashboard.addTextFieldLable("Pickup Station:", 20, 40, 100, 40);
    // body.add(pks);

    // JTextField pks_tk = Dashboard.addTextFieldBody(20, 75, 250, 35);
    // body.add(pks_tk);

    // JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 400, 40, 100, 40);
    // body.add(ds);
    // JTextField ds_tk = Dashboard.addTextFieldBody(400, 75, 250, 35);
    // body.add(ds_tk);

    // JLabel bno = Dashboard.addTextFieldLable("Bus Number:", 20, 140, 100, 40);
    // body.add(bno);
    // JTextField bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
    // body.add(bno_tk);

    // JLabel cost = Dashboard.addTextFieldLable("Trip Cost:", 20, 240, 100, 40);
    // body.add(cost);
    // JTextField cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
    // body.add(cost_tk);

    // JLabel noTrips = Dashboard.addTextFieldLable("Number of Available Buses:",
    // 20, 350, 300, 40);
    // body.add(noTrips);

    // JLabel no_Trips = Dashboard.addTextFieldLable("7", 300, 350, 300, 40);
    // body.add(no_Trips);

    // JLabel dr_no = Dashboard.addTextFieldLable("Number of Available Drivers:",
    // 20, 375, 340, 40);
    // body.add(dr_no);

    // JLabel dri_No = Dashboard.addTextFieldLable("7", 300, 375, 340, 40);
    // body.add(dri_No);

    // JButton create = new JButton("Create");

    // create.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // create.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // create.setContentAreaFilled(false);
    // create.setBounds(800, 500, 80, 40);
    // body.add(create);
    // return body;
    // }

    private void addTrip(Trip t) throws Exception {

        final String DB_URL = "jdbc:mysql://localhost/sbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        // t = new Trip();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "INSERT INTO trips (pickup_station, drop_staion, bus_num, driver_num, cost, seats_num) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            // preparedStatement.setInt(1,.id);
            preparedStatement.setString(1, t.getPickup_station());
            preparedStatement.setString(2, t.getDrop_staion());
            preparedStatement.setInt(3, t.getBus_num());
            preparedStatement.setString(4, t.getDriver_num());
            preparedStatement.setInt(5, t.getCost());
            preparedStatement.setInt(6, t.getSeats_num());

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }

    }

}
