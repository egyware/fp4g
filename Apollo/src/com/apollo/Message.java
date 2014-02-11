package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public interface Message<Handler extends MessageHandler> 
{
	
	public void dispatch(MessageHandler handler, Object ...args);
	
	public Class<Handler> getClassHandler();
	
	/**
	 * Funcion de utilidad para hacer calzar con la función name de enum
	 * @return
	 */
	public String name();


	
}
