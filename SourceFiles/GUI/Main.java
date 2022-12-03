package GUI;

/*


 */
import ProfileUsers.Vendor;
import ProfileUsers.VendorAccountArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        VendorAccountArray.init();

        String last = "12/2/2222";
        String seas = "12/5/2121";
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");




        new PurchaserView();
    }
}
