package GUI;

import ItemProfile.ItemProfile;
import PurchaseOrder.PurchaseOrder;
import org.jdatepicker.JDatePicker;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import ItemProfile.GenerateItemID;

import static Main.Main.*;
import static ProfileUsers.VendorAccountArray.vendors;


public class PurchaseOrderCreatorGUI extends JFrame{


    private JPanel mainPanel;
    private JList selectedItems;
    private JList itemList;
    private JButton addButton;
    private JButton submitPurchaseOrderButton;
    private JDatePicker datePicker;

    public PurchaseOrderCreatorGUI(String title,String vendorName){

        super(title);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setBounds(100,100,800,500);
        setLocationRelativeTo(null);
        double salesTax = 0.06;
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date(System.currentTimeMillis());
        String vendorID = null;
        DefaultListModel<ItemProfile> model = new DefaultListModel();
        itemList.setModel(model);

        for(ItemProfile item : items)
        {
            for (int i = 0; i < vendors.length; i++)
            {
                if((vendorName == vendors[i].getFullName() && ((item.getExpireDate().compareTo(currentDate)) > 0)))
                {
                    vendorID = String.valueOf(vendors[i].getUserID());
                    if(vendorID.matches(item.getVendorID()) && item.getQuantityonHand()>0){

                        model.addElement(item);
                    }
                }
            }
        }

        if (itemList.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(null, "Vendor Selected has no current items! Returning to menu.");
            JFrame Menu = new PurchaseOrderMenuGUI("Purchaser Menu");
            Menu.setVisible(true);
            this.dispose();
        }

        DefaultListModel model2 = new DefaultListModel();
        selectedItems.setModel(model2);


        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(selectedItems.getModel().getSize() !=5)
                {
                    JFrame ItemInfo = new PurchaseOrderItemInfoGUI("Item Info",itemList.getSelectedValue().toString());
                    ItemInfo.setVisible(true);
                    model2.addElement(itemList.getSelectedValue());
                    model.removeElement(itemList.getSelectedValue());
                }
            }
        });


        submitPurchaseOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.lang.String needByDate = (datePicker.getModel().getMonth() + 1) + "/" + (datePicker.getModel().getDay()) + "/" + (datePicker.getModel().getYear());
                Date currentDate = new Date(System.currentTimeMillis());
                Date expireDateFor;
                try {
                    expireDateFor = formatter.parse(needByDate);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                if ((expireDateFor.compareTo(currentDate)) < 0){
                    JOptionPane.showMessageDialog(null, "Date invalid. Please put a Need By Date for a future date!");
                    return;
                }else if(selectedItems.getModel().getSize() ==0)
                {
                    JOptionPane.showMessageDialog(null, "Please select at least one item!");
                    return;
                }else{

                    boolean doesExist = true;
                    java.lang.String PurchaseID = GenerateItemID.GenerateItemID();
                    while (doesExist) {
                        for (PurchaseOrder itemTest : PurchaseOrders) {
                            if (Objects.equals(itemTest.getPurchaseOrderID(), PurchaseID)) {
                                doesExist = true;
                                PurchaseID = GenerateItemID.GenerateItemID();
                            } else {
                                doesExist = false;
                            }
                        }

                    }
                    PurchaseOrder order = new PurchaseOrder();
                    double balance = 0;
                    for(ItemPurchaseOrderStore items1 : ItemPurchaseOrderStorage){
                        order.addPurchaseItems(items1.getItemID());
                        balance += (items1.getamountPurchased()*items1.getBalance());
                        for(ItemProfile items2: items){
                            if(items1.getItemID().equals(items2.getItemID()))
                            {
                                items2.setQuantityonHand(items2.getQuantityonHand()-items1.getamountPurchased());
                            }
                        }
                    }
                    balance = balance * (1+salesTax);
                    System.out.println(balance);
                    try {
                        String vendorID2 = null;
                        for (int i = 0; i < vendors.length; i++)
                        {
                            if(vendorName == vendors[i].getFullName())
                            {
                                vendorID2 = String.valueOf(vendors[i].getUserID());
                                vendors[i].addToBalance(balance);

                            }
                        }
                        order.createPurchaseOrder(PurchaseID,vendorID2,balance,needByDate);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    ItemPurchaseOrderStorage.removeAll(ItemPurchaseOrderStorage);
                    PurchaseOrders.add(order);
                    JOptionPane.showMessageDialog(null, "Successfully created purchased order!");

                    int totalOutOfStock = 0;

                    for(ItemProfile item : items)
                    {
                        if(item.getQuantityonHand() == 0){
                            totalOutOfStock+=1;
                        }
                    }
                    if(totalOutOfStock >= 2){
                        JOptionPane.showMessageDialog(null, "Two items have gone out of stock!");
                    }

                    PurchaseOrderCreatorGUI.super.dispose();
                    JFrame PurchaseMenu = new PurchaseOrderMenuGUI("Purchase Order");
                    PurchaseMenu.setVisible(true);
                }

            }
        });
    }



}
