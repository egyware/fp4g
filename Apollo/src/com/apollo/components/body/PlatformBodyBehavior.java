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
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;


/**
 * @author egyware
 *
 */
public class PlatformBodyBehavior extends PhysicsFamily
implements PlatformMessageHandler, ContactMessageHandler,RayCastCallback
{
	private Body box;
	//initial values
	public int width = 5;
	public int height = 5;	
	
	private float desiredVelocity = 0;	
	private Fixture bottonSensor;
	private Fixture leftSensor;
	private Fixture rightSensor;
	
	private int touchBotton;
	private int touchLeft;
	private int touchRight;
		
	public PlatformBodyBehavior(float x, float y, int width,  int height) 
	{
		this.x = x;
		this.y = y;		
		this.width = width;
		this.height = height;
	}

	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(PlatformMessage.onMovePlatform, this);
		owner.removeEventHandler(PlatformMessage.onJumpPlatform, this);
		owner.removeEventHandler(ContactMessage.onBeginContact, this);
		owner.removeEventHandler(ContactMessage.onEndContact, this);
		
		box.getWorld().destroyBody(box);
	}
	
	@Override	
	public void initialize()
	{	
		owner.addEventHandler(PlatformMessage.onMovePlatform, this);
		owner.addEventHandler(PlatformMessage.onJumpPlatform, this);
		owner.addEventHandler(ContactMessage.onBeginContact, this);
		owner.addEventHandler(ContactMessage.onEndContact, this);
		
		World world = owner.getWorld().getManager(PhysicsManager.class).getb2World();
		final Vector2 position = new Vector2(x,y);
		final Vector2 temp = new Vector2();
		{
			BodyDef def = new BodyDef();		
			def.position.set(position.cpy().scl(SCALE));
			def.type = BodyDef.BodyType.DynamicBody;
			def.fixedRotation = true;		
			box = world.createBody(def);
			box.setUserData(owner);			
		
			final float width_2 = width*0.5f;
			final float height_2 = height*0.5f;
			//shape
		    PolygonShape boxShape = new PolygonShape();
		    boxShape.setAsBox(width_2*SCALE,height_2*SCALE);
		    //FixtureDef fixtureDef = new FixtureDef();
		    //fixtureDef.density = 1.0f; //!\todo puede ser un parametro
		    //fixtureDef.friction = 1.0f;//!\todo puede ser un parametro
	//	    fixtureDefA.filter.groupIndex = -1; //!\todo puede ser un parametro
	//	    fixtureDefA.filter.categoryBits = 0x0101;
	//	    fixtureDefA.filter.maskBits = 0x1101;
		    //fixtureDef.shape = boxShape;
		    //box.createFixture(fixtureDef);
		    box.createFixture(boxShape, 1.0f);

		    FixtureDef sensorDef = new FixtureDef();
		    sensorDef.isSensor = true;
		    sensorDef.density = 1;
		    sensorDef.shape = boxShape;
		    //sensor abajo
		    boxShape.setAsBox(width_2*0.95f*SCALE, SCALE,temp.set(0,-height_2*SCALE-SCALE),0);
		    bottonSensor = box.createFixture(sensorDef);		    
		    //sensor izquierda
		    boxShape.setAsBox(SCALE, height_2*0.8f*SCALE,temp.set(-width_2*SCALE-SCALE,0),0);
		    leftSensor = box.createFixture(sensorDef);		    
		    //sensor derecha
		    boxShape.setAsBox(SCALE, height_2*0.8f*SCALE,temp.set(width_2*SCALE+SCALE,0),0);
		    rightSensor = box.createFixture(sensorDef);
		    
		    
		    
		    boxShape.dispose(); //ya no la usaremos más
		}
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
	

	private void jump(float jump) 
	{
		Vector2 worldCenter = box.getWorldCenter();
		box.applyLinearImpulse(0, jump, worldCenter.x,worldCenter.y,true);		
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
	public void onMovePlatform(float x)
	{
		desiredVelocity = x*SCALE;
	}
	
	@Override
	public void onJumpPlatform(float y)
	{
		jump(y*SCALE);
	}
	
	@Override
	public void onBeginContactPlatform(int value) 
	{	
	}
		
	@Override
	public void onEndContactPlatform(int intValue)
	{	
	}		
	
	public static PlatformBodyBehavior build(Number x, Number y, Number ratio, Number height)
	{
		PlatformBodyBehavior behavior = new PlatformBodyBehavior(x.floatValue(), y.floatValue(),ratio.intValue(),height.intValue());
		
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
	@Override
	public float reportRayFixture(Fixture fixture, Vector2 point, Vector2 normal, float fraction) 
	{
		Object userData = fixture.getBody().getUserData();
		if(!fixture.isSensor() &&  userData != null && userData instanceof Entity)
		{
			touched.add((Entity)userData);
			return 1; //todos
		}
		else
		{
			return -1;
		}		
	}

	public void rayCast(Bag<Entity> entities, Vector2 p1, Vector2 p2) 
	{
		this.touched = entities;
		p1.scl(SCALE);
		p2.scl(SCALE);
		box.getWorld().rayCast(this, p1, p2);
	}

}
