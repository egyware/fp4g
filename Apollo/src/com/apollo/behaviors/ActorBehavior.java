package com.apollo.behaviors;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.IMessage;
import com.apollo.IMessageReceiver;
import com.apollo.Engine;
import com.apollo.managers.EntityManager;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorBehavior extends Actor implements Behavior, IMessageReceiver 
{
	protected Entity owner;	
	@Override
	public Engine getEngine() 
	{		
		return owner.getEngine();
	}

	@Override
	public EntityManager getEntityManager() 
	{	
		return owner.getEngine().getEntityManager();
	}

	@Override
	public void setOwner(Entity owner) 
	{
		this.owner = owner;
	}

	@Override
	public Entity getOwner() 
	{		
		return owner;
	}

	@Override
	public Class<? extends Behavior> getType() 
	{
		return ActorBehavior.class;		
	}
	
	@Override
	public <T extends Behavior> T getComponentFromOwner(Class<T> family) 
	{
		return owner.getBehavior(family);
	}

	@Override
	public void initialize() 
	{
	}
	
	@Override
	public void uninitialize()
	{
	}


	@Override
	public void update(float delta) 
	{
	}
	
	public abstract void draw(Batch batch, float parentAlpha);
	
	public void onMessage(IMessage<? extends IMessageReceiver> message, Object... args)
	{
		message.dispatch(this, args);				
	}
}
