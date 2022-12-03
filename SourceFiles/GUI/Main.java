package GUI;

/*


 */
import ProfileUsers.Vendor;
import ProfileUsers.VendorAccountArray;

import java.text.ParseException;


public class Main {
    public static void main(String[] args) throws ParseException {
        VendorAccountArray.init();

        new PurchaserView();
    }
}
