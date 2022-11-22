package UserClasses;

public class UserAccountArray
{
    private static int arraySize = 0;
    private static User[] users = new User[arraySize];

    public static void testAccount()
    {
        User owner = UserFactory.userFactory("Owner");
        owner.setUserID(123456);
        owner.setPassword("123Forger");

        addUser(owner);
    }

    public static void addUser(User user)
    {
        increaseArraySize();

        users[arraySize - 1] = user;
    }

    private static void increaseArraySize()
    {
        User[] temporaryHold = users;

        arraySize += 1;
        users = new User[arraySize];
        for (int i = 0; i < arraySize - 1; i++)
        {
             users[i] = temporaryHold[i];
        }
    }

    public static User searchForUser(int id, String Password)
    {
        User toBeFound = null;

        for (int i = 0; i < arraySize; i++)
        {
            if (users[i].getUserID() == id)
            {
                toBeFound = users[i];
            }
        }

        return toBeFound;
    }

}
