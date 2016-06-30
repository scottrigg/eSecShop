package order;

import productData.Product;
import support.ProductNotFoundException;

import java.util.ArrayList;

/**
 * Created by mac on 16/6/29.
 */
public class ShoppingCart {
    private ArrayList<Product> cart;

    public ShoppingCart() {
        cart = new ArrayList<>();
    }

    public ArrayList<Product> getCart() {
        return cart;
    }

    public Product locater(String ID) throws ProductNotFoundException{
        for(Product i: cart){
            if (i.getProductID().equals(ID))
                return i;
        }
        throw new ProductNotFoundException(ID);
    }

    public void addCart(String ID) throws ProductNotFoundException{
        cart.add(locater(ID));
    }

    public void rmCart(String ID) throws ProductNotFoundException{
        cart.remove(locater(ID));
    }

    public void clearCart(){
        cart.clear();
    }
}
