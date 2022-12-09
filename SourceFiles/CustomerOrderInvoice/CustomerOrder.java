package CustomerOrderInvoice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CustomerOrder {
public int id;
private String custName;
    public Date getNeedbydate() {
        return needbydate;
    }

    public void setNeedbydate(Date needbydate) {
        this.needbydate = needbydate;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public int[] getQuantity() {
        return quantity;
    }

    public void setQuantity(int[] quantity) {
        this.quantity = quantity;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double total;
private Date needbydate;
private Date orderdate;
private int[] quantity = new int[5];
private String[] items = new String[5];

    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    public CustomerOrder(int id,String name, double total, String needbydate, String orderdate, int quantity[], String items[]) {
        this.id = id;
        this.custName = name;
        this.total = total;

        try {
            this.needbydate = formatter.parse(needbydate);
            this.orderdate = formatter.parse(orderdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.quantity = quantity;
        for(int i = 0; i <5;i++){
            this.items[i] = items[i];
        }
    }

    public CustomerOrder() {

    }
    public String itemquantity(){
        String output ="";
        for(int i = 0; i < 5; i++){
            output += " item: " + this.items[i] + " quantity: " + this.quantity[i];
        }

        return output;
    }
    public String displayCustomerOrder(){
        String output ="ID: " + this.id + " total: " + this.total + " Need By Date: " + this.needbydate + " Order Date: "  + this.orderdate
                + " \n\n " + itemquantity();
        return output;
    }
}
