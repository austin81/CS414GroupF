package controllers;

import objects.Order;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class OrderListListener extends MyActionListener implements ListSelectionListener {
    public OrderListListener(){
        components = new HashMap<>();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        System.out.println(actionEvent.paramString());
        switch (actionEvent.getActionCommand()){
            case "New Order":
                manager.passOrderID(manager.CUSTOMER, -1);
                manager.activateWindow(manager.ORDER_LIST, manager.CUSTOMER);
                break;
            case "Order Lookup":

                break;
            case "Back":
                manager.activateWindow(manager.ORDER_LIST, manager.MAIN_MENU);
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {
        JList list = ((JList)components.get("orderList"));
        String orderString = list.getSelectedValue().toString();

        Order order = null;
        for(Order o : model.getOrders()){
            if(orderString.equals(o.toString())){
                order = o;
                System.out.println("ValueChanged, OrderListListener: " + order.toString());
            }
        }
        if(order != null){
            manager.passOrderID(manager.CUSTOMER, order.getOrderID());
            manager.activateWindow(manager.ORDER_LIST, manager.CUSTOMER);
        }
    }
}
