package com.apollo;

public interface Behavior
{
	public abstract Engine getEngine();

	public abstract void setOwner(Entity owner);

	public abstract Entity getOwner();

	public abstract Class<? extends Behavior> getType();

	public abstract void initialize();

	public abstract void update(float delta);

	public abstract <T extends Behavior> T getComponentFromOwner(Class<T> family);

	public abstract void uninitialize();

}