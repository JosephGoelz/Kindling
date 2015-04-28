package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tcai on 4/26/15.
 */

// This works in Java lol idk whats happening with android fml
    // why??? why????????????? PLS HELP
public class ChatClientThread extends Thread {
    private PrintWriter pw;
    private BufferedReader br;
    private Scanner scan;
    private Socket s;
    public ChatClientThread() {
        try {
            s = new Socket("198.199.92.13", 7777);
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            pw = new PrintWriter(s.getOutputStream());
            scan = new Scanner(System.in);
            this.start();
            while(true) {
                String line = scan.nextLine();
                if(line == null) break;
                pw.println(line);
                pw.flush();
            }
        } catch (IOException ioe) {
            System.out.println("IOE in ChatClient constructor: " + ioe.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (pw != null) {
                    pw.close();
                }
                if (s != null) {
                    s.close();
                }
                if (scan != null) {
                    scan.close();
                }
            } catch (IOException ioe) {
                System.out.println("IOE closing things in ChatClient constructor: " + ioe.getMessage());
            }
        }
    }
    public void run() {
        try {
            while (true) {
                String line = br.readLine();
                System.out.println(line);

            }
        } catch (IOException ioe) {
            System.out.println("IOE in ChatClient.run(): " + ioe.getMessage());
        }
    }
}
