package ProfileUsers;

public class ProfileAccountArray {
    public static int arraySize = 0;
    public static Profile[] profiles = new Profile[arraySize];
    public int getLength()
    {
        return arraySize;
    }
    public static void updateVendor(Vendor profile,int i){
        profiles[i] = profile;
    }
    public static void addProfile(Profile profile)
    {
        increaseArraySize();
        profiles[arraySize - 1] = profile;
    }

    private static void increaseArraySize()
    {
        Profile[] temporaryHold = profiles;

        arraySize += 1;
        profiles = new Profile[arraySize];
        for (int i = 0; i < arraySize - 1; i++)
        {
            profiles[i] = temporaryHold[i];
        }
    }

    public static Profile searchForUser(int id)
    {
        Profile toBeFound = null;

        for (int i = 0; i < arraySize; i++)
        {
            if (profiles[i].getUserID() == id)
            {
                toBeFound = profiles[i];
            }
        }

        return toBeFound;
    }

}
