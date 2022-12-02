package GUI;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


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
    private JDatePicker expireDate;


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



        itemName.setDocument(new JTextFieldMaxSize(20));

        for(int i = 0; i < Units.length;i++){
            UnitsCB.insertItemAt(Units[i],i);
        }
        for(int i = 0; i < Categories.length;i++){
            itemCategoriesCB.insertItemAt(Categories[i],i);
        }

        createItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(itemName.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter valid Item Name");
                    return;
                }
                if(!sellingPrice.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter a valid Selling Price");
                    return;
                }
                if(!purchasePrice.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter valid Purchase Price");
                    return;
                }
                if(!quantity.getText().matches("-?\\d+(\\.\\d+)?")){
                    JOptionPane.showMessageDialog(null, "Please enter a ");
                    return;
                }
            }
        });
    }
}

