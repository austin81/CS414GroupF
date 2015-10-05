package objects;

import java.util.ArrayList;

/**
 * Created by darkbobo on 10/5/15.
 */
public class User {
    private int userID;
    private String username;
    private String fullname;
    private ArrayList<Address> addresses;
    private String authentication;
    public User(){
        setUserID(1111);
        setUsername("User1");
        setFullname("User One");
        addAddress(new Address("123 Blah Street", "Foco", "CO", "80526"));
        setAuthentication("1111");
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

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }
    public Address getAddress(int index){
        return this.addresses.get(index);
    }
    public void addAddress(Address address) {
        if(this.addresses == null){
            this.addresses = new ArrayList<>();
        }
        this.addresses.add(address);
    }
    public void setAddresses(ArrayList<Address> addresses) {
        if(this.addresses == null){
            this.addresses = new ArrayList<>();
        }
        this.addresses.addAll(addresses);
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }
}
