package controllers;

import objects.Pizza;
import views.MakelineView;

import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by Tyler on 10/25/15.
 */
public class MakelineListener extends MyActionListener {

    public MakelineListener(){
        components = new HashMap<>();
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        System.out.println(command);
        System.out.println(actionEvent.paramString());
        Pizza pizza = new Pizza();
        switch (actionEvent.getActionCommand()) {

        }
    }
}