package support;

/**
 * Created by mac on 16/6/26.
 */
public class NotLogInException extends Exception {
    public NotLogInException(){
        super("You are currently not log in.");
    }
}
