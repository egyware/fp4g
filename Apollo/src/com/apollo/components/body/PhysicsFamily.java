package com.apollo.components.body;

import com.apollo.components.TransformFamily;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Este es el común compenente para el cuerpo fisico
 * @author egyware
 *
 */
public abstract class PhysicsFamily extends TransformFamily {
	private final Vector2 position = new Vector2();

	public abstract Body getBody();
	public abstract void setPosition(float x,float y);
	public abstract void setRotation(float angleRadians);
	public abstract void update(float dt);
	public abstract Vector2 getRawPosition();
	
	//helpers
	public Vector2 getPosition()
	{
		position.set(x,y);
		return position;
	}	
	public final void setPosition(Vector2 vector)
	{
		setPosition(vector.x,vector.y);
	}
	
	
}
