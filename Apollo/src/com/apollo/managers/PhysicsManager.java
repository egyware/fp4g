package com.apollo.managers;

import com.apollo.Entity;
import com.apollo.messages.ContactMessageType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Filter;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;
import com.egysoft.gdx.assets.Collision;
import com.egysoft.gdx.assets.CollisionMap;

/**
 * Administrador de Fisica usando Box2D
 * Nota no es necesario que al agregar entidades se agregen cuerpos, ya que
 * box2d no funciona asi, asi que cuando se creen el componente sse agrega altiro el body
 * @author egyware
 *
 */
public class PhysicsManager extends Manager implements ContactListener
{
	public static final float SCALE = 0.01f;
	public static final float INV_SCALE = 100.0f;
	
	public static final short CATEGORY_SCENARY   = 0x0001;
	public static final short CATEGORY_PLAYER    = 0x0002;
	public static final short CATEGORY_ENEMY     = 0x0004;
	public static final short CATEGORY_ITEM      = 0x0008;
	
	
	public static final short MASK_PLAYER =  CATEGORY_ENEMY  | CATEGORY_ITEM | CATEGORY_SCENARY;
	public static final short MASK_ENEMY = CATEGORY_PLAYER | CATEGORY_SCENARY; 
	public static final short MASK_SCENERY = -1;	
	public static final short MASK_ITEM = CATEGORY_PLAYER | CATEGORY_SCENARY; 
			
	public static final Filter FILTER_PLAYER = new Filter()
	{{
		categoryBits = CATEGORY_PLAYER;
		maskBits     = MASK_PLAYER;
	}};	
	
	public static final Filter FILTER_ENEMY = new Filter()
	{{
		categoryBits = CATEGORY_ENEMY;
		maskBits     = MASK_ENEMY;
	}};
	
	public static final Filter FILTER_SCENARY = new Filter()
	{{
		categoryBits = CATEGORY_SCENARY;
		maskBits     = MASK_SCENERY;
	}};
	
	public static final Filter FILTER_SCENARY_ENEMY = new Filter()
	{{
		maskBits = CATEGORY_ENEMY;		
	}};
	
	public static final Filter FILTER_ITEM = new Filter()
	{{
		categoryBits = CATEGORY_ITEM;
		maskBits     = MASK_ITEM;
	}};
	
	private final World world;
	public PhysicsManager()
	{
		this(Vector2.Zero);
	}
	
	public PhysicsManager(Vector2 gravity)
	{		
		world = new World(gravity, true);
		world.setContactListener(this);		
	}
	public PhysicsManager(float x, float y)
	{
		this(new Vector2(x,y));
	}
	
	public void setTerrain(CollisionMap terrain)
	{
		for(Collision subterrain:terrain.terrains)
		{
			subterrain.createBody(world);
		}
	}
	
	public void update(float delta)
	{		
		//TODO [egyware] por ahora utilizaré la misma frequencia del update para actualizar
		world.step(delta, 8,2);
		world.clearForces();		
	}	
	
	public World getb2World()
	{
		return world;
	}

	@Override
	public void beginContact(Contact contact) {
		//onBeginContact(Entity other,Fixture otherFixture, Fixture ownFixture,Contact contact);
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		Entity a = (Entity)fixA.getBody().getUserData();
		Entity b = (Entity)fixB.getBody().getUserData();
		if(a != null)
		{				
			a.onMessage(ContactMessageType.onBeginContact, b, fixB, fixA, contact);			
		}
		if(b != null)
		{			
			b.onMessage(ContactMessageType.onBeginContact, a, fixA, fixB, contact);
			
		}
	}

	@Override
	public void endContact(Contact contact) {
		//onEndContact(Entity other,Fixture otherFixture, Fixture ownFixture,Contact contact);		
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();		
		Entity a = (Entity)fixA.getBody().getUserData();
		Entity b = (Entity)fixB.getBody().getUserData();
		if(a != null)
		{
			a.onMessage(ContactMessageType.onEndContact, b, fixB, fixA, contact);
		}
		if(b != null)
		{
			b.onMessage(ContactMessageType.onEndContact, a, fixA, fixB, contact);
		}		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}
	public void rayCast(RayCastCallback callback, Vector2 p1, Vector2 p2) {
		world.rayCast(callback, p1,p2);		
	}
	public void deleteWorld() {
		world.dispose();		
	}
}