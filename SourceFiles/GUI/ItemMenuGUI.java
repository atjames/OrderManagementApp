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
                JFrame CreateItemFrame = new CreateItemGUI("Create Item");
                CreateItemFrame.setVisible(true);
            }
        });
        showItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CreateSearchFrame = new  JFrame("Show Items");
                CreateSearchFrame.setSize(10,10);
                CreateSearchFrame.add(new ItemTableGUI().panel1);
                CreateSearchFrame.setVisible(true);
                CreateSearchFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                CreateSearchFrame.setLocationRelativeTo(null);
            }
        });
        deleteItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame DeleteItemFrame = new DeleteItemGUI("Delete Item");
                DeleteItemFrame.setVisible(true);

            }
        });
        updateItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CreateUpdateFrame = new UpdateItemSelectorGUI("Update Item");
                CreateUpdateFrame.setVisible(true);
            }
        });
        searchItemsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame CreateSearchFrame = new SearchItemsGUI("Search for Item");
                CreateSearchFrame.setVisible(true);
            }
        });
    }


}
