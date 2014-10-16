package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.Entity;
import com.apollo.managers.PhysicsManager;
import com.apollo.messages.ContactMessage;
import com.apollo.messages.ContactMessageHandler;
import com.apollo.messages.PlatformMessage;
import com.apollo.messages.PlatformMessageHandler;
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
public class PlatformBodyBehavior extends PhysicsFamily
implements PlatformMessageHandler, ContactMessageHandler,RayCastCallback,QueryCallback
{
	private Body box;
	public int width;
	public int height;
	
	private float desiredVelocity = 0;	
	private Fixture bottonSensor;
	private Fixture leftSensor;
	private Fixture rightSensor;
	
	private int touchBotton;
	private int touchLeft;
	private int touchRight;
		
	private PlatformBodyBehavior(float x, float y, int width, int height) 
	{
		this.x = x;
		this.y = y;	
		this.width = width;
		this.height = height;
		
		
	}

	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(ContactMessage.onBeginContact, this);
		owner.removeEventHandler(ContactMessage.onEndContact, this);
		
		box.getWorld().destroyBody(box);		
	}
	
	@Override	
	public void initialize()
	{	
		owner.addEventHandler(ContactMessage.onBeginContact, this);
		owner.addEventHandler(ContactMessage.onEndContact, this);
		
		
	}
	
	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getBody()
	 */
	@Override
	public Body getBody()
	{		
		return box;
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

	
	@Override
	public void setPosition(float x, float y)
	{
		// TODO Auto-generated method stub		
	}
	
	public void setRotation(float angleRadians)
	{
		// TODO Auto-generated method stub
		
	}
	public void update(float dt)
	{
		moveHorizontal(desiredVelocity);
		
		//actualizando transformación
		Vector2 pos = box.getPosition();
		x = pos.x * INV_SCALE;
		y = pos.y * INV_SCALE;
	}
	@Override
	public Vector2 getRawPosition()
	{		
		return box.getPosition();
	}
	@Override
	public void onTranslateTransform(float x, float y)
	{
				
	}
	@Override
	public void onRotateTransform(float grad)
	{
		// TODO Auto-generated method stub		
	}
	
	@Override
	public void onBeginContactPlatform(int value) 
	{	
	}
		
	@Override
	public void onEndContactPlatform(int intValue)
	{	
	}		
	
	public static PlatformBodyBehavior build(Entity owner, Number _x, Number _y, Number _width, Number _height)
	{
		return build(owner,_x,_y,_width,_height,null);
	}
	public static PlatformBodyBehavior build(Entity owner, Number _x, Number _y, Number _width, Number _height,Filter filter)
	{
		float x = _x.floatValue(), y = _y.floatValue();
		int width = _width.intValue(), height = _height.intValue();
		PlatformBodyBehavior behavior = new PlatformBodyBehavior(x,y,width,height);
		
		World world = owner.getWorld().getManager(PhysicsManager.class).getb2World();
		final Vector2 position = new Vector2(x,y);
		final Vector2 temp = new Vector2();
		{
			BodyDef def = new BodyDef();		
			def.position.set(position.cpy().scl(SCALE));
			def.type = BodyDef.BodyType.DynamicBody;
			def.fixedRotation = true;		
			Body box = world.createBody(def);
			box.setUserData(owner);			
		
			final float width_2 = width*0.5f;
			final float height_2 = height*0.5f;
			//shape
		    PolygonShape boxShape = new PolygonShape();
		    boxShape.setAsBox(width_2*SCALE,height_2*SCALE);
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
		    box.createFixture(fixtureDef);		    

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
		    	
		    //sensor abajo
		    boxShape.setAsBox(width_2*0.9f*SCALE, SCALE,temp.set(0,-height_2*SCALE-SCALE),0);
		    Fixture bottonSensor = box.createFixture(sensorDef);		    
		    //sensor izquierda
		    boxShape.setAsBox(SCALE, height_2*0.8f*SCALE,temp.set(-width_2*SCALE-SCALE,0),0);
		    Fixture leftSensor = box.createFixture(sensorDef);		    
		    //sensor derecha
		    boxShape.setAsBox(SCALE, height_2*0.8f*SCALE,temp.set(width_2*SCALE+SCALE,0),0);
		    Fixture rightSensor = box.createFixture(sensorDef);
		    
		    boxShape.dispose(); //ya no la usaremos más
		    
		    //guardamos los valores dentro del objeto
		    behavior.box = box;
		    behavior.bottonSensor = bottonSensor;
		    behavior.leftSensor   = leftSensor;
		    behavior.rightSensor  = rightSensor;
		}
		
		return behavior;
	}

	@Override
	public void onBeginContact(Entity other, Fixture otherFixture,	Fixture ownFixture, Contact contact) 
	{
		if(other == null) // que sea piso
		{
			if(bottonSensor == ownFixture)
			{
				touchBotton++;
				owner.onMessage(PlatformMessage.onBeginContactPlatform, PlatformMessage.GROUND);				
			}
			if(leftSensor == ownFixture)
			{
				touchLeft++;
				owner.onMessage(PlatformMessage.onBeginContactPlatform, PlatformMessage.LEFTWALL);				
			}
			if(rightSensor == ownFixture)
			{			
				touchRight++;
				owner.onMessage(PlatformMessage.onBeginContactPlatform, PlatformMessage.RIGHTWALL);				
			}
		}
	}

	@Override
	public void onEndContact(Entity other, Fixture otherFixture, Fixture ownFixture, Contact contact) 
	{
		if(other == null) // que sea piso
		{
			if(bottonSensor == ownFixture)
			{		
				touchBotton--;
				owner.onMessage(PlatformMessage.onEndContactPlatform, PlatformMessage.GROUND);
			}
			if(leftSensor == ownFixture)
			{			
				touchLeft--;
				owner.onMessage(PlatformMessage.onEndContactPlatform, PlatformMessage.LEFTWALL);
			}
			if(rightSensor == ownFixture)
			{
				touchRight--;
				owner.onMessage(PlatformMessage.onEndContactPlatform, PlatformMessage.RIGHTWALL);
			}
		}		
	}

	public Vector2 getVelocity() 
	{
		return box.getLinearVelocity();
	}
	
	
	public boolean isTouchGround()
	{
		return touchBotton > 0;
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
		return String.format("PlatformBodyBehavior: {desiredVelocity: %f, leftSensor: %d, rightSensor: %d, bottonSensor: %d}",desiredVelocity, touchLeft,touchRight,touchBotton);		 
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
		p1.scl(SCALE);
		p2.scl(SCALE);
		box.getWorld().rayCast(this, p1, p2);
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
	

}
