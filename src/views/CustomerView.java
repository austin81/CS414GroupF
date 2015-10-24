package views;

import controllers.CustomerListener;
import objects.Order;
import objects.Register;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/24/15.
 */
public class CustomerView extends JFrame implements Observer{
    private JPanel customerContainer;
    private JTextField textField1;
    private JTextField streetTextField;
    private JTextField cityTextField;
    private JTextField textField2;
    private JTextArea phoneEditText;
    private JTextArea nameEditText;
    private JTextArea streetEditText;
    private JTextArea cityEditText;
    private JTextField stateTextField;
    private JTextField zipTextField;
    private JTextArea stateEditText;
    private JTextArea zipEditText;
    private Register model;
    private CustomerListener controller;
    private Order order;
    public CustomerView(){
        customerContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(customerContainer);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        pack();
        setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
