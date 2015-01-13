package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public interface IMessageFilter<Handler extends IMessageFilterReceiver> 
{
	
	public boolean dispatch(IMessageFilterReceiver handler, Object ...args);	
	/**
	 * Funcion de utilidad para hacer calzar con la función name de enum
	 * @return
	 */
	public String name();


	
}
