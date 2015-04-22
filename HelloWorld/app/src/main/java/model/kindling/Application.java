package model.kindling;

/**
 * Created by Jay on 4/21/2015.
 */
public class Application {
    private User _User;
    private boolean loggedIn;


    public Application(User _User){
        //when we log in we give the application our user
        //and set loggedIn to true
        this._User = _User;
        loggedIn = true;
    }

    private void logOut(){
        //we only need logOut because we log in as soon as the application
        //starts by default
        loggedIn = false;
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }

    public User get_User() {
        return _User;
    }

    public void set_User(User _User) {
        this._User = _User;
    }
}
