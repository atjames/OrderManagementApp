package GUI;

import GUI.PurchaserView;
import ProfileUsers.ProfileAccountArray;
import ProfileUsers.Vendor;

public class Main {
    public static void main(String[] args) {

       Vendor v = new Vendor(0,"a","b","c","D","e");
        ProfileAccountArray.addProfile(v);
        new PurchaserView();
    }
}
