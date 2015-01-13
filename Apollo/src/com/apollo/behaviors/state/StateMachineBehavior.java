package com.apollo.behaviors.state;

import com.apollo.BaseBehavior;
import com.apollo.utils.Bag;

/**
 *  Maquina de estados finitos?
 * @author Edgardo
 *
 */
public abstract class StateMachineBehavior extends BaseBehavior 
{
	private final Bag<State>       states = new Bag<State>();
	private final Bag<Integer> priorities = new Bag<Integer>();
	/**
	 * Realiza la acción con más prioridad
	 * @param state
	 */
	protected abstract void doAction(State state);
	
	protected void addState(State state, int p)
	{
		states.add(state);
		priorities.add(p);
	}
	
	@Override
	public void update(float delta)
	{
		
		if(priorities.size() == 1)
		{		
			doAction(states.get(0));
			states.clear();
			priorities.clear();
		}
		else if(priorities.size() > 1)
		{		
			final int size = states.size();
			int p = 0;
			int index = 0;
			for(int i = 0; i < size; i++)
			{		
				int s = priorities.get(i);				
				if(p < s)
				{
					p = s;
					index = i;
				}
			}
			doAction(states.get(index));
			states.clear();
			priorities.clear();
		}
	}
}
