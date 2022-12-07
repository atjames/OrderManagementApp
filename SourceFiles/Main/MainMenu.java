/**
 * Class made by 'Benjamin Pienta'
 **/

package Main;

import Login.PasswordChange;
import Login.HoldCurrentLoginType;
import Login.HoldPagesVisited;
import Login.LoginMenu;
import ObserverInterface.ObserveVendorSale;
import ProfileUsers.Vendor;
import ProfileUsers.VendorAccountArray;
import UserClasses.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class MainMenu extends JFrame
{
    // Main variables for the FUI
    private Container c;
    private JLabel menuTitle;
    private JButton exit;
    private JButton addUser;
    private JButton editUser;
    private JButton searchUser;
    private JButton logout;
    private JButton changePassword;
    private static User currentUser = null;

    // Variable to store the date
    Date todaysDate = new Date();

    public MainMenu()
    {
        setTitle("MainMenu");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Menu title
        menuTitle = new JLabel("Menu");
        menuTitle.setSize(300, 30);
        menuTitle.setLocation(400, 30);
        c.add(menuTitle);

        // Button that exits the program
        exit = new JButton("Exit");
        exit.setSize(150, 30);
        exit.setLocation(340, 350);
        exit.addActionListener(new ActionListener() {
            // Test button closes the menu
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.super.dispose();
            }
        });
        c.add(exit);

        // If Owners or Administrators are logged in, reveal these buttons
        if (currentUser instanceof Owner || currentUser instanceof Administrator)
        {
            // Button that takes allowed users to the 'Add User' page
            addUser = new JButton("Add User");
            addUser.setSize(150, 30);
            addUser.setLocation(340, 250);
            addUser.addActionListener(new ActionListener() {
                // Test button closes the menu
                @Override
                public void actionPerformed(ActionEvent e) {
                    HoldPagesVisited.incrementPagesVisited();
                    new UserCreationPage();
                    MainMenu.super.dispose();
                }
            });
            c.add(addUser);

            // Button that takes allowed users to the 'Edit User' page
            editUser = new JButton("Edit User");
            editUser.setSize(150, 30);
            editUser.setLocation(340, 150);
            editUser.addActionListener(new ActionListener() {
                // Test button closes the menu
                @Override
                public void actionPerformed(ActionEvent e) {
                    HoldPagesVisited.incrementPagesVisited();
                    new UserEditPage();
                    MainMenu.super.dispose();
                }
            });
            c.add(editUser);

            // Button that takes allowed users to the 'Search User' page
            searchUser = new JButton("Search User");
            searchUser.setSize(150, 30);
            searchUser.setLocation(140, 150);
            searchUser.addActionListener(new ActionListener() {
                // Opens the Search User page
                @Override
                public void actionPerformed(ActionEvent e) {
                    HoldPagesVisited.incrementPagesVisited();
                    new UserSearchPage();
                    MainMenu.super.dispose();
                }
            });
            c.add(searchUser);
        }

        // Button that logs the user out
        logout = new JButton("Log Out");
        logout.setSize(150, 30);
        logout.setLocation(700, 20);
        logout.addActionListener(new ActionListener() {
            // Test button closes the menu
            @Override
            public void actionPerformed(ActionEvent e)
            {
                HoldCurrentLoginType.updateUser(null);
                HoldPagesVisited.resetNumberOfPagesVisited();

                new LoginMenu();
                MainMenu.super.dispose();
            }
        });
        c.add(logout);

        // Button changes the user's password upon use
        changePassword = new JButton("Change Password");
        changePassword.setSize(150, 30);
        changePassword.setLocation(700, 500);
        changePassword.addActionListener(new ActionListener() {
            // Changes the User's password
            @Override
            public void actionPerformed(ActionEvent e)
            {
                HoldPagesVisited.incrementPagesVisited();
                new PasswordChange();
            }
        });
        c.add(changePassword);

        setVisible(true);

        // If this is the first time a user has used the system, send them to change their password
        // and update their profile
        if (HoldCurrentLoginType.getLoggedInUser().isFirstLogin())
        {
            new PasswordChange();

            // Change firstLogin to false for the user
            for (User user: UserAccountArray.getUsers())
                if (HoldCurrentLoginType.getLoggedInUser() == user)
                {
                    user.setFirstLogin(false);
                }

            UserWriteToCSV.writeUsersToCSV(UserAccountArray.getUsers());
        }

        // Having the conditional after the 'setVisible' loads the menu THEN shows
        // the pop-ups
        if (HoldPagesVisited.getNumberOfPagesVisited() == 0)
        {
            // If the logged-in user is meant to be updated, tell that user a sale is occurring.
            for (Vendor vendor : VendorAccountArray.vendors)
                for (ObserveVendorSale observe : vendor.saleObservers)
                    if (HoldCurrentLoginType.getLoggedInUser() == observe && todaysDate.after(vendor.getSeasonalDiscount()))
                        vendor.updateSaleObservers();
        }
    }

    public static void setUserType(User user)
    {
        currentUser = user;
    }
}
