package database.sqlcommands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class SQLCommand {
	protected static final String DRIVER = "com.mysql.jdbc.Driver";
	protected static final String DB_ADDRESS = "jdbc:mysql://localhost:3306/";
	protected static final String DB_NAME = "bindling";
	protected static final String DB_USER = "root";
	protected static final String DB_PW = "kindling";

	protected void runQuery(String query) {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(DB_ADDRESS + DB_NAME, DB_USER, DB_PW);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			filterRS(rs);
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("CNFE: " + cnfe.getMessage());
		}
		catch (SQLException sqle) {
			System.out.println("SQLE: " + sqle.getMessage());
		}
	}
	
	protected abstract void filterRS(ResultSet rs);
}
