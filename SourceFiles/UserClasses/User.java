package UserClasses;

public abstract class User
{
    String lastName;
    String firstName;
    String userID;
    String userRole;
    String password;

    // Getter and Setters
    public String getLastName()
    {
        return lastName;
    }
    public   void setLastName(String lname)
    {
        lastName = lname;
    }

    public String getFirstName()
    {
        return firstName;
    }
    public  void setFirstName(String fname)
    {
        firstName = fname;
    }

    public String getUserRole()
    {
        return userRole;
    }
    public  void setUserRole(String uRole)
    {
        userRole = uRole;
    }

    public String getUserID()
    {
        return userID;
    }
    public void setUserID(String id)
    {
        userID = id;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String pass)
    {
        password = pass;
    }
}
