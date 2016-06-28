package support;

/**
 * Created by mac on 16/6/27.
 */
public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String msg){
        super("Product "+msg+" not exist");
    }
}
