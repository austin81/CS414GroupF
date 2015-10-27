package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Order {
    private int orderID;
    private Person customer;
    boolean isPaidFor;
    private ArrayList<Pizza> pizzas;

    public Order() {
        pizzas = new ArrayList<>();
    }

    public Order(Person customer, Address address) {
        this.customer = customer;
        this.pizzas = new ArrayList<>();
        setIsPaidFor(false);
    }

    public Order(int orderID, Person customer) {
        this.orderID = orderID;
        this.customer = customer;
        setIsPaidFor(false);
    }

    public Order(Person customer, ArrayList<Pizza> pizzas) {
        this.customer = customer;
        this.pizzas = pizzas;
        setIsPaidFor(false);
    }

    public Order(int orderID, Person customer, ArrayList<Pizza> pizzas) {
        this.orderID = orderID;
        this.customer = customer;
        this.pizzas = pizzas;
        setIsPaidFor(false);
    }

    @Override
    public String toString(){
        return getOrderID() + "   "
                + getCustomer().getPhoneNumbers().get(0)
                + "   " + getCustomer().getName()
                + "   " + getOrderTotal();
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customerName) {
        this.customer = customerName;
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
            pizza.setOrderID(orderID);
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

    public boolean isPaidFor() {
        return isPaidFor;
    }

    public void setIsPaidFor(boolean isPaidFor) {
        this.isPaidFor = isPaidFor;
    }

    public void payForOrder(){
        this.isPaidFor = true;
    }
/*
    public double testingGetOrderTotal(){
        return 12.99;
    }
*/
}
