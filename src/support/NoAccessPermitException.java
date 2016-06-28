package support;

/**
 * Created by mac on 16/6/28.
 */
public class NoAccessPermitException extends Exception {
    public NoAccessPermitException(String msg){
        super("Read/Write request to"+msg+"denied");
    }
}
