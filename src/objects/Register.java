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
    private PizzaCatalog catalog;
    private ArrayList<Employee> employees;
    CustomerListener customerListener;
    OrderEditListener orderEditListener;
    CollectPaymentListener collectPaymentListener;
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
        addEmployee(new Employee("manager1", new Address("street1", "city1", "state1", "zip1"), new Phone("phone1"), "manager1", "321", ROLE.MANAGER));
        addEmployee(new Employee("chef1", new Address("street2", "city2", "state2", "zip2"), new Phone("phone2"), "chef1", "123", ROLE.CHEF));
        addEmployee(new Employee("cashier1", new Address("street3", "city3", "state3", "zip3"), new Phone("phone3"), "cashier1", "000", ROLE.CASHIER));
    }

    public int getNextOrderID(){
        return orders.size();
    }
    public PizzaCatalog getCatalog(){
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

    public ArrayList<String> getMakelineItems(){
        ArrayList<String> items = new ArrayList<>();

        for(Order o: orders) {
            for (Pizza p : o.getPizzas()) {
                if(p.getStatus() == PIZZA_STATUS.MAKELINE) {
                    items.add(p.getSize() + "     " + p.getSauce() + "     " + p.getToppingList().toString());
                }
            }

            for (SideItem s: o.getSides()){
                if(s.getStatus() == SIDE_STATUS.MAKELINE){
                    items.add(o.getSides().toString());
                }
            }

        }
        return items;
    }

    public ArrayList<String> getMakelineSides(){
        ArrayList<String> sides = new ArrayList<>();

        for(Order o: orders) {
            for (SideItem s: o.getSides()){
                if(s.getStatus() == SIDE_STATUS.MAKELINE){
                    sides.add(s.toString());
                }
            }
        }

        return sides;
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

    public void removeEmployee(Employee employee){
        employees.remove(employee);
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
        if(getLoggedInEmployee().getRole().equals(ROLE.MANAGER)){
            return true;
        }
        if(getLoggedInEmployee().getRole().equals(ROLE.CASHIER) && toWindow.equals(manager.ORDER_LIST)){
            return true;
        }
        if(getLoggedInEmployee().getRole().equals(ROLE.CHEF) && toWindow.equals(manager.MAKE_LINE)){
            return true;
        }
        return false;
    }

    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    public void updateEmployee(int userID, Employee employee){
        for(int i = 0; i < getEmployees().size(); i++){
            if(employees.get(i).getUserID() == userID){
                employees.set(i, employee);
            }
        }
    }
}
