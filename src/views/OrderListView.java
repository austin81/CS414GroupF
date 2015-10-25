package views;

import controllers.CollectPaymentListener;
import controllers.OrderListListener;
import controllers.WindowManager;
import objects.Order;
import objects.Register;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/24/15.
 */
public class OrderListView extends MyJFrame {
    private JPanel orderViewContainer;
    private JList orderList;
    private JButton newOrderButton;
    private JButton orderLookupButton;
    private OrderListListener controller;
    private WindowManager manager;

    public OrderListView(){
        orderViewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderViewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addController(OrderListListener controller){
        this.controller = controller;
        controller.addView(this);
    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }

    public void addComponents(){
        controller.registerComponent("orderList", orderList);
        controller.registerComponent("newOrderButton", newOrderButton);
        controller.registerComponent("orderLookupButton", orderLookupButton);
        orderList.addListSelectionListener(controller);
        newOrderButton.addActionListener(controller);
        orderLookupButton.addActionListener(controller);
    }
}
