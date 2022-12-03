package ItemProfile;

/*
@author: Andrew James
 */


public class ItemProfileCSV extends ItemProfile{

    public static String CSVFormatter(ItemProfile item){

        String CSVFormat = item.itemID + "," + item.getItemName() + "," + item.getVendorID() + "," + item.getSellingPrice() + "," + item.getItemCategory() + "," + item.getQuantityonHand()
                + "," + item.getUnitOfMeasurement() + "," + item.getExpireDate() + "," + item.getPurchasePrice();

        //Formatter for CSV output.

        return CSVFormat;
    }


}
