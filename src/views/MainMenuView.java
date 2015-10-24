package views;

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
    OrderEditListener oeListener;
    AddOrderView addOrderView;

    public MainMenuView(){
        setContentPane(mainMenuPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        register = new Register();
        oeListener = new OrderEditListener();
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // add authentication here
                oeListener.addModel(register);
                addOrderView = new AddOrderView();
                addOrderView.addRegister(register);
                addOrderView.addController(oeListener);
                addOrderView.addControllers();
                oeListener.addView(addOrderView);
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
