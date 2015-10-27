package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class ManagerMainView extends MyJFrame {

    private JPanel viewContainer;
    private JButton manageUsersButton;
    private JButton manageMenuButton;

    public ManagerMainView() {
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void addComponents(){
        controller.registerComponent("manageUsersButton", manageUsersButton);
        controller.registerComponent("manageMenuButton", manageMenuButton);

        manageUsersButton.addActionListener(controller);
        manageMenuButton.addActionListener(controller);
    }
}
