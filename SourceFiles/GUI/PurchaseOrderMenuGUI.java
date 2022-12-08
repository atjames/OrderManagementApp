package GUI;

import ProfileUsers.VendorAccountArray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import static Main.Main.ItemPurchaseOrderStorage;

public class PurchaseOrderMenuGUI extends JFrame {
    private JComboBox vendorList;
    private JButton submitButton;
    private JPanel mainPanel;
    private JButton viewPurchaseOrdersButton;

    public PurchaseOrderMenuGUI(String title) {
        super(title);
        ItemPurchaseOrderStorage.removeAll(ItemPurchaseOrderStorage);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(100,100,500,500);
        setLocationRelativeTo(null);
        Date currentDate = new Date(System.currentTimeMillis());
        for(int i = 0; i < VendorAccountArray.vendors.length; i++)
        {
            vendorList.addItem(VendorAccountArray.vendors[i].getFullName());
        }

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedVendor = vendorList.getSelectedItem().toString();
                new PurchaseOrderCreatorGUI("Create Order", selectedVendor);
                PurchaseOrderMenuGUI.super.dispose();
            }
        });
        viewPurchaseOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedVendor = vendorList.getSelectedItem().toString();
                JFrame OrderTable = new  JFrame("Show Items");
                OrderTable.setSize(500,500);
                OrderTable.add(new PurchaseOrderTableGUI().panel1);
                OrderTable.setVisible(true);
                OrderTable.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                OrderTable.setLocationRelativeTo(null);
            }
        });
    }
}
