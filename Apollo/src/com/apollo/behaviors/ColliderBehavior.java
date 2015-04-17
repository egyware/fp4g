package com.apollo.behaviors;

import static com.apollo.managers.PhysicsManager.INV_SCALE;
import static com.apollo.managers.PhysicsManager.SCALE;

import com.apollo.Behavior;
import com.apollo.BehaviorTemplate;
import com.apollo.Engine;
import com.apollo.managers.PhysicsManager;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.ObjectMap;

/**
 * @author Edgardo
 *
 */
public class ColliderBehavior extends PhysicsBehavior
{
	public abstract static class ShapeTemplate
	{
		protected abstract Shape createShape();
	}
	public static class FixtureTemplate
	{
		public ShapeTemplate shape;
		private float density;
		private float friction;
		private float restitution;
		private boolean isSensor;
		//private Filter filter; //TODO por ahora lo dejaré comentado esto...
		protected void createFixture(final Body body)
		{
			Shape s = shape.createShape();
			FixtureDef fdef = new FixtureDef();			
			fdef.density = density;
			fdef.friction = friction;
			fdef.restitution = restitution;
			fdef.isSensor = isSensor;
//			if(filter != null)
//			{
//				fdef.filter.categoryBits = filter.categoryBits;
//				fdef.filter.groupIndex   = filter.groupIndex;
//				fdef.filter.maskBits     = filter.maskBits;
//			}
			fdef.shape = s;
			
			body.createFixture(fdef);
			
			s.dispose();			
		}
	}
	public static class BoxShapeTemplate extends ShapeTemplate
	{		
		public int w;
		public int h;
		
		@Override
		protected Shape createShape() 
		{
			PolygonShape shape = new PolygonShape();			
			shape.setAsBox(w*SCALE, h*SCALE);
			return shape;
		}
		
	}
	public static class Template implements BehaviorTemplate
	{
		public int x;
		public int y;
		public FixtureTemplate fixtures[];
		
		@Override
		public Behavior createBehavior(final Engine engine, final int x, final int y, final int w, final int h,final ObjectMap<String,Object> map) 
		{
			World world = engine.getManager(PhysicsManager.class).getb2World();
			
			BodyDef def = new BodyDef();
			def.type = BodyDef.BodyType.DynamicBody;
			def.position.x = x*SCALE;
			def.position.y = y*SCALE;
			Body body = world.createBody(def);
			
			for(FixtureTemplate f:fixtures)
			{
				f.createFixture(body);
			}
			
			return new ColliderBehavior(body);
		}		
	}	
	private Body body;	
	
	public ColliderBehavior(Body body)
	{
		this.body = body;
	}
	
	@Override
	public void initialize()
	{
		super.initialize();
		body.setUserData(owner);
	}
	@Override
	public void uninitialize()
	{
		super.uninitialize();
		body.setUserData(null);
		body.getWorld().destroyBody(body);
		body = null;
	}

	@Override
	public Vector2 getPosition() 
	{
		return body.getPosition().cpy().scl(INV_SCALE);
	}

	@Override
	protected float getAngle() 
	{	
		return body.getAngle();
	}

	public void setPosition(float x, float y,float angle) 
	{
		body.setTransform(x, y, angle);		
	}

	public void setLinearVelocity(float vx, float vy)
	{
		body.setLinearVelocity(vx, vy);		
	}
	
	/**
	 * Devuelve la velocidad linear del objecto en pixeles por segundo
	 * @return
	 */
	public Vector2 getLinearVelocity() 
	{
		return body.getLinearVelocity().cpy().scl(INV_SCALE);		
	}
}
