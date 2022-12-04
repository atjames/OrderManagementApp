package ProfileUsers;

public class ProfileFactory {
    public Profile makeProfile(String profileType)
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
