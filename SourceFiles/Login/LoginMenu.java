package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginMenu extends JFrame
{
    private Container c;
    private JLabel menuTitle;
    private JButton confirm;

    // User ID
    protected JLabel userID;
    protected JTextField textUserID;

    // Password
    protected JLabel password;
    protected JTextField textPassword;

    public LoginMenu() {
        setTitle("Login Page");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Menu title
        menuTitle = new JLabel("Login");
        menuTitle.setSize(300, 30);
        menuTitle.setLocation(400, 30);
        c.add(menuTitle);

        // Button that confirms the login of the user
        confirm = new JButton("Confirm");
        confirm.setSize(150, 30);
        confirm.setLocation(340, 350);
        confirm.addActionListener(new ActionListener() {
            // Sends user to page that shows all the actions they can perform
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginMenu.super.dispose();
            }
        });
        c.add(confirm);

        // Label for the User ID box
        userID = new JLabel("Enter User ID");
        userID.setSize(150, 30);
        userID.setLocation(150, 65);
        c.add(userID);

        // User ID box to insert ID
        textUserID = new JTextField();
        textUserID.setSize(200, 30);
        textUserID.setLocation(150, 90);
        textUserID.setDocument(new MaxCharLimit(6));
        c.add(textUserID);

        // Label for the Password Box
        password = new JLabel("Enter Password");
        password.setSize(150, 30);
        password.setLocation(525, 65);
        c.add(password);

        // Textbox to enter the password
        textPassword = new JTextField();
        textPassword.setSize(200, 30);
        textPassword.setLocation(525, 90);
        textPassword.setDocument(new MaxCharLimit(16));
        c.add(textPassword);

        setVisible(true);
    }
}
