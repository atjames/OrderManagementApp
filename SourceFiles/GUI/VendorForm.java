package GUI;

import ProfileUsers.ProfileAccountArray;
import ProfileUsers.Vendor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendorForm  extends JFrame{
   private JPanel Panel1;
    private JTextField FullName;
    private JLabel FullNameLabel;
    private JLabel StreetAddress;
    private JTextField StreetAdd;
    private JLabel CityL;
    private JTextField City;
    private JLabel StateL;
    private JTextField State;
    private JLabel PhoneL;
    private JTextField Phone;
    private JButton Submit;
    private JButton Return;

    public VendorForm(){

        setContentPane(Panel1);
        setTitle("Vendor Form");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fullname = FullName.getText();
                String street = StreetAdd.getText();
                String city = City.getText();
                String state = State.getText();
                String phone = Phone.getText();
                //Implement a way to validate input
                int num = ProfileAccountArray.arraySize;
                Vendor v = new Vendor(num,fullname,street,city,state,phone);
                ProfileAccountArray.addProfile(v);
                new PurchaserView();
                VendorForm.super.dispose();
            }
        });
        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaserView();

                VendorForm.super.dispose();
            }
        });
    }


    public static void main(String[] args) {


        VendorForm vendorFrame = new VendorForm();
    }

}

