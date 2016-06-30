package support;

import order.Order;
import order.OrderCatalog;
import productData.*;
import usr.*;

/**
 * Created by mac on 16/6/28.
 */
public class DataManager {
    protected Catalog currentCatalog;
    private OrderCatalog currentOrder;

    public DataManager(){
        currentUser = new UserCatalog();
        currentOrder = new OrderCatalog();
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
