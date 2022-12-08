package PurchaseOrder;

import ItemProfile.ItemProfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static Main.Main.items;
import static PurchaseOrder.PurchaseOrderCSV.CSVFormatter;

public class writePurchaseOrders extends PurchaseOrder{

    public static void write_items(ArrayList<PurchaseOrder> orders){

        try (FileWriter writer = new FileWriter(PurchaseOrder.PURCHASE_ORDERS_CSV, false)) //overwrites the .CSV with the new values
        {
            writer.write(PurchaseOrder.PURCHASE_ORDER_CSV_HEADER); //writes the header line to the CSV first

            for (PurchaseOrder order : orders) //iterates over arraylist and writes the formatter CSV line
            {
                writer.write('\n' + CSVFormatter(order));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer2 = new FileWriter(PurchaseOrder.PURCHASE_ORDERS_ITEMS_CSV, false)) //overwrites the .CSV with the new values
        {
            writer2.write(PurchaseOrder.PURCHASE_ORDER_ITEMS_CSV_HEADER); //writes the header line to the CSV first

            for (PurchaseOrder order : orders) //iterates over arraylist and writes the formatter CSV line
            {
                ArrayList<String> temp;
                temp = order.getPurchasedItems();
                for (String item : temp) {
                    writer2.write('\n' + item + "," +order.getPurchaseOrderID());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
