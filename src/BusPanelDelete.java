import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;
import java.sql.*;

public class BusPanelDelete extends JPanel {
    JPanel body;
    JLabel add_bus;
    String[] buses;

    BusPanelDelete() {

        this.setBackground(new Color(20, 20, 20));
        this.setLayout(null);
        this.setBounds(10, 90, 1100 - 20, 700 - 97);

        JLabel add_bus = Dashboard.addTitle("Delete a Bus", 10, 10, 200, 40);
        this.add(add_bus);

        JLabel busno = Dashboard.addTextFieldLable("Choose a Bus:", 20, 40, 100, 40);
        this.add(busno);

        JComboBox busesList = Dashboard.addComboBox(20, 80, 400, 40);
        try {
            buses = BusPanelEdit.getTripsForComboBox();
            busesList.setModel(new DefaultComboBoxModel(buses));

        } catch (Exception ex) {
            System.out.println(ex);
        }

        this.add(busesList);

        JButton delete = new JButton("Delete");

        delete.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
        delete.setForeground(Color.WHITE);
        // create.setBorderPainted(false);
        delete.setContentAreaFilled(false);
        delete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String[] v = null;
                try {
                    v = buses[busesList.getSelectedIndex()].split(" ");
                    int pk = new Integer(v[0]).intValue();
                    deleteBus(pk);
                    JOptionPane.showMessageDialog(BusPanelDelete.this,
                            "Bus Deleted Successfuly",
                            "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    BusesPanelBar.plist[2] = new BusPanelEdit();
                    // BusesPanelBar.plist[3] = new BusPanelDelete();
                    // BusesPanelBar.plist[1] = new BusPanelAdd();
                    BusesPanelBar.plist[0] = new BusPanelDisplay();
                    try {
                        buses = BusPanelEdit.getTripsForComboBox();
                        busesList.setModel(new DefaultComboBoxModel(buses));
                        v = buses[busesList.getSelectedIndex()].split(" ");

                    } catch (Exception ex) {
                        System.out.println(ex);
                    }

                } catch (com.mysql.cj.jdbc.exceptions.CommunicationsException ex) {
                    JOptionPane.showMessageDialog(BusPanelDelete.this,
                            "ERROR IN THE DATABASE!",
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);
                    System.out.println(ex);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(BusPanelDelete.this,
                            ex.getMessage(),
                            "Try again",
                            JOptionPane.ERROR_MESSAGE);

                }

            }
        });
        delete.setBounds(800, 550, 80, 40);
        add(delete);
    }

    // public JPanel deleteBusPanel() {
    // JPanel this = new JPanel();
    // body.setBackground(new Color(20, 20, 20));
    // body.setLayout(null);
    // body.setBounds(10, 90, 1100 - 20, 700 - 97);

    // JLabel add_bus = Dashboard.addTitle("Delete a Bus", 10, 10, 200, 40);
    // body.add(add_bus);

    // JLabel busno = Dashboard.addTextFieldLable("Choose a Bus:", 20, 40, 100, 40);
    // body.add(busno);

    // JComboBox busesList = Dashboard.addComboBox(20, 80, 400, 40);
    // body.add(busesList);

    // JButton delete = new JButton("Delete");

    // delete.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.orange));
    // delete.setForeground(Color.WHITE);
    // // create.setBorderPainted(false);
    // delete.setContentAreaFilled(false);
    // delete.setBounds(800, 550, 80, 40);
    // body.add(delete);
    // return body;
    // }
    public void deleteBus(int num) throws Exception {

        final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...
            // sql = "INSERT INTO users (id, first, last, username, password, phone) VALUES
            // ( ?,?, ?, ?, ?, ? )";
            String sql = "DELETE FROM buses WHERE number = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, num);

            preparedStatement.execute();

            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            throw e;
        }
    }
}
