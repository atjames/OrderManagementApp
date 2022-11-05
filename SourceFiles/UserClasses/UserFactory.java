package UserClasses;

public class UserFactory
{
    public User userFactory(String userType)
    {
        if (userType == "Owner")
            return new Owner();
        else if (userType == "Administrator")
            return new Administrator();
        else if (userType == "InventoryManager")
            return new InventoryManager();
        else if (userType == "Purchaser")
            return new Purchaser();
        else if (userType == "SalesPerson")
            return new SalesPerson();
        else if (userType == "Accountant")
            return new Accountant();
        else
            return null;
        /*
        return switch (userType) {
            case "Owner" -> new Owner();
            case "Administrator" -> new Administrator();
            case "InventoryManager" -> new InventoryManager();
            case "Purchaser" -> new Purchaser();
            case "SalesPerson" -> new SalesPerson();
            case "Accountant" -> new Accountant();
            default -> null;
        };
        */
    }
}
