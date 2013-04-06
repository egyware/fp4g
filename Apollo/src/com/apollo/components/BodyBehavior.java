package com.apollo.components;

import com.apollo.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Este es el común compenente para el cuerpo fisico
 * @author egyware
 *
 */
public abstract class BodyBehavior extends Component {	
	public abstract Body getBody();
	public abstract Vector2 getPosition();
	public abstract void setPosition(float x,float y);
	public abstract float getAngle();
	
	
	public final void setPosition(Vector2 vector)
	{
		setPosition(vector.x,vector.y);
	}	
	
	public Class<BodyBehavior> getType()
	{
		return BodyBehavior.class;
	}	
}
