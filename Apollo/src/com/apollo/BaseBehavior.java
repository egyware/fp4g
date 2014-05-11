package com.apollo;

import com.apollo.managers.EntityManager;

public abstract class BaseBehavior implements Behavior, MessageHandler
{
	protected Entity owner;
							
	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getWorld()
	 */
	@Override
	public WorldContainer getWorldContainer()
	{
		return owner.getWorld();
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getEntityManager()
	 */
	@Override
	public EntityManager getEntityManager()
	{
		return owner.getWorld().getEntityManager();
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#setOwner(com.apollo.Entity)
	 */
	@Override
	public void setOwner(Entity owner)
	{
		this.owner = owner;
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getOwner()
	 */
	@Override
	public Entity getOwner()
	{
		return owner;
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getType()
	 */
	@Override
	public Class<? extends BaseBehavior> getType()
	{
		return this.getClass();
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#initialize()
	 */
	@Override
	public void initialize()
	{
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#update(float)
	 */
	@Override
	public void update(float delta)
	{
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getComponentFromOwner(java.lang.Class)
	 */
	@Override
	public <T extends Behavior> T getComponentFromOwner(Class<T> family) 
	{
		return owner.getBehavior(family);
	}

	/* (non-Javadoc)
	 * @see com.apollo.Behavior#uninitialize()
	 */
	@Override
	public void uninitialize() 
	{
	}
	
	public void onMessage(Message<? extends MessageHandler> message, Object... args)
	{
		message.dispatch(this, args);				
	}

}
