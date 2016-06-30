package productData;

import support.NoAccessPermitException;
import support.ProductNotFoundException;
import support.RepeatProductException;
import usr.Manager;
import usr.User;

/**
 * Created by mac on 16/6/29.
 */
public class ProdcutManager {


    public static void newProduct(Product product, ProductType pt, User usr) throws RepeatProductException,NoAccessPermitException {
        isAccessible(usr, product.getProductID());
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

    public static void rmProduct(String ID, User usr) throws ProductNotFoundException, NoAccessPermitException {
        isAccessible(usr,ID);
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

    private static void isAccessible(User usr, String ID) throws NoAccessPermitException {
        if (!(usr instanceof Manager))
            throw new NoAccessPermitException("Product "+ID);
    }
}
