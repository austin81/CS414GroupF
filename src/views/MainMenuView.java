package views;

import controllers.CollectPaymentListener;
import controllers.CustomerListener;
import controllers.OrderEditListener;
import objects.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by darkbobo on 9/28/15.
 */
public class MainMenuView extends JFrame{
    private JButton addOrderButton;
    private JButton makeLineViewButton;
    private JButton managerControlsButton;
    public JPanel mainMenuPanel;
    Register register;
    CustomerListener customerListener;
    OrderEditListener oeListener;
    CollectPaymentListener collectPaymentListener;
    CustomerView customerView;
    AddOrderView addOrderView;
    CollectPaymentView collectPaymentView;

    public MainMenuView(){
        setContentPane(mainMenuPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register = new Register();



        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // add authentication here


                addOrderView = new AddOrderView();
                addOrderView.addModel(register);
                addOrderView.addController(register.getOrderEditListener());
                addOrderView.addComponents();

                setVisible(false);
            }
        });
        makeLineViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        managerControlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        setVisible(true);
    }
}
