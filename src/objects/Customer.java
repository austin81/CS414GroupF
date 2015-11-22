package objects;

import java.io.Serializable;

/**
 * Created by berryhillb on 11/22/15.
 */
public class Customer extends Person implements Serializable {
    public Customer(){
        super();
    }
    public Customer(String name, Address address, Phone phone, String username, String authentication, ROLE role) {
        super(name,address,phone);

    }
}
