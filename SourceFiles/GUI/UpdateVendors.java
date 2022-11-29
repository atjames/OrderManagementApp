package GUI;

import ProfileUsers.VendorAccountArray;
import ProfileUsers.Vendor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
GUI for updating vendors.
@author Austin Jeffery

 */
public class UpdateVendors extends  JFrame{
    String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
            "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
            "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
            "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND",
            "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
            "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };
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
    private JComboBox StateList;
    private JTextField VendorNameField;
    private JButton Reset;

    UpdateVendors(){
        fullNameTextField.setDocument(new JTextFieldMaxSize(20));
        streetTextField.setDocument(new JTextFieldMaxSize(20));
        cityTextField.setDocument(new JTextFieldMaxSize(20));
        phoneTextField.setDocument(new JTextFieldMaxSize(12));
        for(int i = 0;i<50;i++){
            StateList.insertItemAt(states[i],i);
        }
        setContentPane(UpdateVendorsPanel);
        setTitle("Vendor Form");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = VendorIDtextfield.getText();
                if(VendorIDtextfield.getText().matches(".*[a-z].*")) {
                    JOptionPane.showMessageDialog(null, "Please enter valid Vendor ID");
                    return;
                }
                if(VendorIDtextfield.getText().equals("") && VendorNameField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter Vendor name or ID");
                    return;
                }
                String ids = VendorIDtextfield.getText();
                String name = VendorNameField.getText();
                Vendor v = new Vendor();
                if(ids.equals("") && !name.equals("")){
                    System.out.println(name);
                    v = VendorAccountArray.searchForUser(name);
                    if(v==null){
                        JOptionPane.showMessageDialog(null, "Please enter valid Vendor name or ID");
                        return;
                    }
                    VendorIDtextfield.setText(String.valueOf(v.getUserID()));
                    ids = VendorIDtextfield.getText();
                }
                if(!ids.equals("") && name.equals("")){
                    int i = Integer.parseInt(ids);
                    if(VendorAccountArray.searchForUser(i) == null){
                        JOptionPane.showMessageDialog(null, "id: " + ids + "\n Vendor not found");
                        return;
                    }
                    v = VendorAccountArray.searchForUser(i);
                    VendorNameField.setText(v.getFullName());
                    name = VendorNameField.getText();
                }
                if(!ids.equals("") && !name.equals("")){//search both text fields
                int i = Integer.parseInt(ids);
                if(VendorAccountArray.searchForUser(i) == null){
                    JOptionPane.showMessageDialog(null, "id: " + ids + "\n Vendor not found");
                    return;
                }
                    v = VendorAccountArray.searchForUser(i);
                    int k = v.getUserID();

                    if(!v.getFullName().equals(name) || k != i){
                        JOptionPane.showMessageDialog(null, "Vendor ID and name do not match!");
                    }
                else {
                    fullNameTextField.setText(VendorAccountArray.searchForUser(i).getFullName());
                    streetTextField.setText(VendorAccountArray.searchForUser(i).getStreetAddress());
                    cityTextField.setText(VendorAccountArray.searchForUser(i).getCity());
                    phoneTextField.setText(VendorAccountArray.searchForUser(i).getPhone());
                    Balance.setText(String.valueOf(VendorAccountArray.searchForUser(i).getBalance()));
                    StateList.setSelectedItem(VendorAccountArray.searchForUser(i).getState());
                }
            }
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
                String state = (String) StateList.getSelectedItem();
                String phone = phoneTextField.getText();

                String dash = String.valueOf(phone.charAt(3));
                String dash2 = String.valueOf(phone.charAt(7));
                if(phone.matches(".*[a-z].*") || (!dash.equals("-")) || (!dash2.equals( "-"))){
                    JOptionPane.showMessageDialog(null, "Phone number is not valid, must be ###-###-####");
                    return;
                }
                if(Balance.getText().matches(".*[a-z].*")){
                    JOptionPane.showMessageDialog(null, "Balance is not valid (only enter numbers)");
                    return;
                }
                double bal = Double.parseDouble((Balance.getText()));
                //Implement a way to validate input


                Vendor v = new Vendor(i,fullname,street,city,state,phone);
                v.setBalance(bal);
                VendorAccountArray.updateVendor(v,i);
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

        Reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fullNameTextField.setText("");
                streetTextField.setText("");
                cityTextField.setText("");
                phoneTextField.setText("");
                Balance.setText("");
                StateList.setSelectedItem(null);
                VendorIDtextfield.setText("");
                VendorNameField.setText("");
            }
        });
    }

}
