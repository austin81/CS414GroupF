package controllers;

import objects.*;
import views.AddOrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerListener extends MyActionListener {
    public CustomerListener(){
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        // add order to register (model)
        // give ID so AddOrderView can access
        switch (actionEvent.getActionCommand()){
            case "Cancel":
                clearEditTextFields();
                manager.activateWindow("customerView", "orderListView");
                break;
            case "Clear":
                clearEditTextFields();
                break;
            case "Save":
                Address address = new Address();
                address.setStreetAddress(((JTextArea) components.get("streetEditText")).getText());
                address.setCity(((JTextArea) components.get("cityEditText")).getText());
                address.setState(((JTextArea) components.get("stateEditText")).getText());
                address.setZipcode(((JTextArea) components.get("zipEditText")).getText());

                Phone phone = new Phone();
                phone.setNumber(((JTextArea) components.get("zipEditText")).getText());

                Person person = new Person(((JTextArea) components.get("nameEditText")).getText(), address, phone);
                Order order = new Order();
                order.setCustomer(person);
                int orderID = model.addOrder(order);
                System.out.println("OrderID: " + orderID);
                manager.passOrderID("orderEditListener", orderID);
                manager.activateWindow("customerView", "addOrderView");
                break;
        }
    }

    public void clearEditTextFields(){

    }
}
