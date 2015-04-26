package database.sqlcommands;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthenticateUser extends SQLCommand {
	boolean good = false;
	private static String query = "SELECT * FROM users WHERE username='";
	private String passwordWanted;
	private boolean isGood = false;
	
	public boolean checkUser(String username, String password) {
		passwordWanted = password;
		super.runQuery(query + username + "'");
		return isGood;
	}
	
	@Override
	protected void filterRS(ResultSet rs) {
		try {
		while(rs.next()) {
			if(rs.getString("password").equals(passwordWanted)) {
				isGood = true;
				break;
			}
		}
		} catch(SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
		}
	}

}
