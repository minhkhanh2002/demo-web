package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private static String DB_URL = "jdbc:mysql://localhost:3306/webshop";
	private static String USER_NAME = "root";
	private static String PASSWORD = "";
	
	
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
			System.out.println("connect successfully!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}
