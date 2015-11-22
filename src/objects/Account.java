package objects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by clark on 11/21/15.
 *
 * Customer Frequent Buyer Account class. Identified by a Phone number (held by a person).
 * Has an array list of Pizzas which represent free pizzas that the account has
 */
public class Account implements Serializable{

    Phone holder;
    int points;
    ArrayList<Pizza> certificates;

    public Account(Phone p) {
        this.holder = p;
        this.points = 0;
        certificates = new ArrayList<>();
    }

    public int addPoints(int p) {
        return this.points += p;
    }

    public int removePoints(int p) {
        return this.points -= p;
    }

    public void clearPoints() {
        this.points = 0;
    }
}
