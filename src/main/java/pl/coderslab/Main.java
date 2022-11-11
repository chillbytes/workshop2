package pl.coderslab;

public class Main {
    private static final String DIVIDER = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++";
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        User    user    = new User();

        /*

        //creating users//
        user.setUserName("Joanna");
        user.seteMail("joanna.blonda@coderslab.pl");
        user.setPassWord("anyżek");
        userDao.create(user);

        */






        //find all//
        User [] usr = userDao.findAll();
        printArr(usr, "Find all:");

        //read user data//
        User user1 = userDao.read(3);
        printUsr(user1, "Update data of user with id ==> 3:");


        //update user//
        user1.seteMail("grzegorz@bak.pl");
        userDao.update(user1);

        printUsr(user1, "After update of user with id ==> 3:");

        //delete user//
        //at first, create new user:
        user.setUserName("Balbina");
        user.seteMail("balbina.olek@conf.pl");
        user.setPassWord("superpassword");
        userDao.create(user);

        //print all users from db//
        User [] usarr1 = userDao.findAll();

        printArr(usarr1, "Before delete:");

        userDao.delete(user.getId());

        User [] usarr2 = userDao.findAll();

        printArr(usarr2, "After delete:");


    }

    public static void printArr(User [] userArr, String promptStr) {
        System.out.println(promptStr);
        for (int i = 0; i < userArr.length; i++) {
            System.out.println(DIVIDER);
            System.out.println("User id:        " + userArr[i].getId());
            System.out.println("User name:      " + userArr[i].getUserName());
            System.out.println("User eMail:     " + userArr[i].geteMail());
            System.out.println("User password:  " + userArr[i].getPassWord());
        }
        System.out.println(DIVIDER);
    }
    public static void printUsr(User user, String promptStr) {
        System.out.println(promptStr);
        System.out.println(DIVIDER);
        System.out.println("User id:        " + user.getId());
        System.out.println("User name:      " + user.getUserName());
        System.out.println("User eMail:     " + user.geteMail());
        System.out.println("User password:  " + user.getPassWord());
        System.out.println(DIVIDER);
    }
}