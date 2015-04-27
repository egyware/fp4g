package com.apollo.utils;

/**
 * Interfaz com�n para los estados
 * @author Edgardo
 *
 */
public interface State 
{
	void enter();
	void update(float dt);
}
