package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 10/5/15.
 */
public class Employee extends Person {
    private int userID;
    private String username;
    private String authentication;
    private Role role;
    public Employee(){
        super();
    }
    public Employee(String name, Address address, Phone phone, String username, String authentication, Role role) {
        super(name,address,phone);
        this.username = username;
        this.authentication = authentication;
        this.role = role;
    }

    @Override
    public String toString(){
        return getUserID() + " " + getName() + " " + getRole().name;
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

    public void setRole(Role role){
        this.role = role;
    }

    public Role getRole(){
        return role;
    }

}
