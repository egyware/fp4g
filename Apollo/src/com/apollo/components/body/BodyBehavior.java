/**
 * 
 */
package com.apollo.components.body;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * @author Edgardo
 *
 */
public class BodyBehavior extends PhysicsBehavior
{
	private Vector2 position = new Vector2();
	private Body body;	
	
	public BodyBehavior(Body body)
	{
		this.body = body;
	}
	
	@Override
	public void initialize()
	{
		super.initialize();
		body.setUserData(owner);
	}
	@Override
	public void uninitialize()
	{
		super.uninitialize();
		body.setUserData(null);
		body.getWorld().destroyBody(body);
		body = null;
	}

	@Override
	protected Vector2 getPosition() 
	{
		return position.set(body.getPosition());
	}

	@Override
	protected float getAngle() 
	{	
		return body.getAngle();
	}

	public void setPosition(float x, float y,float angle) 
	{
		body.setTransform(x, y, angle);		
	}

	public void setLinearVelocity(float vx, float vy)
	{
		body.setLinearVelocity(vx, vy);		
	}
}
