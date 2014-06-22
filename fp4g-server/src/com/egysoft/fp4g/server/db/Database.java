package com.egysoft.fp4g.server.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.esotericsoftware.reflectasm.MethodAccess;

/**
 * Clase que administra la base de datos y realize un simple mapeo entre clases y tablas. 
 * @author Edgardo
 *
 */
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
		try
		{
			connection.close();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public <T> List<T> selectAll(Class<T> clazz) 
	{
		return select(clazz, "*");
	}
	
	public <T> List<T> select(Class<T> clazz, String ...columns) 
	{
		if(columns.length == 0)
		{
			return selectAll(clazz);
		}
		StringBuilder builder = new StringBuilder();
		int n = columns.length-1;
		for(int i = 0; i < n - 1;i++ )
		{
			builder.append(columns[i]);
			builder.append(',');
		}
		builder.append(columns[n]);
		return select(clazz, builder.toString());
	}
		
	private <T> List<T> select(Class<T> clazz, String columns)
	{
		String table           = Inflector.getInstance().pluralize(clazz.getSimpleName());		
		return selectQuery(clazz, String.format("SELECT %s FROM %s",columns, table));
	}
	
	public <T> List<T> selectQuery(Class<T> clazz, String query, Object ...params)
	{
		PreparedStatement st = null;
		try
		{
			st = connection.prepareStatement(query);
			for(int i = 1; i <= params.length; i++)
			{
				st.setObject(i, params[i-1]);
			}			
			MethodAccess methods   = MethodAccess.get(clazz);
			ResultSet rs           = st.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			LinkedList<T> list     = new LinkedList<T>();
			int countColumns = meta.getColumnCount();
			
			while(rs.next())
			{
				T data = clazz.newInstance();				
				for(int i = 1; i <= countColumns; i++)
				{
					String columnName = meta.getColumnName(i);
					set(methods, i, columnName, data, rs);										
				}				
				list.add(data);
			}			
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {if(st!=null)st.close();} catch(SQLException e){e.printStackTrace();}
		}
		return null;		
	}
	
	public <T> List<T> selectQuery(Class<T> clazz, String query)
	{
		Statement st = null;
		try
		{
			st                     = connection.createStatement();	
			MethodAccess methods   = MethodAccess.get(clazz);
			ResultSet rs           = st.executeQuery(query);
			ResultSetMetaData meta = rs.getMetaData();
			LinkedList<T> list     = new LinkedList<T>();
			int countColumns = meta.getColumnCount();
			
			while(rs.next())
			{
				T data = clazz.newInstance();				
				for(int i = 1; i <= countColumns; i++)
				{
					String columnName = meta.getColumnName(i);
					set(methods, i, columnName, data, rs);										
				}				
				list.add(data);
			}
			
			st.close();
			return list;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {if(st!=null)st.close();} catch(SQLException e){e.printStackTrace();}
		}
		return null;		
	}
	
	private void set(MethodAccess methods, int columnIndex, String columnName, Object data, ResultSet rs) throws SQLException
	{
		int index = methods.getIndex(setterName(columnName));
		Class<?> param = methods.getParameterTypes()[index][0];
		if(int.class == param)
		{
			methods.invoke(data, index, rs.getInt(columnIndex));
		}else
		if(String.class == param)
		{
			methods.invoke(data, index, rs.getString(columnIndex));
		}
		else
		{
			methods.invoke(data, index, rs.getObject(columnIndex, param));
		}				
	}
	
	private static String setterName(String name)
	{
		return String.format("set%c%s",Character.toUpperCase(name.charAt(0)), name.substring(1));		
	}
}
