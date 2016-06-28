package support;

import order.Order;
import order.OrderCatalog;
import productData.Product;
import usr.User;
import usr.UserCatalog;

import java.util.ArrayList;

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

    public void register(User usr){
        if (!currentUser.register(usr))
            currentUser = new UserCatalog();
    }

//    public User findUser(String un){
//
//    }

    public User userLocator(String ID) throws UserNotFoundException{
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        UserCatalog uc = new UserCatalog(catalogID);
        uc.userLocator(userID);
    }

    public void newOrder(Order order){
        if (!currentOrder.newOrder(order))
            currentOrder = new OrderCatalog();
    }

    public void newProduct(Product product, String lst){
        
    }
}
