package controllers;

import objects.Register;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MyActionListener implements ActionListener {
    public int orderID;
    public Register model;
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }

    public void setOrderID(int orderID){
        this.orderID = orderID;
    }

    public void addModel(Register model){
        this.model = model;
    }

    public int getOrderID(){
        return orderID;
    }
}
