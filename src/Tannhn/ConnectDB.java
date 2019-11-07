package Tannhn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectDB {
	public static void main (String[] a)
	{
		Connection conn =  ConnectDB.createConnect();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from login");
			while(rs.next())
			{
				System.out.println("id: " + rs.getInt("id") + " username: " + rs.getString("login") + "password: " + rs.getString("password") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static Connection createConnect()
	{
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/test";
		String userName = "root";
		String passWord = "12345";
		
		try {
			Class.forName("com.mysql.jdbc.Driver"); //org.mariadb.jdbc.Driver
			conn = DriverManager.getConnection(url, userName, passWord);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
