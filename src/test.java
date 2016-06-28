import usr.User;
import usr.UserCatalog;
import usr.UserInterface;

import java.util.ArrayList;

/**
 * Created by mac on 16/6/25.
 */
public class test {
    public static void main(String args[]){
        UserInterface ui = new UserInterface();

//        UserCatalog user= new UserCatalog();
//        for (int i = 0; i < 50 ; i++) {
//            User test = new User();
//            user.register(test);
//        }
//        user.save();
        UserCatalog u2 = new UserCatalog("0");
        ArrayList<User> exam = u2.getCatalog();
        for (User i: exam){
            System.out.println(i);
        }

//        User usr = new User();
//        String ans = usr.pwEncoder("1234567");
//        try {
//            System.out.print(ans + usr.pwDecoder(ans));
//        }
//        catch (IOException ioe){
//            System.err.print("err");
//        }
    }
}
