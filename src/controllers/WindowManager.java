package controllers;

import objects.Register;
import views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.HashMap;
import java.util.Observable;

/**
 * Created by darkbobo on 10/25/15.
 */
public class WindowManager implements WindowStateListener {
    HashMap<String,MyJFrame> views;
    HashMap<String, MyActionListener> controllers;
    Register register;

    JFrame activeWindow;

    public WindowManager(){
        register = new Register();
        init();
        registerMVC();
        registerManager();
        registerComponents();
        for(MyJFrame jFrame : views.values()){
            jFrame.setVisible(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        // init main menu view
        views.get("mainMenu").setVisible(true);
    }

    @Override
    public void windowStateChanged(WindowEvent windowEvent) {
        System.out.println(windowEvent.paramString());
        System.out.println(windowEvent.getNewState());
        System.out.println(windowEvent.getOldState());
    }

    public void activateWindow(String oldWindow, String newWindow){
        views.get(oldWindow).setVisible(false);
        views.get(newWindow).setVisible(true);
    }

    public void init(){
        views = new HashMap<>();
        views.put("mainMenu", new MainMenuView());
        views.put("orderEdit", new AddOrderView());
        views.put("collectPayment", new CollectPaymentView());
        views.put("customer", new CustomerView());
        views.put("makeline", new MakelineView());
        views.put("orderList", new OrderListView());

        controllers = new HashMap<>();
        //controllers.put("mainMenuListener", new)
        controllers.put("orderEdit", new OrderEditListener());
        controllers.put("collectPayment", new CollectPaymentListener());
        controllers.put("customer", new CustomerListener());
        //controllers.put("makeline", new MakelineListener());
        controllers.put("orderList", new OrderListListener());
    }

    public void registerMVC(){
        (views.get("orderEdit")).addModel(register);

        (views.get("collectPayment")).addModel(register);
        (views.get("customer")).addModel(register);
        (views.get("makeline")).addModel(register);
        (views.get("orderList")).addModel(register);

        ((AddOrderView)views.get("orderEdit")).addController((OrderEditListener) controllers.get("orderEdit"));
        ((CollectPaymentView)views.get("collectPayment")).addController((CollectPaymentListener) controllers.get("collectPayment"));
        ((CustomerView) views.get("customer")).addController((CustomerListener) controllers.get("customer"));
        //((MakelineView)views.get("makeline")).addController(register);
        ((OrderListView)views.get("orderList")).addController((OrderListListener) controllers.get("orderList"));

        for(MyActionListener listener : controllers.values()){
            listener.addModel(register);
        }
    }

    public void registerManager(){

        ((MainMenuView)views.get("mainMenu")).addWindowManager(this);
        ((AddOrderView)views.get("orderEdit")).addWindowManager(this);
        ((CollectPaymentView)views.get("collectPayment")).addWindowManager(this);
        ((CustomerView) views.get("customer")).addWindowManager(this);
        ((MakelineView)views.get("makeline")).addWindowManager(this);
        ((OrderListView)views.get("orderList")).addWindowManager(this);

        //((MainMenuListener)views.get("mainMenuListener")).addWindowManager(this);
        ((OrderEditListener)controllers.get("orderEdit")).addWindowManager(this);
        ((CollectPaymentListener)controllers.get("collectPayment")).addWindowManager(this);
        ((CustomerListener) controllers.get("customer")).addWindowManager(this);
        //((MakelineListener)controllers.get("makeline")).addWindowManager(this);
        ((OrderListListener)controllers.get("orderList")).addWindowManager(this);
    }

    public void registerComponents(){
        //((MainMenuView)views.get("mainMenuView")).addComponents();
        ((AddOrderView)views.get("orderEdit")).addComponents();
        ((CollectPaymentView)views.get("collectPayment")).addComponents();
        ((CustomerView)views.get("customer")).addComponents();
        ((MakelineView)views.get("makeline")).addComponents();
        ((OrderListView)views.get("orderList")).addComponents();
    }
    public void passOrderID(String toController, int orderID){
        ((MyActionListener)controllers.get(toController)).setOrderID(orderID);
    }
}
