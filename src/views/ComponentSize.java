package views;

import objects.PizzaSize;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentSize extends JLabel implements ListCellRenderer {
    public ComponentSize(){
        setOpaque(true);

    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        PizzaSize size = (PizzaSize)value;
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(60, 60));
        button.setText(size.toString());
        return button;
    }
}
