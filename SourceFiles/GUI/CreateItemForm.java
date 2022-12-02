package GUI;
import ItemProfile.ItemProfile;
import org.jdatepicker.JDatePicker;
import ItemProfile.GenerateItemID;
import ItemProfile.writeCSV;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static Main.Main.items;

/*
@author: Andrew James
 */

public class CreateItemForm extends JFrame {
    private JPanel createItemFrame;
    private JTextField itemName;
    private JComboBox vendorIDCB;
    private JTextField sellingPrice;
    private JTextField purchasePrice;
    private JComboBox UnitsCB;
    private JTextField quantity;
    private JButton createItemButton;
    private JComboBox itemCategoriesCB;
    private JDatePicker expireDateForm;

    String AlphaNumericString = "0123456789";

    Date today = new Date();
    String[] Units = { "pounds", "gallon", "dozen"};
    String[] Categories = {"vegetables", "fruits", "nuts", "dairy", "meat",
            "snacks", "soda", "juice", "bakery products"};


    public CreateItemForm(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(createItemFrame);
        this.pack();
        setSize(500, 500);
        setLocationRelativeTo(null);

        //setting max size for item name == 20 characters
        itemName.setDocument(new JTextFieldMaxSize(20));

        //populating combo boxes
        for(int i = 0; i < Units.length;i++){
            UnitsCB.insertItemAt(Units[i],i);
        }
        for(int i = 0; i < Categories.length;i++){
            itemCategoriesCB.insertItemAt(Categories[i],i);
        }

        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Input verification for all fields.
                if(itemName.getText().matches("-?\\d+(\\.\\d+)?") || itemName.getText() == null){
                    JOptionPane.showMessageDialog(null, "Please enter valid Item Name");
                    return;
                }
                else if(!sellingPrice.getText().matches("-?\\d+(\\.\\d+)?") || sellingPrice.getText() == null){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Selling Price");
                    return;
                }
                else if(!purchasePrice.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter valid Purchase Price");
                    return;
                }
                else if(!quantity.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Quantity");
                    return;
                }else if(itemCategoriesCB.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Please Select an item category");
                    return;
                }else if(UnitsCB.getSelectedItem() == null) {
                    JOptionPane.showMessageDialog(null, "Please Select an item category");
                    return;
                }//else if(vendorIDCB.getSelectedItem() == null) {
                    //JOptionPane.showMessageDialog(null, "Please Select an item category");
                    //return;
                //}
                else{
                    ItemProfile item = new ItemProfile();
                    boolean doesExist = true;

                    //Format date from the JDatePicker so we can pass it to our item
                    String expireDate = (expireDateForm.getModel().getMonth() + 1) + "/" + (expireDateForm.getModel().getDay()) + "/" + (expireDateForm.getModel().getYear());

                    //verify that ItemID is unique. If not will generate a new one.
                    while(doesExist) {
                        String itemID = GenerateItemID.GenerateItemID();
                        for (ItemProfile itemTest : items)
                        {
                            if(itemTest.getItemID() == itemID){
                                doesExist = true;
                                itemID =GenerateItemID.GenerateItemID();
                            }else{
                                doesExist= false;
                            }
                        }
                    }
                    try {
                        item.createItem(GenerateItemID.GenerateItemID(),itemName.getText(),"123456",Double.parseDouble(sellingPrice.getText()),itemCategoriesCB.getSelectedItem().toString(),
                                Double.parseDouble(quantity.getText()),UnitsCB.getSelectedItem().toString(),expireDate);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    items.add(item);
                    writeCSV.write_items(items);
                    JOptionPane.showMessageDialog(null, "Item " + item.getItemName() +" successfully created with Item ID: " + item.getItemID());
                    JFrame ItemMenuGUI = new ItemMenuGUI("Items Menu");
                    ItemMenuGUI.setVisible(true);
                    CreateItemForm.super.dispose();
                }
            }
        });
    }
}

