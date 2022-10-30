package SourceFiles.ProfileUsers;

import SourceFiles.ProfileUsers.*;

public class ProfileFactory {
    public Profile ProfileFactory(String profileType)
    {
        if(profileType.equals("Vender")){
            return new Vender();
        }
        else if(profileType.equals("Customer")){
            return new Customer();
        }
        return null;
    }

}
