package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public interface Message<Handler extends MessageReciever> 
{
	
	public void dispatch(MessageReciever handler, Object ...args);
	
	public Class<Handler> getClassHandler();
	
	/**
	 * Funcion de utilidad para hacer calzar con la funci�n name de enum
	 * @return
	 */
	public String name();


	
}
