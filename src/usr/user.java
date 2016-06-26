package usr;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.util.locale.provider.FallbackLocaleProviderAdapter;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by mac on 16/6/25.
 */
public class User implements Serializable {
    private String userID;
    private String userName;
    private String passWord;
    private boolean status;

    public User(){
        userName = "Guest";
        setPassWord("Default");
        userID = "0";
        status = true;
    }

    public User(String un, String pw, String id, boolean st){
        userName = un;
        passWord = pw;
        userID = id;
        status = st;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String un){
        userName = un;
    }

    public void setPassWord(String pw) {
        byte [] data = pw.getBytes();
        passWord = (new BASE64Encoder()).encodeBuffer(data);
    }

    public String getEnPW(){
        return passWord;
    }

    private String pwDecoder() throws IOException {
        byte [] data = (new BASE64Decoder()).decodeBuffer(passWord);
        return new String(data);
    }

    public boolean isPWCorrect(String pw){
        try {
            return (pwDecoder().equals(pw));
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getStatus(){
        if (status)
            return "online";
        else return "offline";
    }

    public boolean logIn(String pw){
        if (isPWCorrect(pw)) {
            status = true;
            return true;
        }
        else{
            return false;
        }
    }

    public void logOut(){
        status = false;
    }

    public String toString(){
        return userID+','+userName+','+passWord+','+status;
    }

    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            return obj.userID == this.userID;
        }
        else return false;
    }
}
