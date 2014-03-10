package com.apollo.managers.entity;

public class EntitySpawn 
{
	public final int lenght;
	public final String[] entities;
	public final Object[][] params;
	
	public EntitySpawn(int n)
	{
		lenght = n;
		entities = new String[n];
		params = new Object[n][];
	}
}

