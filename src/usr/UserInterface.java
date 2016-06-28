package usr;

import support.NotLogInException;
import support.UserNotFoundException;

import java.io.*;

/**
 * Created by mac on 16/6/26.
 */
public class UserInterface {
    User currentUser;
    UserCatalog currentCatalog;

    public UserInterface(){
        try {
            currentUser = new Customer();
            FileReader fr = new FileReader("index.txt");
            BufferedReader bf = new BufferedReader(fr);
            currentCatalog = new UserCatalog(bf.readLine());
            register();
            //login();
        }
        catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void login() throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to E-Security system!");

        System.out.println("Please enter your User Name:");
        String userId=br.readLine();
        System.out.println("Please enter your password:");
        String pass = br.readLine();
        UserCatalog uc = new UserCatalog("0");
        while (true){
            try{
                User user = uc.userLocator(userId);
                if (user.logIn(pass)) {
                    //currentUser = user;
                    break;
                }
                else
                    System.out.print("Password is not correct.");
                System.out.println("Please enter your userId:");
                userId=br.readLine();
                System.out.println("Please enter your password:");
                pass = br.readLine();
            }
            catch (UserNotFoundException unf) {
                System.out.print("Cannot find user:" + userId);
            }
        }
        if (currentUser instanceof Customer) {
            customerInterface();
        }
        if (currentUser instanceof Employee) {
            employeeInterface();
        }
    }

    private void customerInterface(){
        while (true){

        }
    }

    private void employeeInterface(){

    }

    public void register() throws IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to E-Security system Registration!");

        System.out.println("Please enter your userName:");
        String userName=br.readLine();
        System.out.println("Please enter your password:");
        String pass = br.readLine();
        System.out.println("Please enter your Email Address:");
        String email = br.readLine();
        Customer csm = (Customer) currentUser;
        csm.setUserName(userName);
        try {
            csm.setPassWord(pass);
        }
        catch (NotLogInException nli){
            nli.printStackTrace();
        }
        csm.setEmailAddress(email);
        currentUser = csm;
        if (!currentCatalog.register(currentUser)){
            currentCatalog.save();
            currentCatalog = new UserCatalog();
            currentCatalog.register(currentUser);
        }
        currentCatalog.save();
        System.out.println("Registration Complete!");
    }


}
