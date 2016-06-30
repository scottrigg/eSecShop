package order;

import support.Catalog;
import support.OrderNotFoundException;



import java.util.ArrayList;

/**
 * Created by mac on 16/6/27.
 */
public class OrderCatalog extends Catalog {

    private ArrayList<Order> catalog;
    private String catalogID;

    public OrderCatalog(){
        super("order");
    }

    public OrderCatalog(String ID){
        super("order",ID);
    }

    public boolean newOrder(Order order){
        if (super.isFull()) {
            order.setOrderID(super.getCatalogID()+ catalog.size());
            catalog.add(order);
            save();
            return true;
        }
        else {
            save();
            return false;
        }
    }

    public Order orderLocator(String id) throws OrderNotFoundException {
        for (Object i : catalog) {
            Order tem = (Order) i;
            if (tem.getOrderID().equals(id)){
                return tem;
            }
        }
        throw new OrderNotFoundException(id);
    }

    @Override
    public String toString() {
        return catalogID+":"+catalog;
    }
}
