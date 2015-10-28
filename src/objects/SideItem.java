package objects;

/**
 * Created by darkbobo on 10/26/15.
 */
public class SideItem extends OrderItem {
    int itemID;
    String name;
    SIDE_STATUS status;

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

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public void setStatus(SIDE_STATUS status){ this.status = status; }

    public SIDE_STATUS getStatus(){ return status; }

    public void sendSideToMakeline(){
        this.status = SIDE_STATUS.MAKELINE;
    }
}
