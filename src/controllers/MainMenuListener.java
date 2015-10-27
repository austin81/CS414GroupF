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
        switch (actionEvent.getActionCommand()){
            case "Orders":
                String s = (String)JOptionPane.showInputDialog(
                        view,
                        "Enter Authentication Code",
                        "Login",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);

//If a string was returned, say so.
                if ((s != null) && (s.length() > 0) && model.userExists(s)) {
                    manager.activateWindow(manager.MAIN_MENU, manager.ORDER_LIST);
                    return;
                }

                break;
            case "Make Line View":
                manager.activateWindow(manager.MAIN_MENU, manager.MAKE_LINE);
                break;
            case "Manager Controls":

                break;
        }
    }
}
