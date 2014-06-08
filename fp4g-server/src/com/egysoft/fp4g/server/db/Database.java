package com.egysoft.fp4g.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	private final String url;
	private Connection connection;
	
	public Database(String url)
	{
		this.url = url;
	}
	
	public void init()
	{
		try 
		{			
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s",url));			
		}
		catch (ClassNotFoundException e) 
		{		
			e.printStackTrace();
		}
		catch (SQLException e) 
		{		
			e.printStackTrace();
		}
	}
	
	public void close()
	{
		
	}
}
