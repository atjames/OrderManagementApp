package Main;

import GUI.PurchaserView;
import ItemProfile.ItemProfile;
import Login.LoginMenu;
import ProfileUsers.VendorAccountArray;
import UserClasses.UserAccountArray;

import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();

    public static void main(String[] args)
    {
        VendorAccountArray.init();

        new PurchaserView();
        UserAccountArray.testAccount();
        new LoginMenu();
    }
}
