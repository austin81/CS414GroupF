package controllers;

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
                manager.activateWindow(manager.MAIN_MENU, manager.ORDER_LIST);
                break;
            case "Make Line View":
                manager.activateWindow(manager.MAIN_MENU, manager.MAKE_LINE);
                break;
            case "Manager Controls":

                break;
        }
    }
}
