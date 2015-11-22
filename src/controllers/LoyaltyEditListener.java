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

    public void resetView(){
        ((JTextArea)components.get("redeemedAtEditText")).setText("");
        ((JTextArea)components.get("priceEditText")).setText("");
        ((JList)components.get("certificateList")).setListData(model.getLoyaltyProgram().getProgramArrayList().toArray());
        components.get("sizeComboBox").setEnabled(true);
        components.get("toppingsComboBox").setEnabled(true);
    }
}
