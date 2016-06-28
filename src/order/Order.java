package order;

import usr.User;

/**
 * Created by mac on 16/6/26.
 */
public class Order {
    private String orderID;
    private User supervisor;
    private String statment;

    public Order(String orderID){
        orderID = orderID;
        supervisor = null;
        statment = null;
    }




    public Order(String orderID, User supervisor, String statment) {
        this.orderID = orderID;
        this.supervisor = supervisor;
        this.statment = statment;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSupervisor() {
        return supervisor.toString();
    }

    public void setSupervisor(User supervisor) {
        this.supervisor = supervisor;
    }

    public String getStatment() {
        return statment;
    }

    public void setStatment(String statment) {
        this.statment = statment;
    }
}
