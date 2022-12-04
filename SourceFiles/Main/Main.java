package Main;

import ItemProfile.ItemProfile;
import Login.LoginMenu;
import UserClasses.UserAccountArray;

import java.util.ArrayList;

public class Main
{
    public static ArrayList<ItemProfile> items = new ArrayList<>();

    public static void main(String[] args)
    {
        UserAccountArray.testAccount();
        new LoginMenu();
    }
}
