package objects;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by clark on 11/20/15.
 */
public class ManagerClient {
    public static void main(String[] args) {
        RegisterInt b = null;
        try {
            b = (RegisterInt)
                    Naming.lookup("rmi://" + args[0] + ":" + args[1] + "/Service");
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

        try {
            System.out.println(b.getCatalogRMI());
        } catch (RemoteException re) {
            System.out.println("RemoteException: ");
            System.out.println(re);
            System.exit(-1);
        }
    }
}
