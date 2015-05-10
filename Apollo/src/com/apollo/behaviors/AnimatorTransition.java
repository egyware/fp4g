package com.apollo.behaviors;


public class AnimatorTransition
{
	private AnimatorState next;	
	
	public AnimatorTransition(AnimatorState next)
	{
		this.next = next;		
	}		
	
	public boolean isActive()
	{
		return false;
	}
	public AnimatorState getNext()
	{
		return next;
	}
}