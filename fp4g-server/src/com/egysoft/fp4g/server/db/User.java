package com.egysoft.fp4g.server.db;

/**
 * POJO para almacenar los datos de un usuario.
 * @author Edgardo
 *
 */
public class User 
{
	private String username;
	private long lastSeen;
	
	public User()
	{		
	}
	
	public final String getUsername() 
	{
		return username;
	}	
	public final long getLastSeen() 
	{
		return lastSeen;
	}
	
	public final void setUsername(String username) 
	{
		this.username = username;
	}	
	public final void setLastSeen(long lastSeen)
	{
		this.lastSeen = lastSeen;
	}

}
