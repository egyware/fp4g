package com.egysoft.gdx.assets;


/**
 * 
 * @author Edgardo
 *
 */
public class Spawner 
{
	public final int lenght;
	public final Spawn[] entities;
	
	public Spawner(int n)
	{
		lenght = n;
		entities = new Spawn[n];	
	}
}


