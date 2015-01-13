package com.apollo.behaviors;

import com.apollo.Action;
import com.apollo.BaseBehavior;

public class ActionControllerBehavior extends BaseBehavior
{
	
	private Action current;
	public void doAction(Action action)
	{
		current = action;
		current.setEntity(owner);
		current.begin();
	}
	
	@Override
	public void update(float delta)
	{
		//realiza esta acción hasta que se detiene
		if(current != null && current.act(delta))
		{
			current.end();
			current.setEntity(null);
			current = null;
		}
	}

	public static ActionControllerBehavior build()	
	{
		return new ActionControllerBehavior();
	}
	
	@Override
	public String toString()
	{
		return String.format("ActionController: { doAction: %s}",(current!=null)?current.getClass().getSimpleName():"null");
	}
}
