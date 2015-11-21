package common;

import objects.Order;
import objects.PizzaCatalog;
import objects.Register;

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
    void updateOrderRMI(int orderId, Order order) throws java.rmi.RemoteException;
    void removeOrderRMI(int orderId) throws java.rmi.RemoteException;
}
