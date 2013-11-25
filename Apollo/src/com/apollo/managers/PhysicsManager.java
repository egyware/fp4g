package com.apollo.managers;

import com.apollo.DefaultEntity;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.RayCastCallback;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Administrador de Fisica usando Box2D
 * Nota no es necesario que al agregar entidades se agregen cuerpos, ya que
 * box2d no funciona asi, asi que cuando se creen el componente sse agrega altiro el body
 * @author egyware
 *
 */
public class PhysicsManager extends Manager implements ContactListener{
	public static final float SCALE = 0.01f;
	public static final float INV_SCALE = 100.0f;
	private final World world;
	//private final ContactMessageHandler contactMessage;
	//TODO arreglar mensajeria
	public PhysicsManager()
	{
		this(Vector2.Zero);
	}
	public PhysicsManager(Vector2 gravity)
	{		
		world = new World(gravity, true);
		world.setContactListener(this);
//		contactMessage = new ContactMessageHandler();

	}
	
	public void update(float delta)
	{		
		//TODO [egyware] por ahora utilizaré la misma frequencia del update para actualizar
		world.step(delta, 8,2);
		world.clearForces();		
	}	


	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		DefaultEntity a = (DefaultEntity)fixA.getBody().getUserData();
		DefaultEntity b = (DefaultEntity)fixB.getBody().getUserData();
//		if(a != null)
//		{		
//			contactMessage.contact = contact;			
//			contactMessage.other = b;
//			contactMessage.ownFixture = fixA;
//			contactMessage.otherFixture = fixB;			
//			contactMessage.begin = true;
//			a.fireEvent(contactMessage);
//		}
//		if(b != null)
//		{			
//			contactMessage.contact = contact;
//			contactMessage.other = a;
//			contactMessage.ownFixture = fixB;
//			contactMessage.otherFixture = fixA;
//			contactMessage.begin = true;
//			b.fireEvent(contactMessage);
//		}
	}

	public World getb2World()
	{
		return world;
	}

	@Override
	public void endContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		DefaultEntity a = (DefaultEntity)fixA.getBody().getUserData();
		DefaultEntity b = (DefaultEntity)fixB.getBody().getUserData();
//		if(a != null)
//		{
//			contactMessage.contact = contact;
//			contactMessage.other = b;
//			contactMessage.ownFixture = fixA;
//			contactMessage.otherFixture = fixB;		
//			contactMessage.begin = false;
//			a.fireEvent(contactMessage);
//		}
//		if(b != null)
//		{
//			contactMessage.contact = contact;
//			contactMessage.other = a;
//			contactMessage.ownFixture = fixB;
//			contactMessage.otherFixture = fixA;
//			contactMessage.begin = false;
//			b.fireEvent(contactMessage);
//		}		
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