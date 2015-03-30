package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public abstract class Message 
{
	private boolean isConsumed = false;
	public abstract Class<? extends Message> getType();
	
	public final boolean isConsumed()
	{
		return isConsumed;
	}
	
	public final void consume()
	{
		isConsumed = true; 
	}
	
}