package client;

import common.RegisterInt;
import objects.PizzaCatalog;
import objects.Register;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by clark on 11/20/15.
 */
public class RegisterClient {

    Register register;
    RegisterInt r;

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
            return
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

}