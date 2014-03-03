package com.apollo.managers.physics;


/**
 * Esta clase contiene todos los objetos estaticos.
 * 
 * Esta clase se encarga de almacenar todos los objetos estaticos de box2D o de algún motor fisico 2D.
 * 
 * 
 * @author Edgardo
 *
 */
public class Terrain2D
{	
	//TODO esta variable cambiará con el tiempo siempre y cuando agrege más cosas a un terreno estatico.
	public final Box[] terrains;
	public final int width;
	public final int height;
	
	public Terrain2D(final int w, final int h, final int n)
	{	
		terrains = new Box[n];
		width = w;
		height = h;
	}
	
	public static class Box
	{
		public final int x;
		public final int y;
		public final int w;
		public final int h;
		public Box(int x,int y,int w, int h)
		{
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}
	}
}
