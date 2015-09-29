package views;

import objects.Pizza;
import objects.PizzaSize;
import objects.Sauce;
import objects.Topping;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by darkbobo on 9/28/15.
 */
public class AddOrderView extends JFrame{
    private JList pizzaList;
    private JPanel orderView;
    private JList pizzaToppingsList;
    private JList pizzaSizesList;
    private JList pizzaSaucesList;
    private JButton collectOrderButton;
    private JButton sendToMakelineButton;
    private JButton addPizzaButton;

    ArrayList<Pizza> pizzas;
    ArrayList<Topping> toppings;
    ArrayList<PizzaSize> sizes;
    ArrayList<Sauce> sauces;
    public AddOrderView(){
        orderView.setPreferredSize(new Dimension(1000, 800));
        setContentPane(orderView);
        pack();
        pizzas = new ArrayList<>();
        toppings = new ArrayList<>();
        sizes = new ArrayList<>();
        sauces = new ArrayList<>();
        initData();
        pizzaList.setListData(pizzas.toArray());
        pizzaList.setCellRenderer(new ComponentPizza());
        pizzaToppingsList.setListData(toppings.toArray());
        pizzaToppingsList.setCellRenderer(new ComponentTopping());
        pizzaSizesList.setListData(sizes.toArray());
        pizzaSizesList.setCellRenderer(new ComponentSize());
        pizzaSizesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSizesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pizzaSaucesList.setListData(sauces.toArray());
        pizzaSaucesList.setCellRenderer(new ComponentSauce());
        setVisible(true);
    }
    private void initData(){
        toppings.add(new Topping("P", "Pepperoni"));
        toppings.add(new Topping("S", "Sausage"));
        toppings.add(new Topping("O", "Onion"));
        toppings.add(new Topping("R", "Black Olive"));
        toppings.add(new Topping("G", "Green Pepper"));

        sizes.add(new PizzaSize("S"));
        sizes.add(new PizzaSize("M"));
        sizes.add(new PizzaSize("L"));
        sizes.add(new PizzaSize("XL"));

        sauces.add(new Sauce("M", "Marinara"));
        sauces.add(new Sauce("O", "Onion"));
        sauces.add(new Sauce("R", "Ranch"));

        ArrayList<Topping> ptoppings = new ArrayList<>();
        ptoppings.add(toppings.get(0));
        ptoppings.add(toppings.get(1));
        pizzas.add(new Pizza(ptoppings, sauces.get(0), sizes.get(2), 10.99));


    }
}
