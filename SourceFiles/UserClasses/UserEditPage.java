package UserClasses;

import Login.HoldCurrentLoginType;
import Login.HoldPagesVisited;
import Login.LoginMenu;
import Login.MaxCharLimit;
import Main.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserEditPage extends JFrame
{
    private Container c;
    private JLabel menuTitle;
    private JButton confirm;
    private JButton selectUser;
    private JButton deleteUser;
    private JButton logout;
    private int userSlotInArrayList;
    private boolean userSelected = false;

    // User Type
    protected JLabel userTypeLabel;
    protected JComboBox userTypeDropBox;

    // firstName
    protected JLabel firstNameLabel;
    protected JTextField textFirstName;

    // Last Name Variables
    protected JLabel lastNameLabel;
    protected JTextField textLastName;

    // Password Variables
    protected JLabel passwordLabel;
    protected JTextField textPassword;

    // List of Users
    protected JLabel allUsersLabel;
    protected JComboBox allUsersDropBox;

    // List of All Users
    protected String[] allUsersIDs;

    // Lists for the JComboBox for owners and Administrators respectively
    private String userTypeListOwner[]
            = {"Owner", "Administrator", "Inventory Manager", "Accountant", "Purchaser", "Sales Person"};
    private String userTypeListAdministrator[]
            = {"Inventory Manager", "Accountant", "Purchaser", "Sales Person"};

    public UserEditPage()
    {
        setTitle("Edit User Profile");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        createArrayCopy();

        c = getContentPane();
        c.setLayout(null);

        // Menu title
        menuTitle = new JLabel("Edit Account");
        menuTitle.setSize(400, 30);
        menuTitle.setLocation(400, 30);
        c.add(menuTitle);

        // Button that confirms the submission of the new user
        confirm = new JButton("Confirm Edit");
        confirm.setSize(150, 30);
        confirm.setLocation(340, 350);
        confirm.addActionListener(new ActionListener() {
            // Updates the user for the new array
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (userSelected)
                {
                    // Variables from input
                    String firstNameInput = textFirstName.getText();
                    String lastNameInput = textLastName.getText();
                    String userRoleInput = (String)userTypeDropBox.getSelectedItem();
                    String passwordInput = textPassword.getText();
                    String selectedID = (String)allUsersDropBox.getSelectedItem();

                    // Checks if the new password length is long enough
                    if (passwordInput.length() >= 8)
                    {
                        // Initializes a new user to replace the old user
                        User user = UserFactory.userFactory(userRoleInput);
                        user.setFirstName(firstNameInput);
                        user.setLastName(lastNameInput);
                        user.setPassword(passwordInput);
                        user.setUserID(selectedID);
                        user.setUserRole(userRoleInput);

                        // Replace old user with new user
                        UserAccountArray.editUser(userSlotInArrayList, user);

                        // Opens the Main Menu
                        new MainMenu();
                        UserEditPage.super.dispose();
                    }
                    else
                        passwordLabel.setText("Password too Short");
                }
                else
                    menuTitle.setText("Select a User from the ID list first");
            }
        });
        c.add(confirm);

        // Button that selects the user for Editing
        selectUser = new JButton("Select");
        selectUser.setSize(150, 30);
        selectUser.setLocation(340, 450);
        selectUser.addActionListener(new ActionListener() {
            // Adds all items from selected user to the box
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String selectedID = (String)allUsersDropBox.getSelectedItem();

                if (UserAccountArray.searchUserID(selectedID))
                {
                    userSlotInArrayList = UserAccountArray.getUserPlace(selectedID);
                    userSelected = true;

                    // Set all editable variables from the user
                    textPassword.setText(UserAccountArray.getUsers().get(userSlotInArrayList).getPassword());
                    textFirstName.setText(UserAccountArray.getUsers().get(userSlotInArrayList).getFirstName());
                    textLastName.setText(UserAccountArray.getUsers().get(userSlotInArrayList).getLastName());
                    menuTitle.setText("User is a(n) " + UserAccountArray.getUsers().get(userSlotInArrayList).getUserRole());
                }
                else
                    allUsersLabel.setText("ID Not Found");
            }
        });
        c.add(selectUser);

        // Button that deletes a selected user
        deleteUser = new JButton("Delete User");
        deleteUser.setSize(150, 30);
        deleteUser.setLocation(140, 450);
        deleteUser.addActionListener(new ActionListener() {
            // Updates the user for the new array
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // If a user is selected, delete the user
                if (userSelected)
                {
                    UserAccountArray.removeUser(userSlotInArrayList);
                    userSelected = false;
                    new UserEditPage();
                    UserEditPage.super.dispose();
                }
                else
                    menuTitle.setText("Select a User from the ID list first");
            }
        });
        c.add(deleteUser);

        // Label for the User Type dropdown box
        userTypeLabel = new JLabel("Account Type");
        userTypeLabel.setSize(150, 30);
        userTypeLabel.setLocation(150, 65);
        c.add(userTypeLabel);

        // Dropdown list for the User Types
        if (HoldCurrentLoginType.getLoggedInUser() instanceof Owner)
        {
            userTypeDropBox = new JComboBox<>(userTypeListOwner);
            userTypeDropBox.setSize(125, 30);
            userTypeDropBox.setLocation(150, 100);
            c.add(userTypeDropBox);
        }
        else if (HoldCurrentLoginType.getLoggedInUser() instanceof Administrator)
        {
            userTypeDropBox = new JComboBox<>(userTypeListAdministrator);
            userTypeDropBox.setSize(125, 30);
            userTypeDropBox.setLocation(150, 100);
            c.add(userTypeDropBox);
        }

        // Label for the firstName Box
        firstNameLabel = new JLabel("Enter First Name");
        firstNameLabel.setSize(150, 30);
        firstNameLabel.setLocation(525, 65);
        c.add(firstNameLabel);

        // Textbox for the first name
        textFirstName = new JTextField();
        textFirstName.setSize(200, 30);
        textFirstName.setLocation(525, 90);
        textFirstName.setDocument(new MaxCharLimit(16));
        c.add(textFirstName);

        // Label for the lastName Box
        lastNameLabel = new JLabel("Enter Last Name");
        lastNameLabel.setSize(150, 30);
        lastNameLabel.setLocation(525, 115);
        c.add(lastNameLabel);

        // Textbox for the last name
        textLastName = new JTextField();
        textLastName.setSize(200, 30);
        textLastName.setLocation(525, 140);
        textLastName.setDocument(new MaxCharLimit(16));
        c.add(textLastName);

        // Label for the User ID list
        allUsersLabel = new JLabel("List Of Users to Edit");
        allUsersLabel.setSize(150, 30);
        allUsersLabel.setLocation(150, 130);
        c.add(allUsersLabel);

        // Dropbox of Users editable
        allUsersDropBox = new JComboBox<>(allUsersIDs);
        allUsersDropBox.setSize(200, 30);
        allUsersDropBox.setLocation(150, 155);
        c.add(allUsersDropBox);

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
                UserEditPage.super.dispose();
            }
        });
        c.add(logout);


        setVisible(true);
    }

    // Creates the array list for this GUI depending on the user logged in
    private void createArrayCopy()
    {
        if (HoldCurrentLoginType.getLoggedInUser() instanceof Owner)
        {
            allUsersIDs = new String[UserAccountArray.getUsers().size()];
            for (int i = 0; i < UserAccountArray.getUsers().size(); i++)
                allUsersIDs[i] = UserAccountArray.getUsers().get(i).getUserID();
        }
        else
        {
            // Get the allotted size for Administrators to edit
            int numOfAllowedEdits = 0;
            for (int i = 0; i < UserAccountArray.getUsers().size(); i++)
            {
                if (!(UserAccountArray.getUsers().get(i) instanceof Owner || UserAccountArray.getUsers().get(i) instanceof Administrator))
                    numOfAllowedEdits++;
            }
            allUsersIDs = new String[numOfAllowedEdits];

            for (int i = 0; i < UserAccountArray.getUsers().size(); i++)
            {
                if (!(UserAccountArray.getUsers().get(i) instanceof Owner || UserAccountArray.getUsers().get(i) instanceof Administrator))
                    allUsersIDs[i] = UserAccountArray.getUsers().get(i).getUserID();
            }
        }
    }
}
