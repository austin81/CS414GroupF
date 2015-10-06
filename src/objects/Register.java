package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 10/5/15.
 */
public class Register {
    private ArrayList<Order> orders;
    private User loggedInUser;
    private int storeID;

    public Register() {

    }

    public Register(ArrayList<Order> orders, User loggedInUser, int storeID) {
        this.orders = orders;
        this.loggedInUser = loggedInUser;
        this.storeID = storeID;
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
    public void setOrders(ArrayList<Order> orders) {
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        this.orders.addAll(orders);
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
}
