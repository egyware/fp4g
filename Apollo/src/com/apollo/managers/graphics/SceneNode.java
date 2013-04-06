/**
 * 
 */
package com.apollo.managers.graphics;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Nodos de escena, libres de logica
 * @author egyware
 *
 */
public abstract class SceneNode {
	protected Vector2 position = new Vector2();	
	
	public SceneNode()
	{	
	}
	
	public Vector2 Position()
	{
		return position;
	}
	
	public abstract void draw(SpriteBatch batch, float dt);
	
		
}
