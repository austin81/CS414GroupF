package controllers;

import objects.Address;
import objects.Employee;
import objects.Phone;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditListener extends MyActionListener {
    private Employee employee;

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
                if(employee != null) {
                    model.removeEmployee(employee);
                    resetView();
                }
                break;
            case "Set Authentication Code":

                break;
            case "Cancel":
                resetView();
                break;
            case "Save":
                Address address = new Address();
                address.setCity(((JTextArea) components.get("cityEditText")).getText());
                address.setState(((JTextArea) components.get("stateEditText")).getText());
                address.setStreetAddress(((JTextArea) components.get("streetEditText")).getText());
                address.setZipcode(((JTextArea) components.get("zipEditText")).getText());
                ArrayList<Address> addresses = new ArrayList<>();
                addresses.add(address);

                Phone phone = new Phone(((JTextArea)components.get("phoneEditText")).getText());
                ArrayList<Phone> phones = new ArrayList<>();
                phones.add(phone);

                boolean isNew = false;
                if(employee == null){
                    // add new employee
                    employee = new Employee();
                    isNew = true;
                }
                employee.setAddresses(addresses);
                employee.setPhoneNumbers(phones);
                employee.setName(((JTextArea) components.get("nameEditText")).getText());

                String roleKey = "";
                switch (((JComboBox)components.get("roleComboBox")).getSelectedItem().toString()){
                    case "Manager":
                        roleKey = model.MANAGER_ROLE;
                        break;
                    case "Cashier":
                        roleKey = model.CASHIER_ROLE;
                        break;
                    case "Chef":
                        roleKey = model.CHEF_ROLE;
                        break;
                }
                employee.setRole(model.getRoles().get(roleKey));

                if(isNew) {
                    model.addEmployee(employee);
                }else{
                    // save existing
                    model.updateEmployee(employee.getUserID(), employee);
                }
                resetView();
                break;
        }
    }
    @Override
    public void valueChanged(ListSelectionEvent event) {
        System.out.println(event.toString());
        JList list = (JList) event.getSource();
        String employeeButtonText = list.getSelectedValue().toString();
        employee = null;
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
        employee = null;
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
