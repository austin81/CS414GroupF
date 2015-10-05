package views;

import objects.Pizza;
import objects.PizzaSize;
import objects.Sauce;
import objects.Topping;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
        orderView.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));

        setContentPane(orderView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        pizzaToppingsList.setSelectionModel(new DefaultListSelectionModel(){
            @Override
            public void setSelectionInterval(int index0, int index1){
                if(super.isSelectedIndex(index0)){
                    super.removeSelectionInterval(index0, index1);
                }else{
                    super.addSelectionInterval(index0, index1);
                }
            }
        });

        pizzaSizesList.setListData(sizes.toArray());
        pizzaSizesList.setCellRenderer(new ComponentSize());
        pizzaSizesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSizesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pizzaSaucesList.setListData(sauces.toArray());
        pizzaSaucesList.setCellRenderer(new ComponentSauce());
        setVisible(true);
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

        ArrayList<Topping> ptoppings = new ArrayList<>();
        ptoppings.add(toppings.get(0));
        ptoppings.add(toppings.get(1));
        pizzas.add(new Pizza(ptoppings, sauces.get(0), sizes.get(2), 10.99));


    }
}
