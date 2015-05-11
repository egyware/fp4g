package com.apollo.scripting;

import org.luaj.vm2.LuaValue;

import com.apollo.behaviors.AnimatorState;
import com.apollo.behaviors.AnimatorTransition;

public class AnimatorTransitionProxy extends AnimatorTransition
{
	private final LuaValue self;
	public AnimatorTransitionProxy(AnimatorState state, LuaValue table)
	{
		super(state);
		this.self = table;
	}
	
	@Override
	public boolean isActive() 
	{
		LuaValue isActive = self.get("isActive");
		if(LuaValue.NIL != isActive)
		{
			return isActive.call(self).checkboolean();	
		}		
		return false;
	}	
}