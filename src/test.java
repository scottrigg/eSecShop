import usr.User;

import java.io.IOException;

/**
 * Created by mac on 16/6/25.
 */
public class test {
    public static void main(String args[]){
        User usr = new User();
        String ans = usr.pwEncoder("1234567");
        try {
            System.out.print(ans + usr.pwDecoder(ans));
        }
        catch (IOException ioe){
            System.err.print("err");
        }
    }
}
