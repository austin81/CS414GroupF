package views;

import objects.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;

/**
 * Created by Tyler on 10/24/15.
 */
public class MakelineView extends MyJFrame {
    private JPanel panel1;
    private JList orderList;
    private JButton backButton;
    private JList itemList;
    private JButton refreshButton;
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

        // timer does not work
        // the timer refreshes every 15 seconds to make line view no matter what window you're currently in

//        Timer timer = new Timer(15000, new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                if( "need something here" ) {
//                    manager.activateWindow(manager.MAKE_LINE, manager.MAKE_LINE);
//                    System.out.println("refreshed");
//                }
//                else{
//                    System.out.println("tried to refresh");
//                }
//            }
//        });
//
//        timer.setRepeats(true);
//        timer.setCoalesce(true);
//        timer.start();

        orderList.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int orderNum = (Integer) orderList.getSelectedValue();
                    int numPizzas = model.getOrder(orderNum).getPizzas().size();

                    for(int i = 0; i < numPizzas; i++) {
                        Order completed = model.getOrder(orderNum);
                        completed.getPizza(i).setStatus(PIZZA_STATUS.COMPLETED);
                        if(!completed.getSides().isEmpty()) {
                            completed.getSide(i).setStatus(PIZZA_STATUS.COMPLETED);
                        }
                        model.updateOrder(orderNum,completed);
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

                    int itemsBeforePizza = 0;
                    for(int i = 0; i < itemList.getSelectedIndex(); i++){
                        if(orderList.getModel().getElementAt(i) != orderList.getModel().getElementAt(itemList.getSelectedIndex())){
                            itemsBeforePizza++;
                        }
                    }

                    char check = itemList.getSelectedValue().toString().charAt(0);
                    if(check == '['){
                        int order = (Integer)orderList.getModel().getElementAt(itemList.getSelectedIndex());
                        Order completed = model.getOrder(order);
                        completed.getSide(0).setStatus(PIZZA_STATUS.COMPLETED);
                        model.updateOrder(order,completed);
                    }
                    else {
                        int pizza = (Integer) orderList.getModel().getElementAt(itemList.getSelectedIndex());
                        Order completed = model.getOrder(pizza);
                        completed.getPizza(itemList.getSelectedIndex() - itemsBeforePizza).setStatus(PIZZA_STATUS.COMPLETED);
                        model.updateOrder(pizza,completed);
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
        controller.registerComponent("backButton",  backButton);
        controller.registerComponent("refreshButton", refreshButton);

        backButton.addActionListener(controller);
        refreshButton.addActionListener(controller);
    }

}
