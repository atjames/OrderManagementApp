package PurchaseOrder;

import ItemProfile.ItemProfile;

import java.util.ArrayList;
import java.util.Date;

public class PurchaseOrder
{
    public static final String PURCHASE_ORDERS_CSV = "Resources/purchaseorders.csv";
    public static final String PURCHASE_ORDER_CSV_HEADER = "itemID,purchaseOrders,vendorID,balance,needByDate";

    String purchaseOrderID;
    double totalCost;
    Date needByDate;
    ArrayList<ItemProfile> purchasedItems = new ArrayList<>();
    void setPurchaseOrderID(String purchaseOrderID){this.purchaseOrderID = purchaseOrderID;}
    void setTotalCost(double totalCost){this.totalCost = totalCost;}
    void setNeedByDate(Date needByDate){this.needByDate = needByDate;}
    void addPurchaseItems(ItemProfile item){purchasedItems.add(item);}

    String getPurchaseOrderID(){return purchaseOrderID;}
    double getTotalCost(){return totalCost;}
    Date getNeedByDate(){return needByDate;}

    ArrayList getPurchasedItems(){return purchasedItems;}


}
