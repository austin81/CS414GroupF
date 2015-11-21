package client;

import common.RegisterInt;
import objects.*;
import controllers.CollectPaymentListener;
import controllers.CustomerListener;
import controllers.OrderEditListener;
import controllers.WindowManager;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by clark on 11/20/15.
 */
public class RegisterClient {

    RegisterInt r;
    public static final String TOTAL_TEXT = "Total................";

    CustomerListener customerListener;
    OrderEditListener orderEditListener;
    CollectPaymentListener collectPaymentListener;
    WindowManager manager;

    public RegisterClient(String url) {
        try {
            r = (RegisterInt)
                    Naming.lookup(url);
            customerListener.addModel(this);
            orderEditListener.addModel(this);
            collectPaymentListener.addModel(this);
        } catch (MalformedURLException murle) {
            System.out.println("MalformedURLException");
            System.out.println(murle);
            System.exit(-1);
        } catch (RemoteException re) {
            System.out.println("RemoteException");
            System.out.println(re);
            System.exit(-1);
        } catch (NotBoundException nbe) {
            System.out.println("NotBoundException");
            System.out.println(nbe);
            System.exit(-1);
        }

    }

    public void setWindowManager(WindowManager manager) {
        this.manager = manager;
    }

    //have controllers call RegisterInt methods here.

    public PizzaCatalog getCatalog() {
        try{
            return r.getCatalogRMI();
        } catch(RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public PizzaCatalog deleteItem(Object o){
        try{
            return r.deleteItemRMI(o);
        }catch(RemoteException re){
            System.out.println(re);
            return null;
        }

    }
    public PizzaCatalog updateItem(Object o){
        try{
            return r.updateItemRMI(o);
        }catch(RemoteException re){
            System.out.println(re);
            return null;
        }
    }

    public PizzaCatalog addItem(Object o){
        try{
            return r.addItemRMI(o);
        }catch(RemoteException re){
            System.out.println(re);
            return null;
        }
    }

    public ArrayList<Order> getOrders() {
        try {
            return r.getOrdersRMI();
        } catch(RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public Order getOrder(int o){
        try{
            return r.getOrderRMI(o);
        }catch(RemoteException re){
            System.out.println(re);
            return null;
        }

    }

    public void updateOrder(int orderId, Order order) {
        try{
            r.updateOrderRMI(orderId, order);
        } catch(RemoteException re) {
            System.out.println(re);
        }
    }

    public void removeOrder(int orderId) {
        try{
            r.removeOrderRMI(orderId);
        } catch(RemoteException re) {
            System.out.println(re);
        }
    }

    public int getOrderIDByPhone(String phoneNumber) {
        try {
            return r.getOrderIDByPhone(phoneNumber);
        } catch(RemoteException re) {
            System.out.println(re);
            return -1;
        }
    }

    public int addOrder(Order order) {
        try{
            return r.addOrderRMI(order);
        } catch(RemoteException re) {
            System.out.println(re);
            return -1;
        }
    }

    public Employee getEmployeeByAuth(String auth){
        try{
            return r.getEmployeeByAuthRMI(auth);
        }catch(RemoteException re){
            System.out.println(re);
            return null;
        }
    }

    public void removeEmployee(Employee employee) {
        try{
            r.removeEmployeeRMI(employee);
        } catch(RemoteException re) {
            System.out.println(re);
        }
    }

    public void updateEmployee(int ID, Employee employee) {
        try{
            r.updateEmployee(ID, employee);
        } catch(RemoteException re) {
            System.out.println(re);
        }
    }


    public void setLoggedInEmployee(Employee e){
        try{
            r.setLoggedInEmployeeRMI(e);
        }catch(RemoteException re){
            System.out.println(re);
        }
    }

    public ArrayList<Employee> getEmployees() {
        try {
            return r.getEmployeesRMI();
        } catch (RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public void addEmployee(Employee e) {
        try {
            r.addEmployeeRMI(e);
        } catch (RemoteException re) {
            System.out.println(re);
        }
    }

    public ArrayList<Pizza> getMakelinePizzas(){
        try {
            return r.getMakelinePizzas();
        } catch (RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public ArrayList<String> getMakelineSides(){
        try {
            return r.getMakelineSides();
        } catch (RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public ArrayList<Integer> getMakelineID(){
        try{
            return r.getMakelineIDRMI();
        } catch (RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public ArrayList<Integer> getMakelineItems(){
        try{
            return r.getMakelineItemsRMI();
        }catch (RemoteException re) {
            System.out.println(re);
            return null;
        }
    }

    public void clearLoggedInEmployee() {
        try{
            r.clearLoggedInEmployeeRMI();
        } catch (RemoteException re) {
            System.out.println(re);
        }
    }
}
