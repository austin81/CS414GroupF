package views;

import objects.Pizza;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 9/28/15.
 */
public class ComponentPizza extends JLabel implements ListCellRenderer {
    public ComponentPizza(){
        setOpaque(true);

    }
    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Pizza pizza = (Pizza)value;
        JButton button = new JButton(pizza.toString());
        return button;
    }
}
