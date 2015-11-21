package server;

import common.RegisterInt;
import objects.Employee;
import objects.Order;
import objects.PizzaCatalog;
import objects.Register;

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

    @Override
    public void removeEmployeeRMI(Employee employee) throws RemoteException {
        register.removeEmployee(employee);
    }

    @Override
    public void updateEmployee(int ID, Employee employee) throws RemoteException {
        register.updateEmployee(ID, employee);
    }

    public Employee getEmployeeByAuthRMI(String auth) throws RemoteException{
        return register.getEmployeeByAuth(auth);
    }
    public void setLoggedInEmployeeRMI(Employee e) throws RemoteException{
        register.setLoggedInEmployee(e);
    }
}
