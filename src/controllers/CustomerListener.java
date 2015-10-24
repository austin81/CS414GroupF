package controllers;

import objects.Order;
import objects.Register;
import views.AddOrderView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerListener implements ActionListener {
    HashMap<String,JComponent> components;
    AddOrderView view; // view
    Register model;      // model
    Order order;


    public CustomerListener(){
        components = new HashMap<>();
    }

    public void addModel(Register register){
        this.model = register;
    }

    public void addView(AddOrderView view){
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        // add order to register (model)
        // give ID so AddOrderView can access
    }



    public void registerComponent(String labelID, JComponent component){
        components.put(labelID, component);
    }


}
