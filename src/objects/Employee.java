package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 10/5/15.
 */
public class Employee extends Person {
    private int userID;
    private String username;
    private String authentication;
    public Employee(String name, Address address, Phone phone, String username, String authentication, int userID) {
        super(name,address,phone);
        this.username = username;
        this.authentication = authentication;
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthentication() { return authentication; }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }
}
