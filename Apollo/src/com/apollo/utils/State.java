package com.apollo.utils;

/**
 * Interfaz común para los estados
 * @author Edgardo
 *
 */
public interface State 
{
	void enter();
	void update(float dt);
}
