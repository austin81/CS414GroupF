package views;

import objects.Pizza;
import objects.Sauce;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentSauce extends JLabel implements ListCellRenderer {
    public ComponentSauce(){
        setOpaque(true);

    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Sauce sauce = (Sauce)value;
        JButton button = new JButton(sauce.toString());
        button.setPreferredSize(new Dimension(60, 60));
        button.setText(sauce.toString());
        return button;
    }
}
