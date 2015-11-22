package views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by clark on 11/21/15.
 */
public class LoyaltyView extends MyJFrame{
    private JPanel viewContainer;
    private JButton backButton;
    private JPanel priceContainer;
    private JButton cancelButton;
    private JButton deleteButton;
    private JButton saveButton;
    private JList certificateList;
    private JTextArea priceEditText;
    private JComboBox toppingsComboBox;
    private JTextArea redeemedAtEditText;
    private JComboBox sizeComboBox;
    private JPanel shortnameContainer;

    public LoyaltyView() {
        viewContainer.setPreferredSize(new Dimension(getToolkit().getScreenSize().width, getToolkit().getScreenSize().height));
        setContentPane(viewContainer);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void addComponents() {
        controller.registerComponent("certificateList", certificateList);
        controller.registerComponent("priceEditText", priceEditText);
        controller.registerComponent("redeemedAtEditText", redeemedAtEditText);
        controller.registerComponent("cancelButton", cancelButton);
        controller.registerComponent("deleteButton", deleteButton);
        controller.registerComponent("saveButton", saveButton);
        controller.registerComponent("backButton", backButton);
        controller.registerComponent("sizeComboBox", sizeComboBox);
        controller.registerComponent("priceContainer", priceContainer);
        controller.registerComponent("shortnameContainer", shortnameContainer);
        controller.registerComponent("toppingsComboBox", toppingsComboBox);

        certificateList.addListSelectionListener(controller);

        cancelButton.addActionListener(controller);
        deleteButton.addActionListener(controller);
        saveButton.addActionListener(controller);
        backButton.addActionListener(controller);

        toppingsComboBox.addActionListener(controller);
        sizeComboBox.addActionListener(controller);
    }
}
