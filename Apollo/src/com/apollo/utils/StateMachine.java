package com.apollo.utils;

import java.util.Stack;

/**
 * 
 * @author Edgardo
 *
 */
public class StateMachine 
{
	private Stack<State> stack;
	
    public StateMachine()    
    {
        this.stack = new Stack<State>();
    }

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
			current.enter();
		}
		return pop;
	}
	 
	public void pushState(State state) 
	{
		final State current = getCurrentState();
		if (current != state)
	    {
			state.enter();
	    	stack.push(state);
	    }
	}
	 
	public State getCurrentState()
	{
	  return stack.size() > 0 ? stack.peek() : null;
	}
	
	public boolean isStackEmpty()
	{
		return stack.isEmpty();
	}
}
