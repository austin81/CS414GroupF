package views;

import controllers.CollectPaymentListener;
import controllers.WindowManager;
import objects.*;
import controllers.OrderEditListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
    private JButton backButton;
    private JList sauceList;
    private JList toppingList;
    private JList sizeList;
    private Order order;

    public MakelineView(){
        panel1.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //orderList.setCellRenderer(new ComponentMakline());
        //setVisible(true);

        DefaultListCellRenderer renderer0 = (DefaultListCellRenderer) orderList.getCellRenderer();
        DefaultListCellRenderer renderer1 = (DefaultListCellRenderer) sauceList.getCellRenderer();
        DefaultListCellRenderer renderer2 = (DefaultListCellRenderer) sizeList.getCellRenderer();
        DefaultListCellRenderer renderer3 = (DefaultListCellRenderer) toppingList.getCellRenderer();
        renderer0.setHorizontalAlignment(SwingConstants.CENTER);
        renderer1.setHorizontalAlignment(SwingConstants.CENTER);
        renderer2.setHorizontalAlignment(SwingConstants.CENTER);
        renderer3.setHorizontalAlignment(SwingConstants.CENTER);

        orderList.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    //order.getPizza(0).setStatus(PIZZA_STATUS.COMPLETED);

                    //model.getOrder((Integer)orderList.getSelectedValue()).getPizza(0).setStatus(PIZZA_STATUS.COMPLETED);

                    model.getOrder((Integer)orderList.getSelectedValue()).getPizza(0).setStatus(PIZZA_STATUS.COMPLETED);


                    manager.activateWindow(manager.MAKE_LINE, manager.MAKE_LINE);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }

            @Override
            public void keyTyped(KeyEvent e) { }
        });

    }



    public void setOrderList(){
        if(model.getMakelinePizzas() != null){
            orderList.setListData(model.getMakelineID().toArray());
        }
    }

    public void setSizeList(){
        if(model.getMakelinePizzas() != null){
            sizeList.setListData(model.getMakelineSizes().toArray());
        }
    }

    public void setSauceList(){
        if(model.getMakelinePizzas() != null){
            sauceList.setListData(model.getMakelineSauces().toArray());
        }
    }

    public void setToppingList(){
        if(model.getMakelinePizzas() != null){
            toppingList.setListData(model.getMakelineToppings().toArray());
        }
    }

    @Override
    public void update(Observable observable, Object o) {

    }


    public void addComponents() {
        controller.registerComponent("orderList", orderList);
        controller.registerComponent("sizeList", sizeList);
        controller.registerComponent("sauceList", sauceList);
        controller.registerComponent("toppingList", toppingList);
        controller.registerComponent("backButton",  backButton);

        backButton.addActionListener(controller);
    }

}
