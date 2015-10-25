package controllers;

import objects.Order;
import objects.Register;
import views.CollectPaymentView;
import views.OrderListView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class OrderListListener extends MyActionListener implements ListSelectionListener {
    HashMap<String,JComponent> components;
    OrderListView view; // view
    Register model;      // model
    WindowManager manager;
    public OrderListListener(){
        components = new HashMap<>();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        System.out.println(actionEvent.paramString());
        switch (actionEvent.getActionCommand()){
            case "New Order":
                manager.activateWindow("orderListView", "customerView");
                break;
            case "Order Lookup":

                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent) {

    }

    /*public void addModel(Register register){
        this.model = register;
    }*/

    public void addView(OrderListView view){
        this.view = view;
    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }

    public void registerComponent(String labelID, JComponent component){
        components.put(labelID, component);
    }
}
