package controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MainMenuListener extends MyActionListener {
    public MainMenuListener(){
        components = new HashMap<>();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        System.out.println(actionEvent.getActionCommand());
        String authenticationKey;
        switch (actionEvent.getActionCommand()){
            case "Orders":
                authenticationKey = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
                if ((authenticationKey != null) && (authenticationKey.length() > 0) && model.userExists(authenticationKey)) {
                    manager.activateWindow(manager.MAIN_MENU, manager.ORDER_LIST);
                    return;
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
                if ((authenticationKey != null) && (authenticationKey.length() > 0) && model.userExists(authenticationKey)) {
                    manager.activateWindow(manager.MAIN_MENU, manager.MAKE_LINE);
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
                if ((authenticationKey != null) && (authenticationKey.length() > 0) && model.userExists(authenticationKey)) {
                    manager.activateWindow(manager.MAIN_MENU, manager.MANAGE_MAIN);
                }
                break;
        }
    }
}
