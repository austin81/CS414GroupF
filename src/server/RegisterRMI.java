package server;

import common.RegisterInt;
import objects.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * Created by clark on 11/20/15.
 */
public class RegisterRMI extends UnicastRemoteObject implements RegisterInt {

    Register register;

    public RegisterRMI() throws RemoteException{
        super();
        register = new Register();
    }

    public RegisterRMI(Register r) throws RemoteException{
        super();
        this.register = r;
    }
    public PizzaCatalog getCatalogRMI() throws RemoteException{
        return register.getCatalog();
    }
    public PizzaCatalog deleteItemRMI(Object o) throws RemoteException{
        register.getCatalog().deleteItem(o);
        return getCatalogRMI();
    }
    public Order getOrderRMI(int o) throws RemoteException {
        return register.getOrder(o);
    }
    public PizzaCatalog updateItemRMI(Object o) throws RemoteException{
        register.getCatalog().updateItem(o);
        return getCatalogRMI();
    }
    public ArrayList<Order> getOrdersRMI() throws RemoteException{
        return register.getOrders();
    }
    public PizzaCatalog addItemRMI(Object o) throws RemoteException{
        register.getCatalog().addItem(o);
        return getCatalogRMI();
    }
    public void updateOrderRMI(int orderId, Order order) throws RemoteException{
        register.updateOrder(orderId, order);
    }
    public void removeOrderRMI(int orderId) throws RemoteException{
        register.removeOrder(orderId);
    }
    public int getOrderIDByPhone(String phoneNumber) throws RemoteException{
        return register.getOrderIDByPhone(phoneNumber);
    }
    public int addOrderRMI(Order order) throws RemoteException {
        return register.addOrder(order);
    }
    public void removeEmployeeRMI(Employee employee) throws RemoteException {
        register.removeEmployee(employee);
    }
    public void updateEmployee(int ID, Employee employee) throws RemoteException {
        register.updateEmployee(ID, employee);
    }

    public Employee getEmployeeByAuthRMI(String auth) throws RemoteException{
        return register.getEmployeeByAuth(auth);
    }
    public void setLoggedInEmployeeRMI(Employee e) throws RemoteException{
        register.setLoggedInEmployee(e);
    }
    public void clearLoggedInEmployeeRMI() throws RemoteException{
        register.clearLoggedInEmployee();
    }
    public ArrayList<Employee> getEmployeesRMI() throws RemoteException{
        return register.getEmployees();
    }
    public void addEmployeeRMI(Employee e) throws RemoteException {
        register.addEmployee(e);
    }

    @Override
    public ArrayList<Pizza> getMakelinePizzas() throws RemoteException {
        return register.getMakelinePizzas();
    }

    @Override
    public ArrayList<String> getMakelineSides() throws RemoteException {
        return register.getMakelineSides();
    }

    @Override
    public ArrayList<Integer> getMakelineIDRMI() throws RemoteException {
        return register.getMakelineID();
    }

    @Override
    public ArrayList<String> getMakelineItemsRMI() throws RemoteException {
        return register.getMakelineItems();
    }
    public LoyaltyProgram getLoyaltyProgramRMI() throws RemoteException {
        return register.getLoyaltyProgram();
    }
}
