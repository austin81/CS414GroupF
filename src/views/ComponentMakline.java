package views;

import objects.Pizza;

import javax.swing.*;

/**
 * Created by Tyler on 10/25/15.
 */
public class ComponentMakline extends JLabel implements ListCellRenderer {

    public ComponentMakline(){
        setOpaque(true);

    }


    @Override
    public JButton getListCellRendererComponent(JList jList, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Pizza pizza = (Pizza)value;
        JButton button = new JButton(pizza.makelineToString());
        return button;
    }


}
