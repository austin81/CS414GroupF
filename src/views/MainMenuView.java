package views;

import objects.Register;

import javax.swing.*;
import java.awt.*;
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
    private JButton customerButton;

    public MainMenuView(){
        setContentPane(mainMenuPanel);
        this.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        pack();
    }

    public void addComponents(){
        controller.registerComponent("orderViewButton", orderViewButton);
        controller.registerComponent("makeLineViewButton", makeLineViewButton);
        controller.registerComponent("managerControlsButton", managerControlsButton);
        controller.registerComponent("customerButton", customerButton);
        orderViewButton.addActionListener(controller);
        makeLineViewButton.addActionListener(controller);
        managerControlsButton.addActionListener(controller);
        customerButton.addActionListener(controller);
    }
}
