package usr;

import support.Catalog;
import support.FileAccessable;
import support.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mac on 16/6/25.
 */
public class UserCatalog extends Catalog{


    public UserCatalog(){
        super("usr");
    }

    public UserCatalog(String ID){
        super("usr",ID);
    }

    public boolean register(User usr){
        if (super.isFull()) {
            usr.setUserID(super.getCatalogID()+ catalog.size());
            catalog.add(usr);
            save();
            return true;
        }
        else {
            save();
            return false;
        }
    }

    public User userLocator(String id) throws UserNotFoundException {
        int tem = Integer.parseInt(id);
        if (tem > 100)
            throw new UserNotFoundException(id);
        return (User) catalog.get(tem);
    }
}
