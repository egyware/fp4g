package com.apollo.actions;


import com.apollo.Action;
import com.apollo.components.ActorBehavior;
import com.apollo.components.SpriteBehavior;

public class SetAnimationAction extends Action 
{
	private String sequence;
	public void setSequence(String sequence)
	{
		this.sequence = sequence;  
	}
	
	public void restart()
	{
		sequence = null;
	}

	@Override
	public boolean act(float delta) 
	{
		((SpriteBehavior)entity.getBehavior(ActorBehavior.class)).setAnimation(sequence);		
		return true;
	}

}
