package objects;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by clark on 11/20/15.
 */
public class RegisterRMI extends UnicastRemoteObject implements RegisterInt {

    Register r;

    public RegisterRMI() throws RemoteException{
        super();
        r = new Register();
    }
    public PizzaCatalog getCatalogRMI() throws RemoteException{
        return r.getCatalog();
    }
}
