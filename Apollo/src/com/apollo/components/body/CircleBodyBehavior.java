/**
 * 
 */
package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Edgardo
 *
 */
public class CircleBodyBehavior extends BodyBehavior
{
	private int radius;	
	
	
	public CircleBodyBehavior()
	{
		this(0,0);		
	}
	
	public CircleBodyBehavior(int r)
	{
		this(0,0, r);		
	}
	
	public CircleBodyBehavior(int x, int y)
	{
		this(x, y, 10);		
	}
	
	public CircleBodyBehavior(int x, int y, int r)
	{		
		this.radius = r;		
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void initialize()
	{
		World world = owner.getWorld().getManager(PhysicsManager.class).getb2World();
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(x,y).scl(SCALE);
		
		simpleBody = world.createBody(bodyDef);
		
		CircleShape shape = new CircleShape();
		shape.setRadius(radius*SCALE);		
		simpleBody.createFixture(shape,1);
			
		super.initialize();
	}
	
	public static CircleBodyBehavior build()
	{
		return new CircleBodyBehavior();
	}
	
	public static CircleBodyBehavior build(Number r)
	{
		return new CircleBodyBehavior(r.intValue());
	}
	
	public static CircleBodyBehavior build(Number x, Number y)
	{
		return new CircleBodyBehavior(x.intValue(), y.intValue());
	}
	
	public static CircleBodyBehavior build(Number x, Number y, Number r)
	{
		return new CircleBodyBehavior(x.intValue(), y.intValue(), r.intValue());
	}

}
