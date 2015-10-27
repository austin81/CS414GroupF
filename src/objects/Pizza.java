package objects;

import com.sun.xml.internal.messaging.saaj.util.SAAJUtil;

import java.util.ArrayList;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Pizza {
    ArrayList<Topping> toppings;
    Sauce sauce;
    PizzaSize size;
    PIZZA_STATUS status;
    double price;
    int orderID;

    public Pizza(){
        toppings = new ArrayList<>();
    }

    public Pizza(ArrayList<Topping> toppings, Sauce sauce, PizzaSize size, PIZZA_STATUS status, double price) {
        this.toppings = toppings;
        this.sauce = sauce;
        this.size = size;
        this.status = status;
        this.price = price;
    }

    @Override
    public String toString(){
        return size.toString() + " " + getSauce() + " " + getToppingList() + " $" + getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pizza)){
            return false;
        }else {
            Pizza p = (Pizza)o;
            if (getSauce().equals(p.getSauce()) && getSize().equals(p.getSize()) && getStatus() == p.getStatus()) {
                for (Topping t : p.getToppingList()) {
                    if (!getToppingList().contains(t)) {
                        return false;
                    }
                }
            } else {
                return false;
            }
            return true;
        }
    }


    public ArrayList<Topping> getToppingList() {
        return toppings;
    }

    public void setToppingList(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public PizzaSize getSize() {
        return size;
    }

    public void setSize(PizzaSize size) {
        this.size = size;
    }

    public PIZZA_STATUS getStatus(){
        return status;
    }

    public void setStatus(PIZZA_STATUS status){
        this.status = status;
    }

    public void sendPizzaToMakeline(){
        this.status = PIZZA_STATUS.MAKELINE;
    }

    public void loadPizza(){
        this.status = PIZZA_STATUS.LOADED;
    }

    public void completePizza(){
        this.status = PIZZA_STATUS.COMPLETED;
    }

    public void calculatePrice(){
        // should abstract out so pricing calculations are dynamic
        double basePrice = 0;
        if(this.size.getShortName().equals("S")){
            basePrice = 3.99;
        }else if(this.size.getShortName().equals("M")){
            basePrice = 4.99;
        }else if(this.size.getShortName().equals("L")){
            basePrice = 6.99;
        }else if(this.size.getShortName().equals("XL")){
            basePrice = 9.99;
        }
        basePrice += toppings.size();
        setPrice(basePrice);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String makelineToString(){
        System.out.println("OrderID" + orderID);
        return orderID + size.toString() + sauce + toppings.toString();
    }

}
