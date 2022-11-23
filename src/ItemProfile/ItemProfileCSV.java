package ItemProfile;

public class ItemProfileCSV extends ItemProfile{

    public String CSVFormatter(ItemProfile item){

        String CSVFormat = item.itemID + "," + item.getItemName() + "," + item.getVendorID() + "," + item.getSellingPrice() + "," + item.getItemCategory()
                + "," + item.getQuantityonHand() + "," + item.getExpireDate();

        return CSVFormat;
    }


}
