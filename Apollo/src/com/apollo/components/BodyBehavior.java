/**
 * 
 */
package com.apollo.components;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.Message;
import com.apollo.managers.PhysicsManager;
import com.apollo.messages.MoveMessage;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Edgardo
 *
 */
public class BodyBehavior extends IBodyBehavior {
	private Body simpleBody;
	
	public BodyBehavior(com.apollo.World managers,int x, int y,FixtureDef fixDef)
	{
		World world = managers.getManager(PhysicsManager.class).getb2World();
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x,y).scl(SCALE);
		
		simpleBody = world.createBody(bodyDef);
		
		simpleBody.createFixture(fixDef);
			
		//transformacionv
		this.x = x;
		this.y = y;
	}
	public BodyBehavior(com.apollo.World world, Integer x, Integer y,	FixtureDef fixDef, int dx,int dy) {
		this(world,x,y,fixDef);
		simpleBody.setBullet(true);
		simpleBody.setLinearVelocity(dx, dy);
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
	public void onMessage(Message<?> message, Object... args) {
		if(message instanceof MoveMessage)
		{
			switch((MoveMessage)message)
			{
			case onSpeedMove:
				onSpeedMove(((Number)args[0]).floatValue(),((Number)args[1]).floatValue());
				break;
			case onTranslateMove:
				onTranslateMove(((Number)args[0]).floatValue(),((Number)args[1]).floatValue());
				break;
			case onRotateMove:
				onRotateMove(((Number)args[0]).floatValue());
				break;				
			}
		}
	}

}
