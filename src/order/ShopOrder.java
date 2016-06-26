package order;

import shop.Product;
import support.PayMethod;
import usr.Customer;
import usr.Employee;
import usr.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by mac on 16/6/26.
 */
public class ShopOrder extends Order{
    private Customer customer;
    private ArrayList<Product> orderList;
    private PayMethod payment;
    private DeliverOrder delivery;
    private ArrayList<String> status;

    public ShopOrder(ArrayList<Product> orderList, PayMethod payment) {
        super();
        this.orderList = orderList;
        this.payment = payment;
        status = new ArrayList<String>();
        status.add("Wait for confirm,system,"+currentDate());
    }

    public ShopOrder(String orderID, User supervisor, String statment, Customer customer, ArrayList<Product> orderList, PayMethod payment, DeliverOrder delivery, ArrayList<String> status) {
        super(orderID, supervisor, statment);
        this.customer = customer;
        this.orderList = orderList;
        this.payment = payment;
        this.delivery = delivery;
        this.status = status;
    }

    public void update(String msg, User usr){
        status.add(msg+usr.getUserID()+currentDate());
    }

    public void confirm(String id, Employee supervisor){
        super.setOrderID(id);
        super.setSupervisor(supervisor);
        update("confirmed",supervisor);
    }

    public void shipped(DeliverOrder DO, Employee logistics){
        delivery = DO;
        update("shipped",logistics);
    }

    public void delivered(User logistics){
        update("delivered",logistics);
    }

    private String currentDate(){
        return (new SimpleDateFormat("MM.dd")).format(new Date());
    }

}
