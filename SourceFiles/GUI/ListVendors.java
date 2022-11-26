package GUI;

import ProfileUsers.ProfileAccountArray;
import ProfileUsers.Vendor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListVendors extends JFrame{
    private JPanel Panel1;
    private JLabel FullNameLabel;

    private JButton Return;
    private JPanel ListVendors;
    private JLabel FullNameL;
    ListVendors() {
        setContentPane(ListVendors);
        setTitle("Vendor Form");
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        if(ProfileAccountArray.searchForUser(0) == null){
            new PurchaserView();
            ListVendors.super.dispose();
        }
        //so far just list first profile in array
        FullNameL.setText(ProfileAccountArray.searchForUser(0).toString());


        Return.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PurchaserView();
                ListVendors.super.dispose();
            }
        });
    }

}
