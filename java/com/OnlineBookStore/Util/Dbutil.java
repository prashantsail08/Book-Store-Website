package com.OnlineBookStore.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	private static Connection con;

	public static Connection getDbConnection()
	{
		if(con==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore","root","root");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}



}
