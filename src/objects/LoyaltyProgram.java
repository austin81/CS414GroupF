package objects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by clark on 11/21/15.
 */
public class LoyaltyProgram implements Serializable{

    HashMap<Integer, Pizza> rewards;

    public LoyaltyProgram() {
        rewards = new HashMap<>();
    }

    public void addReward(Integer i, Pizza p) {
        rewards.put(i,p);
    }

    public void removeReward(Pizza p) {
        rewards.remove(p);
    }

    public HashMap<Integer, Pizza> getProgram() {
        return rewards;
    }

    public ArrayList<Object> getProgramArrayList() {
        ArrayList<Object> ret = new ArrayList<>();
        for (HashMap.Entry<Integer,Pizza> entry : rewards.entrySet()) {
            String r = entry.getKey() + " points... " + entry.getValue();
            ret.add(r);
        }
        return ret;
    }
}
