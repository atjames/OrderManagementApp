package GUI;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.View;

/*
Class for the Purchaser view. Once a purchaser logins they have access to these functions
to add vendors, edit, delete.
@autho Austin Jeffery

 */
public class PurchaserView extends javax.swing.JFrame {

    private Container c;
    private JPanel panel1;
    private JButton AddVendor;
    private JButton ViewVendors;
    private JButton UpdateVendors;
    private JButton DeleteVendor;
    private JButton SearchVendor;


    public PurchaserView(){
            setTitle("Purchaser View");
            setBounds(300, 90, 900, 600);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            c = getContentPane();
            c.setLayout(null);
            AddVendor = new JButton("Add Vendor");
            AddVendor.setSize(150, 30);
            AddVendor.setLocation(340, 350);
           c.add(AddVendor);
           //make list to show all vendors
           ViewVendors = new JButton("View Vendors");
           ViewVendors.setSize(150,30);
           ViewVendors.setLocation(140,350);
           c.add(ViewVendors);
           //Enter vendor id to search and update
        UpdateVendors = new JButton("Update Vendors");
        UpdateVendors.setSize(150,30);
        UpdateVendors.setLocation(540,350);
        c.add(UpdateVendors);

        DeleteVendor = new JButton("Delete Vendors");
        DeleteVendor.setSize(150,30);
        DeleteVendor.setLocation(340,150);
        c.add(DeleteVendor);

        SearchVendor = new JButton("Search Vendors");
        SearchVendor.setSize(150,30);
        SearchVendor.setLocation(140,150);
        c.add(SearchVendor);
        DeleteVendor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                PurchaserView.super.dispose();
                new DeleteVendor();

            }
        });
        SearchVendor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                PurchaserView.super.dispose();
                new SearchVendors();

            }
        });
           AddVendor.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                    c.hide();

                    new VendorForm();
                    PurchaserView.super.dispose();
               }
           });
            setVisible(true);
        ViewVendors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                PurchaserView.super.dispose();
                new ListVendors();

            }
        });
        UpdateVendors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                PurchaserView.super.dispose();
                new UpdateVendors();

            }
        });


    }


}
