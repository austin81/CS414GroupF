package common;

import objects.PizzaCatalog;

import java.util.ArrayList;

/**
 * Created by clark on 11/20/15.
 */
public interface RegisterInt extends java.rmi.Remote{
    PizzaCatalog getCatalogRMI() throws java.rmi.RemoteException;
    PizzaCatalog deleteItemRMI(Object o) throws java.rmi.RemoteException;
}
