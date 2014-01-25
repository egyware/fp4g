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
public class BoxBodyBehavior extends BodyBehavior
{
	private int width;
	private int height;
	
	
	public BoxBodyBehavior()
	{
		this(0,0);		
	}
	
	public BoxBodyBehavior(int x, int y)
	{
		this(x, y, 10, 10);		
	}
	
	public BoxBodyBehavior(int x, int y, int w, int h)
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
	
	public static BoxBodyBehavior build()
	{
		return new BoxBodyBehavior();
	}
	
	public static BoxBodyBehavior build(Number x, Number y)
	{
		return new BoxBodyBehavior(x.intValue(), y.intValue());
	}
	
	public static BoxBodyBehavior build(Number x, Number y, Number w, Number h)
	{
		return new BoxBodyBehavior(x.intValue(),y.intValue(),w.intValue(),h.intValue());
	}		
}
