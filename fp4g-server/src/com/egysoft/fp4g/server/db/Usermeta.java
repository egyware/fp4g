package com.egysoft.fp4g.server.db;

public class Usermeta 
{
	private int user;
	private String name;
	private String value;
	
	public final int getUser() 
	{
		return user;
	}
	public final String getName() 
	{
		return name;
	}
	public final String getValue()
	{
		return value;
	}
	public final void setUser(int user) 
	{
		this.user = user;
	}
	public final void setName(String name)
	{
		this.name = name;
	}
	public final void setValue(String value)
	{
		this.value = value;
	}
	
}
