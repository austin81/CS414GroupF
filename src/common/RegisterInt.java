package common;

import objects.Employee;
import objects.Order;
import objects.PizzaCatalog;
import objects.Register;
import objects.Employee;
import java.util.ArrayList;

/**
 * Created by clark on 11/20/15.
 */
public interface RegisterInt extends java.rmi.Remote{
    PizzaCatalog getCatalogRMI() throws java.rmi.RemoteException;
    PizzaCatalog deleteItemRMI(Object o) throws java.rmi.RemoteException;
    PizzaCatalog updateItemRMI(Object o) throws java.rmi.RemoteException;
    Order getOrderRMI(int o) throws java.rmi.RemoteException;
    ArrayList<Order> getOrdersRMI() throws java.rmi.RemoteException;
    PizzaCatalog addItemRMI(Object o) throws java.rmi.RemoteException;
    void updateOrderRMI(int orderId, Order order) throws java.rmi.RemoteException;
    void removeOrderRMI(int orderId) throws java.rmi.RemoteException;
    int getOrderIDByPhone(String phoneNumber) throws java.rmi.RemoteException;
    int addOrderRMI(Order order)throws java.rmi.RemoteException;
    void removeEmployeeRMI(Employee employee) throws java.rmi.RemoteException;
    void updateEmployee(int ID, Employee employee) throws java.rmi.RemoteException;
    Employee getEmployeeByAuthRMI(String auth) throws java.rmi.RemoteException;
    void setLoggedInEmployeeRMI(Employee e) throws java.rmi.RemoteException;
    void addEmployee(Employee e) throws java.rmi.RemoteException;
}
