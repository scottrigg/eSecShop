package support;

/**
 * Created by mac on 16/6/28.
 */
public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String id){
        super("Order "+id+"does not exist");
    }
}
