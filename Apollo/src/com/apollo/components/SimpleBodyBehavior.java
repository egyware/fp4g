/**
 * 
 */
package com.apollo.components;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Edgardo
 *
 */
public class SimpleBodyBehavior extends BodyBehavior {
	private Body simpleBody;
	
	public SimpleBodyBehavior(com.apollo.World managers,int x, int y,FixtureDef fixDef)
	{
		World world = managers.getManager(PhysicsManager.class).getb2World();
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x,y).mul(SCALE);
		
		simpleBody = world.createBody(bodyDef);
		
		simpleBody.createFixture(fixDef);
			
		//transformacionv
		this.x = x;
		this.y = y;
	}
	public SimpleBodyBehavior(com.apollo.World world, Integer x, Integer y,	FixtureDef fixDef, int dx,int dy) {
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

}
