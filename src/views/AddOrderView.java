package views;

import objects.*;
import controllers.OrderEditListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 9/28/15.
 */
public class AddOrderView extends JFrame implements Observer{
    private JList pizzaList;
    private JPanel orderView;
    private JList pizzaToppingsList;
    private JList pizzaSizesList;
    private JList pizzaSaucesList;
    private JButton collectOrderButton;
    private JButton sendToMakelineButton;
    private JButton addPizzaButton;
    private JButton cancelCurrent;
    private JTextField totalDisplay;
    private JButton cancelOrderButton;
    private JButton cancelPizzaButton;
    private Order order;
    private Register model;
    private OrderEditListener controller;



    public AddOrderView(){
        orderView.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(orderView);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        order = new Order();


        totalDisplay.setText(model.TOTAL_TEXT + order.getOrderTotal());
        pizzaList.setListData(order.getPizzas().toArray());
        pizzaList.setCellRenderer(new ComponentPizza());

        /*pizzaList.addListSelectionListener(new ListSelectionListener() {
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
                        for (int i = 0; i < model.getCatalog().getToppings().size(); i++) {
                            if (model.getCatalog().getToppings().get(i).equals(t)) {
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
        });*/
        pizzaToppingsList.setListData(model.getCatalog().getToppings().toArray());
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

        pizzaSizesList.setListData(model.getCatalog().getSizes().toArray());
        pizzaSizesList.setCellRenderer(new ComponentSize());
        pizzaSizesList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        pizzaSizesList.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pizzaSaucesList.setListData(model.getCatalog().getSauces().toArray());
        pizzaSaucesList.setCellRenderer(new ComponentSauce());



        /*
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
        */
        /*cancelCurrent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(addPizzaButton.getText().equals("Update Pizza")){
                    addPizzaButton.setText("Add Pizza");

                    Pizza pizza = null;
                    for(Pizza p : order.getPizzas()){
                        if(p.toString().equals(pizzaList.getSelectedValue().toString())){
                            pizza = p;
                        }
                    }
                    if(pizza != null){
                        order.removePizza(pizza);

                        pizzaList.setListData(order.getPizzas().toArray());
                        System.out.println(order.getPizzas().size());
                    }
                }
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
        */
        setVisible(true);
    }

    public void addModel(Register model){
        this.model = model;
    }

    public void addController(OrderEditListener controller){
        this.controller = controller;
    }


    @Override
    public void update(Observable observable, Object o) {
        System.out.println("AddOrderView: Observer is: " + observable.getClass() + ", object passed is: " + o.getClass());
    }

    public void addComponents(){
        controller.registerComponent("pizzaToppingsList", pizzaToppingsList);
        controller.registerComponent("pizzaSizesList", pizzaSizesList);
        controller.registerComponent("pizzaSaucesList", pizzaSaucesList);
        controller.registerComponent("pizzaList", pizzaList);
        pizzaList.addListSelectionListener(controller);
        controller.registerComponent("totalDisplay", totalDisplay);

        controller.registerComponent("addPizzaButton", addPizzaButton);
        addPizzaButton.addActionListener(controller);
        controller.registerComponent("collectOrderButton", collectOrderButton);
        collectOrderButton.addActionListener(controller);
        controller.registerComponent("cancelCurrent", cancelCurrent);
        cancelCurrent.addActionListener(controller);
        controller.registerComponent("cancelOrderButton", cancelOrderButton);
        cancelOrderButton.addActionListener(controller);
        controller.registerComponent("sendToMakelineButton", sendToMakelineButton);
        sendToMakelineButton.addActionListener(controller);
        controller.registerComponent("cancelPizzaButton", cancelPizzaButton);
        cancelPizzaButton.addActionListener(controller);
    }
}
