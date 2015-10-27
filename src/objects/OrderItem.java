package objects;

/**
 * Created by darkbobo on 10/27/15.
 */
public class OrderItem {
    double price;
    int orderID;
    public OrderItem(){

    }
    public OrderItem(double price){
        this.price = price;
    }
    public OrderItem(double price, int orderID){
        this.price = price;
        this.orderID = orderID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
}
