package server;

import common.RegisterInt;
import objects.Order;
import objects.PizzaCatalog;
import objects.Register;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

    @Override
    public Register getOrderRMI() throws RemoteException {
        return null;
    }
    public PizzaCatalog updateItemRMI(Object o) throws RemoteException{
        register.getCatalog().updateItem(o);
        return getCatalogRMI();
    }
}
