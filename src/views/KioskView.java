package views;

import objects.Order;

import javax.swing.*;
import java.awt.*;

/**
 * Created by berryhillb on 11/22/15.
 */
public class KioskView extends MyJFrame {
    private JPanel orderView;
    private JTextField totalDisplay;
    private JButton collectOrderButton;
    private JButton cancelOrderButton;
    private JButton sidesButton;
    private JButton drinksButton;
    private JButton exitButton;
    private JRadioButton pickUpButton;
    private JRadioButton deliveryButton;
    private JPanel pizzaContainer;
    private JButton addPizzaButton;
    private JButton cancelCurrent;
    private JButton cancelPizzaButton;
    private JList pizzaToppingsList;
    private JList pizzaSizesList;
    private JList pizzaSaucesList;
    private JLabel toppingLabel;
    private JLabel saucesLabel;
    private JLabel sizesLabel;
    private JList pizzaList;
    private Order order;

    public KioskView() {
        orderView.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        order = new Order();
        pizzaList.setCellRenderer(new ComponentPizza());
        pizzaToppingsList.setCellRenderer(new ComponentTopping());
        pizzaToppingsList.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
                    super.addSelectionInterval(index0, index1);
                }
            }
        });
    }
}
