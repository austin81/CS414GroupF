package views;

import javax.swing.*;
import java.awt.*;

/**
 * Created by darkbobo on 10/27/15.
 */
public class MenuEditView extends MyJFrame {

    private JPanel viewContainer;
    private JList menuItemList;
    private JTextArea itemNameEditText;
    private JTextArea shortNameEditText;
    private JTextArea priceEditText;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JButton backButton;
    private JComboBox typeComboBox;

    public MenuEditView(){
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void addComponents(){

    }
}
