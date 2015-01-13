package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public interface IMessage<Handler extends IMessageReceiver> 
{
	
	public void dispatch(IMessageReceiver handler, Object ...args);
	
	public Class<Handler> getClassHandler();
	
	/**
	 * Funcion de utilidad para hacer calzar con la función name de enum
	 * @return
	 */
	public String name();


	
}
