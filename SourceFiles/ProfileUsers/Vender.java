package ProfileUsers;

import java.util.Date;

public class Vender extends Profile{
    Vender(){
    }
    Date seasonalDiscountsStartDate;
    public Vender(int userID, String fullName, String streetAddress, String city, String state, String phone, double balance, double lastPaidAmount) {
        this.userID = userID; //auto generated max 6 character
        this.fullName = fullName;//must be unique
        this.streetAddress = streetAddress;//must be unique
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = 0;
        this.lastPaidAmount = 0;
    }

}
