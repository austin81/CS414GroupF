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
    private JButton backButton;

    public OrderListView(){
        orderViewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderViewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        orderList.setCellRenderer(new ComponentOrder());
        //setOrderList();
        //setVisible(true);
    }

    public void setOrderList(){
        orderList.setListData(model.getOrders().toArray());
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addComponents(){
        controller.registerComponent("orderList", orderList);
        controller.registerComponent("newOrderButton", newOrderButton);
        controller.registerComponent("orderLookupButton", orderLookupButton);
        controller.registerComponent("backButton", backButton);
        orderList.addListSelectionListener(controller);
        newOrderButton.addActionListener(controller);
        orderLookupButton.addActionListener(controller);
        backButton.addActionListener(controller);
    }
}
