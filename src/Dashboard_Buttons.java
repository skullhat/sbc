import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;

public class Dashboard_Buttons extends JComponent {

    Dashboard_Buttons() {
        setLayout(new MigLayout("fillx, wrap, inset 0, top", "fill", ""));
    }
}

class MenuItems extends Button {
}
