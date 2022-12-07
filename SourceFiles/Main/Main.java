package Main;

import GUI.PurchaserView;
import ItemProfile.ItemProfile;
import Login.LoginMenu;
import ProfileUsers.VendorAccountArray;
import UserClasses.GetUsersFromCSV;
import ItemProfile.getItems;
import UserClasses.UserAccountArray;

import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        GetUsersFromCSV.getUsersFromCSV();
        items = getItems.get_items();
        VendorAccountArray.init();

        //new PurchaserView();
        new LoginMenu();
    }
}
