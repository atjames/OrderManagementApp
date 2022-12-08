package PurchaseOrder;

import ItemProfile.ItemProfile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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

        //add writing of items to file

    }
}
