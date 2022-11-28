package GUI;

import javax.swing.*;
import ProfileUsers.VendorAccountArray;
import ProfileUsers.Vendor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
/*
Gui class for deleting Vendors
can only delete vendors if their balance is zero
@autho Austin Jeffery
 */
public class DeleteVendor extends  JFrame {
    private JPanel DeleteVendorPanel;
    private JLabel Label;
    private JLabel IDLabel;
    private JLabel VendorName;
    private JTextField IDTextfield;
    private JTextField NameTextField;
    private JButton Submit;
    private JButton Return;
    private JButton Search;
    private JLabel Vendor;
    private JLabel VendorL;

    DeleteVendor() {
        setContentPane(DeleteVendorPanel);
        setTitle("Vendor Form");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(IDTextfield.getText().matches(".*[a-z].*")) {
                    JOptionPane.showMessageDialog(null, "Please enter Vendor name or ID");
                    VendorL.setText("");
                    return;
                }
                if(IDTextfield.getText().equals("") && NameTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter Vendor name or ID");
                    VendorL.setText("");
                    return;
                }
                String id = IDTextfield.getText();
                String name = NameTextField.getText();
                Vendor v = new Vendor();

                if(id.equals("") && !name.equals("")){
                    System.out.println(name);
                    v = VendorAccountArray.searchForUser(name);
                    if(v==null){
                        JOptionPane.showMessageDialog(null, "Please enter valid Vendor name or ID");
                        VendorL.setText("");
                        return;
                    }
                    IDTextfield.setText(String.valueOf(v.getUserID()));
                    VendorL.setText(v.getFullName());

                }
                else if(!id.equals("") && name.equals("")){
                    int i = Integer.parseInt(id);
                    if(VendorAccountArray.searchForUser(i) == null){
                        JOptionPane.showMessageDialog(null, "id: " + id + "\n Vendor not found");
                        return;
                    }
                    v = VendorAccountArray.searchForUser(i);
                    NameTextField.setText(v.getFullName());
                    VendorL.setText(v.getFullName());
                }
                else{
                    int i = Integer.parseInt(id);
                    if(VendorAccountArray.searchForUser(i)==null){
                        return;
                    }
                    else if(VendorAccountArray.searchForUser(i).getFullName().equals(null)){
                        JOptionPane.showMessageDialog(null, "Vendor ID and name do not match!");
                    }
                    else{
                        VendorL.setText(v.getFullName());
                    }
                }




            }
        });
        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaserView();
                DeleteVendor.super.dispose();
            }
        });
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(VendorL.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter Vendor name or ID");
                    VendorL.setText("");
                    return;
                }
                Vendor v = new Vendor();
                String vname = VendorL.getText();
                v = VendorAccountArray.searchForUser(vname);
                if (v.getBalance()!=0){
                    JOptionPane.showMessageDialog(null, "You can only delete a Vendor if they have Zero Balance\n " +
                            "This Vendor " + v.getFullName() + " Has balance of:  " + v.getBalance());
                    VendorL.setText("");
                    return;
                }
                else{
                    VendorAccountArray.deleteVendor(v);
                    JOptionPane.showMessageDialog(null, "Vendor has been deleted");
                    new PurchaserView();
                    DeleteVendor.super.dispose();
                    return;
                }
            }
        });
    }
}