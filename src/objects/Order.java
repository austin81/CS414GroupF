package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Order {
    public int orderID;
    String customerName;
    Address address;
    ArrayList<Pizza> pizzas;

    public Order() {
        pizzas = new ArrayList<>();
    }

    public Order(String customerName, Address address) {
        this.customerName = customerName;
        this.address = address;
        this.pizzas = new ArrayList<>();
    }

    public Order(int orderID, String customerName, Address address) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.address = address;
    }

    public Order(String customerName, Address address, ArrayList<Pizza> pizzas) {
        this.customerName = customerName;
        this.address = address;
        this.pizzas = pizzas;
    }

    public Order(int orderID, String customerName, Address address, ArrayList<Pizza> pizzas) {
        this.orderID = orderID;
        this.customerName = customerName;
        this.address = address;
        this.pizzas = pizzas;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Pizza> getPizzas() {
        return pizzas;
    }

    public Pizza getPizza(int index){
        return this.pizzas.get(index);
    }

    public void addPizza(Pizza pizza){
        if(this.pizzas == null){
            this.pizzas = new ArrayList<>();
        }
        pizza.setStatus(PIZZA_STATUS.NEW);
        this.pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza){
        if(pizzas.contains(pizza)){
            pizzas.remove(pizza);
        }
    }
    public void removeAllPizzas(){
        this.pizzas.clear();
    }

    public void setPizzas(ArrayList<Pizza> pizzas) {
        if(this.pizzas == null){
            this.pizzas = new ArrayList<>();
        }
        this.pizzas.addAll(pizzas);
    }

    public void updatePizza(int index, Pizza pizza){
        pizzas.set(index, pizza);
    }

    public void sendPizzasToMakeLine(){
        for(Pizza pizza : pizzas){
            pizza.sendPizzaToMakeline();
        }
    }

    public double getOrderTotal(){
        double totalPrice = 0.0;
        for(Pizza pizza : pizzas){
            totalPrice += pizza.getPrice();
        }
        return totalPrice;
    }
}
