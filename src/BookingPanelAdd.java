import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;
import java.util.UUID;

public class BookingPanelAdd extends JPanel {
    JPanel body;
    JLabel add_trip;
    String[] trips;
    String[] v;

    JTextField pk_tf, ds_tf, bno_tk, cost_tk, phone_tf, st_tf;

    BookingPanelAdd() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        add_trip = Dashboard.addTitle("Book a Ticket", 10, 10, 100, 40);
        this.add(add_trip);

        JComboBox tripList = Dashboard.addComboBox(20, 70, 400, 40);
        try {
            trips = TripPanelEdit.getTripsForComboBox();
            tripList.setModel(new DefaultComboBoxModel(trips));
            // v = trips[tripList.getSelectedIndex()].split("-");

        } catch (Exception ex) {
            System.out.println(ex);
        }
        tripList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                //
                // Get the source of the component, which is our combo
                // box.
                //
                JComboBox tripList = (JComboBox) event.getSource();

                v = trips[tripList.getSelectedIndex()].split("-");
                String pk = v[0];

                try {
                    Trip t = bookTickit(pk);
                    pk_tf.setText(t.getPickup_station());
                    ds_tf.setText(t.getDrop_staion());
                    bno_tk.setText(String.valueOf(java.time.LocalDate.now()));
                    cost_tk.setText(String.valueOf(t.getCost()));
                    phone_tf.setText(t.getDriver_num());
                    st_tf.setText(String.valueOf(t.getSeats_num()));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    JOptionPane.showMessageDialog(BookingPanelAdd.this,
                            e.getMessage(),
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                }
                // Object selected = tripList.getSelectedItem();
                // if (selected.toString().equals("item1"))
                // field.setText("30");
                // else if (selected.toString().equals("item2"))
                // field.setText("40");

            }
        });
        this.add(tripList);

        JLabel pk = Dashboard.addTextFieldLable("Pickup Station:", 450, 40, 100, 40);
        this.add(pk);

        pk_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
        // pk_tf.setText("Kalakla");
        pk_tf.setEditable(false);
        this.add(pk_tf);

        JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 450, 140, 100, 40);
        this.add(ds);
        ds_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
        // ds_tf.setText("Al Araby");
        ds_tf.setEditable(false);

        this.add(ds_tf);

        JLabel bno = Dashboard.addTextFieldLable("Book Date:", 20, 140, 100, 40);
        this.add(bno);
        bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
        // bno_tk.setText("7/3/2025");
        bno_tk.setEditable(false);

        this.add(bno_tk);

        JLabel cost = Dashboard.addTextFieldLable("Ticket Cost:", 20, 240, 100, 40);
        this.add(cost);

        cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
        // cost_tk.setText("250$");
        cost_tk.setEditable(false);
        this.add(cost_tk);

        JLabel phone = Dashboard.addTextFieldLable("Phone Number:", 20, 350, 300, 40);

        this.add(phone);

        phone_tf = Dashboard.addTextFieldBody(20, 385, 380, 35);
        phone_tf.setEditable(false);
        this.add(phone_tf);

        JLabel seat = Dashboard.addTextFieldLable("Seat Number:", 20, 450, 300, 40);
        this.add(seat);

        st_tf = Dashboard.addTextFieldBody(20, 485, 380, 35);
        // st_tf.setText("22");
        st_tf.setEditable(false);
        this.add(st_tf);

        JButton book = new JButton("Book");

        book.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        book.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        book.setContentAreaFilled(false);
        book.setBounds(800, 500, 80, 40);
        book.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UUID ud = UUID.randomUUID();
                JOptionPane.showMessageDialog(BookingPanelAdd.this,
                        "Your Ticket Has Been Booked\nIt\'s Number is:\n" + ud,
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        this.add(book);
    }
    // JPanel addBookingPanel() {
    // body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // add_trip = Dashboard.addTitle("Book a Ticket", 10, 10, 100, 40);
    // body.add(add_trip);

    // JComboBox tripList = Dashboard.addComboBox(20, 70, 400, 40);
    // body.add(tripList);

    // JLabel pk = Dashboard.addTextFieldLable("Pickup Station:", 450, 40, 100, 40);
    // body.add(pk);

    // JTextField pk_tf = Dashboard.addTextFieldBody(450, 75, 250, 35);
    // pk_tf.setText("Kalakla");
    // pk_tf.setEditable(false);
    // body.add(pk_tf);

    // JLabel ds = Dashboard.addTextFieldLable("Drop Station:", 450, 140, 100, 40);
    // body.add(ds);
    // JTextField ds_tf = Dashboard.addTextFieldBody(450, 175, 250, 35);
    // ds_tf.setText("Al Araby");
    // ds_tf.setEditable(false);

    // body.add(ds_tf);

    // JLabel bno = Dashboard.addTextFieldLable("Book Date:", 20, 140, 100, 40);
    // body.add(bno);
    // JTextField bno_tk = Dashboard.addTextFieldBody(20, 175, 380, 35);
    // bno_tk.setText("7/3/2025");
    // bno_tk.setEditable(false);

    // body.add(bno_tk);

    // JLabel cost = Dashboard.addTextFieldLable("Ticket Cost:", 20, 240, 100, 40);
    // body.add(cost);

    // JTextField cost_tk = Dashboard.addTextFieldBody(20, 275, 380, 35);
    // cost_tk.setText("250$");
    // cost_tk.setEditable(false);
    // body.add(cost_tk);

    // JLabel phone = Dashboard.addTextFieldLable("Phone Number:", 20, 350, 300,
    // 40);
    // body.add(phone);

    // JTextField phone_tf = Dashboard.addTextFieldBody(20, 385, 380, 35);
    // body.add(phone_tf);

    // JLabel seat = Dashboard.addTextFieldLable("Seat Number:", 20, 450, 300, 40);
    // body.add(seat);

    // JTextField st_tf = Dashboard.addTextFieldBody(20, 485, 380, 35);
    // st_tf.setText("22");
    // st_tf.setEditable(false);
    // body.add(st_tf);

    // JButton book = new JButton("Book");

    // book.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // book.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // book.setContentAreaFilled(false);
    // book.setBounds(800, 500, 80, 40);
    // body.add(book);
    // return body;
    // }

    public Trip bookTickit(String pk) throws Exception {
        // String pickup_station = "5454";

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";
        Trip t = new Trip();
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "SELECT * FROM trips WHERE pickup_station = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, pk);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                t.setPickup_station(rs.getString(2));
                t.setDrop_staion(rs.getString(3));
                t.setBus_num(rs.getInt(4));
                t.setDriver_num(rs.getString(5));
                t.setCost(rs.getInt(6));
                t.setSeats_num(rs.getInt(7));
            }

            System.out.println(t.getDriver_num());

            preparedStatement.close();
            conn.close();
            return t;

        } catch (Exception e) {
            throw e;
        }
    }
}
