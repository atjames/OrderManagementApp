package GUI;

import ProfileUsers.ProfileAccountArray;
import ProfileUsers.Vendor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateVendors extends  JFrame{
    private JLabel SearchL;
    private JTextField VendorIDtextfield;
    private JButton Submit;
    private JTextField fullNameTextField;
    private JTextField streetTextField;
    private JTextField cityTextField;
    private JTextField stateTextField;
    private JTextField phoneTextField;
    private JButton Update;
    private JPanel UpdateVendorsPanel;
    private JTextField Balance;
    private JButton Return;

    UpdateVendors(){
        setContentPane(UpdateVendorsPanel);
        setTitle("Vendor Form");
        setSize(950, 900);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = VendorIDtextfield.getText();
                int i = Integer.parseInt(id);

                if(ProfileAccountArray.searchForUser(i) == null){
                    JOptionPane.showMessageDialog(null, "id: " + id + "\n Vendor not found");

                    new PurchaserView();
                    UpdateVendors.super.dispose();
                    return;
                }
                fullNameTextField.setText(ProfileAccountArray.searchForUser(i).getFullName());
                streetTextField.setText(ProfileAccountArray.searchForUser(i).getStreetAddress());
                cityTextField.setText(ProfileAccountArray.searchForUser(i).getCity());
                stateTextField.setText(ProfileAccountArray.searchForUser(i).getState());
                phoneTextField.setText(ProfileAccountArray.searchForUser(i).getPhone());
                Balance.setText(String.valueOf(ProfileAccountArray.searchForUser(i).getBalance()));

            }
        });

        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = VendorIDtextfield.getText();
                int i = Integer.parseInt(id);
                String fullname = fullNameTextField.getText();
                String street = streetTextField.getText();
                String city = cityTextField.getText();
                String state = stateTextField.getText();
                String phone = phoneTextField.getText();
                //int bal = Integer.parseInt(Balance.getText());
                //Implement a way to validate input


                Vendor v = new Vendor(i,fullname,street,city,state,phone);
               // v.setBalance(bal);
                ProfileAccountArray.updateVendor(v,i);
                new PurchaserView();
                UpdateVendors.super.dispose();
            }
        });
        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaserView();
                UpdateVendors.super.dispose();
            }
        });
    }
}
