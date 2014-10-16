package com.apollo.managers.physics;

import java.util.Vector;


/**
 * Esta clase contiene todos los objetos estaticos.
 * 
 * Esta clase se encarga de almacenar todos los objetos estaticos de box2D o de algún motor fisico 2D.
 * 
 * 
 * @author Edgardo
 *
 */
public class Terrain
{	
	public int tile_rows;
	public int tile_columns;
	public int tile_width;
	public int tile_height;
	
	public Vector<SubTerrain> subterrains = new Vector<SubTerrain>(); 
	
	public Terrain()
	{	
	}
	
	
}
