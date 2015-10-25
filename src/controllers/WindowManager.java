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
    HashMap<String,JFrame> views;
    HashMap<String, MyActionListener> controllers;
    Register register;

    JFrame activeWindow;

    public WindowManager(){
        register = new Register();
        init();
        registerMVC();
        registerManager();
        registerComponents();
        for(JFrame jFrame : views.values()){
            jFrame.setVisible(false);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        // init main menu view
        views.get("mainMenuView").setVisible(true);
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
        views.put("mainMenuView", new MainMenuView());
        views.put("addOrderView", new AddOrderView());
        views.put("collectPaymentView", new CollectPaymentView());
        views.put("customerView", new CustomerView());
        views.put("makelineView", new MakelineView());
        views.put("orderListView", new OrderListView());

        controllers = new HashMap<>();
        //controllers.put("mainMenuListener", new)
        controllers.put("orderEditListener", new OrderEditListener());
        controllers.put("collectPaymentListener", new CollectPaymentListener());
        controllers.put("customerListener", new CustomerListener());
        //controllers.put("makelineListener", new MakelineListener());
        controllers.put("orderListListener", new OrderListListener());
    }

    public void registerMVC(){
        ((AddOrderView)views.get("addOrderView")).addModel(register);
        ((CollectPaymentView)views.get("collectPaymentView")).addModel(register);
        ((CustomerView) views.get("customerView")).addModel(register);
        ((MakelineView)views.get("makelineView")).addModel(register);
        ((OrderListView)views.get("orderListView")).addModel(register);

        ((AddOrderView)views.get("addOrderView")).addController((OrderEditListener) controllers.get("orderEditListener"));
        ((CollectPaymentView)views.get("collectPaymentView")).addController((CollectPaymentListener) controllers.get("collectPaymentListener"));
        ((CustomerView) views.get("customerView")).addController((CustomerListener) controllers.get("customerListener"));
        //((MakelineView)views.get("makelineView")).addController(register);
        ((OrderListView)views.get("orderListView")).addController((OrderListListener) controllers.get("orderListListener"));

        for(MyActionListener listener : controllers.values()){
            listener.addModel(register);
        }
    }

    public void registerManager(){
        ((MainMenuView)views.get("mainMenuView")).addWindowManager(this);
        ((AddOrderView)views.get("addOrderView")).addWindowManager(this);
        ((CollectPaymentView)views.get("collectPaymentView")).addWindowManager(this);
        ((CustomerView) views.get("customerView")).addWindowManager(this);
        ((MakelineView)views.get("makelineView")).addWindowManager(this);
        ((OrderListView)views.get("orderListView")).addWindowManager(this);

        //((MainMenuListener)views.get("mainMenuListener")).addWindowManager(this);
        ((OrderEditListener)controllers.get("orderEditListener")).addWindowManager(this);
        ((CollectPaymentListener)controllers.get("collectPaymentListener")).addWindowManager(this);
        ((CustomerListener) controllers.get("customerListener")).addWindowManager(this);
        //((MakelineListener)controllers.get("makelineListener")).addWindowManager(this);
        ((OrderListListener)controllers.get("orderListListener")).addWindowManager(this);
    }

    public void registerComponents(){
        //((MainMenuView)views.get("mainMenuView")).addComponents();
        ((AddOrderView)views.get("addOrderView")).addComponents();
        ((CollectPaymentView)views.get("collectPaymentView")).addComponents();
        ((CustomerView)views.get("customerView")).addComponents();
        ((MakelineView)views.get("makelineView")).addComponents();
        ((OrderListView)views.get("orderListView")).addComponents();
    }
    public void passOrderID(String toController, int orderID){
        ((MyActionListener)controllers.get(toController)).setOrderID(orderID);
    }
}
