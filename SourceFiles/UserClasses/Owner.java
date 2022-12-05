package UserClasses;

import javax.swing.*;

public class Owner extends User
{

    @Override
    public void update(String fullName)
    {
        JOptionPane.showMessageDialog(null, fullName + " Is Having A Sale!");
    }
}
