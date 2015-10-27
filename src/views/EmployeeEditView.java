package views;

import objects.Role;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditView extends MyJFrame{
    private JPanel viewContainer;
    private JList employeeList;
    private JTextArea nameEditText;
    private JTextArea phoneEditText;
    private JTextArea streetEditText;
    private JTextArea cityEditText;
    private JTextArea stateEditText;
    private JTextArea zipEditText;
    private JButton cancelButton;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton backButton;
    private JButton setAuthenticationCodeButton;
    private JComboBox roleComboBox;

    public EmployeeEditView(){
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public void addComponents(){
        controller.registerComponent("employeeList", employeeList);
        controller.registerComponent("nameEditText", nameEditText);
        controller.registerComponent("phoneEditText", phoneEditText);
        controller.registerComponent("streetEditText", streetEditText);
        controller.registerComponent("cityEditText", cityEditText);
        controller.registerComponent("roleComboBox", roleComboBox);
        controller.registerComponent("stateEditText", stateEditText);
        controller.registerComponent("zipEditText", zipEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("deleteButton", deleteButton);
        controller.registerComponent("backButton", backButton);
        controller.registerComponent("setAuthenticationCodeButton", setAuthenticationCodeButton);

        employeeList.setCellRenderer(new ComponentEmployeeEdit());

        for(Role role : model.getRoles().values()){
            roleComboBox.addItem(role.toString());
        }

        cancelButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        backButton.addActionListener(controller);
        setAuthenticationCodeButton.addActionListener(controller);
    }
}
