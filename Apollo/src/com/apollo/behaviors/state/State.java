package com.apollo.behaviors.state;

/**
 * Interfaz com�n para los estados
 * @author Edgardo
 *
 */
public interface State 
{

	void update(float dt);

	void activeState();
	
}
