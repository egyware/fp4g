package com.apollo;

import com.badlogic.gdx.utils.Pool;
import com.badlogic.gdx.utils.Pool.Poolable;

/**
 * Mi propia versión LIGERAMENTE alterada de gdx.Action
 * @author Edgardo
 *
 */
@SuppressWarnings({"rawtypes","unchecked"})
public abstract class Action implements Poolable
{
	protected Entity entity;	
	private Pool pool;
	
	public abstract boolean act (float delta);

	@Override
	public void reset ()
	{
		restart();
	}

	public final Pool<?> getPool () 
	{
		return pool;
	}
	
	public Entity getEntity() 
	{
		return entity;
	}	
	public void setEntity(Entity owner) 
	{
		entity = owner;
		if (entity == null) 
		{
			if (pool != null) 
			{
				pool.free(this);
				pool = null;
			}
		}
	}
	
	public void setPool(Pool pool) 
	{
		this.pool = pool;
	}

	public String toString () 
	{
		String name = getClass().getName();
		int dotIndex = name.lastIndexOf('.');
		if (dotIndex != -1) name = name.substring(dotIndex + 1);
		if (name.endsWith("Action")) name = name.substring(0, name.length() - 6);
		return name;
	}

	public void begin()
	{	
	}	
	public void end()
	{	
	}
	public void restart() 
	{	
	}
}
