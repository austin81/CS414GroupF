package objects;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by darkbobo on 10/5/15.
 */
public class Register {
    private ArrayList<Order> orders;
    private Employee loggedInEmployee;
    private int storeID;
    private OrderEditListener orderEditListener;
    private static PizzaCatalog catalog;
    public static final String TOTAL_TEXT = "Total................";
    public Register() {
        orders = new ArrayList<>();
        orderEditListener = new OrderEditListener();
        catalog = new PizzaCatalog();
    }

    public Register(ArrayList<Order> orders, Employee loggedInEmployee, int storeID) {
        this.orders = orders;
        this.loggedInEmployee = loggedInEmployee;
        this.storeID = storeID;
        catalog = new PizzaCatalog();
    }

    public static PizzaCatalog getCatalog(){
        return catalog;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public Order getOrder(int index){
        return this.orders.get(index);
    }

    public void addOrder(Order order){
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        this.orders.add(order);
    }

    public void removeOrder(Order order){
        if(orders.contains(order)){
            orders.remove(order);
        }
    }

    public void setOrders(ArrayList<Order> orders) {
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        this.orders.addAll(orders);
    }

    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }

    public void setLoggedInEmployee(Employee loggedInEmployee) {
        this.loggedInEmployee = loggedInEmployee;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void registerActionListenerComponent(String labelID, JComponent component){
        orderEditListener.registerComponent(labelID, component);
    }

    public ActionListener getActionListener(){
        return orderEditListener;
    }
}
