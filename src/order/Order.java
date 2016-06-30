package order;

import usr.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mac on 16/6/26.
 */
public class Order {
    private String orderID;
    private User operator;
    protected ArrayList<String> status;

    public Order(String orderID){
        this.orderID = orderID;
        operator = null;

    }

    public Order(String orderID, User supervisor, ArrayList<String> status) {
        this.orderID = orderID;
        this.operator = supervisor;
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSupervisor() {
        return operator.toString();
    }

    public void setSupervisor(User supervisor) {
        this.operator = supervisor;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order: "
                + orderID + ','
                + operator.getUserID() + '\n'
                + status + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        return orderID != null ? orderID.equals(order.orderID) : order.orderID == null;

    }

    protected String currentDate(){
        return (new SimpleDateFormat("MM.dd")).format(new Date());
    }

    public void update(String msg, User usr){
        status.add(msg+usr.getUserID()+currentDate());
    }

}
