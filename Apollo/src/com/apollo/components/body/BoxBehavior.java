/**
 * 
 */
package com.apollo.components.body;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * @author Edgardo
 *
 */
public class BoxBehavior extends BodyBehavior
{
	private Body simpleBody;
	private int width;
	private int height;
	
	
	public BoxBehavior()
	{
		this(0,0);		
	}
	
	public BoxBehavior(int x, int y)
	{
		this(x, y, 10, 10);		
	}
	
	public BoxBehavior(int x, int y, int w, int h)
	{		
		this.width = w;
		this.width = h;
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
		
		PolygonShape shape = new PolygonShape();
		shape.setAsBox(width*SCALE*0.5f, height*SCALE*0.5f);
		simpleBody.createFixture(shape,1);
			
		super.initialize();
	}
	
	public static BoxBehavior build()
	{
		return new BoxBehavior();
	}
	
	public static BoxBehavior build(int x, int y)
	{
		return new BoxBehavior(x, y);
	}
	
	public static BoxBehavior build(int x, int y, int w, int h)
	{
		return new BoxBehavior(x,y,w,h);
	}		
}
