package support;

import order.Order;
import order.OrderCatalog;
import productData.*;
import usr.*;

/**
 * Created by mac on 16/6/28.
 */
public class DataManager {
    private UserCatalog currentUser;
    private OrderCatalog currentOrder;

    public DataManager(){
        currentUser = new UserCatalog();
        currentOrder = new OrderCatalog();
    }

    private void register(User usr){
        if (!currentUser.register(usr))
            currentUser = new UserCatalog();
    }

    public void newEmployee(User ne, User hr)throws NoAccessPermitException{
        if (!(hr instanceof humanResource))
            throw new NoAccessPermitException("Employee Data");
        else
            register(ne);

    }

    public void newCustomer(User ne)throws NoAccessPermitException{
        if (!(ne instanceof Customer))
            throw new NoAccessPermitException("Customer Data");
        else
            register(ne);
    }

    public User userLocator(String ID) throws UserNotFoundException{
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        UserCatalog uc = new UserCatalog(catalogID);
        return uc.userLocator(userID);
    }

    public void newOrder(Order order){
        if (!currentOrder.newOrder(order))
            currentOrder = new OrderCatalog();
    }

    public void newProduct(Product product, ProductType pt) throws RepeatProductException {
        ProductCatalog p;
        switch (pt) {
            case SecurityCamera:
                p = new SecurityCamera();
                p.newProduct(product);
                break;
            case DVR:
                p = new DVR();
                p.newProduct(product);
                break;
            case Accessories:
                p = new Accessories();
                p.newProduct(product);
        }
    }

    public void rmProduct(String ID, User usr) throws ProductNotFoundException,NoAccessPermitException {
        if (!(usr instanceof Manager))
            throw new NoAccessPermitException("Product "+ID);
        String pt = ID.substring(0);
        ProductCatalog p;
        switch (pt) {
            case "1":
                p = new SecurityCamera();
                p.rmProduct(ID);
                break;
            case "2":
                p = new DVR();
                p.rmProduct(ID);
                break;
            case "3":
                p = new Accessories();
                p.rmProduct(ID);

        }

    }



    public void save(){
        currentOrder.save();
        currentUser.save();
    }


}
