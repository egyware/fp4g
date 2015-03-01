package com.egysoft.gdx.assets;

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
public class CollisionMap
{	
	public String name;	
	public Vector<Collision> terrains = new Vector<Collision>(); 
	
	public CollisionMap()
	{	
	}
	
	
}
