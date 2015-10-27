package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 10/22/15.
 */
public class PizzaCatalog {
    ArrayList<Topping> toppings;
    ArrayList<Sauce> sauces;
    ArrayList<PizzaSize> sizes;
    ArrayList<SideItem> sides;

    public PizzaCatalog(){
        toppings = new ArrayList<>();
        sauces = new ArrayList<>();
        sizes = new ArrayList<>();
        sides = new ArrayList<>();
        initData();
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<Topping> toppings) {
        this.toppings = toppings;
    }

    public ArrayList<Sauce> getSauces() {
        return sauces;
    }

    public void setSauces(ArrayList<Sauce> sauces) {
        this.sauces = sauces;
    }

    public ArrayList<PizzaSize> getSizes() {
        return sizes;
    }

    public void setSizes(ArrayList<PizzaSize> sizes) {
        this.sizes = sizes;
    }

    public ArrayList<Side> getSides(){
        ArrayList<Side> tmpSides = new ArrayList<>();
        for(SideItem item : sides){
            if(item.getClass().equals(Side.class)){
                tmpSides.add((Side)item);
            }
        }
        return tmpSides;
    }
    public ArrayList<Drink> getDrinks(){
        ArrayList<Drink> tmpSides = new ArrayList<>();
        for(SideItem item : sides){
            if(item.getClass().equals(Drink.class)){
                tmpSides.add((Drink)item);
            }
        }
        return tmpSides;
    }

    private void initData(){
        toppings.add(new Topping("A", "Anchovies"));
        toppings.add(new Topping("B", "Beef"));
        toppings.add(new Topping("C", "Xtra Cheese"));
        toppings.add(new Topping("D", "Banana Peppers"));
        toppings.add(new Topping("E", "Green Chilis"));
        toppings.add(new Topping("F", "Tomatoes"));
        toppings.add(new Topping("G", "Green Pepper"));
        toppings.add(new Topping("I", "Artichokes"));
        toppings.add(new Topping("J", "Jalapenos"));
        toppings.add(new Topping("K", "Bacon"));
        toppings.add(new Topping("L", "Green Olives"));
        toppings.add(new Topping("M", "Mushrooms"));
        toppings.add(new Topping("N", "Chicken"));
        toppings.add(new Topping("O", "Onion"));
        toppings.add(new Topping("P", "Pepperoni"));
        toppings.add(new Topping("R", "Black Olive"));
        toppings.add(new Topping("S", "Sausage"));
        toppings.add(new Topping("U", "Sundried Tomatoes"));
        toppings.add(new Topping("V", "Feta"));
        toppings.add(new Topping("W", "Garlic"));

        sizes.add(new PizzaSize("S", "10\" Small"));
        sizes.add(new PizzaSize("M", "12\" Medium"));
        sizes.add(new PizzaSize("L", "14\" Large"));
        sizes.add(new PizzaSize("XL", "16\"Extra Large"));

        sauces.add(new Sauce("M", "Marinara"));
        sauces.add(new Sauce("O", "Olive Oil"));
        sauces.add(new Sauce("R", "Ranch"));

        sides.add(new Side("Bread Stick", 2.99));
        sides.add(new Side("Salad", 2.99));
        sides.add(new Side("Ice Cream", 4.99));
        sides.add(new Drink("Pepsi", 1.99));
        sides.add(new Drink("Sierra Mist", 1.99));
        sides.add(new Drink("Diet Pepsi", 1.99));
    }
}
