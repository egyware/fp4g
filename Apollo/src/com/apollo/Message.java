package com.apollo;

/**
 * Interface for Messages
 * @author egyware
 *
 */
public interface Message {
	public Class<?> getClassHandler();
	
	/**
	 * Funcion de utilidad para hacer calzar con la funci�n name de enum
	 * @return
	 */
	public String name(); 
}
