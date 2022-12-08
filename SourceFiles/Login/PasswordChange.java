/**
 * Class made by 'Benjamin Pienta'
 **/

package Login;

import UserClasses.UserAccountArray;
import UserClasses.UserWriteToCSV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordChange extends JFrame
{
    private Container c;
    private JLabel menuTitle;
    private JButton confirm;

    // Password Variables
    protected JLabel passwordLabel;
    protected JTextField textPassword;

    public PasswordChange()
    {
        setTitle("Search For user");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        // Menu title
        menuTitle = new JLabel("Change password");
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

                    // Ensure the user is not trying to re-enter their old password
                    if (!HoldCurrentLoginType.getLoggedInUser().getPassword().equals(passwordInput))
                    {
                        // Update user in array and in .csv
                        HoldCurrentLoginType.getLoggedInUser().setPassword(passwordInput);
                        UserAccountArray.editUser(userSlot, HoldCurrentLoginType.getLoggedInUser());
                        UserWriteToCSV.writeUsersToCSV(UserAccountArray.getUsers());

                        PasswordChange.super.dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "The password is the same as before");
                }
                else
                    JOptionPane.showMessageDialog(null, "The password is too short");

            }
        });
        c.add(confirm);

        setVisible(true);
    }
}
