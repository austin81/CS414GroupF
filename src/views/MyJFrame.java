package views;

import client.RegisterClient;
import controllers.MyActionListener;
import controllers.WindowManager;
import objects.Register;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by darkbobo on 10/25/15.
 */
public class MyJFrame extends JFrame implements Observer {
    RegisterClient model;
    MyActionListener controller;
    WindowManager manager;
    public MyJFrame(){
        super();
    }

    @Override
    public void update(Observable observable, Object o) {

    }

    public void addModel(RegisterClient model){
        this.model = model;
    }

    public void addController(MyActionListener controller){
        this.controller = controller;
    }

    public void addWindowManager(WindowManager windowManager){
        this.manager = windowManager;
    }

    public void addComponents(){

    }
}
