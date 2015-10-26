package controllers;

import objects.Order;
import objects.Pizza;
import objects.Register;
import views.AddOrderView;
import views.CollectPaymentView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CollectPaymentListener extends MyActionListener {
    Order order;

    private static final String CASH_BUTTON = "Cash";
    private static final String CARD_BUTTON = "Card";

    public CollectPaymentListener(){
        components = new HashMap<>();
        order = new Order();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(actionEvent.getActionCommand());
        System.out.println(actionEvent.paramString());
        switch (actionEvent.getActionCommand()){
            case CASH_BUTTON:
                (components.get("cashOptContainer")).setVisible(true);
                ((JButton)components.get("exactChangeButton")).setText("$" + Double.toString(order.testingGetOrderTotal()));
                ((JButton)components.get("roundUpOneButton")).setText("$" + Integer.toString((int)order.testingGetOrderTotal() + 1) + ".00");
                // 5*(Math.ceil(Math.abs(number/5)));
                ((JButton)components.get("roundUpFiveButton")).setText("$" + Integer.toString((int)(5*(Math.ceil(order.testingGetOrderTotal()/5)))) + ".00");
                ((JButton)components.get("roundUpTwentyButton")).setText("$" + Integer.toString((int)(20*(Math.ceil(order.testingGetOrderTotal()/20)))) + ".00");
                break;
            case CARD_BUTTON:
                (components.get("cashOptContainer")).setVisible(false);
                break;
            default:
                Object[] options = {"Confirm",
                        "Cancel"};
                double returnAmount = Double.parseDouble(actionEvent.getActionCommand().replace("$", "")) - order.testingGetOrderTotal();
                returnAmount = Math.round(returnAmount * 100.0) / 100.0;
                int n = JOptionPane.showOptionDialog(view,
                        "Cash Collected: " + actionEvent.getActionCommand()
                        + "\nChange Amount: $" + returnAmount,
                        "Collect Cash",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,     //do not use a custom Icon
                        options,  //the titles of buttons
                        options[0]); //default button title
                if(n == JOptionPane.YES_OPTION){
                    order.payForOrder();

                }else{
                    // do nothing
                }
                break;
        }
    }
}
