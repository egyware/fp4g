package com.apollo.scripting;

import org.luaj.vm2.LuaValue;

import com.apollo.behaviors.AnimatorBehavior;
import com.apollo.behaviors.AnimatorState;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimatorStateProxy extends AnimatorState
{
	private final LuaValue self;
	public AnimatorStateProxy(AnimatorBehavior behavior, Animation animation, LuaValue table)
	{
		super(behavior, animation);
		this.self = table;
	}
	
	@Override
	public void enter() 
	{
		super.enter();
		self.get("enter").call(self);
	}		
}