package views;

import controllers.CollectPaymentListener;
import controllers.WindowManager;
import objects.*;
import controllers.OrderEditListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Tyler on 10/24/15.
 */
public class MakelineView extends MyJFrame {
    private JPanel panel1;
    private JList orderList;

    public MakelineView(){
        panel1.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();

        //setVisible(true);
    }

    public void setOrderList(){
        if(model.getMakelinePizzas() != null){
            orderList.setListData(model.getMakelinePizzas().toArray());
        }

    }

    @Override
    public void update(Observable observable, Object o) {

    }


    public void addComponents() {
        controller.registerComponent("orderList", orderList);

    }

}
