package views;

import controllers.CustomerListener;
import controllers.WindowManager;
import objects.Order;
import objects.Register;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerView extends MyJFrame {
    private JPanel customerContainer;
    private JTextArea phoneEditText;
    private JTextArea nameEditText;
    private JTextArea streetEditText;
    private JTextArea cityEditText;
    private JTextArea stateEditText;
    private JTextArea zipEditText;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton clearButton;
    private CustomerListener controller;
    private WindowManager manager;
    private Order order;
    public CustomerView(){
        customerContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(customerContainer);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        //setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addController(CustomerListener controller){
        this.controller = controller;
    }

    public void addWindowManager(WindowManager manager){
        this.manager = manager;
    }

    public void addComponents(){
        controller.registerComponent("phoneEditText", phoneEditText);
        controller.registerComponent("nameEditText", nameEditText);
        controller.registerComponent("streetEditText", streetEditText);
        controller.registerComponent("cityEditText", cityEditText);
        controller.registerComponent("stateEditText", stateEditText);
        controller.registerComponent("zipEditText", zipEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("clearButton", clearButton);
        controller.registerComponent("saveButton", saveButton);

        cancelButton.addActionListener(controller);
        clearButton.addActionListener(controller);
        saveButton.addActionListener(controller);
    }
}
