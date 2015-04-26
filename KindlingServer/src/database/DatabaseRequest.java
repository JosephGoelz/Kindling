package database;

import java.io.Serializable;

import users.User;

public class DatabaseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final User user;
	private final RequestType type;

	// Constructor
	public DatabaseRequest(User u, RequestType type) {
		this.user = u;
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public RequestType getRequestType() {
		return type;
	}
}