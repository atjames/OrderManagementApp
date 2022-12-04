package Login;

import UserClasses.UserAccountArray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstLoginPasswordChange extends JFrame
{
    private Container c;
    private JLabel menuTitle;
    private JButton confirm;

    // Password Variables
    protected JLabel passwordLabel;
    protected JTextField textPassword;

    public FirstLoginPasswordChange()
    {
        setTitle("Search For user");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Menu title
        menuTitle = new JLabel("Edit Account");
        menuTitle.setSize(400, 30);
        menuTitle.setLocation(400, 30);
        c.add(menuTitle);

        // Label for the Password box
        passwordLabel = new JLabel("Enter Password");
        passwordLabel.setSize(150, 30);
        passwordLabel.setLocation(150, 180);
        c.add(passwordLabel);

        // Textbox for the Password
        textPassword = new JTextField();
        textPassword.setSize(200, 30);
        textPassword.setLocation(150, 205);
        textPassword.setDocument(new MaxCharLimit(16));
        c.add(textPassword);

        // Button that confirms the password change
        confirm = new JButton("Confirm");
        confirm.setSize(150, 30);
        confirm.setLocation(340, 350);
        confirm.addActionListener(new ActionListener() {
            // Sends user to page that shows all the actions they can perform
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Variable from input
                String passwordInput = textPassword.getText();

                // If the password is long enough, change the user password
                if (passwordInput.length() >= 8)
                {
                    int userSlot = UserAccountArray.getUserPlace(HoldCurrentLoginType.getLoggedInUser().getUserID());

                    HoldCurrentLoginType.getLoggedInUser().setPassword(passwordInput);
                    UserAccountArray.editUser(userSlot, HoldCurrentLoginType.getLoggedInUser());

                    FirstLoginPasswordChange.super.dispose();
                }
                else
                    passwordLabel.setText("Password too Short");

            }
        });
        c.add(confirm);

        setVisible(true);
    }
}
