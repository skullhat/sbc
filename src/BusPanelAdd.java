import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;;

public class BusPanelAdd extends JPanel {
    JPanel body;
    JLabel add_bus;

    BusPanelAdd() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        JLabel add_bus = Dashboard.addTitle("Add a Bus", 10, 10, 100, 40);
        this.add(add_bus);

        JLabel busno = Dashboard.addTextFieldLable("Bus Number:", 20, 40, 100, 40);
        this.add(busno);

        JTextField busno_tf = Dashboard.addTextFieldBody(20, 75, 250, 35);
        this.add(busno_tf);

        JLabel bus_color = Dashboard.addTextFieldLable("Bus Color:", 400, 40, 100, 40);
        this.add(bus_color);

        JTextField buscolor_tf = Dashboard.addTextFieldBody(400, 75, 250, 35);
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

        JButton create = new JButton("Create");

        create.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        create.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        create.setContentAreaFilled(false);
        create.setBounds(800, 550, 80, 40);
        create.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    int name = Integer.parseInt(busno_tf.getText());
                    String color = buscolor_tf.getText();
                    int seats_number = new Integer(busseats_tf.getText()).intValue();
                    String driver_name = drivername_tField.getText();
                    String driver_phone = driphone_tf.getText();
                    String driver_card_num = drivercard_tf.getText();
                    int isAvailable = 1;// 1 -> true , 0 -> false

                    Bus t = new Bus();
                    t.setNumber(name);
                    t.setColor(color);
                    t.setSeats_number(seats_number);
                    t.setDriver_name(driver_name);
                    t.setDriver_phone(driver_phone);
                    t.setDriver_card_num(driver_card_num);
                    t.setIsAvailable(isAvailable);

                    addBus(t);
                    JOptionPane.showMessageDialog(BusPanelAdd.this,
                            "Bus Added Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    busno_tf.setText("");
                    buscolor_tf.setText("");
                    busseats_tf.setText("");
                    drivername_tField.setText("");
                    driphone_tf.setText("");
                    drivercard_tf.setText("");
                    BusesPanelBar.plist[2] = new BusPanelEdit();
                    BusesPanelBar.plist[3] = new BusPanelDelete();
                    // BusesPanelBar.plist[1] = new BusPanelAdd();
                    BusesPanelBar.plist[0] = new BusPanelDisplay();
                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(BusPanelAdd.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(BusPanelAdd.this,
                            ex.getMessage(),
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        this.add(create);
    }

    // public JPanel addBusPanel() {
    // body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // JLabel add_bus = Dashboard.addTitle("Add a Bus", 10, 10, 100, 40);
    // body.add(add_bus);

    // JLabel busno = Dashboard.addTextFieldLable("Bus Number:", 20, 40, 100, 40);
    // body.add(busno);

    // JTextField busno_tf = Dashboard.addTextFieldBody(20, 75, 250, 35);
    // body.add(busno_tf);

    // JLabel bus_color = Dashboard.addTextFieldLable("Bus Color:", 400, 40, 100,
    // 40);
    // body.add(bus_color);

    // JTextField buscolor_tf = Dashboard.addTextFieldBody(400, 75, 250, 35);
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

    // JButton create = new JButton("Create");

    // create.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // create.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // create.setContentAreaFilled(false);
    // create.setBounds(800, 550, 80, 40);
    // body.add(create);
    // return body;
    // }

    private void addBus(Bus b) throws Exception {

        final String DB_URL = "jdbc:mysql://localhost/sbc";
        final String USERNAME = "root";
        final String PASSWORD = "";

        // t = new Trip();

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            // String sql = "INSERT INTO trips (pickup_station, drop_staion, bus_num,
            // driver_num, cost, seats_num) VALUES (?, ?, ?, ?, ?, ?);";
            String sql = "INSERT INTO buses (number, color, seats_number, driver_name, driver_phone, driver_card_num, isAvailable) VALUES (?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            // preparedStatement.setInt(1,.id);
            preparedStatement.setInt(1, b.getNumber());
            preparedStatement.setString(2, b.getColor());
            preparedStatement.setInt(3, b.getSeats_number());
            preparedStatement.setString(4, b.getDriver_name());
            preparedStatement.setString(5, b.getDriver_phone());
            preparedStatement.setString(6, b.getDriver_card_num());
            preparedStatement.setInt(7, b.getIsAvailable());

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }

    }
}
