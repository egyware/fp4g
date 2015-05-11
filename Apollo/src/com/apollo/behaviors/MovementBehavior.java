/**
 * 
 */
package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.annotate.InjectComponent;
import com.badlogic.gdx.math.Vector2;

/**
 * @author Edgardo
 *
 */
public abstract class MovementBehavior extends BaseBehavior
{
	@InjectComponent 
	private TransformBehavior transform;
	public final Vector2 velocity = new Vector2();
	public final Vector2 position = new Vector2();
	public float angle;
	
	@Override
	public void update(float delta)
	{
		transform.setPosition(position);
		transform.setRotation(angle);		
	}
	
	public final Vector2 getPosition()
	{
		return position;
	}	
	public final float getAngle()
	{
		return angle;
	}
	public final Vector2 getVelocity()
	{
		return velocity;
	}

	@Override
	public Class<MovementBehavior> getType()
	{
		return MovementBehavior.class;
	}
}
