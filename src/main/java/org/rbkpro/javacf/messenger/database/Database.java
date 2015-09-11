package org.rbkpro.javacf.messenger.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
	public Connection Get_Connection() throws Exception
	{
		try
		{
		String connectionURL = "jdbc:mysql://localhost:3306/pers43";
		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		connection = DriverManager.getConnection(connectionURL+unicode, "root", "");
	    return connection;
		}
		catch (SQLException e)
		{
		throw e;	
		}
		catch (Exception e)
		{
		throw e;	
		}
	}

}