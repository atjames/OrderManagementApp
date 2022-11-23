package ProfileUsers;

public class ProfileFactory {
    public static Profile ProfileFactory(String profileType)
    {
        if(profileType.equals("Vendor")){
            return new Vendor();
        }
        else if(profileType.equals("Customer")){
            return new Customer();
        }
        return null;
    }

}
