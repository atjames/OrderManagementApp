package Main;

import UserClasses.Owner;
import UserClasses.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame
{
    private Container c;
    private JLabel menuTitle;
    private JButton test1;
    private JButton test2;
    private static User currentUser = null;


    public MainMenu() {
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

        // Button that test1s the login of the user
        test1 = new JButton("Test Button");
        test1.setSize(150, 30);
        test1.setLocation(340, 350);
        test1.addActionListener(new ActionListener() {
            // Test button closes the menu
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu.super.dispose();
            }
        });
        c.add(test1);

        if (currentUser instanceof Owner)
        {
            // Button that test1s the login of the user
            test2 = new JButton("Test Button 2");
            test2.setSize(150, 30);
            test2.setLocation(340, 250);
            test2.addActionListener(new ActionListener() {
                // Test button closes the menu
                @Override
                public void actionPerformed(ActionEvent e) {
                    MainMenu.super.dispose();
                }
            });
            c.add(test2);
        }


        setVisible(true);
    }

    public static void setUserType(User user)
    {
        currentUser = user;
    }
}
