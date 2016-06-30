package order;

import support.DataManager;
import support.OrderNotFoundException;
import usr.UserCatalog;

/**
 * Created by mac on 16/6/29.
 */
public class OrderManager extends DataManager{
    public OrderManager() {
        super.currentCatalog = new OrderCatalog();
    }

    public void newOrder(Order order){
        OrderCatalog oc = (OrderCatalog) currentCatalog;
        if (!oc.newOrder(order))
            oc = new OrderCatalog();
    }

    public Order orderLocater(String ID) throws OrderNotFoundException {
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        OrderCatalog oc = new OrderCatalog(catalogID);
        return oc.orderLocator(userID);
    }
}
