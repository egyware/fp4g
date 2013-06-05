package com.apollo.components;

import com.apollo.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Este es el com�n compenente para el cuerpo fisico
 * @author egyware
 *
 */
public abstract class BodyBehavior extends Transform {
	private Vector2 position = new Vector2();
	
	
	public abstract Body getBody();
	public abstract void setPosition(float x,float y);
	public abstract void setRotation(float angleRadians);
	public abstract void update(float dt);
	
	//helpers
	public Vector2 getPosition(){
		position.set(x,y);
		return position;
	}
	public final void setPosition(Vector2 vector)
	{
		setPosition(vector.x,vector.y);
	}	
	
}
