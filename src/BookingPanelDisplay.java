import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import java.awt.event.*;
import java.sql.*;

public class BookingPanelDisplay extends JPanel {
        JPanel body;
        JLabel add_trip;
        String[][] rec;

        BookingPanelDisplay() {
                this.setBackground(new Color(20, 20, 20));
                this.setLayout(null);
                this.setBounds(10, 90, 1100 - 20, 700 - 97);

                add_trip = Dashboard.addTitle("Avilable Trips to Book", 10, 10, 180, 40);
                this.add(add_trip);

                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Today Trips",
                                TitledBorder.CENTER, TitledBorder.TOP));
                try {
                        rec = TripPanelDisplay.getDatabaseRows();
                } catch (Exception e) {
                        // TODO Auto-generated catch block
                        JOptionPane.showMessageDialog(BookingPanelDisplay.this,
                                        e.getMessage(),
                                        "Try again",
                                        JOptionPane.ERROR_MESSAGE);
                }
                String[] header = { "ID", "Pickup Station", "Drop Station", "Bus Number", "Driver Phone", "Cost",
                                "Number of Seats" };

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
                cm.getColumn(0).setPreferredWidth(50);
                cm.getColumn(1).setPreferredWidth(150);
                cm.getColumn(2).setPreferredWidth(150);
                cm.getColumn(3).setPreferredWidth(150);
                cm.getColumn(4).setPreferredWidth(150);
                cm.getColumn(5).setPreferredWidth(150);

                panel.add(new JScrollPane(table));
                panel.setBounds(20, 20, 1050, 560);
                table.setIntercellSpacing(new Dimension(0, 0));
                // remove all boders
                JTableHeader hd = table.getTableHeader();
                // hd.setBackground(Color.BLACK);
                hd.setForeground(Color.black);
                hd.setPreferredSize(new Dimension(10, 30));
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

        // JPanel displayBookingPanel() {
        // body = new JPanel();
        // body.setBackground(new Color(20, 20, 20));
        // body.setLayout(null);
        // body.setBounds(10, 90, 1100 - 20, 700 - 97);

        // add_trip = Dashboard.addTitle("Avilable Trips", 10, 10, 100, 40);
        // body.add(add_trip);

        // JPanel panel = new JPanel();
        // panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
        // "Today Trips",
        // TitledBorder.CENTER, TitledBorder.TOP));
        // String[][] rec = {
        // { "1", "Al Araby", "New York", "55", "+1 123 123 133", "1234" },
        // { "2", "Om Durman", "Hong Kong", "25", "+248 888 888 888", "1919" },
        // { "3", "Bahri", "Madina", "14", "+249 925 258 252", "1616" },
        // };
        // String[] header = { "ID", "Pickup Station", "Drop Station", "Bus Number",
        // "Driver Phone",
        // "Driver Card Number" };

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
}
