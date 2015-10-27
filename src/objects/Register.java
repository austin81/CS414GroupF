package objects;

import controllers.CollectPaymentListener;
import controllers.CustomerListener;
import controllers.OrderEditListener;
import controllers.WindowManager;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/5/15.
 */
public class Register {
    private ArrayList<Order> orders;
    private Employee loggedInEmployee;
    private int storeID;
    private static PizzaCatalog catalog;
    private ArrayList<Employee> employees;
    CustomerListener customerListener;
    OrderEditListener orderEditListener;
    CollectPaymentListener collectPaymentListener;
    HashMap<String, Role> roles;
    public final String MANAGER_ROLE = "managerRole";
    public final String CASHIER_ROLE = "cashierRole";
    public final String CHEF_ROLE = "chefRole";
    private WindowManager manager;

    public static final String TOTAL_TEXT = "Total................";
    public Register() {
        orders = new ArrayList<>();
        employees = new ArrayList<>();
        catalog = new PizzaCatalog();
        customerListener = new CustomerListener();
        orderEditListener = new OrderEditListener();
        collectPaymentListener = new CollectPaymentListener();
        customerListener.addModel(this);
        orderEditListener.addModel(this);
        collectPaymentListener.addModel(this);
        roles = new HashMap<>();
        initRoles();
        addEmployee(new Employee("manager1", new Address("street1", "city1", "state1", "zip1"), new Phone("phone1"), "manager1", "321", roles.get(MANAGER_ROLE)));
        addEmployee(new Employee("chef1", new Address("street1", "city1", "state1", "zip1"), new Phone("phone1"), "chef1", "123", roles.get(CHEF_ROLE)));
        addEmployee(new Employee("cashier1", new Address("street1", "city1", "state1", "zip1"), new Phone("phone1"), "cashier1", "000", roles.get(CASHIER_ROLE)));
    }

    public int getNextOrderID(){
        return orders.size();
    }
    public static PizzaCatalog getCatalog(){
        return catalog;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }
    public Order getOrder(int index){
        return this.orders.get(index);
    }

    public int addOrder(Order order){
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        order.setOrderID(getNextOrderID());
        this.orders.add(order);
        return order.getOrderID();
    }

    public void removeOrder(Order order){
        if(orders.contains(order)){
            orders.remove(order);
        }
    }

    public void setOrders(ArrayList<Order> orders) {
        if(this.orders == null){
            this.orders = new ArrayList<>();
        }
        this.orders.addAll(orders);
    }

    public ArrayList<Pizza> getMakelinePizzas(){
        ArrayList<Pizza> pizzas = new ArrayList<>();

        for(Order o: orders){
            for(Pizza p: o.getPizzas()){

                if(p.getStatus()== PIZZA_STATUS.MAKELINE){
                    pizzas.add(p);
                }
            }
        }
        return pizzas;
    }

    public ArrayList<Integer> getMakelineID(){
        ArrayList<Integer> id = new ArrayList<>();

        for(Order o: orders){
            for(Pizza p: o.getPizzas()){

                if(p.getStatus()== PIZZA_STATUS.MAKELINE){
                    id.add(p.getOrderID());
                }
            }
        }
        return id;
    }

    public ArrayList<PizzaSize> getMakelineSizes(){
        ArrayList<PizzaSize> sizes = new ArrayList<>();

        for(Order o: orders){
            for(Pizza p: o.getPizzas()){

                if(p.getStatus()== PIZZA_STATUS.MAKELINE){
                    sizes.add(p.getSize());
                }
            }
        }

        return sizes;

    }

    public ArrayList<Sauce> getMakelineSauces(){
        ArrayList<Sauce> sauces = new ArrayList<>();

        for(Order o: orders){
            for(Pizza p: o.getPizzas()){

                if(p.getStatus()== PIZZA_STATUS.MAKELINE){
                    sauces.add(p.getSauce());
                }
            }
        }

        return sauces;

    }

    public ArrayList<String> getMakelineToppings(){
        ArrayList<String> toppings = new ArrayList<>();

        for(Order o: orders){
            for(Pizza p: o.getPizzas()){

                if(p.getStatus()== PIZZA_STATUS.MAKELINE){
                    toppings.add(p.getToppingList().toString());
                }
            }
        }

        return toppings;

    }

    public void updateOrder(int orderID, Order order){
        orders.set(orderID, order);
    }

    public Employee getLoggedInEmployee() {
        return loggedInEmployee;
    }

    public void setLoggedInEmployee(Employee loggedInEmployee) {
        this.loggedInEmployee = loggedInEmployee;
    }

    public void addEmployee(Employee employee){
        employee.setUserID(employees.size());
        employees.add(employee);
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setWindowManager(WindowManager manager) {
        this.manager = manager;
    }

    public boolean userExists(String s) {
        for(Employee e : employees){
            if(e.getAuthentication().equals(s)){
                setLoggedInEmployee(e);
            }
        }
        if(getLoggedInEmployee() == null){
            return false;
        }else{
            return true;
        }
    }

    public boolean canEnter(String toWindow){
        if(getLoggedInEmployee().getRole().equals(roles.get(MANAGER_ROLE))){
            return true;
        }
        if(getLoggedInEmployee().getRole().equals(roles.get(CASHIER_ROLE)) && toWindow.equals(manager.ORDER_LIST)){
            return true;
        }
        if(getLoggedInEmployee().getRole().equals(roles.get(CHEF_ROLE)) && toWindow.equals(manager.MAKE_LINE)){
            return true;
        }
        return false;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public void initRoles(){
        roles.put(MANAGER_ROLE, new Role("Manager"));
        roles.put(CASHIER_ROLE, new Role("Cashier"));
        roles.put(CHEF_ROLE, new Role("Chef"));
    }

    public HashMap<String, Role> getRoles() {
        return roles;
    }
}
