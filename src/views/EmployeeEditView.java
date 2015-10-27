package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class EmployeeEditView extends MyJFrame{
    private JPanel viewContainer;
    public EmployeeEditView(){
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }
    public void addComponents(){

    }
}
