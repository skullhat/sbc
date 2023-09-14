import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

import javax.swing.plaf.basic.BasicComboPopup;
import java.awt.event.*;

public class BookingPanelBar extends JPanel implements ActionListener {
    public static Color bkColor = new Color(20, 20, 20);
    public static Color wColor = new Color(240, 238, 238);
    JPanel choises;
    JButton display;
    JButton book;
    public static JPanel[] list;

    JPanel[] returnList() {
        return list;
    }

    public BookingPanelBar() {

        list = new JPanel[2];
        list[0] = new BookingPanelDisplay();
        list[1] = new BookingPanelAdd();
        /// Dashboard.setVivibleFalse(list);
        list[0].setVisible(true);

        this.setBackground(bkColor);
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBounds(10, 27, 1100 - 20, 50);
        this.add(new JLabel("    "));
        display = new JButton("Display");
        display.setBorder(BorderFactory.createEmptyBorder());
        display.setBackground(bkColor);
        display.setBorderPainted(false);
        display.setForeground(Color.white);

        display.setContentAreaFilled(false);
        display.addActionListener(this);
        this.add(display);
        this.add(new JLabel("    "));
        book = new JButton("Book a Ticket");
        book.setBorder(BorderFactory.createEmptyBorder());
        book.setBackground(bkColor);
        book.setContentAreaFilled(false);
        book.setBorderPainted(false);
        book.setForeground(Color.white);

        book.addActionListener(this);
        this.add(book);
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
    // display.setContentAreaFilled(false);
    // display.addActionListener(this);
    // choises.add(display);
    // choises.add(new JLabel(" "));
    // book = new JButton("Book a Ticket");
    // book.setBorder(BorderFactory.createEmptyBorder());
    // book.setBackground(bkColor);
    // book.setContentAreaFilled(false);
    // book.setBorderPainted(false);
    // book.addActionListener(this);
    // choises.add(book);

    // choises.setVisible(true);
    // return choises;
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == display) {
            Dashboard.setVivibleFalse(list);
            list[0].setVisible(true);
            Dashboard.right_side.add(list[0]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        } else if (e.getSource() == book) {
            Dashboard.setVivibleFalse(list);
            list[1].setVisible(true);
            Dashboard.right_side.add(list[1]);
            Dashboard.x.invalidate();
            Dashboard.x.validate();
            Dashboard.x.repaint();
        }

    }

}
