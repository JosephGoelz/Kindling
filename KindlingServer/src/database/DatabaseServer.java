package database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class DatabaseServer {
	public static final int PORT_NUMBER = 8888;
	
	private ServerSocket dbSocket;
	private Vector<DatabaseThread> threadList = new Vector<DatabaseThread>();
	
	public DatabaseServer() {
		Socket s = null;
		try {
			dbSocket = new ServerSocket(PORT_NUMBER);
			while (true) {
				System.out.println("Waiting for client to connect...");
				s = dbSocket.accept();
				System.out.println("Client " + s.getInetAddress() + ":" + s.getPort() + " connected");
				DatabaseThread thread = new DatabaseThread(s, this);
				threadList.add(thread);
				thread.start();
			}
		} catch (IOException ioe) {
			System.out.println("IO Exception with DBServer");
			System.out.println(ioe.getMessage());
		} finally {
			if (s != null) {
				try {
					s.close();
				} catch (IOException ioe) {
					System.out.println("IOE closing Socket: " + ioe.getMessage());
				}
			}
			if (dbSocket != null) {
				try {
					dbSocket.close();
				} catch (IOException ioe) {
					System.out.println("IOE closing ServerSocket: " + ioe.getMessage());
				}
			}
		}
	}
	
	public boolean removeThread(DatabaseThread thread) {
		return threadList.remove(thread);
	}

	public static void main(String[] args) {
		new DatabaseServer();
	}
}
