package objects;

/**
 * Created by darkbobo on 9/28/15.
 */
public class PizzaSize extends Topping{
    double price;

    public PizzaSize(String shortName, double price) {
        super(shortName);
        this.price = price;
    }

    public PizzaSize(String shortName, String fullName, double price) {
        super(shortName, fullName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
