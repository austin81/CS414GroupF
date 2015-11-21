package client;

import common.RegisterInt;
import objects.Order;
import objects.PizzaCatalog;
import objects.Register;

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

    public RegisterClient(String url) {
        r = null;
        try {
            r = (RegisterInt)
                    Naming.lookup(url);
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


    public int addOrder(Order order) {
        try{
            return r.addOrderRMI(order);
        } catch(RemoteException re) {
            System.out.println(re);
            return 0;
        }
    }
}
