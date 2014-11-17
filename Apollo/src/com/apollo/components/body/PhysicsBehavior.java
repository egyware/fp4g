/**
 * 
 */
package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;

import com.apollo.BaseBehavior;
import com.apollo.annotate.InjectComponent;
import com.apollo.components.TransformBehavior;
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
		//TODO incluir interpolacion
		transform.setPosition(getPosition().scl(INV_SCALE));
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
