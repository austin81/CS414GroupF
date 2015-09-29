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
    double price;

    public Pizza(){

    }

    public Pizza(ArrayList<Topping> toppings, Sauce sauce, PizzaSize size, double price) {
        this.toppings = toppings;
        this.sauce = sauce;
        this.size = size;
        this.price = price;
    }
    @Override
    public String toString(){
        return size.toString() + " " + getSauce() + " " + getToppingList() + " $" + getPrice();
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
