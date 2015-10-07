package objects;

/**
 * Created by clark on 10/7/15.
 */
public class Phone {
    private String number;

    public Phone(String number) { this.number = number; }

    public String getNumber() { return number; }

    public void setNumber(String number) { /*check if valid number*/this.number = number;}
}
