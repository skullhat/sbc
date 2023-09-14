import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;

public class BusPanelEdit extends JPanel {
    JPanel body;
    JLabel add_bus;
    String[] buses;

    BusPanelEdit() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        JLabel add_bus = Dashboard.addTitle("Edit a Bus Information", 10, 10, 200, 40);
        this.add(add_bus);

        JComboBox busesList = Dashboard.addComboBox(20, 70, 400, 40);
        try {
            buses = getTripsForComboBox();
            busesList.setModel(new DefaultComboBoxModel(buses));

        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.add(busesList);

        JLabel busno = Dashboard.addTextFieldLable("Bus Number:", 450, 40, 100, 40);
        this.add(busno);

        JTextField busno_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
        this.add(busno_tf);

        JLabel bus_color = Dashboard.addTextFieldLable("Bus Color:", 450, 140, 100, 40);
        this.add(bus_color);

        JTextField buscolor_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
        this.add(buscolor_tf);

        JLabel bus_seats = Dashboard.addTextFieldLable("Bus Seats:", 20, 140, 100, 40);
        this.add(bus_seats);

        JTextField busseats_tf = Dashboard.addTextFieldBody(20, 175, 380, 35);
        this.add(busseats_tf);

        JLabel driver_name = Dashboard.addTextFieldLable("Driver Name:", 20, 240, 100, 40);
        this.add(driver_name);

        JTextField drivername_tField = Dashboard.addTextFieldBody(20, 275, 380, 35);
        this.add(drivername_tField);

        JLabel dri_phone = Dashboard.addTextFieldLable("Driver Phone Number:", 20, 350, 300, 40);
        this.add(dri_phone);

        JTextField driphone_tf = Dashboard.addTextFieldBody(20, 385, 380, 35);
        this.add(driphone_tf);

        JLabel dri_card = Dashboard.addTextFieldLable("Driver Card Number:", 20, 450, 300, 40);
        this.add(dri_card);

        JTextField drivercard_tf = Dashboard.addTextFieldBody(20, 485, 380, 35);
        this.add(drivercard_tf);

        JButton update = new JButton("Update");

        update.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        update.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        update.setContentAreaFilled(false);
        update.setBounds(800, 550, 80, 40);

        update.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Bus b = new Bus();
                String[] v = null;
                try {

                    int name = new Integer(busno_tf.getText()).intValue();
                    String color = buscolor_tf.getText();
                    int seats_number = new Integer(busseats_tf.getText()).intValue();
                    String driver_name = drivername_tField.getText();
                    String driver_phone = driphone_tf.getText();
                    String driver_card_num = drivercard_tf.getText();
                    int isAvailable = 1;// 1 -> true , 0 -> false

                    b.setNumber(name);
                    b.setColor(color);
                    b.setSeats_number(seats_number);
                    b.setDriver_name(driver_name);
                    b.setDriver_phone(driver_phone);
                    b.setDriver_card_num(driver_card_num);
                    b.setIsAvailable(isAvailable);

                    v = buses[busesList.getSelectedIndex()].split(" ");
                    int pk = new Integer(v[0]).intValue();
                    System.out.println(pk);

                    editBus(b, pk);
                    JOptionPane.showMessageDialog(BusPanelEdit.this,
                            "Trip Editid Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    try {
                        buses = getTripsForComboBox();
                        busesList.setModel(new DefaultComboBoxModel(buses));
                        v = buses[busesList.getSelectedIndex()].split(" ");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                    busno_tf.setText("");
                    buscolor_tf.setText("");
                    busseats_tf.setText("");
                    drivername_tField.setText("");
                    driphone_tf.setText("");
                    drivercard_tf.setText("");
                    // BusesPanelBar.plist[2] = new BusPanelEdit();
                    BusesPanelBar.plist[3] = new BusPanelDelete();
                    // BusesPanelBar.plist[1] = new BusPanelAdd();
                    BusesPanelBar.plist[0] = new BusPanelDisplay();

                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(BusPanelEdit.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(BusPanelEdit.this,
                            ex.getMessage(),
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                }

            }
        });

        this.add(update);
    }

    // public JPanel editBusPanel() {
    // body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // JLabel add_bus = Dashboard.addTitle("Edit a Bus Information", 10, 10, 200,
    // 40);
    // body.add(add_bus);

    // JComboBox busesList = Dashboard.addComboBox(20, 70, 400, 40);
    // body.add(busesList);

    // JLabel busno = Dashboard.addTextFieldLable("Bus Number:", 450, 40, 100, 40);
    // body.add(busno);

    // JTextField busno_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
    // body.add(busno_tf);

    // JLabel bus_color = Dashboard.addTextFieldLable("Bus Color:", 450, 140, 100,
    // 40);
    // body.add(bus_color);

    // JTextField buscolor_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
    // body.add(buscolor_tf);

    // JLabel bus_seats = Dashboard.addTextFieldLable("Bus Seats:", 20, 140, 100,
    // 40);
    // body.add(bus_seats);

    // JTextField busseats_tf = Dashboard.addTextFieldBody(20, 175, 380, 35);
    // body.add(busseats_tf);

    // JLabel driver_name = Dashboard.addTextFieldLable("Driver Name:", 20, 240,
    // 100, 40);
    // body.add(driver_name);

    // JTextField drivername_tField = Dashboard.addTextFieldBody(20, 275, 380, 35);
    // body.add(drivername_tField);

    // JLabel dri_phone = Dashboard.addTextFieldLable("Driver Phone Number:", 20,
    // 350, 300, 40);
    // body.add(dri_phone);

    // JTextField driphone_tf = Dashboard.addTextFieldBody(20, 385, 380, 35);
    // body.add(driphone_tf);

    // JLabel dri_card = Dashboard.addTextFieldLable("Driver Card Number:", 20, 450,
    // 300, 40);
    // body.add(dri_card);

    // JTextField drivercard_tf = Dashboard.addTextFieldBody(20, 485, 380, 35);
    // body.add(drivercard_tf);

    // JButton update = new JButton("Update");

    // update.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // update.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // update.setContentAreaFilled(false);
    // update.setBounds(800, 550, 80, 40);
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
            String query = "select count(*) from buses";
            // Executing the query
            ResultSet rs = stmt.executeQuery(query);
            // Retrieving the result
            rs.next();
            int count = rs.getInt(1);

            result = new String[count];

            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            String sql = "SELECT `number`, `color` FROM `buses` WHERE 1";
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

    public void editBus(Bus b, int num) throws Exception {
        // String pickup_station = "5454";

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "UPDATE buses SET number = ?,color = ?,seats_number = ?,driver_name = ?,driver_phone = ?,driver_card_num =?,isAvailable = ? WHERE number = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, Integer.valueOf(b.getNumber()));
            preparedStatement.setString(2, b.getColor());
            preparedStatement.setInt(3, Integer.valueOf(b.getSeats_number()));
            preparedStatement.setString(4, b.getDriver_name());
            preparedStatement.setString(5, b.getDriver_phone());
            preparedStatement.setString(6, b.getDriver_card_num());
            preparedStatement.setInt(7, Integer.valueOf(b.getIsAvailable()));
            preparedStatement.setInt(8, num);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }
}
