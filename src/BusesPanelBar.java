import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;

public class BusesPanelBar extends JPanel implements ActionListener {
    public static Color bkColor = new Color(20, 20, 20);
    public static Color wColor = new Color(240, 238, 238);
    JPanel choises;
    JButton display;
    JButton addbus;
    JButton delete;
    JButton edit;
    public static JPanel[] plist;

    public BusesPanelBar() {
        plist = new JPanel[4];
        plist[0] = new BusPanelDisplay();
        plist[1] = new BusPanelAdd();
        plist[2] = new BusPanelEdit();
        plist[3] = new BusPanelDelete();
        plist[0].setVisible(true);

        this.setBackground(bkColor);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBounds(10, 27, 1100 - 20, 50);
        this.add(new JLabel("    "));
        display = new JButton("Display");
        display.setBorder(BorderFactory.createEmptyBorder());
        display.setBackground(bkColor);
        display.setForeground(Color.white);

        display.setBorderPainted(false);
        display.addActionListener(this);
        display.setContentAreaFilled(false);
        this.add(display);
        this.add(new JLabel("    "));
        addbus = new JButton("Add");
        addbus.setBorder(BorderFactory.createEmptyBorder());
        addbus.setBackground(bkColor);
        addbus.setForeground(Color.white);

        addbus.setContentAreaFilled(false);
        addbus.setBorderPainted(false);
        addbus.addActionListener(this);
        this.add(addbus);
        this.add(new JLabel("    "));
        edit = new JButton("Edit");
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setBackground(bkColor);
        edit.setForeground(Color.white);

        edit.setContentAreaFilled(false);
        edit.setBorderPainted(false);
        edit.addActionListener(this);
        this.add(edit);
        this.add(new JLabel("    "));

        delete = new JButton("Delete");
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setContentAreaFilled(false);
        delete.setForeground(Color.white);
        delete.setBackground(new Color(20, 20, 20));
        delete.setBorderPainted(false);
        delete.addActionListener(this);
        this.add(delete);
        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white));

        this.setVisible(true);
    }

    // public JPanel printX() {

    // choises = new JPanel();
    // choises.setBackground(bkColor);
    // choises.setLayout(new BoxLayout(choises, BoxLayout.X_AXIS));
    // choises.setBounds(10, 27, 1100 - 20, 50);
    // choises.add(new JLabel(" "));
    // display = new JButton("Display");
    // display.setBorder(BorderFactory.createEmptyBorder());
    // display.setBackground(bkColor);
    // display.setBorderPainted(false);
    // display.addActionListener(this);
    // display.setContentAreaFilled(false);
    // choises.add(display);
    // choises.add(new JLabel(" "));
    // addbus = new JButton("Add");
    // addbus.setBorder(BorderFactory.createEmptyBorder());
    // addbus.setBackground(bkColor);
    // addbus.setContentAreaFilled(false);
    // addbus.setBorderPainted(false);
    // addbus.addActionListener(this);
    // choises.add(addbus);
    // choises.add(new JLabel(" "));
    // edit = new JButton("Edit");
    // edit.setBorder(BorderFactory.createEmptyBorder());
    // edit.setBackground(bkColor);
    // edit.setContentAreaFilled(false);
    // edit.setBorderPainted(false);
    // edit.addActionListener(this);
    // choises.add(edit);
    // choises.add(new JLabel(" "));

    // delete = new JButton("Delete");
    // delete.setBorder(BorderFactory.createEmptyBorder());
    // delete.setContentAreaFilled(false);
    // delete.setBackground(new Color(20, 20, 20));
    // delete.setBorderPainted(false);
    // delete.addActionListener(this);
    // choises.add(delete);
    // choises.setVisible(true);
    // return choises;
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {

            Dashboard.setVivibleFalse(plist);
            plist[0].setVisible(true);
            Dashboard.right_side.add(plist[0]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        } else if (e.getSource() == addbus) {

            Dashboard.setVivibleFalse(plist);
            plist[1].setVisible(true);
            Dashboard.right_side.add(plist[1]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        } else if (e.getSource() == edit) {

            Dashboard.setVivibleFalse(plist);
            plist[2].setVisible(true);
            // TripPanelEdit a = new TripPanelEdit();
            Dashboard.right_side.add(plist[2]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        } else if (e.getSource() == delete) {

            Dashboard.setVivibleFalse(plist);
            plist[3].setVisible(true);
            // TripPanelDelete a = new TripPanelDelete();
            Dashboard.right_side.add(plist[3]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        }

    }

}
