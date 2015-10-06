package views;

import objects.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton cancelPizzaButton;
    private JTextField totalDisplay;
    private Order order;
    ArrayList<Pizza> pizzas;
    ArrayList<Topping> toppings;
    ArrayList<PizzaSize> sizes;
    ArrayList<Sauce> sauces;
    public static final String TOTAL_TEXT = "Total................";

    public AddOrderView(){
        orderView.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        order = new Order();
        pizzas = new ArrayList<>();
        toppings = new ArrayList<>();
        sizes = new ArrayList<>();
        sauces = new ArrayList<>();
        initData();
        totalDisplay.setText(TOTAL_TEXT + order.getOrderTotal());
        pizzaList.setListData(order.getPizzas().toArray());
        pizzaList.setCellRenderer(new ComponentPizza());
        pizzaList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                System.out.println(event.toString());
                addPizzaButton.setText("Update Pizza");
                JList list = (JList) event.getSource();
                String buttonText = "";
                try {
                    buttonText = list.getSelectedValue().toString();
                } catch (NullPointerException e) {
                    addPizzaButton.setText("Add Pizza");
                }
                Pizza pizza = null;
                for (Pizza p : order.getPizzas()) {
                    if (p.toString().equals(buttonText)) {
                        pizza = p;
                    }
                }
                if (pizza != null) {
                    pizzaSaucesList.setSelectedValue(pizza.getSauce(), true);
                    pizzaSizesList.setSelectedValue(pizza.getSize(), true);

                    ArrayList<Integer> indicies = new ArrayList<>();
                    for (Topping t : pizza.getToppingList()) {
                        for (int i = 0; i < toppings.size(); i++) {
                            if (toppings.get(i).equals(t)) {
                                indicies.add(i);
                            }
                        }
                    }
                    int[] tmpIndicies = new int[indicies.size()];
                    for (int i = 0; i < indicies.size(); i++) {
                        tmpIndicies[i] = indicies.get(i);
                    }
                    pizzaToppingsList.setSelectedIndices(tmpIndicies);
                }
            }
        });
        pizzaToppingsList.setListData(toppings.toArray());
        pizzaToppingsList.setCellRenderer(new ComponentTopping());
        pizzaToppingsList.setSelectionModel(new DefaultListSelectionModel() {
            @Override
            public void setSelectionInterval(int index0, int index1) {
                if (super.isSelectedIndex(index0)) {
                    super.removeSelectionInterval(index0, index1);
                } else {
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
        order = new Order();
        addPizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Topping> selectedToppings = new ArrayList<>();
                int[] tmpSelectedToppings = pizzaToppingsList.getSelectedIndices();
                for (int i = 0; i < tmpSelectedToppings.length; i++) {
                    selectedToppings.add(toppings.get(tmpSelectedToppings[i]));
                }

                // add new pizza to order
                Pizza pizza = new Pizza();
                pizza.setToppingList(selectedToppings);
                pizza.setSauce(sauces.get(pizzaSaucesList.getSelectedIndex()));
                pizza.setSize(sizes.get(pizzaSizesList.getSelectedIndex()));
                pizza.calculatePrice();
                if (addPizzaButton.getText().equals("Add Pizza")) {
                    order.addPizza(pizza);
                } else {
                    // update pizza
                    int selectedIndex = pizzaList.getSelectedIndex();
                    order.updatePizza(selectedIndex, pizza);
                }
                pizzaList.setListData(order.getPizzas().toArray());
                clearPizzaSelections();
                totalDisplay.setText(TOTAL_TEXT + order.getOrderTotal());
            }
        });
        cancelPizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(addPizzaButton.getText().equals("Update Pizza")){
                    addPizzaButton.setText("Add Pizza");
                }
                clearPizzaSelections();
            }
        });
        collectOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // go to payment screen
            }
        });
        sendToMakelineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // push order to makeline
                order.sendPizzasToMakeLine();
            }
        });
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
    }

    public void clearPizzaSelections(){
        pizzaToppingsList.clearSelection();
        pizzaSizesList.clearSelection();
        pizzaSaucesList.clearSelection();
        pizzaList.clearSelection();
        addPizzaButton.setText("Add Pizza");
    }
}
