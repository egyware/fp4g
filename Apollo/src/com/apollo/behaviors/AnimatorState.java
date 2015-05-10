package com.apollo.behaviors;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.utils.Array;

public abstract class AnimatorState implements State
{
	private final AnimatorBehavior animator;	
	private final Animation animation; 
	private final Array<AnimatorTransition> transitions;
	
	public AnimatorState(AnimatorBehavior _animator, Animation _animation)
	{
		animator = _animator;
		animation = _animation;
		transitions = new Array<AnimatorTransition>();
	}
	
	public void addTransition(AnimatorTransition transition)
	{
		transitions.add(transition);
	}

	@Override
	public void enter()
	{
		animator.setAnimation(animation);
	}
	
	@Override
	public final void update(float dt) 
	{	
		//revisar condiciones
		for(AnimatorTransition t:transitions)
		{
			if(t.isActive())
			{
				animator.setState(t.getNext());
			}
		}
	}	
}