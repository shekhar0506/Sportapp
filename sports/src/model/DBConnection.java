package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getDBCon()
	{
		Connection con = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sush?user=root2&password=myroot");
			if(con!=null)
				System.out.println("Connected...");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}

