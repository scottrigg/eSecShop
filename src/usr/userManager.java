package usr;

import support.DataManager;
import support.NoAccessPermitException;
import support.UserNotFoundException;

/**
 * Created by mac on 16/6/29.
 */
public class UserManager extends DataManager{
    public UserManager() {
        super.currentCatalog = new UserCatalog();
    }

    private void register(User usr){
        UserCatalog uc = (UserCatalog) currentCatalog;
        if (!uc.register(usr))
            uc = new UserCatalog();
    }

    public void newEmployee(User ne, User hr)throws NoAccessPermitException {
        if (!(hr instanceof humanResource))
            throw new NoAccessPermitException("Employee Data");
        else
            register(ne);

    }

    public void newCustomer(User ne)throws NoAccessPermitException{
        if (!(ne instanceof Customer))
            throw new NoAccessPermitException("Customer Data");
        else
            register(ne);
    }

    public User userLocator(String ID) throws UserNotFoundException {
        String catalogID = ID.substring(0,ID.length()-2);
        String userID = ID.substring(ID.length()-2,ID.length());
        UserCatalog uc = new UserCatalog(catalogID);
        return uc.userLocator(userID);
    }

    public boolean login(String ID,String pw) {
        try {
            return (userLocator(ID)).logIn(pw);
        }
        catch (UserNotFoundException unf){
            System.err.print(unf.getMessage());
            return false;
        }
    }

    public void logOut(User usr){
        usr.logOut();
    }

}
