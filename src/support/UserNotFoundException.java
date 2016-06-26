package support;

/**
 * Created by mac on 16/6/26.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException(String id){
        super("User:"+id+"cannot found.");
    }
}
