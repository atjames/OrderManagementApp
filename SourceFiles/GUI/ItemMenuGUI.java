package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
@author: Andrew James
 */

public class ItemMenuGUI extends JFrame {
    private JPanel mainPanel;
    private JButton createItemButton;
    private JButton showItemsButton;
    private JButton deleteItemsButton;
    private JButton searchItemsButton;
    private JButton updateItemsButton;

    public ItemMenuGUI(String title){
            super(title);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainPanel);
            this.pack();
            setLocationRelativeTo(null);

            createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CreateItemFrame = new CreateItemForm("Create Items");
                CreateItemFrame.setVisible(true);
                ItemMenuGUI.super.dispose();
            }
        });
        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CreateSearchFrame = new  JFrame("Show Items");
                CreateSearchFrame.setSize(1250,300);
                CreateSearchFrame.add(new itemTableForm().panel1);
                CreateSearchFrame.setVisible(true);
                CreateSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                CreateSearchFrame.setLocationRelativeTo(null);
            }
        });
    }


}
