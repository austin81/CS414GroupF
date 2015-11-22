package controllers;

import objects.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by clark on 11/21/15.
 */
public class LoyaltyEditListener extends MyActionListener {

    Pizza item;

    public LoyaltyEditListener(){
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        switch (command) {
            case "comboBoxChanged":

                break;
            case "Back":
                manager.activateWindow(manager.MENU_EDIT, manager.MANAGE_MAIN);
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        if(list.getSelectedValue() != null){
            String buttonText = list.getSelectedValue().toString();
            Integer key = Integer.parseInt(buttonText);
            item = model.getLoyaltyProgram().getProgram().get(key);
            item.calculatePrice();
            String price = "" + item.getPrice();
            ((JTextArea)components.get("redeemedAtEditText")).setText(key.toString());
            ((JTextArea)components.get("priceEditText")).setText(price);
            ((JComboBox)components.get("sizeComboBox")).setSelectedItem(item.getSize());
            ((JComboBox)components.get("toppingsComboBox")).setSelectedItem(item.getToppingList().size());
        }
    }

    public void resetView(){
        ((JTextArea)components.get("redeemedAtEditText")).setText("");
        ((JTextArea)components.get("priceEditText")).setText("");
        ((JList)components.get("certificateList")).setListData(model.getLoyaltyProgram().getProgramArrayList().toArray());
        ((JComboBox)components.get("sizeComboBox")).setSelectedIndex(0);
        ((JComboBox)components.get("toppingsComboBox")).setSelectedIndex(0);
        components.get("sizeComboBox").setEnabled(true);
        components.get("toppingsComboBox").setEnabled(true);
    }
}
