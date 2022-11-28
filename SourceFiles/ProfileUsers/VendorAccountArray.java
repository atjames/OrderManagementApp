package ProfileUsers;
/*
Class for Array of vendors to be used across the project
@author Austin Jeffery
 */
public class VendorAccountArray {
    public static int arraySize = 0;
    public static Vendor[] vendors = new Vendor[arraySize];

    public static void print() {
        for(int i = 0; i <arraySize; i++){
            System.out.println(vendors[i].getFullName());

        }

    }

    public int getLength()
    {
        return arraySize;
    }
    public static void updateVendor(Vendor vendor,int i){
        vendors[i] = vendor;
    }
    public static void addVendor(Vendor vendor)
    {
        increaseArraySize();
        vendors[arraySize - 1] = vendor;
    }
    public static void deleteVendor(Vendor vendor)
    {
        Vendor[] temporaryHold = vendors;
        arraySize= arraySize-1;
        Vendor[] copy = new Vendor[arraySize];
        int index = vendor.getUserID();
        int k = 0;
        for(int i = 0; i < arraySize+1; i++){
            if(i == index){
                continue;
            }
            copy[k++] = temporaryHold[i];
        }
        vendors = new Vendor[arraySize];
        vendors = copy;
        for(int i= 0;i<arraySize;i++){

            vendors[i].setUserID(i);
           // System.out.println(vendors[i].getFullName() + " id: " + vendors[i].getUserID());
            }
    }


    private static void increaseArraySize()
    {
        Vendor[] temporaryHold = vendors;

        arraySize += 1;
        vendors = new Vendor[arraySize];
        for (int i = 0; i < arraySize - 1; i++)
        {
            vendors[i] = temporaryHold[i];
        }
    }

    public static Vendor searchForUser(int id)
    {
        Vendor toBeFound = null;

        for (int i = 0; i < arraySize; i++)
        {
            if (vendors[i].getUserID() == id)
            {
                toBeFound = vendors[i];
            }
        }

        return toBeFound;
    }
    public static Vendor searchForUser(String name)
    {
        Vendor toBeFound = null;

        for (int i = 0; i < arraySize; i++)
        {
            if (vendors[i].getFullName().equals(name))
            {
                toBeFound = vendors[i];
            }
        }

        return toBeFound;
    }

}
