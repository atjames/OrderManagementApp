package GUI;

import ProfileUsers.VendorAccountArray;
import ProfileUsers.Vendor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
/*
This class is to show the form to add Vendors and will validate user input
@author Austin Jeffery

 */
public class VendorForm  extends JFrame{
    String[] states = { "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE",
                         "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
                        "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
                        "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND",
                        "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN",
                        "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY" };

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
    private JComboBox StateList;
    private JLabel lastorderdateL;
    private JTextField LastOrderDate;
    private JLabel SeasonaldDiscountL;
    private JTextField SeasonalDiscountDate;

    public VendorForm(){

        setContentPane(Panel1);
        setTitle("Vendor Form");
        setSize(900,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        FullName.setDocument(new JTextFieldMaxSize(20));
        StreetAdd.setDocument(new JTextFieldMaxSize(20));
        City.setDocument(new JTextFieldMaxSize(20));
        Phone.setDocument(new JTextFieldMaxSize(12));

        //load state list
        for(int i = 0;i<50;i++){
            StateList.insertItemAt(states[i],i);
        }


        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    String fullname = FullName.getText();
                    String street = StreetAdd.getText();
                    String city = City.getText();
                    String state = (String) StateList.getSelectedItem();

                    String phone = Phone.getText();
                    String dash = String.valueOf(phone.charAt(3));
                    String dash2 = String.valueOf(phone.charAt(7));
                    if(phone.matches(".*[a-z].*") || (!dash.equals("-")) || (!dash2.equals( "-"))){
                        JOptionPane.showMessageDialog(null, "Phone number is not valid, must be ###-###-####");
                        new VendorForm();
                        VendorForm.super.dispose();
                        return;
                    }
                    String lastorderdate = LastOrderDate.getText();
                    String seasonaldate = SeasonalDiscountDate.getText();
                    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                    Date lastorder = formatter.parse(lastorderdate);
                    Date seasonal = formatter.parse(seasonaldate);
                    //System.out.println(lastorder);
                    //System.out.println(seasonal);
                    String lastDate = formatter.format(new Date(lastorderdate));
                    String seasDate = formatter.format(new Date(seasonaldate));
                    int num = VendorAccountArray.arraySize;
                    Vendor v = new Vendor(num,fullname,street,city,state,phone,lastorder,seasonal);
                    VendorAccountArray.addVendor(v);
                    //System.out.println(lastDate);
                    //System.out.println(seasDate);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Enter Valid Dates MM/DD/YYYY");
                    ex.printStackTrace();
                    return;
                }

                new PurchaserView();
                VendorForm.super.dispose();
                //Implement a way to validate input

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




}

