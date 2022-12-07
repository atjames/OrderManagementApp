package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class AccountantView extends JFrame {
    private JPanel AccountantPanel;
    private Container c;
    private JButton viewCustomerInvoiceButton;
    private JButton searchCustomerInvoicesButton;
    private JButton searchForCustomerButton;
    private JButton returnButton;

    public AccountantView() {
        setTitle("Accountant View");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setContentPane(AccountantPanel);
        c = getContentPane();
        setTitle("Search Form");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        searchForCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                AccountantView.super.dispose();
                try {
                    new SearchCustomers();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                return;
                //logout
            }
        });
        searchCustomerInvoicesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.hide();
                AccountantView.super.dispose();
                new SearchInvoices();

            }
        });
    }
}
