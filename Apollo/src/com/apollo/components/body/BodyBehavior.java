/**
 * 
 */
package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.messages.MoveMessage;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * @author Edgardo
 *
 */
public abstract class BodyBehavior extends PhysicsFamily 
{
	protected Body simpleBody;
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(MoveMessage.onTranslateMove, this);
		owner.addEventHandler(MoveMessage.onSpeedMove, this);
		owner.addEventHandler(MoveMessage.onRotateMove, this);
		owner.addEventHandler(MoveMessage.onForwardMove, this);
		simpleBody.setUserData(owner);
	}
	
	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(MoveMessage.onTranslateMove, this);
		owner.removeEventHandler(MoveMessage.onSpeedMove, this);
		owner.removeEventHandler(MoveMessage.onRotateMove, this);
		owner.removeEventHandler(MoveMessage.onForwardMove, this);
		
		simpleBody.setUserData(null);
		simpleBody.getWorld().destroyBody(simpleBody);
	}
	
	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getBody()
	 */
	@Override
	public Body getBody() {
		return simpleBody;
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#setPosition(float, float)
	 */
	@Override
	public void setPosition(float x, float y) {
		simpleBody.setTransform(x*SCALE, y*SCALE, rotation);		
		this.x = x*SCALE;
		this.y = y*SCALE;
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#setRotation(float)
	 */
	@Override
	public void setRotation(float angleRadians) {
		rotation = angleRadians;
		simpleBody.setTransform(x*SCALE, y*SCALE, rotation);
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#update(float)
	 */
	@Override
	public void update(float dt) {
		rotation = simpleBody.getAngle();
		Vector2 position = simpleBody.getPosition();
		x = position.x*INV_SCALE;
		y = position.y*INV_SCALE;		
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getRawPosition()
	 */
	@Override
	public Vector2 getRawPosition() {		
		return simpleBody.getPosition();
	}
	
	@Override
	public void onTranslateMove(float x, float y) 
	{
		simpleBody.setTransform((this.x + x)*SCALE, (this.y + y)*SCALE, rotation);		
	}
	
	@Override
	public void onSpeedMove(float vX, float vY) 
	{
		simpleBody.setLinearVelocity(vX*SCALE, vY*SCALE);		
	}
	@Override
	public void onRotateMove(float grad) 
	{
		addRotation(grad*MathUtils.degreesToRadians);
	}
	@Override
	public void onForwardMove(float units)
	{
		move(units);
	}
	@Override
	public void onAngularSpeedMove(float w)
	{
		// TODO Auto-generated method stub		
	}
}
