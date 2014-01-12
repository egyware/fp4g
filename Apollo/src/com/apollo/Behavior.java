package com.apollo;

import com.apollo.managers.EntityManager;

public interface Behavior
{
	public abstract WorldContainer getWorldContainer();

	public abstract EntityManager getEntityManager();

	public abstract void setOwner(Entity owner);

	public abstract Entity getOwner();

	public abstract Class<? extends Behavior> getType();

	public abstract void initialize();

	public abstract void update(float delta);

	public abstract <T extends Behavior> T getComponentFromOwner(Class<T> family);

	public abstract void uninitialize();

}