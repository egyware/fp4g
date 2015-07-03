package com.apollo.behaviors;

import com.apollo.Behavior;
import com.apollo.Engine;
import com.apollo.Entity;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class ActorBehavior extends Actor implements Behavior 
{
	protected Entity owner;	
	@Override
	public Engine getEngine() 
	{		
		return owner.getEngine();
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
	public <T extends Behavior> T getBehaviorFromOwner(Class<T> family) 
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
}
