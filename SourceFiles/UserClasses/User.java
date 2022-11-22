package UserClasses;

public abstract class User
{
    String lastName;
    String firstName;
    int userID;
    String userRole;
    String password;

    // Getter and Setters
    protected String getLastName()
    {
        return lastName;
    }
    protected  void setLastName(String lname)
    {
        lastName = lname;
    }

    protected String getFirstName()
    {
        return firstName;
    }
    protected  void setFirstName(String fname)
    {
        firstName = fname;
    }

    protected String getUserRole()
    {
        return userRole;
    }
    protected  void setUserRole(String uRole)
    {
        userRole = uRole;
    }

    protected int getUserID()
    {
        return userID;
    }
    protected  void setUserID(int id)
    {
        userID = id;
    }

    protected String getPassword()
    {
        return password;
    }
    protected  void setPassword(String pass)
    {
        password = pass;
    }
}
