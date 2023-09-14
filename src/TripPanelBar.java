import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;

public class TripPanelBar extends JPanel implements ActionListener {
    public static Color bkColor = new Color(20, 20, 20);
    public static Color wColor = new Color(240, 238, 238);
    JPanel choises;
    JButton display;
    JButton add;
    JButton delete;
    JButton edit;
    public static JPanel[] plist;

    public TripPanelBar() {
        plist = new JPanel[4];
        plist[0] = new TripPanelDisplay();
        plist[1] = new TripPanelAdd();
        plist[2] = new TripPanelEdit();
        plist[3] = new TripPanelDelete();
        // Dashboard.setVivibleFalse(plist);

        this.setBackground(bkColor);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBounds(10, 27, 1100 - 20, 50);
        this.add(new JLabel("    "));
        display = new JButton("Display");
        display.setBorder(BorderFactory.createEmptyBorder());
        display.setBackground(bkColor);
        display.setBorderPainted(false);
        display.addActionListener(this);
        display.setContentAreaFilled(false);
        display.setForeground(Color.white);
        this.add(display);
        this.add(new JLabel("    "));
        add = new JButton("Add");
        add.setBorder(BorderFactory.createEmptyBorder());
        add.setBackground(bkColor);
        add.setContentAreaFilled(false);
        add.setBorderPainted(false);
        add.addActionListener(this);
        add.setForeground(Color.white);
        this.add(add);
        this.add(new JLabel("    "));
        edit = new JButton("Edit");
        edit.setBorder(BorderFactory.createEmptyBorder());
        edit.setBackground(bkColor);
        edit.setContentAreaFilled(false);
        edit.setBorderPainted(false);
        edit.addActionListener(this);
        edit.setForeground(Color.white);
        this.add(edit);
        this.add(new JLabel("    "));

        delete = new JButton("Delete");
        delete.setBorder(BorderFactory.createEmptyBorder());
        delete.setContentAreaFilled(false);
        delete.setBackground(new Color(20, 20, 20));
        delete.setBorderPainted(false);
        delete.addActionListener(this);
        delete.setForeground(Color.white);
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
    // add = new JButton("Add");
    // add.setBorder(BorderFactory.createEmptyBorder());
    // add.setBackground(bkColor);
    // add.setContentAreaFilled(false);
    // add.setBorderPainted(false);
    // add.addActionListener(this);
    // choises.add(add);
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
            // TripPanelDisplay a = new TripPanelDisplay();
            Dashboard.setVivibleFalse(plist);
            plist[0].setVisible(true);
            Dashboard.right_side.add(plist[0]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        } else if (e.getSource() == add) {
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
