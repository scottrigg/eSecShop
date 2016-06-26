package usr;

import support.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mac on 16/6/25.
 */
public class UserCatalog {
    private String catalogID;
    private ArrayList<User> cataLog;

    public UserCatalog(String ID){
        catalogID = ID;
        try{
            FileInputStream fis = new FileInputStream(catalogID+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < 100 ; i++) {
                cataLog.add((User)ois.readObject());
            }
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
    }

    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream(catalogID+".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (User i : cataLog) {
                oos.writeObject(i);
            }
            oos.close();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public boolean register(User usr){
        if (cataLog.size() < 100) {
            cataLog.add(usr);
            return true;
        }
        else return false;
    }

    public String findUser(String id) throws UserNotFoundException {
        for (User i :cataLog) {
            if (i.getUserID().equals(id)){
                return i.toString();
            }
        }
        throw new UserNotFoundException(id);
    }

}
