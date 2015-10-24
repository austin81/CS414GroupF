package objects;

import controllers.CollectPaymentListener;
import controllers.CustomerListener;
import controllers.OrderEditListener;

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
    private static PizzaCatalog catalog;
    CustomerListener customerListener;
    OrderEditListener orderEditListener;
    CollectPaymentListener collectPaymentListener;

    public static final String TOTAL_TEXT = "Total................";
    public Register() {
        orders = new ArrayList<>();
        catalog = new PizzaCatalog();
        customerListener = new CustomerListener();
        orderEditListener = new OrderEditListener();
        collectPaymentListener = new CollectPaymentListener();
        customerListener.addModel(this);
        orderEditListener.addModel(this);
        collectPaymentListener.addModel(this);
    }

    public int getNextOrderID(){
        return orders.size();
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
        order.setOrderID(getNextOrderID());
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

    public CustomerListener getCustomerListener() {
        return customerListener;
    }

    public OrderEditListener getOrderEditListener() {
        return orderEditListener;
    }

    public CollectPaymentListener getCollectPaymentListener() {
        return collectPaymentListener;
    }
}
