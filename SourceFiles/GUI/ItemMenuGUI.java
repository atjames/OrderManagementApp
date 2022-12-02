package GUI;

import ItemProfile.writeCSV;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Main.items;


/*
@author: Andrew James
 */

public class ItemMenuGUI extends JFrame {
    private JPanel mainPanel;
    private JButton createItemButton;
    private JButton searchItemsButton;
    private JButton deleteItemsButton;
    private JButton showItemsButton;

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
    }


}
