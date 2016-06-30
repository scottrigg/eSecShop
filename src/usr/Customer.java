package usr;

import order.Order;
import productData.Product;
import support.Address;
import support.PayMethod;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by mac on 16/6/26.
 */
public class Customer extends User {
    private String emailAddress;
    private ArrayList<Address> addressBook;
    private ArrayList<PayMethod> payBook;
    private ArrayList<Order> orderHistory;

    public Customer() {
        super();
        emailAddress = null;
        addressBook =  new ArrayList<Address>();
        payBook = new ArrayList<PayMethod>();
        orderHistory = new ArrayList<Order>();
    }

    public Customer(String un, String pw, String id, boolean st, String emailAddress, ArrayList<Address> addressBook, ArrayList<PayMethod> payBook, ArrayList<Order> orderHistory) {
        super(un, pw, id, st);
        this.emailAddress = emailAddress;
        this.addressBook = addressBook;
        this.payBook = payBook;
        this.orderHistory = orderHistory;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDefaultAddress(){
        return  addressBook.get(0).toString();
    }

    public String getDefaultPayment(){
        return payBook.get(0).toString();
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addOrderHistory(Order o){
        orderHistory.add(o);
    }

    public ArrayList<String> viewAllAddress(){
        ArrayList<String> result=new ArrayList<>();
        for (Address i: addressBook){
            result.add(i.toString());
        }
        return result;
    }

    public ArrayList<String> viewAllPayment(){
        ArrayList<String> result=new ArrayList<>();
        for (PayMethod i: payBook){
            result.add(i.toString());
        }
        return result;
    }

    public void setAddress(int index, Address add){
        addressBook.set(index, add);
    }

    public void setPayment(int index, PayMethod pay){
        payBook.set(index,pay);
    }

    public void setDefaultAddress(int index){
        Collections.swap(addressBook,0,index);
    }

    public void setDefaultPayment(int index){
        Collections.swap(payBook,0,index);
    }

    @Override
    public String toString() {
        String result=super.toString()+","+emailAddress+"\n";
        for(String i:viewAllAddress()){
            result += i;
            result += ",";
        }
        result += "\n";
        for(String i:viewAllPayment()){
            result += i;
            result += ",";
        }
        return result;
    }
}
