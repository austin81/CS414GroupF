package views;

import objects.Order;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;

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

        pizzaSizesList.setCellRenderer(new ComponentSize());
        pizzaSizesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSizesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pizzaSaucesList.setCellRenderer(new ComponentSauce());;
        pizzaSaucesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSaucesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }

    @Override
    public void update(Observable observable, Object o) {
        System.out.println("AddOrderView: Observer is: " + observable.getClass() + ", object passed is: " + o.getClass());
    }

    public void addComponents(){
        controller.registerComponent("pizzaToppingsList", pizzaToppingsList);
        controller.registerComponent("pizzaSizesList", pizzaSizesList);
        controller.registerComponent("pizzaSaucesList", pizzaSaucesList);
        controller.registerComponent("pizzaList", pizzaList);
        pizzaList.addListSelectionListener(controller);
        controller.registerComponent("totalDisplay", totalDisplay);

        controller.registerComponent("addPizzaButton", addPizzaButton);
        addPizzaButton.addActionListener(controller);
        controller.registerComponent("collectOrderButton", collectOrderButton);
        collectOrderButton.addActionListener(controller);
        controller.registerComponent("cancelCurrent", cancelCurrent);
        cancelCurrent.addActionListener(controller);
        controller.registerComponent("cancelOrderButton", cancelOrderButton);
        cancelOrderButton.addActionListener(controller);
        controller.registerComponent("cancelPizzaButton", cancelPizzaButton);
        cancelPizzaButton.addActionListener(controller);

        pickUpButton.setActionCommand("pickup");
        deliveryButton.setActionCommand("delivery");

        controller.registerComponent("sidesButton", sidesButton);
        controller.registerComponent("drinksButton", drinksButton);
        controller.registerComponent("exitButton", exitButton);
        controller.registerComponent("pickUpButton", pickUpButton);
        controller.registerComponent("deliveryButton",deliveryButton);
        sidesButton.addActionListener(controller);
        drinksButton.addActionListener(controller);
        exitButton.addActionListener(controller);
        pickUpButton.addActionListener(controller);
        deliveryButton.addActionListener(controller);
    }
}
