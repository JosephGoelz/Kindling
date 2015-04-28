package model.kindling;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by Jay on 4/21/2015.
 */
public class Application {
    private static User _User;
    private static boolean loggedIn = false;
    private static Socket chatSocket;

    public static void initApplication(User user) {
        //when we log in we give the application our user
        //and set loggedIn to true
        _User = user;
        loggedIn = true;
        // TODO: Get the chat server working. Connection should be ok
        // openChatSocket();
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

    public static Socket getChatSocket() {
        return chatSocket;
    }

    public static void openChatSocket() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    chatSocket = new Socket("198.199.92.13", 7777);
                } catch (IOException ioe) {
                    System.out.println("IOE in ChatClient constructor: " + ioe.getMessage());
                    try {
                        chatSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.start();
    }
}
