package common;

import objects.*;
import objects.Employee;
import java.util.ArrayList;
import java.util.HashMap;

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
    void clearLoggedInEmployeeRMI() throws java.rmi.RemoteException;
    ArrayList<Employee> getEmployeesRMI() throws java.rmi.RemoteException;
    void addEmployeeRMI(Employee e) throws java.rmi.RemoteException;
    ArrayList<Pizza> getMakelinePizzas() throws java.rmi.RemoteException;
    ArrayList<String> getMakelineSides() throws java.rmi.RemoteException;
    ArrayList<Integer> getMakelineIDRMI() throws java.rmi.RemoteException;
    ArrayList<String> getMakelineItemsRMI() throws java.rmi.RemoteException;
    LoyaltyProgram getLoyaltyProgramRMI() throws java.rmi.RemoteException;
}
