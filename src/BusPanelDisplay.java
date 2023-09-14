import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import java.sql.*;

import java.awt.event.*;

public class BusPanelDisplay extends JPanel {
        JPanel body;
        JLabel add_trip;
        String[][] rec;

        BusPanelDisplay() {

                this.setBackground(new Color(20, 20, 20));
                this.setLayout(null);
                this.setBounds(10, 90, 1100 - 20, 700 - 97);

                add_trip = Dashboard.addTitle("Avilable Buses", 10, 10, 150, 40);
                this.add(add_trip);

                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Buses State:",
                                TitledBorder.CENTER, TitledBorder.TOP));
                try {
                        rec = getDatabaseRows();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(BusPanelDisplay.this,
                                        e.getMessage(),
                                        "Try again",
                                        JOptionPane.ERROR_MESSAGE);
                }
                String[] header = { "Bus Number", "Color", "Seats Number", "Driver Name", "Driver Phone",
                                "Driver Card Number", "Avilable" };

                JTable table = new JTable(rec, header);
                table.setForeground(Color.white);
                table.setBackground(new Color(45, 45, 45));
                table.getTableHeader().setOpaque(false);
                table.getTableHeader().setBackground(Color.white);
                table.setRowHeight(25);
                // table.setShowGrid(false);
                table.setShowHorizontalLines(false);
                table.setShowVerticalLines(false);
                TableColumnModel cm = table.getColumnModel();
                cm.getColumn(0).setPreferredWidth(100);
                cm.getColumn(1).setPreferredWidth(150);
                cm.getColumn(2).setPreferredWidth(150);
                cm.getColumn(3).setPreferredWidth(150);
                cm.getColumn(4).setPreferredWidth(150);
                cm.getColumn(5).setPreferredWidth(150);
                cm.getColumn(6).setPreferredWidth(150);

                panel.add(new JScrollPane(table));
                panel.setBounds(20, 20, 1050, 560);
                table.setIntercellSpacing(new Dimension(0, 0));
                // remove all boders
                JTableHeader hd = table.getTableHeader();
                // hd.setBackground(Color.BLACK);
                hd.setForeground(Color.black);
                hd.setPreferredSize(new Dimension(7, 30));
                hd.setBorder(new LineBorder(new Color(21, 25, 28), 2));
                final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
                renderer.setBorder(null);
                hd.setDefaultRenderer(renderer);

                table.setShowGrid(false);
                // fit to the contents
                table.setPreferredScrollableViewportSize(table.getPreferredSize());
                table.setFillsViewportHeight(true);
                panel.setBackground(new Color(20, 20, 20));
                this.add(panel);

        }
        // JPanel displayBusPanel() {
        // body = new JPanel();
        // body.setBackground(new Color(20, 20, 20));
        // body.setLayout(null);
        // body.setBounds(10, 90, 1100 - 20, 700 - 97);

        // add_trip = Dashboard.addTitle("Avilable Buses", 10, 10, 150, 40);
        // body.add(add_trip);

        // JPanel panel = new JPanel();
        // panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
        // "Buses State:",
        // TitledBorder.CENTER, TitledBorder.TOP));
        // String[][] rec = {
        // { "1", "Al Araby", "New York", "55", "+1 123 123 133", "1234", "true" },
        // { "2", "Om Durman", "Hong Kong", "25", "+248 888 888 888", "1919", "true" },
        // { "3", "Bahri", "Madina", "14", "+249 925 258 252", "1616", "false" },
        // };
        // String[] header = { "Number", "Name", "Color", "Seats Number", "Driver
        // Phone",
        // "Driver Card Number", "Avilable" };

        // JTable table = new JTable(rec, header);
        // table.setForeground(Color.white);
        // table.setBackground(new Color(45, 45, 45));
        // table.getTableHeader().setOpaque(false);
        // table.getTableHeader().setBackground(Color.white);
        // table.setRowHeight(25);
        // // table.setShowGrid(false);
        // table.setShowHorizontalLines(false);
        // table.setShowVerticalLines(false);
        // TableColumnModel cm = table.getColumnModel();
        // cm.getColumn(0).setPreferredWidth(50);
        // cm.getColumn(1).setPreferredWidth(150);
        // cm.getColumn(2).setPreferredWidth(150);
        // cm.getColumn(3).setPreferredWidth(150);
        // cm.getColumn(4).setPreferredWidth(150);
        // cm.getColumn(5).setPreferredWidth(150);

        // panel.add(new JScrollPane(table));
        // panel.setBounds(20, 20, 1050, 560);
        // table.setIntercellSpacing(new Dimension(0, 0));
        // // remove all boders
        // JTableHeader hd = table.getTableHeader();
        // // hd.setBackground(Color.BLACK);
        // hd.setForeground(Color.black);
        // hd.setPreferredSize(new Dimension(10, 30));
        // hd.setBorder(new LineBorder(new Color(21, 25, 28), 2));
        // final DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        // renderer.setBorder(null);
        // hd.setDefaultRenderer(renderer);

        // table.setShowGrid(false);
        // // fit to the contents
        // table.setPreferredScrollableViewportSize(table.getPreferredSize());
        // table.setFillsViewportHeight(true);
        // panel.setBackground(new Color(20, 20, 20));
        // body.add(panel);
        // return body;
        // }
        public String[][] getDatabaseRows() throws Exception {
                String[][] result = null;

                final String DB_URL = "jdbc:mysql://localhost/sbc?serverTimezone=UTC";
                final String USERNAME = "root";
                final String PASSWORD = "";

                try {
                        Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);// Creating the
                                                                                                  // Statement object
                        // Query to get the number of rows in a table
                        PreparedStatement stmt = conn.prepareStatement("Select * from buses where 1",
                                        ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                        ResultSet rs = stmt.executeQuery();
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int numberOfColumns = rsmd.getColumnCount();
                        // ArrayList l = new ArrayList();
                        rs.first();
                        int rowcount = 0;
                        do {
                                rowcount++;
                        } while (rs.next());
                        rs.first();
                        int rowindex = 0;
                        String array2D[][] = new String[rowcount][];
                        do {
                                array2D[rowindex] = new String[numberOfColumns];
                                for (int i = 0; i < numberOfColumns; i++) {
                                        array2D[rowindex][i] = rs.getString(i + 1);
                                }
                                // prints each row on separate line
                                rowindex++;
                        } while (rs.next());
                        return array2D;
                } catch (Exception e) {
                        throw e;
                }
        }
}
