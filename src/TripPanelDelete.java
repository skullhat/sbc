import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;

public class TripPanelDelete extends JPanel {
    JPanel body;
    JLabel add_bus;
    String[] trips;
    // String[] v;x

    TripPanelDelete() {
        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        JLabel add_bus = Dashboard.addTitle("Delete a Trip", 10, 10, 200, 40);
        this.add(add_bus);

        JLabel busno = Dashboard.addTextFieldLable("Choose a trip:", 20, 40, 100, 40);
        this.add(busno);

        JComboBox tripList = Dashboard.addComboBox(20, 80, 400, 40);
        try {
            trips = TripPanelEdit.getTripsForComboBox();
            tripList.setModel(new DefaultComboBoxModel(trips));

        } catch (Exception ex) {
            System.out.println(ex);
        }
        this.add(tripList);

        JButton delete = new JButton("Delete");

        delete.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        delete.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.setBounds(800, 550, 80, 40);
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Trip t = new Trip();
                String[] v = null;
                try {
                    v = trips[tripList.getSelectedIndex()].split("-");
                    String pk = v[0];
                    deleteTrip(pk);
                    JOptionPane.showMessageDialog(TripPanelDelete.this,
                            "Trip Deleted Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    try {
                        trips = TripPanelEdit.getTripsForComboBox();
                        tripList.setModel(new DefaultComboBoxModel(trips));
                        v = trips[tripList.getSelectedIndex()].split("-");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                    TripPanelBar.plist[0] = new TripPanelDisplay();

                    BookingPanelBar.list[0] = new BookingPanelDisplay();
                    BookingPanelBar.list[1] = new BookingPanelAdd();
                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(TripPanelDelete.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(TripPanelDelete.this,
                            "PLEASE FILL ALL THE FEILDSs FIRST!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });

        this.add(delete);
    }

    // public JPanel deleteTripPanel() {
    // JPanel body = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // JLabel add_bus = Dashboard.addTitle("Delete a Trip", 10, 10, 200, 40);
    // body.add(add_bus);

    // JLabel busno = Dashboard.addTextFieldLable("Choose a trip:", 20, 40, 100,
    // 40);
    // body.add(busno);

    // JComboBox tripList = Dashboard.addComboBox(20, 80, 400, 40);
    // body.add(tripList);

    // JButton delete = new JButton("Delete");

    // delete.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // delete.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // delete.setContentAreaFilled(false);
    // delete.setBounds(800, 550, 80, 40);
    // body.add(delete);
    // return body;
    // }

    public void deleteTrip(String pk) throws Exception {

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "DELETE FROM trips WHERE pickup_station = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, pk);

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }

}
