package views;

import controllers.WindowManager;
import objects.*;
import controllers.OrderEditListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 9/28/15.
 */
public class AddOrderView extends JFrame implements Observer{
    private JList pizzaList;
    private JPanel orderView;
    private JList pizzaToppingsList;
    private JList pizzaSizesList;
    private JList pizzaSaucesList;
    private JButton collectOrderButton;
    private JButton sendToMakelineButton;
    private JButton addPizzaButton;
    private JButton cancelCurrent;
    private JTextField totalDisplay;
    private JButton cancelOrderButton;
    private JButton cancelPizzaButton;
    private Order order;
    private Register model;
    private OrderEditListener controller;
    private WindowManager manager;

    public AddOrderView(){
        orderView.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        order = new Order();
        totalDisplay.setText(model.TOTAL_TEXT + order.getOrderTotal());
        pizzaList.setListData(order.getPizzas().toArray());
        pizzaList.setCellRenderer(new ComponentPizza());

        pizzaToppingsList.setListData(model.getCatalog().getToppings().toArray());
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

        pizzaSizesList.setListData(model.getCatalog().getSizes().toArray());
        pizzaSizesList.setCellRenderer(new ComponentSize());
        pizzaSizesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSizesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pizzaSaucesList.setListData(model.getCatalog().getSauces().toArray());
        pizzaSaucesList.setCellRenderer(new ComponentSauce());
    }

    public void addModel(Register model){
        this.model = model;
    }

    public void addController(OrderEditListener controller){
        this.controller = controller;
    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
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
        controller.registerComponent("sendToMakelineButton", sendToMakelineButton);
        sendToMakelineButton.addActionListener(controller);
        controller.registerComponent("cancelPizzaButton", cancelPizzaButton);
        cancelPizzaButton.addActionListener(controller);
    }
}
