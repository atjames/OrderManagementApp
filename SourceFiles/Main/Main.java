package Main;

import GUI.PurchaseOrderMenuGUI;
import ItemProfile.ItemProfile;
import ProfileUsers.VendorAccountArray;
import UserClasses.UserAccountArray;
import ItemProfile.getItems;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        VendorAccountArray.init();
        items = getItems.get_items();
        UserAccountArray.testAccount();
        JFrame PurchaseOrderMenu = new PurchaseOrderMenuGUI("Purchase Order");
        PurchaseOrderMenu.setVisible(true);
    }
}
