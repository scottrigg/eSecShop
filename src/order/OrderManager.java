package order;

import support.DataManager;

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

    public void checkOut(ShopOrder so){

    }
}
