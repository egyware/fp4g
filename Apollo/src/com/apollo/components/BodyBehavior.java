/**
 * 
 */
package com.apollo.components;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.managers.PhysicsManager;
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
public class BodyBehavior extends IBodyBehavior 
{
	private Body simpleBody;
	
	public BodyBehavior(com.apollo.WorldContainer managers,FixtureDef fixDef)
	{
		World world = managers.getManager(PhysicsManager.class).getb2World();
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;		
		
		simpleBody = world.createBody(bodyDef);
		
		simpleBody.createFixture(fixDef);
	}
	
	public BodyBehavior(com.apollo.WorldContainer managers,FixtureDef fixDef, int x, int y)
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
	
	@Override
	public void initialize()
	{
		simpleBody.setUserData(owner);
	}
	
	@Override
	public void uninitialize()
	{
		simpleBody.setUserData(null);
		simpleBody.getWorld().destroyBody(simpleBody);
	}
	
	public BodyBehavior(com.apollo.WorldContainer world, FixtureDef fixDef, int x, int y, int dx,int dy) {
		this(world,fixDef,x,y);
		simpleBody.setBullet(true);
		simpleBody.setLinearVelocity(dx*SCALE, dy*SCALE);
	}
	
	public static BodyBehavior build(com.apollo.WorldContainer world, FixtureDef fixDef, Number x, Number y, Number dx,Number dy) {
		return new BodyBehavior(world,fixDef,x.intValue(),y.intValue(),dx.intValue(),dy.intValue());
	}
	
	public static BodyBehavior build(com.apollo.WorldContainer world, FixtureDef fixDef)
	{
		return new BodyBehavior(world,fixDef);		
	}
	
	public static BodyBehavior build(com.apollo.WorldContainer managers,FixtureDef fixDef, Number x, Number y)
	{
		return new BodyBehavior(managers,fixDef,x.intValue(),y.intValue());
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
