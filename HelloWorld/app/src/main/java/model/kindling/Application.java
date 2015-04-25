package model.kindling;

/**
 * Created by Jay on 4/21/2015.
 */
public class Application {
    private static User _User;
    private static boolean loggedIn;

    public Application(User _User){
        //when we log in we give the application our user
        //and set loggedIn to true
        this._User = _User;
        loggedIn = true;
    }

    public static void logOut(){
        //we only need logOut because we log in as soon as the application
        //starts by default
        loggedIn = false;
    }
    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static User getUser() {
        return _User;
    }
}
