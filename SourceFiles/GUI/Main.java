package GUI;

/*


 */
import GUI.PurchaserView;
import ProfileUsers.Vendor;
import ProfileUsers.VendorAccountArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        String last = "12/2/2222";
        String seas = "12/5/2121";
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date lastorder = formatter.parse(last);
        Date seasonal = formatter.parse(seas);
       Vendor v = new Vendor(0,"zero","b","c","MI","123-123-1234",lastorder,seasonal);
        Vendor v2 = new Vendor(1,"one","b","c","AK","321-321-3214",lastorder,seasonal);
        Vendor v3= new Vendor(2,"two","b","c","AZ","111-111-1111",lastorder,seasonal);
        Vendor v4 = new Vendor(3,"three","b","c","AR","121-121-1212",lastorder,seasonal);
        Vendor v5 = new Vendor(4,"four","b","c","CA","123-123-1234",lastorder,seasonal);
       v.setBalance(15.0);
        VendorAccountArray.addVendor(v);
        VendorAccountArray.addVendor(v2);
        VendorAccountArray.addVendor(v3);
        VendorAccountArray.addVendor(v4);
        VendorAccountArray.addVendor(v5);


        new PurchaserView();
    }
}
