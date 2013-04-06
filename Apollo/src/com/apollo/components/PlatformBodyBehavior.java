/**
 * 
 */
package com.apollo.components;

import static com.apollo.managers.PhysicsManager.SCALE;
import static com.apollo.managers.PhysicsManager.INV_SCALE;
import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJoint;
import com.badlogic.gdx.physics.box2d.joints.RevoluteJointDef;


/**
 * @author egyware
 *
 */
public class PlatformBodyBehavior extends BodyBehavior {
	private Body circle;
	private Body box;
	private RevoluteJoint motor;
	public static class Def
	{
		public int ratio = 5;
		public int height = 5;
		public Vector2 position = new Vector2();
	}
	
	public PlatformBodyBehavior(com.apollo.World world)
	{		
		this(world,new Def());
	}
	public PlatformBodyBehavior(com.apollo.World managers,Def def)
	{	
		World world = managers.getManager(PhysicsManager.class).getb2World();
	
		{
			BodyDef defA = new BodyDef();		
			defA.position.set(def.position.cpy().mul(SCALE));
			defA.type = BodyDef.BodyType.DynamicBody;
			defA.fixedRotation = true;		
			box = world.createBody(defA);
			box.setUserData(owner);
		
			 //shape
	//	    Fixture fixtureBox = new Fixture();
		    PolygonShape boxShape = new PolygonShape();
		    boxShape.setAsBox((def.ratio)*SCALE,def.height*SCALE);
	//	    FixtureDef fixtureDefA;
	//	    fixtureDefA.density = 1.0f; //!\todo puede ser un parametro
	//	    fixtureDefA.friction = 1.0f;//!\todo puede ser un parametro
	//	    fixtureDefA.filter.groupIndex = -1; //!\todo puede ser un parametro
	//	    fixtureDefA.filter.categoryBits = 0x0101;
	//	    fixtureDefA.filter.maskBits = 0x1101;
		    //fixtureDefA.shape = &box;
		    //fixtureBox =
		    box.createFixture(boxShape, 1.0f);
		    boxShape.dispose(); //ya no la usaremos m�s
		    //guardo en cach� los vertices por decirlo asi
		    //b2PolygonShape shape = static_cast<b2PolygonShape*>(fixtureBox->GetShape());
		    //b2Vec2 *vertices = shape->m_vertices;
		}
		
		{
			//crear el body B
		    BodyDef defB = new BodyDef();
		    defB.type = BodyDef.BodyType.DynamicBody;
		    defB.position.set(def.position.cpy().add(0,-def.height).mul(SCALE));	    
		    circle = world.createBody(defB);
		    circle.setUserData(owner);

		    //shape
		    CircleShape circleShape = new CircleShape();
		    circleShape.setRadius(def.ratio*SCALE);
		    //FixtureDef fixtureDefB;
		    //fixtureDefB.friction = 1.0f;//!\todo puede ser un parametro
		    //fixtureDefB.density = 1.0f;//!\todo puede ser un parametro
		    //fixtureDefB.filter.groupIndex = -1; //!\todo puede ser un parametro
		    //fixtureDefB.filter.categoryBits = 0x0101;
		    //fixtureDefB.filter.maskBits = 0x1101;
		    //fixtureDefB.shape = &circle;
		    circle.createFixture(circleShape,1.0f);		    
		}
		
		{
			RevoluteJointDef motorDef = new RevoluteJointDef();
		    motorDef.initialize(box,circle,circle.getWorldCenter());
		    //motorDef.maxMotorTorque = 1000.0f;//!\todo puede ser un parametro
		    //motorDef.motorSpeed = 0.0f;//velocidad 0 inicial
		    motorDef.enableMotor = false;//true; //pues claro motor :)		    
		    motor = (RevoluteJoint)world.createJoint(motorDef);
		}	
	}
	
	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getBody()
	 */
	@Override
	public Body getBody() {		
		return box;
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getPosition()
	 */
	@Override
	public Vector2 getPosition() {	
		return circle.getPosition().cpy().mul(INV_SCALE);
	}

	/* (non-Javadoc)
	 * @see com.apollo.components.BodyBehavior#getAngle()
	 */
	@Override
	public float getAngle() {
		//regresa angulo 0, no deberia rotar..
		return 0;
	}
	@Override
	public void setPosition(float x, float y) {
		// TODO Auto-generated method stub
		
	}
}
