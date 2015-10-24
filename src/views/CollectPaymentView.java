package views;

import controllers.CollectPaymentListener;
import controllers.OrderEditListener;
import objects.Order;
import objects.Register;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CollectPaymentView extends JFrame implements Observer{
    private JPanel collectPaymentContainer;
    private JButton cashButton;
    private JButton cardButton;
    private JButton exactChangeButton;
    private JButton roundUpOneButton;
    private JButton roundUpFiveButton;
    private JButton roundUpTwentyButton;
    private JPanel cashOptContainer;
    private Register model;
    private CollectPaymentListener controller;
    Order order;
    public CollectPaymentView(){
        collectPaymentContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(collectPaymentContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        cashOptContainer.setVisible(false);
        order = new Order();
        setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
    public void addModel(Register model){
        this.model = model;
    }

    public void addController(CollectPaymentListener controller){
        this.controller = controller;
        controller.addView(this);
    }

    public void addComponents(){
        controller.registerComponent("cashOptContainer", cashOptContainer);
        controller.registerComponent("cashButton", cashButton);
        controller.registerComponent("cardButton", cardButton);
        controller.registerComponent("exactChangeButton", exactChangeButton);
        controller.registerComponent("roundUpOneButton", roundUpOneButton);
        controller.registerComponent("roundUpFiveButton", roundUpFiveButton);
        controller.registerComponent("roundUpTwentyButton", roundUpTwentyButton);

        cashButton.addActionListener(controller);
        cardButton.addActionListener(controller);
        exactChangeButton.addActionListener(controller);
        roundUpOneButton.addActionListener(controller);
        roundUpFiveButton.addActionListener(controller);
        roundUpTwentyButton.addActionListener(controller);
    }
}
