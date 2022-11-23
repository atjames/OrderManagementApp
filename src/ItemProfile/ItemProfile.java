package ItemProfile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ItemProfile
{
     public static final String file_path = "rsrc/items.csv";
     public static final String CSVHeaderLine = "itemID,itemName,vendorID,sellingPrice,itemCategory,unitOfMeasurment,quantityonHand,expireDate";
     String itemID;
     String itemName;
     String vendorID;
     double sellingPrice;
     String itemCategory;

     String unitOfMeasurment;
     double quantityonHand;
     Date expireDate;
     DateFormat formatter = new SimpleDateFormat("mm/dd/yyyy");

     public void setItemID(String itemID) {this.itemID = itemID;}
     public void setUnitOfMeasurment(String unitOfMeasurment){this.unitOfMeasurment = unitOfMeasurment;}
     public void setItemName(String itemName) {this.itemName = itemName;}
     public void setVendorID(String vendorID) {this.vendorID = vendorID;}
     public void setSellingPrice(double sellingPrice) {this.sellingPrice = sellingPrice;}
     public void setItemCategory(String itemCategory){this.itemCategory = itemCategory;}
     public void setQuantityonHand(double quantityonHand){this.quantityonHand = quantityonHand;}
     public void setExpireDate(Date expireDate){this.expireDate = expireDate;}

     public String getExpireDate()
     {
          return formatter.format(expireDate);
     }

     public String getItemCategory() {
          return itemCategory;
     }

     public String getUnitOfMeasurment() {
          return unitOfMeasurment;
     }
     public double getSellingPrice() {
          return sellingPrice;
     }

     public double getQuantityonHand() {
          return quantityonHand;
     }

     public String getVendorID() {
          return vendorID;
     }

     public String getItemID() {
          return itemID;
     }

     public String getItemName() {
          return itemName;
     }


     public void createItem(String itemID, String itemName, String vendorID, double sellingPrice, String itemCategory, double quantityonHand,String unitOfMeasurment, String expireDate) throws ParseException {
          this.itemID = itemID;
          this.itemName = itemName;
          this.vendorID = vendorID;
          this.sellingPrice = sellingPrice;
          this.itemCategory = itemCategory;
          this.unitOfMeasurment = unitOfMeasurment;
          this.quantityonHand = quantityonHand;
          this.expireDate = formatter.parse(expireDate);
     }

     public ItemProfile(){
          itemID = "";
          itemName = "test";
          vendorID = "";
          sellingPrice = 0;
          itemCategory = "";
          unitOfMeasurment = "";
          quantityonHand = 0;
          expireDate = new Date();
     }

}



