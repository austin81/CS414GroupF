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
    private JList itemList;
    private JList sideList;


    public MakelineView(){
        panel1.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        //itemList.setCellRenderer(new ComponentMakline());
        //setVisible(true);

        DefaultListCellRenderer renderer0 = (DefaultListCellRenderer) orderList.getCellRenderer();

        renderer0.setHorizontalAlignment(SwingConstants.RIGHT);


        orderList.setFont(new Font("Arial",Font.BOLD,27));
        itemList.setFont(new Font("Arial",Font.BOLD,27));
 //       sideList.setFont(new Font("Arial",Font.BOLD,27));

        orderList.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int numPizzas = model.getOrder(((Integer)orderList.getSelectedValue())).getPizzas().size();

                    for(int i = 0; i < numPizzas; i++) {
                        model.getOrder((Integer) orderList.getSelectedValue()).getPizza(i).setStatus(PIZZA_STATUS.COMPLETED);
                        model.getOrder((Integer) orderList.getSelectedValue()).getSide(i).setStatus(SIDE_STATUS.COMPLETED);
                    }

                    manager.activateWindow(manager.MAKE_LINE, manager.MAKE_LINE);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }

            @Override
            public void keyTyped(KeyEvent e) { }
        });

        itemList.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int itemsBefore = 0;
                    for(int i = 0; i < itemList.getSelectedIndex(); i++){
                        if(orderList.getModel().getElementAt(i) != orderList.getModel().getElementAt(itemList.getSelectedIndex())){
                            itemsBefore++;
                        }
                    }

                    char check = itemList.getSelectedValue().toString().charAt(0);
                    if(check == '['){
                        int side = (Integer)orderList.getModel().getElementAt(itemList.getSelectedIndex());
                        model.getOrder(side).getSide(itemList.getSelectedIndex() - itemsBefore).setStatus(SIDE_STATUS.COMPLETED);
                    }
                    else {
                        int pizza = (Integer) orderList.getModel().getElementAt(itemList.getSelectedIndex());
                        model.getOrder(pizza).getPizza(itemList.getSelectedIndex() - itemsBefore).setStatus(PIZZA_STATUS.COMPLETED);
                    }
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

    public void setItemList(){
        if(model.getMakelinePizzas() != null) {
            itemList.setListData(model.getMakelineItems().toArray());
        }
    }

    public void setSideList(){
        if(model.getMakelineSides() != null){
            //sideList.setListData(model);
        }
    }


    @Override
    public void update(Observable observable, Object o) {

    }


    public void addComponents() {
        controller.registerComponent("orderList", orderList);
        controller.registerComponent("itemList", itemList);
       // controller.registerComponent("sideList", sideList);
        controller.registerComponent("backButton",  backButton);

        backButton.addActionListener(controller);
    }

}
