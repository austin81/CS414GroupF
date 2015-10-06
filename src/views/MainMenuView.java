package views;

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
    private JPanel mainMenuPanel;
    public static final Register register = new Register();
    public MainMenuView(){
        setContentPane(mainMenuPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // add authentication here
                AddOrderView addOrderView = new AddOrderView();
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
