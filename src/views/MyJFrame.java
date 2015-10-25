package views;

import objects.Register;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MyJFrame extends JFrame implements Observer {
    Register model;

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addModel(Register model){
        this.model = model;
    }
}
