package GUI;

import ItemProfile.ItemProfile;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ItemProfile.writeCSV;

import static Main.Main.items;
public class DeleteItemGUI extends JFrame {


    private JButton deleteButton;
    private JComboBox itemBox;
    private JPanel mainPanel;

    public DeleteItemGUI (String title)
    {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        setSize(500, 500);
        setLocationRelativeTo(null);

        for(ItemProfile item : items){

            //Only displayed items that can be deleted
            if(item.getTotalPurchaseOrders() == 0 && item.getTotalInvoices() == 0){
                itemBox.addItem(item);
            }

        }


        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Item successfully deleted!");
                JFrame ItemMenuGUI = new ItemMenuGUI("Items Menu");
                items.remove(itemBox.getSelectedItem());
                writeCSV.write_items(items);
                DeleteItemGUI.super.dispose();
            }
        });
    }


}
