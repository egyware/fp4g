package com.apollo;



public abstract class BaseBehavior 
implements Behavior
{
	/**
	 * Entidad a quien pertenece este behavior
	 */
	protected Entity owner;
							
	/* (non-Javadoc)
	 * @see com.apollo.Behavior#getWorld()
	 */
	@Override
	public Engine getEngine()
	{
		return owner.getEngine();
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
	
	protected void onMessage(Message message) 
	{
		owner.onMessage(owner, message);		
	}
}
