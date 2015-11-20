package objects;

import java.io.Serializable;

/**
 * Created by darkbobo on 9/28/15.
 */
public class Sauce extends Topping implements Serializable{

    public Sauce(String shortName) {
        super(shortName);
    }

    public Sauce(String shortName, String fullName) {
        super(shortName, fullName);
    }
}
