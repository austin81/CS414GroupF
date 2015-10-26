package controllers;

import objects.Order;
import objects.Pizza;
import objects.Register;
import objects.Topping;
import views.AddOrderView;
import views.CollectPaymentView;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/14/15.
 */
public class OrderEditListener extends MyActionListener implements ListSelectionListener {
    Order order;

    public OrderEditListener(){
        components = new HashMap<>();
    }

    public void setOrder(){
        order = model.getOrder(orderID);
        if(order.getPizzas().size() != 0){
            ((JTextField)components.get("totalDisplay")).setText(model.TOTAL_TEXT + order.getOrderTotal());
            ((JList)components.get("pizzaList")).setListData(order.getPizzas().toArray());

        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        Pizza pizza = new Pizza();
        switch (actionEvent.getActionCommand()){
            case "Add Pizza":
            case "Update Pizza":
                ArrayList<Topping> selectedToppings = new ArrayList<>();
                int[] tmpSelectedToppings = ((JList)components.get("pizzaToppingsList")).getSelectedIndices();
                for (int i = 0; i < tmpSelectedToppings.length; i++) {
                    selectedToppings.add(model.getCatalog().getToppings().get(tmpSelectedToppings[i]));
                }

                // add new pizza to order

                pizza.setToppingList(selectedToppings);
                pizza.setSauce(model.getCatalog().getSauces().get(((JList) components.get("pizzaSaucesList")).getSelectedIndex()));
                pizza.setSize(model.getCatalog().getSizes().get(((JList) components.get("pizzaSizesList")).getSelectedIndex()));
                pizza.calculatePrice();
                if (((JButton)components.get("addPizzaButton")).getText().equals("Add Pizza")) {
                    order.addPizza(pizza);
                } else {
                    // update pizza
                    int selectedIndex = ((JList)components.get("pizzaList")).getSelectedIndex();
                    order.updatePizza(selectedIndex, pizza);
                }
                ((JList)components.get("pizzaList")).setListData(order.getPizzas().toArray());
                clearPizzaSelections();
                ((JTextField)components.get("totalDisplay")).setText(model.TOTAL_TEXT + order.getOrderTotal());
                break;
            case "Cancel Pizza":
                if(((JButton)components.get("addPizzaButton")).getText().equals("Update Pizza")){
                    ((JButton)components.get("addPizzaButton")).setText("Add Pizza");

                    Pizza removedPizza = null;
                    for(Pizza p : order.getPizzas()){
                        if(p.toString().equals(((JList)components.get("pizzaList")).getSelectedValue().toString())){
                            removedPizza = p;
                        }
                    }
                    if(removedPizza != null){
                        order.removePizza(removedPizza);

                        ((JList)components.get("pizzaList")).setListData(order.getPizzas().toArray());
                        System.out.println(order.getPizzas().size());
                    }
                }
                clearPizzaSelections();
                break;
            case "Cancel":
                clearPizzaSelections();
                break;
            case "Cancel Order":
                clearPizzaSelections();
                // clear pizzaList
                ((JList)components.get("pizzaList")).setListData(new String[0]);
                order.removeAllPizzas();
                if(model.getOrders().contains(order)){
                    model.getOrders().remove(order);
                }
                order = null;
                ((JTextField)components.get("totalDisplay")).setText(model.TOTAL_TEXT);
                break;
            case "Send To Makeline":
                order.sendPizzasToMakeLine();
                model.updateOrder(orderID, order);
                order = null;
                manager.activateWindow(manager.ORDER_EDIT, manager.ORDER_LIST);
                break;
        }
    }

    public void clearPizzaSelections(){
        ((JList)components.get("pizzaToppingsList")).clearSelection();
        ((JList)components.get("pizzaSizesList")).clearSelection();
        ((JList)components.get("pizzaSaucesList")).clearSelection();
        //((JList)components.get("pizzaList")).clearSelection();
        ((JButton)components.get("addPizzaButton")).setText("Add Pizza");
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        if(list.equals(components.get("pizzaList"))) {
            ((JButton)components.get("addPizzaButton")).setText("Update Pizza");
            String buttonText = "";
            try {
                buttonText = list.getSelectedValue().toString();
            } catch (NullPointerException e) {
                ((JButton)components.get("addPizzaButton")).setText("Add Pizza");
            }
            Pizza pizza = null;
            for (Pizza p : order.getPizzas()) {
                if (p.toString().equals(buttonText)) {
                    pizza = p;
                }
            }
            if (pizza != null) {
                ((JList)components.get("pizzaSaucesList")).setSelectedValue(pizza.getSauce(), true);
                ((JList)components.get("pizzaSizesList")).setSelectedValue(pizza.getSize(), true);

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
                ((JList)components.get("pizzaToppingsList")).setSelectedIndices(tmpIndicies);
            }
        }
    }
}
