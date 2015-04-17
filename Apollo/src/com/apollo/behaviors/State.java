package com.apollo.behaviors;

/**
 * Interfaz común para los estados
 * @author Edgardo
 *
 */
public interface State 
{

	void update(float dt);

	void activeState();
	
}
