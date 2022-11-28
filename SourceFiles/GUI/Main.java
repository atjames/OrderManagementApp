package GUI;

/*


 */
import GUI.PurchaserView;
import ProfileUsers.Vendor;
import ProfileUsers.VendorAccountArray;

public class Main {
    public static void main(String[] args) {

       Vendor v = new Vendor(0,"zero","b","c","D","e");
        Vendor v2 = new Vendor(1,"one","b","c","D","e");
        Vendor v3= new Vendor(2,"two","b","c","D","e");
        Vendor v4 = new Vendor(3,"three","b","c","D","e");
        Vendor v5 = new Vendor(4,"four","b","c","D","e");
       v.setBalance(15.0);
        VendorAccountArray.addVendor(v);
        VendorAccountArray.addVendor(v2);
        VendorAccountArray.addVendor(v3);
        VendorAccountArray.addVendor(v4);
        VendorAccountArray.addVendor(v5);


        new PurchaserView();
    }
}
