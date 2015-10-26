package views;

import objects.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by darkbobo on 9/28/15.
 */
public class MainMenuView extends MyJFrame {
    private JButton orderViewButton;
    private JButton makeLineViewButton;
    private JButton managerControlsButton;
    public JPanel mainMenuPanel;

    public MainMenuView(){
        setContentPane(mainMenuPanel);
        pack();
        model = new Register();

        orderViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // add authentication here
                manager.activateWindow("mainMenu", "orderList");
            }
        });
        makeLineViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                manager.activateWindow("mainMenu", "makeline");
            }
        });
        managerControlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        //setVisible(true);
    }

    public void addComponents(){
        controller.registerComponent("orderViewButton", orderViewButton);
        controller.registerComponent("makeLineViewButton", makeLineViewButton);
        controller.registerComponent("managerControlsButton", managerControlsButton);
        orderViewButton.addActionListener(controller);
        makeLineViewButton.addActionListener(controller);
        managerControlsButton.addActionListener(controller);
    }
}
