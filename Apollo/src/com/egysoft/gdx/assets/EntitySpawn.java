package com.egysoft.gdx.assets;

//TODO esta clase permitir� hacer que los personajes reaparescan seg�n vaya avanzando el personaje, por ahora solo mantiene una lista con los datos.
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

