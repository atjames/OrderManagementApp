package Main;

import GUI.ItemMenuGUI;
import GUI.PurchaserView;
import ItemProfile.ItemProfile;
import Login.LoginMenu;
import ProfileUsers.VendorAccountArray;
import UserClasses.UserAccountArray;
import ItemProfile.getItems;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        VendorAccountArray.init();
        items = getItems.get_items();
        new PurchaserView();
        UserAccountArray.testAccount();
        new LoginMenu();
        JFrame ItemMenu = new ItemMenuGUI("Item Menu");
        ItemMenu.setVisible(true);
    }
}
