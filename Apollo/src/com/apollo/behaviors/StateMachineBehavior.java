package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.utils.State;

/**
 * 
 * @author Edgardo
 *
 */
public abstract class StateMachineBehavior extends BaseBehavior 
{
	private State currentState;
	
    public StateMachineBehavior()    
    {        
    }

    @Override
	public void update(float dt)
    {
	   if (currentState != null) 
	   {		   
		   currentState.update(dt);
	   }
    }
	 
	public void setState(State state) 
	{
		if (currentState != state)
	    {
			state.enter();
			currentState = state;
	    }
	}	
}
