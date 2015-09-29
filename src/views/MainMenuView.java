package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by darkbobo on 9/28/15.
 */
public class MainMenuView extends JFrame{
    private JButton addOrderButton;
    private JButton makeLineViewButton;
    private JButton managerControlsButton;
    private JPanel mainMenuPanel;

    public MainMenuView(){
        setContentPane(mainMenuPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        makeLineViewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        managerControlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        setVisible(true);
    }
}
