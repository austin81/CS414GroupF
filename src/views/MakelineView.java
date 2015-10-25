package views;

import controllers.CollectPaymentListener;
import controllers.WindowManager;
import objects.*;
import controllers.OrderEditListener;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Tyler on 10/24/15.
 */
public class MakelineView extends JFrame implements Observer{
    private JPanel panel1;
    private JList orderList;
    private JList sizeList;
    private JList sauceList;
    private JList toppingList;
    private JList timeList;
    private Register model;
    private WindowManager manager;

    public MakelineView(){
        panel1.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

//        orderList.setListData(model.getOrders().toArray());

        //setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addModel(Register model){
        this.model = model;
    }


    public void addComponents() {

    }
    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }
}
