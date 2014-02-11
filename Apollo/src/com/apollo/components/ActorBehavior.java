package com.apollo.components;

import com.apollo.Behavior;
import com.apollo.Entity;
import com.apollo.WorldContainer;
import com.apollo.managers.EntityManager;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorBehavior extends Actor implements Behavior 
{
	protected Entity owner;	
	@Override
	public WorldContainer getWorldContainer() 
	{		
		return owner.getWorld();
	}

	@Override
	public EntityManager getEntityManager() 
	{	
		return owner.getWorld().getEntityManager();
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
}
