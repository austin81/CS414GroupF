package objects;

/**
 * Created by darkbobo on 10/26/15.
 */
public class SideItem extends OrderItem {
    String name;
    double price;

    public SideItem(){
        super();
    }
    public SideItem(String name, double price){
        super(price);
        this.name = name;
    }

    @Override
    public String toString(){
        return getName() + "   " + getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
