package controllers;

import objects.Employee;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditListener extends MyActionListener {

    public EmployeeEditListener(){
        components = new HashMap<>();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        switch (command){
            case "Back":
                manager.activateWindow(manager.EMPLOYEE_EDIT, manager.MANAGE_MAIN);
                resetView();
                break;
            case "Delete":

                break;
            case "Set Authentication Code":

                break;
            case "Cancel":

                break;
            case "Save":

                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        String employeeButtonText = list.getSelectedValue().toString();
        Employee employee = null;
        for(Employee emp : model.getEmployees()){
            System.out.println(emp.toString());
            if(emp.toString().equals(employeeButtonText)){
                employee = emp;
            }
        }
        if(employee != null){
            ((JTextArea)components.get("nameEditText")).setText(employee.getName());
            ((JTextArea)components.get("phoneEditText")).setText(employee.getPhoneNumbers().get(0).getNumber());
            ((JTextArea)components.get("streetEditText")).setText(employee.getAddress(0).getStreetAddress());
            ((JTextArea)components.get("cityEditText")).setText(employee.getAddress(0).getCity());
            ((JTextArea)components.get("stateEditText")).setText(employee.getAddress(0).getState());
            ((JTextArea)components.get("zipEditText")).setText(employee.getAddress(0).getZipcode());
            ((JComboBox)components.get("roleComboBox")).setSelectedItem(employee.getRole().toString());
        }
    }

    public void resetView(){
        ((JList)components.get("employeeList")).setListData(model.getEmployees().toArray());
        clearEditTextFields();
    }
    public void clearEditTextFields(){
        ((JTextArea)components.get("nameEditText")).setText("");
        ((JTextArea)components.get("phoneEditText")).setText("");
        ((JTextArea)components.get("streetEditText")).setText("");
        ((JTextArea)components.get("cityEditText")).setText("");
        ((JTextArea)components.get("stateEditText")).setText("");
        ((JTextArea)components.get("zipEditText")).setText("");
    }
}
