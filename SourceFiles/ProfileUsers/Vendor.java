package ProfileUsers;

import java.util.Date;

public class Vendor extends Profile{
    public Vendor(){
        this.userID = 0;
        this.fullName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.phone = "";
        this.balance = 0;
        this.lastPaidAmount = 0;
    }
    Date seasonalDiscountsStartDate;

    public Vendor(int userID, String fullName, String streetAddress, String city, String state, String phone) {
        this.userID = userID; //auto generated max 6 character
        this.fullName = fullName;//must be unique
        this.streetAddress = streetAddress;//must be unique
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = 0;
        this.lastPaidAmount = 0;
    }
    public String toString(){
        return print() + "";
    }
}
