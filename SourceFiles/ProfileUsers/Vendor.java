package ProfileUsers;

import java.time.LocalDateTime;
import java.util.Date;
/*
Class for Vendor
@author Austin

 */
public class Vendor extends Profile{

    private LocalDateTime seasonalDiscount; //mm/dd/yyyy

    public Vendor(){
        this.userID = 0;
        this.fullName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.phone = "";
        this.balance = 0;
        this.lastPaidAmount = 0;
        this.seasonalDiscountsStartDate = null;
        this.lastOrderDate = null;
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

    public Vendor(int num, String fullname, String street, String city, String state, String phone, Date lastorder, Date seasonal) {
        this.userID = num; //auto generated max 6 character
        this.fullName = fullname;//must be unique
        this.streetAddress = street;//must be unique
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.balance = 0;
        this.lastPaidAmount = 0;
        this.lastOrderDate = lastorder;
        this.seasonalDiscountsStartDate = seasonal;
    }

    public String toString(){
        return print() + "";
    }
}
