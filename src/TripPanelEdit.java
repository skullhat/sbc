import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class TripPanelEdit extends JPanel {
    JPanel body;
    JLabel add_trip;
    private Exception Exception;
    String[] v;
    String[] trips;

    TripPanelEdit() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        add_trip = Dashboard.addTitle("Edit a Trip", 10, 10, 100, 40);
        this.add(add_trip);

        JComboBox tripList = Dashboard.addComboBox(20, 70, 400, 40);
        // get trips from database

        try {
            trips = getTripsForComboBox();
            tripList.setModel(new DefaultComboBoxModel(trips));

        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.add(tripList);

        JLabel pk = Dashboard.addTextFieldLable("Pickup Station:", 450, 40, 100, 40);
        this.add(pk);

        JTextField pk_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
        this.add(pk_tf);

        JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 450, 140, 100, 40);
        this.add(ds);
        JTextField ds_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
        this.add(ds_tf);

        JLabel bno = Dashboard.addTextFieldLable("Bus Number:", 20, 140, 100, 40);
        this.add(bno);
        JTextField bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
        this.add(bno_tk);

        JLabel cost = Dashboard.addTextFieldLable("Trip Cost:", 20, 240, 100, 40);
        this.add(cost);

        JTextField cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
        this.add(cost_tk);

        JLabel n_seats = Dashboard.addTextFieldLable("Number of Seats:", 20, 240 + 80, 150, 40);
        this.add(n_seats);

        JTextField n_s_tf = Dashboard.addTextFieldBody(20, 355, 380, 35);
        this.add(n_s_tf);

        JLabel drinum = Dashboard.addTextFieldLable("Driver Number:", 20, 400, 250, 40);
        this.add(drinum);

        JTextField drinum_tf = Dashboard.addTextFieldBody(20, 435, 380, 35);
        this.add(drinum_tf);

        JButton update = new JButton("Update");

        update.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        update.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        update.setContentAreaFilled(false);
        update.setBounds(800, 500, 80, 40);
        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Trip t = new Trip();

                try {

                    String pickup_station = pk_tf.getText();
                    String drop_staion = ds_tf.getText();
                    String driver_num = drinum_tf.getText();
                    int bus_num, cost, seats_num = 0;
                    bus_num = Integer.parseInt(bno_tk.getText());
                    cost = Integer.parseInt(cost_tk.getText());
                    seats_num = Integer.parseInt(n_s_tf.getText());
                    t.setPickup_station(pickup_station);
                    t.setDrop_staion(drop_staion);
                    t.setBus_num(bus_num);
                    t.setDriver_num(driver_num);
                    t.setCost(cost);
                    t.setSeats_num(seats_num);
                    v = trips[tripList.getSelectedIndex()].split("-");
                    String pk = v[0];
                    System.out.println(pk);

                    editTrip(t, pk);
                    JOptionPane.showMessageDialog(TripPanelEdit.this,
                            "Trip Editid Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    try {
                        trips = getTripsForComboBox();
                        tripList.setModel(new DefaultComboBoxModel(trips));
                        v = trips[tripList.getSelectedIndex()].split("-");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    pk_tf.setText("");
                    ds_tf.setText("");
                    drinum_tf.setText("");
                    bno_tk.setText("");
                    cost_tk.setText("");
                    n_s_tf.setText("");
                    // TripPanelBar.plist[2] = new TripPanelEdit();
                    TripPanelBar.plist[3] = new TripPanelDelete();
                    // TripPanelBar.plist[1] = new TripPanelAdd();
                    TripPanelBar.plist[0] = new TripPanelDisplay();
                    BookingPanelBar.list[0] = new BookingPanelDisplay();
                    BookingPanelBar.list[1] = new BookingPanelAdd();

                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(TripPanelEdit.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TripPanelEdit.this,
                            "PLEASE FILL ALL THE FEILDSs FIRST!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        // try {
        // if (trips.length == 0) {
        // throw Exception;
        // }

        // } catch (Exception e) {
        // // TODO Auto-generated catch block
        // JOptionPane.showMessageDialog(TripPanelEdit.this,
        // "THERE IS NO TRIPS TO EDITM, PLEASE ADD TRIPS FIRST!",
        // "Try again",
        // JOptionPane.ERROR_MESSAGE);
        // }

        this.add(update);

    }

    // JPanel editTripPanel() {
    // body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // add_trip = Dashboard.addTitle("Edit a Trip", 10, 10, 100, 40);
    // body.add(add_trip);

    // JComboBox tripList = Dashboard.addComboBox(20, 70, 400, 40);
    // body.add(tripList);

    // JLabel pk = Dashboard.addTextFieldLable("Pickup Station:", 450, 40, 100, 40);
    // body.add(pk);

    // JTextField pk_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
    // body.add(pk_tf);

    // JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 450, 140, 100, 40);
    // body.add(ds);
    // JTextField ds_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
    // body.add(ds_tf);

    // JLabel bno = Dashboard.addTextFieldLable("Bus Number:", 20, 140, 100, 40);
    // body.add(bno);
    // JTextField bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
    // body.add(bno_tk);

    // JLabel cost = Dashboard.addTextFieldLable("Trip Cost:", 20, 240, 100, 40);
    // body.add(cost);

    // JTextField cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
    // body.add(cost_tk);

    // JLabel n_seats = Dashboard.addTextFieldLable("Number of Seats:", 20, 240 +
    // 80, 150, 40);
    // body.add(n_seats);

    // JTextField n_s_tf = Dashboard.addTextFieldBody(20, 355, 380, 35);
    // body.add(n_s_tf);

    // JButton update = new JButton("Update");

    // update.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // update.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // update.setContentAreaFilled(false);
    // update.setBounds(800, 500, 80, 40);
    // body.add(update);
    // return body;
    // }

    public static String[] getTripsForComboBox() throws Exception {
        final String DB_URL = "jdbc:mysql://localhost/sbc";
        final String USERNAME = "root";
        final String PASSWORD = "";
        String[] result;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            // Getting the connection
            String mysqlUrl = "jdbc:mysql://localhost/sbc";
            Connection con = DriverManager.getConnection(mysqlUrl, "root", "");
            // Creating the Statement object
            Statement stmt = con.createStatement();
            // Query to get the number of rows in a table
            String query = "select count(*) from trips";
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
            // Retrieving the result
            rs.next();
            int count = rs.getInt(1);

            result = new String[count];

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            String sql = "SELECT `pickup_station`, `drop_staion` FROM `trips` WHERE 1";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            int i = 0;
            while (resultSet.next()) {

                result[i] = resultSet.getString(1) + " - ";
                result[i] += resultSet.getString(2);
                i++;

                System.out.println("successfil");
            }

            preparedStatement.close();
            conn.close();
            return result;

        } catch (Exception e) {
            System.out.println("Database connexion failed!");
        }
        return null;
    }

    public void editTrip(Trip t, String pk) throws Exception {
        // String pickup_station = "5454";

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "UPDATE trips SET pickup_station = ? ,drop_staion = ? ,bus_num = ? ,driver_num = ?,cost = ? ,seats_num = ? WHERE pickup_station = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, t.getPickup_station());
            preparedStatement.setString(2, t.getDrop_staion());
            preparedStatement.setInt(3, t.getBus_num());
            preparedStatement.setString(4, t.getDriver_num());
            preparedStatement.setInt(5, t.getCost());
            preparedStatement.setInt(6, t.getSeats_num());
            preparedStatement.setString(7, pk);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }
}
