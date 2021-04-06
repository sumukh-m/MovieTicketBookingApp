package org.drait;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCHelper {
	
	public static void close(ResultSet x)
	{
		if ( x != null )
		{
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Statement x)
	{
		if ( x != null )
		{
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void close(Connection x)
	{
		if ( x != null )
		{
			try {
				x.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName(Constants.DRIVER_NAME);
			con = DriverManager.getConnection(Constants.URL, Constants.UID, Constants.PWD);
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		}
	}
}
