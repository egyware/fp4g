package com.apollo.actions;
import com.apollo.Action;
import com.apollo.Entity;
import com.apollo.utils.Bag;
import com.apollo.utils.ImmutableBag;

public class SequenceAction extends Action
{
	private int index;
	private Action current;
	private Bag<Action> actions = new Bag<Action>(4);
	
	public void restart()
	{
		index = 0;
		final int size = actions.size();
		for (int i = 0; i < size; i++)
			actions.get(i).restart();
	}
	public void reset()
	{
		super.reset();
		actions.clear();
	}
	
	public void setEntity (Entity entity) 
	{
		final int size = actions.size();
		for (int i = 0; i < size; i++) 
			actions.get(i).setEntity(entity);
		super.setEntity(entity);
	}
	
	public void addAction(Action action)
	{
		actions.add(action);
	}
	public void addActions(ImmutableBag<Action> actions)
	{
		final int size = actions.size();
		for(int i = 0;i<size;i++)
		{
			Action action = actions.get(i);
			action.setEntity(entity);
			this.actions.add(action);
		}
	}	
	
	@Override
	public boolean act(float delta) 
	{
		if (index >= actions.size()) return true;
		if(current == null)
		{
			current = actions.get(index);
			current.begin();
		}
		if (current.act(delta)) 
		{			
			current.end();
			current = null;
			index++;
			if (index >= actions.size()) return true;
		}
		return false;				
	}	
}
