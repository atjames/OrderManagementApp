package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ItemProfile.ItemProfile;
import Main.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import static Main.Main.items;

public class itemTableForm extends JFrame {
    JPanel panel1;
    private JTable table1;
    private JButton returnToMenu;
    String header[] = {"Item ID", "Item Name", "Vendor ID", "Selling Price", "Item Category", "Unit Of Measurement", "Quantity on Hand", "Expire Date"};

    private void createUIComponents() {
        DefaultTableModel model = new DefaultTableModel(0, 8){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        model.setColumnIdentifiers(header);
        table1 = new JTable(model);

        for (ItemProfile item : items) {

            Object[] row = {item.getItemID(),item.getItemName(),item.getVendorID(),item.getSellingPrice(),item.getItemCategory(),
            item.getUnitOfMeasurement(),item.getQuantityonHand(),item.getExpireDate()};
            model.addRow(row);
        }

    }
}