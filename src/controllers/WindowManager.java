package controllers;

import client.RegisterClient;
import objects.Register;
import server.Server;
import views.*;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/25/15.
 */
public class WindowManager implements WindowStateListener {
    HashMap<String, MyJFrame> views;
    HashMap<String, MyActionListener> controllers;
    String url;
    RegisterClient client;
    public final String MAIN_MENU = "mainMenu";
    public final String ORDER_EDIT = "orderEdit";
    public final String COLLECT_PAYMENT = "collectPayment";
    public final String CUSTOMER = "customer";
    public final String MAKE_LINE = "makeline";
    public final String ORDER_LIST = "orderList";
    public final String MANAGE_MAIN = "manageMain";
    public final String EMPLOYEE_EDIT = "employeeEdit";
    public final String MENU_EDIT = "menuEdit";

    public WindowManager(String host, String port){

            // start the client
            url = new String("rmi://" + host + ":" + port + "/Service");
            client = new RegisterClient(url);

            client.setWindowManager(this);
            init();
            registerMVC();
            registerManager();
            registerComponents();
            for (MyJFrame jFrame : views.values()) {
                jFrame.setVisible(false);
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

            // init main menu view
            views.get(MAIN_MENU).setVisible(true);
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
        if(newWindow.equals(MAKE_LINE)){
            ((MakelineView)views.get(MAKE_LINE)).setOrderList();
            ((MakelineView)views.get(MAKE_LINE)).setItemList();
        }
        if(newWindow.equals(EMPLOYEE_EDIT) || newWindow.equals(MENU_EDIT) || newWindow.equals(ORDER_EDIT) || newWindow.equals(ORDER_LIST)){
            (controllers.get(newWindow)).resetView();
        }
        if(newWindow.equals(MAIN_MENU)){
            client.clearLoggedInEmployee();
        }
    }

    public void init(){
        views = new HashMap<>();
        views.put(MAIN_MENU, new MainMenuView());
        views.put(ORDER_EDIT, new AddOrderView());
        views.put(COLLECT_PAYMENT, new CollectPaymentView());
        views.put(CUSTOMER, new CustomerView());
        views.put(MAKE_LINE, new MakelineView());
        views.put(ORDER_LIST, new OrderListView());
        views.put(MANAGE_MAIN, new ManagerMainView());
        views.put(EMPLOYEE_EDIT, new EmployeeEditView());
        views.put(MENU_EDIT, new MenuEditView());

        controllers = new HashMap<>();
        controllers.put(MAIN_MENU, new MainMenuListener());
        controllers.put(ORDER_EDIT, new OrderEditListener());
        controllers.put(COLLECT_PAYMENT, new CollectPaymentListener());
        controllers.put(CUSTOMER, new CustomerListener());
        controllers.put(MAKE_LINE, new MakelineListener());
        controllers.put(ORDER_LIST, new OrderListListener());
        controllers.put(MANAGE_MAIN, new ManagerMainListener());
        controllers.put(EMPLOYEE_EDIT, new EmployeeEditListener());
        controllers.put(MENU_EDIT, new MenuEditListener());
    }

    public void registerMVC(){
        for(MyJFrame jFrame : views.values()){
            jFrame.addModel(client);
        }

        for(String key : views.keySet()){
            views.get(key).addController(controllers.get(key));
        }

        for(MyActionListener listener : controllers.values()){
            listener.addModel(client);
        }
    }

    public void registerManager(){
        for(MyJFrame jFrame : views.values()){
            jFrame.addWindowManager(this);
        }
        for(MyActionListener listener : controllers.values()){
            listener.addWindowManager(this);
        }
    }

    public void registerComponents(){
        //((MainMenuView)views.get("mainMenuView")).addComponents();
        for(MyJFrame jFrame : views.values()){
            jFrame.addComponents();
        }
    }
    public void passOrderID(String toController, int orderID){
        (controllers.get(toController)).setOrderID(orderID);
    }
}
