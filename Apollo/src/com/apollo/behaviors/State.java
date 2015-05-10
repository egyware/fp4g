package com.apollo.behaviors;

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
