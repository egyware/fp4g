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
public abstract class PhysicsBehavior extends BaseBehavior
{
	@InjectComponent 
	private TransformBehavior transform;
	
	public void update(float delta)
	{
		//TODO incluir interpolacion, interpolación de que?
		transform.setPosition(getPosition());
		transform.setRotation(getAngle()); 
	}
	
	protected abstract Vector2 getPosition();
	protected abstract float getAngle();
	

	@Override
	public Class<PhysicsBehavior> getType()
	{
		return PhysicsBehavior.class;
	}
}
