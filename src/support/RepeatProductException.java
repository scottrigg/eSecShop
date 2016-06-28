package support;

import productData.Product;

/**
 * Created by mac on 16/6/27.
 */
public class RepeatProductException extends Exception {
    public RepeatProductException(Product msg){
        super("Product "+msg.toString()+" has already added");
    }
}
