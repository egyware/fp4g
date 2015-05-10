package com.apollo.utils;

import com.apollo.behaviors.AnimatorState;
import com.apollo.behaviors.State;

/**
 * 
 * @author Edgardo
 *
 */
public class StateMachine 
{
	private State currentState;
	
    public void update(float dt)
    {
	   State currentState = getCurrentState();
	   if (currentState != null) 
	   {		   
		   currentState.update(dt);
	   }
    }
	 
	public State getCurrentState()
	{
		return currentState;
	}

	public void setCurrentState(AnimatorState next) 
	{	
		if (currentState != next)
	    {
			currentState = next;
			currentState.enter();	    	
	    }
	}
}
