package pl.coderslab;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int id;
    private String userName;
    private String passWord; //hashed
    private String eMail;

    //getters:
    public int getId() {
        return id;
    }
    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public String geteMail() {
        return eMail;
    }
    //setters:
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassWord(String passWord) {
        this.passWord = BCrypt.hashpw(passWord, BCrypt.gensalt(12));
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    public void setIt(int id) {
        this.id = id;
    }
    //gererators:
    public User() {}
    public User(int id, String userName, String eMail,  String passWord) {
        this.id       = id;
        this.userName = userName;
        this.passWord = BCrypt.hashpw(passWord, BCrypt.gensalt(12));
        this.eMail    = eMail;
    }




    //pas encryp.//
    private static void hashPassword(String[] args) {


        String password = "haselko";
        String candidate = "haselko";
        // Hash a password for the first time
        //String hashed = BCrypt.hashpw(password, BCrypt.gensalt());

        // gensalt's log_rounds parameter determines the complexity
        // the work factor is 2**log_rounds, and the default is 10
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));

        // Check that an unencrypted password matches one that has
        // previously been hashed
        if (BCrypt.checkpw(candidate, hashed))
            System.out.println("It matches");
        else
            System.out.println("It does not match");

    }


}
