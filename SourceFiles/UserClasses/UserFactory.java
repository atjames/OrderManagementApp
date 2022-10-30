package SourceFiles.UserClasses;

public class UserFactory
{
    public User userFactory(String userType)
    {
        return switch (userType) {
            case "Owner" -> new Owner();
            case "Administrator" -> new Administrator();
            case "InventoryManager" -> new InventoryManager();
            case "Purchaser" -> new Purchaser();
            case "SalesPerson" -> new SalesPerson();
            case "Accountant" -> new Accountant();
            default -> null;
        };
    }
}
