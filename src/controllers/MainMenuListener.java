package controllers;

import objects.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MainMenuListener extends MyActionListener {
    Order order;
    public MainMenuListener(){
        components = new HashMap<>();
        orderID = -1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        System.out.println(actionEvent.getActionCommand());
        String authenticationKey;
        Employee e;
        switch (actionEvent.getActionCommand()){
            case "Customer":


                manager.passOrderID(manager.CUSTOMER, -1);
                manager.activateWindow(manager.MAIN_MENU, manager.Kiosk);

                Address address = new Address();
                address.setStreetAddress("efqwf");
                address.setCity("fkjhdskaljf");
                address.setState("dhkfjhadsk");
                address.setZipcode("kdfhdjkhfjkd");

                Phone phone = new Phone();
                phone.setNumber("23323");

                Person person = new Person("name", address, phone);
                if(order == null){
                    order = new Order();
                    order.setCustomer(person);
                    orderID = model.addOrder(order);
                }

                System.out.println("OrderID: " + orderID);
                manager.passOrderID(manager.Kiosk, orderID);
                orderID = -1;
                order = null;
                break;
            case "Orders":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.CASHIER || e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.ORDER_LIST);
                        return;
                    }
                }
                break;

            case "Make Line View":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.CHEF || e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.MAKE_LINE);
                        return;
                    }
                }
                break;

            case "Manager Controls":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                e = model.getEmployeeByAuth(authenticationKey);
                if (e != null) {
                    if (e.getRole() == ROLE.MANAGER) {
                        model.setLoggedInEmployee(e);
                        manager.activateWindow(manager.MAIN_MENU, manager.MANAGE_MAIN);
                        return;
                    }
                }
                break;

            default: break;
        }
    }
}
