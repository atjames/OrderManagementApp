package Main;

import GUI.ItemPurchaseOrderStore;
import GUI.PurchaseOrderMenuGUI;
import ItemProfile.ItemProfile;
import ProfileUsers.VendorAccountArray;
import PurchaseOrder.PurchaseOrder;
import UserClasses.UserAccountArray;
import ItemProfile.getItems;

import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();
    public static ArrayList<ItemPurchaseOrderStore> ItemPurchaseOrderStorage = new ArrayList<>();
    public static ArrayList<PurchaseOrder> PurchaseOrders = new ArrayList<>();

    public static void main(java.lang.String[] args) throws IOException, ParseException {


        VendorAccountArray.init();
        items = getItems.get_items();
        PurchaseOrder order = new PurchaseOrder();
        PurchaseOrder order2 = new PurchaseOrder();
        PurchaseOrder order3 = new PurchaseOrder();
        order.createPurchaseOrder("000001","1",100,"12/20/2022");
        order.addPurchaseItems(items.get(0).getItemID());
        PurchaseOrders.add(order);
        order2.addPurchaseItems(items.get(1).getItemID());
        order2.createPurchaseOrder("000002","0",1025,"12/21/2022");
        PurchaseOrders.add(order2);
        order3.addPurchaseItems(items.get(2).getItemID());
        order3.createPurchaseOrder("000003","2",103,"12/15/2022");
        PurchaseOrders.add(order3);
        UserAccountArray.testAccount();
        JFrame PurchaseOrderMenu = new PurchaseOrderMenuGUI("Purchase Order");
        PurchaseOrderMenu.setVisible(true);

    }
}
