package order;

import productData.Product;
import support.Address;
import support.NoAccessPermitException;
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


    public ShopOrder(String ID, ArrayList<Product> orderList, PayMethod payment, DeliverOrder delO) {
        super(ID);
        this.orderList = orderList;
        this.payment = payment;
        this.delivery = delO;
        super.status = new ArrayList<String>();
        super.status.add("Wait for confirm,system,"+currentDate());
    }

    public ShopOrder(String orderID, User supervisor, Customer customer, ArrayList<Product> orderList, PayMethod payment, DeliverOrder delivery, ArrayList<String> status) {
        super(orderID, supervisor, status);
        this.customer = customer;
        this.orderList = orderList;
        this.payment = payment;
        this.delivery = delivery;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Product> getOrderList() {
        return (ArrayList<Product>) orderList.clone();
    }

    public void setOrderList(ArrayList<Product> orderList) {
        this.orderList = orderList;
    }

    public PayMethod getPayment() {
        return payment;
    }

    public DeliverOrder getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliverOrder delivery) {
        this.delivery = delivery;
    }

    @Override
    public String toString() {
        return "Shopping" + super.toString()
                + customer.getUserName() + customer.getUserID() + '\n'
                + payment.toString() + '\n'
                + delivery.getOrderID();

    }

    public int total() {
        int result = 0;
        for(Product i:orderList){
            result += i.getPrice();
        }
        return result;
    }


    //    public void confirm(String id, Employee supervisor){
//        super.setOrderID(id);
//        super.setSupervisor(supervisor);
//        update("confirmed",supervisor);
//    }
//
//    public void shipped(DeliverOrder DO, Employee logistics){
//        delivery = DO;
//        update("shipped",logistics);
//    }
//
//    public void delivered(User logistics){
//        update("delivered",logistics);
//    }



}
