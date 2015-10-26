package controllers;

import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class OrderListListener extends MyActionListener implements ListSelectionListener {
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
}
