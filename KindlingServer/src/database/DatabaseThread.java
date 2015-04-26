package database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DatabaseThread extends Thread {
	private Socket s;
	private BufferedReader serverIn;
	private PrintWriter serverOut;
	
	public DatabaseThread(Socket s) {
		this.s = s;
		try {
			serverIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
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
			// Constantly wait for a line to come in, then process it
			while (true) {
				String line = serverIn.readLine();
				// If we disconnect unexpectedly, don't send the line
				if(line == null) throw new IOException("Null line");
				sendMessage("Line received");
			}
		} catch (IOException ioe) {
			//server.removeThread(this);
			System.out.println(s.getInetAddress() + ":" + s.getPort() + " disconnected.");
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
