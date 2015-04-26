package database;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import database.sqlcommands.AuthenticateUser;
import users.User;

public class DatabaseThread extends Thread {
	private Socket s;
	private ObjectInputStream serverIn;
	private PrintWriter serverOut;
	
	// Initializes thread to communicate with specified socket
	public DatabaseThread(Socket s) {
		this.s = s;
		try {
			serverIn = new ObjectInputStream(s.getInputStream());
			serverOut = new PrintWriter(s.getOutputStream());
		} catch (IOException ioe) {
			System.out.println("IOE in DatabaseThread constructor: " + ioe.getMessage());
		}
	}

	public void sendMessage(String str) {
		serverOut.println(str);
		serverOut.flush();
	}

	public void run() {
		try {
			// Stay waiting for requests
			while (true) {
				DatabaseRequest request = (DatabaseRequest) serverIn.readObject();
				
				// If we disconnect unexpectedly, don't send the line
				if(request == null) throw new IOException("Null line");
				
				// Process request
				RequestType rt = request.getRequestType();
				User user = request.getUser();
				// TODO add code to do different things based on request type
				if(rt == RequestType.AUTHENTICATE_USER) {
					AuthenticateUser au = new AuthenticateUser();
					if(au.checkUser(user.getUsername(), user.getPassword()))
						sendMessage("Good.");
					else sendMessage("Bad.");
				}
				else {
					sendMessage("Line received: " + request.getUser().getUsername());
				}
			}
		}
		
		// Catch things
		catch (IOException ioe) {
			System.out.println(s.getInetAddress() + ":" + s.getPort() + " disconnected.");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("CNFE in reading request: " + cnfe.getMessage());
		}
		
		// Close readers, writers, socket
		finally {
			serverOut.close();
			try {
				if(serverIn != null) serverIn.close();
				if (s != null) s.close();
			} catch (IOException ioe) {
				System.out.println("IOE closing Socket: " + ioe.getMessage());
			}
		}
	}
}
