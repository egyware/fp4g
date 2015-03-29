package com.apollo.behaviors.body;


import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.Entity;
import com.apollo.managers.PhysicsManager;
import com.apollo.messages.ContactMessageType;
import com.apollo.messages.ContactMessageType;
import com.apollo.utils.Bag;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.QueryCallback;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;


/**
 * @author egyware
 *
 */
public class PlatformBodyBehavior extends PhysicsBehavior
implements ContactMessageHandler,RayCastCallback,QueryCallback
{
	private Body box;
	private PolygonShape boxShape;
	private World world;
	private Vector2 center = new Vector2();
	private int w;
	private int h;
	
	private float desiredVelocity = 0;	
	private Fixture leftSensor;
	private Fixture rightSensor;
	
	private int touchLeft;
	private int touchRight;
	
	private ClosestRaycastCallback bottonLeft;	
	private ClosestRaycastCallback bottonRight;
	
	private ClosestRaycastCallback topLeft;
	private ClosestRaycastCallback topRight;
		
	private PlatformBodyBehavior() 
	{	
		bottonLeft = new ClosestRaycastCallback();		
		bottonRight = new ClosestRaycastCallback();
	
		topLeft = new ClosestRaycastCallback();
		topRight = new ClosestRaycastCallback();		
	}

	@Override
	public void uninitialize()
	{
		owner.removeMessageHandler(ContactMessageType.onBeginContact, this);
		owner.removeMessageHandler(ContactMessageType.onEndContact, this);
		
		box.getWorld().destroyBody(box);		
	}
	
	@Override	
	public void initialize()
	{	
		owner.addMessageHandler(ContactMessageType.onBeginContact, this);
		owner.addMessageHandler(ContactMessageType.onEndContact, this);
		
	}
	
	public void moveHorizontal(float desiredVel)
	{
		//mantener velocidad
		Vector2 vel = box.getLinearVelocity();				
		float velChange = desiredVel - vel.x;	
		float impulse = (box.getMass()) * velChange;		
		Vector2 worldCenter = box.getWorldCenter();
		box.applyLinearImpulse(impulse, 0, worldCenter.x,worldCenter.y,true);		
	}
	
	
	public void move(float x)
	{
		desiredVelocity = x*SCALE;		
	}

	public void jump(float jump) 
	{		
		Vector2 worldCenter = box.getWorldCenter();
		box.applyLinearImpulse(0, jump*SCALE, worldCenter.x,worldCenter.y,true);
	}
		
	private Vector2 p1 = new Vector2();
	private Vector2 p2 = new Vector2();
	//ShapeRenderer shapeDebugger = new ShapeRenderer();
	
	@Override
	public void update(float dt)
	{
		moveHorizontal(desiredVelocity);
		Vector2 p = getPosition().add(center);
		
		bottonLeft.reset();		
		bottonRight.reset();
		
		topLeft.reset();
		topRight.reset();
		
		p1.set(p.x-w/2, p.y+h/2+1); p2.set(p1.x, p1.y+2); world.rayCast(topLeft,   p1.scl(SCALE), p2.scl(SCALE));
		p1.set(p.x+w/2, p.y+h/2+1); p2.set(p1.x, p1.y+2); world.rayCast(topRight,  p1.scl(SCALE), p2.scl(SCALE));
		
		p1.set(p.x-w/2, p.y-h/2-1); p2.set(p1.x, p1.y-2); world.rayCast(bottonLeft,   p1.scl(SCALE), p2.scl(SCALE));
		p1.set(p.x+w/2, p.y-h/2-1); p2.set(p1.x, p1.y-2); world.rayCast(bottonRight,  p1.scl(SCALE), p2.scl(SCALE));
		
		super.update(dt);		 
	}
	
	public static PlatformBodyBehavior build(Entity owner, Number _x, Number _y, Number _width, Number _height)
	{
		return build(owner,_x,_y,_width,_height,null);
	}
	public static PlatformBodyBehavior build(Entity owner, Number _x, Number _y, Number _width, Number _height,Filter filter)
	{
		float x = _x.floatValue()*SCALE;
		float y = _y.floatValue()*SCALE;
		float width = _width.floatValue()*SCALE;
		float height = _height.floatValue()*SCALE;
		PlatformBodyBehavior behavior = new PlatformBodyBehavior();
		
		World world = owner.getEngine().getManager(PhysicsManager.class).getb2World();
		final Vector2 position = new Vector2(x,y);
		final Vector2 temp = new Vector2();
		{
			BodyDef def = new BodyDef();		
			def.position.set(position);
			def.type = BodyDef.BodyType.DynamicBody;
			def.fixedRotation = true;		
			Body box = world.createBody(def);
			box.setUserData(owner);			
		
			final float width_2 = width*0.5f;
			final float height_2 = height*0.5f;
			//shape
		    PolygonShape boxShape = new PolygonShape();
		    boxShape.setAsBox(width_2,height_2);
		    FixtureDef fixtureDef = new FixtureDef();
		    fixtureDef.density = 1.0f; //!\todo puede ser un parametro
		    //fixtureDef.friction = 1.0f;//!\todo puede ser un parametro
		    if(filter != null)
		    {
		    	fixtureDef.filter.categoryBits = filter.categoryBits;
		    	fixtureDef.filter.groupIndex   = filter.groupIndex;
		    	fixtureDef.filter.maskBits     = filter.maskBits;		    	
		    }		    
		    fixtureDef.shape = boxShape;
		    Fixture bodyFix = box.createFixture(fixtureDef);		    

		    FixtureDef sensorDef = new FixtureDef();
		    sensorDef.isSensor = true;
		    sensorDef.density = 1;
		    sensorDef.shape = boxShape;
		    if(filter != null)
		    {
		    	sensorDef.filter.categoryBits = filter.categoryBits;
		    	sensorDef.filter.groupIndex   = filter.groupIndex;
		    	sensorDef.filter.maskBits     = filter.maskBits;
		    }
		    	
		    //sensor izquierda
		    boxShape.setAsBox(0.01f, height_2*0.8f,temp.set(-width_2-0.01f,0),0);
		    Fixture leftSensor = box.createFixture(sensorDef);		    
		    //sensor derecha
		    boxShape.setAsBox(0.01f, height_2*0.8f,temp.set(width_2+0.01f,0),0);
		    Fixture rightSensor = box.createFixture(sensorDef);
		    
		    boxShape.dispose(); //ya no la usaremos más
		    
		    //guardamos los valores dentro del objeto
		    behavior.box = box;		    
		    behavior.leftSensor   = leftSensor;
		    behavior.rightSensor  = rightSensor;
		    behavior.boxShape     = (PolygonShape)bodyFix.getShape();
		    behavior.w = _width.intValue();
		    behavior.h = _height.intValue();
		    behavior.world = world;
		}
		
		return behavior;
	}
	
	public void setBoxSize(int w, int h, Vector2 center)
	{
		this.w = w;
		this.h = h;
		this.center.set(center);
		boxShape.setAsBox(w*SCALE*0.5f, h*SCALE*0.5f, center.scl(SCALE), 0);	
	}

	@Override
	public void onBeginContact(Entity other, Fixture otherFixture,	Fixture ownFixture, Contact contact) 
	{
		if(other == null) // que sea piso
		{
			if(leftSensor == ownFixture && contact.isTouching())
			{
				touchLeft++;								
			}
			if(rightSensor == ownFixture && contact.isTouching())
			{			
				touchRight++;								
			}
		}
	}

	@Override
	public void onEndContact(Entity other, Fixture otherFixture, Fixture ownFixture, Contact contact) 
	{
		if(other == null) // que sea piso
		{
			if(leftSensor == ownFixture)
			{			
				touchLeft--;				
			}
			if(rightSensor == ownFixture)
			{
				touchRight--;				
			}
		}		
	}

	public Vector2 getLinearVelocity() 
	{
		return box.getLinearVelocity().cpy().scl(INV_SCALE);
	}
	
	public boolean isTouchTop()
	{
		return topLeft.fraction < 1 || topRight.fraction < 1;
	}
	
	public boolean isTouchGround()
	{
		return bottonLeft.fraction < 1 || bottonRight.fraction < 1;
	}
	
	public boolean isTouchLeft()
	{
		return touchLeft > 0;
	}
	
	public boolean isTouchRight()
	{
		return touchRight > 0;
	}
	
	
	@Override
	public String toString()
	{
		return String.format("PlatformBodyBehavior: {desiredVelocity: %f, leftSensor: %d, rightSensor: %d, bottonSensor: %d}",desiredVelocity, touchLeft,touchRight, isTouchGround());		 
	}

	private Bag<Entity> touched = new Bag<Entity>();	
	
	
	public void queryAABB(Bag<Entity> entities, float lowerX, float lowerY, float upperX, float upperY)
	{
		this.touched = entities;
		box.getWorld().QueryAABB(this, lowerX*SCALE, lowerY*SCALE, upperX*SCALE, upperY*SCALE);		  
	}
	
	public void rayCast(Bag<Entity> entities, Vector2 p1, Vector2 p2) 
	{
		this.touched = entities;		
		box.getWorld().rayCast(this, p1.scl(SCALE), p2.scl(SCALE));
	}

	@Override
	public boolean reportFixture(Fixture fixture) 
	{
		Object userData = fixture.getBody().getUserData();
		if(!fixture.isSensor() &&  userData != null && userData instanceof Entity)
		{
			Entity e = (Entity)userData;
			if(!touched.contains(e))
			{
				touched.add(e);
			}			
		}	
		return true;
	}
	
	@Override
	public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) 
	{
		Object userData = fixture.getBody().getUserData();
		if(!fixture.isSensor() &&  userData != null && userData instanceof Entity)
		{
			Entity e = (Entity)userData;
			if(!touched.contains(e))
			{
				touched.add(e);
			}
			return 1; //todos
		}
		else
		{
			return -1;
		}		
	}

	@Override
	public Vector2 getPosition()
	{
		return box.getPosition().cpy().scl(INV_SCALE);
	}

	@Override
	protected float getAngle() 
	{		
		return box.getAngle();
	}
	
	
	private class ClosestRaycastCallback implements RayCastCallback
	{
		public float fraction;
		@Override
		public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) 
		{
			this.fraction = fraction;
			return fraction;		
		}
		public void reset() 
		{
			fraction = 1;			
		}
		
	}

	public void setPosition(float x, float y,float angle) 
	{
		box.setTransform(x*SCALE, y*SCALE, angle);		
	}

	public void setLinearVelocity(float vx, float vy)
	{
		box.setLinearVelocity(vx*SCALE, vy*SCALE);		
	}

}
