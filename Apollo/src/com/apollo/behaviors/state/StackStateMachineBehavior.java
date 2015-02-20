package com.apollo.behaviors.state;

import java.util.Stack;

import com.apollo.BaseBehavior;

/**
 * 
 * @author Edgardo
 *
 */
public abstract class StackStateMachineBehavior extends BaseBehavior 
{
	private Stack<State> stack;
	
    public StackStateMachineBehavior()    
    {
        this.stack = new Stack<State>();
    }

    @Override
	public void update(float dt)
    {
	   State currentState = getCurrentState();
	   if (currentState != null) 
	   {		   
		   currentState.update(dt);
	   }
    }
	 
	public State popState() 
	{
		State pop = stack.pop();
		State current = getCurrentState();
		if(current != null)
		{
			current.activeState();
		}
		return pop;
	}
	 
	public void pushState(State state) 
	{
		final State current = getCurrentState();
		if (current != state)
	    {
			state.activeState();
	    	stack.push(state);
	    }
	}
	 
	public State getCurrentState()
	{
	  return stack.size() > 0 ? stack.peek() : null;
	}
	
}
