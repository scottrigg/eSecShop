package usr;

import support.FileAccessable;
import support.UserNotFoundException;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by mac on 16/6/25.
 */
public class UserCatalog implements FileAccessable{
    private String catalogID;
    private ArrayList<User> cataLog;

    public UserCatalog(){
        newCatalog();
    }

    public UserCatalog(String ID){
        catalogID = ID;
        cataLog = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(catalogID+".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object i = ois.readObject();
            while (i != null) {
                cataLog.add((User)i);
                i = ois.readObject();
            }
            ois.close();
        }
        catch (EOFException eofe){

        }
        catch (FileNotFoundException fnf){
            newCatalog();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
        catch (ClassNotFoundException cnf){
            cnf.printStackTrace();
        }
    }

    public void newCatalog(){
        try {
            FileReader fr = new FileReader("index.txt");
            BufferedReader bf = new BufferedReader(fr);
            Integer id = bf.read()-48;
            if (id > 0) id++;
            catalogID = id.toString();
            cataLog = new ArrayList<>();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
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
            usr.setUserID(catalogID+cataLog.size());
            cataLog.add(usr);
            return true;
        }
        else return false;
    }

    public User findUser(String id) throws UserNotFoundException {
        for (User i :cataLog) {
            if (i.getUserID().equals(id)){
                return i;
            }
        }
        throw new UserNotFoundException(id);
    }

    public ArrayList<User> getCataLog() {
        return cataLog;
    }
}
