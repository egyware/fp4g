/**
 * 
 */
package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.managers.PhysicsManager;
import com.apollo.messages.PlatformMessage;
import com.apollo.messages.PlatformMessageHandler;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;


/**
 * @author egyware
 *
 */
public class PlatformBodyBehavior extends PhysicsFamily
implements PlatformMessageHandler
{
	private Body circle;
	private Body box;
	private RevoluteJoint motor;
	
	//initial values
	public int ratio = 5;
	public int height = 5;	
	
	public float desiredHorizontalVelocity = 0;
		
	public PlatformBodyBehavior(float x, float y, int ratio,  int height) 
	{
		this.x = x;
		this.y = y;		
		this.ratio = ratio;
		this.height = height;
	}

	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(PlatformMessage.onMovePlatform, this);
		owner.removeEventHandler(PlatformMessage.onJumpPlatform, this);
	}
	
	@Override	
	public void initialize()
	{	
		owner.addEventHandler(PlatformMessage.onMovePlatform, this);
		owner.addEventHandler(PlatformMessage.onJumpPlatform, this);
		
		World world = owner.getWorld().getManager(PhysicsManager.class).getb2World();
		final Vector2 position = new Vector2(x,y);
		{
			BodyDef defA = new BodyDef();		
			defA.position.set(position.cpy().add(0,height).scl(SCALE));
			defA.type = BodyDef.BodyType.DynamicBody;
			defA.fixedRotation = true;		
			box = world.createBody(defA);
			box.setUserData(owner);
			
		
			//shape
		    PolygonShape boxShape = new PolygonShape();
		    boxShape.setAsBox(ratio*SCALE,height*SCALE);
		    FixtureDef fixtureDef = new FixtureDef();;
		    fixtureDef.density = 1.0f; //!\todo puede ser un parametro
		    fixtureDef.friction = 1.0f;//!\todo puede ser un parametro
	//	    fixtureDefA.filter.groupIndex = -1; //!\todo puede ser un parametro
	//	    fixtureDefA.filter.categoryBits = 0x0101;
	//	    fixtureDefA.filter.maskBits = 0x1101;
		    fixtureDef.shape = boxShape;
		    box.createFixture(fixtureDef);
		    boxShape.dispose(); //ya no la usaremos más
		    //guardo en caché los vertices por decirlo asi
		    //b2PolygonShape shape = static_cast<b2PolygonShape*>(fixtureBox->GetShape());
		    //b2Vec2 *vertices = shape->m_vertices;
		}
		
		{
			//crear el body B
		    BodyDef defB = new BodyDef();
		    defB.type = BodyDef.BodyType.DynamicBody;
		    defB.position.set(position.cpy().scl(SCALE));	    
		    circle = world.createBody(defB);
		    circle.setUserData(owner);

		    //shape
		    CircleShape circleShape = new CircleShape();
		    circleShape.setRadius(ratio*SCALE);
		    FixtureDef fixtureDef = new FixtureDef();
		    fixtureDef.friction = 1.0f;//!\todo puede ser un parametro
		    fixtureDef.density = 1.0f;//!\todo puede ser un parametro
		    //fixtureDefB.filter.groupIndex = -1; //!\todo puede ser un parametro
		    //fixtureDefB.filter.categoryBits = 0x0101;
		    //fixtureDefB.filter.maskBits = 0x1101;
		    fixtureDef.shape = circleShape;
		    circle.createFixture(fixtureDef);		    
		}
		
		{
			RevoluteJointDef motorDef = new RevoluteJointDef();
		    motorDef.initialize(box,circle,circle.getWorldCenter());
		    //motorDef.maxMotorTorque = 1000.0f;//!\todo puede ser un parametro
		    //motorDef.motorSpeed = 0.0f;//velocidad 0 inicial
		    motorDef.enableMotor = false; //pues claro motor :)		    
		    motor = (RevoluteJoint)world.createJoint(motorDef);
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
		Vector2 vel = circle.getLinearVelocity();				
		float velChange = desiredVel - vel.x;	
		float impulse = (box.getMass() + circle.getMass()) * velChange;		
		Vector2 worldCenter = circle.getWorldCenter();
		circle.applyLinearImpulse(impulse, 0, worldCenter.x,worldCenter.y,true);		
		if(desiredVel == 0){
			circle.setAngularVelocity(0);
		}
	}
	

	private void jump(float jump) 
	{
		Vector2 vel = circle.getLinearVelocity();				
		float velChange = jump - vel.x;	
		float impulse = (box.getMass() + circle.getMass()) * velChange;		
		Vector2 worldCenter = circle.getWorldCenter();
		circle.applyLinearImpulse(0, impulse, worldCenter.x,worldCenter.y,true);	
		
		
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
		moveHorizontal(desiredHorizontalVelocity);
//		
		//actualizando transformación
		rotation = circle.getAngle();
		Vector2 pos = circle.getPosition();
		x = pos.x * INV_SCALE;
		y = pos.y * INV_SCALE;
	}
	@Override
	public Vector2 getRawPosition()
	{		
		return circle.getPosition();
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
		desiredHorizontalVelocity = x*SCALE;		
	}
	
	@Override
	public void onJumpPlatform(float y)
	{
		jump(y*SCALE);
	}
		
	
	public static PlatformBodyBehavior build(Number x, Number y, Number ratio, Number height)
	{
		PlatformBodyBehavior behavior = new PlatformBodyBehavior(x.floatValue(), y.floatValue(),ratio.intValue(),height.intValue());
		
		return behavior;
	}
		
}
