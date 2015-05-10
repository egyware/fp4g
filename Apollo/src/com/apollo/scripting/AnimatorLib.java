package com.apollo.scripting;

import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.LibFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

import com.apollo.behaviors.AnimatorBehavior;
import com.badlogic.gdx.graphics.g2d.Animation;

public class AnimatorLib extends LibFunction 
{
	public AnimatorLib()
	{		
	}
	
	public LuaValue call(LuaValue modname, LuaValue env) 
	{				
		LuaValue library = tableOf();		
		library.set("createState", new TwoArgFunction() 
		{
			@Override
			public LuaValue call(LuaValue arg1, LuaValue arg2) 
			{
				AnimatorBehavior animator;
				Animation animation;
				if(!arg2.isstring()) argerror("Se esperaba un String");
				animator = (AnimatorBehavior) arg1.checkuserdata(AnimatorBehavior.class);
				animation = animator.getAnimation(arg2.tojstring());
				if(animation == null) argerror("La animación debe existir");

				//no me gusta como quedará, pero bueno...
				LuaValue self = tableOf();				
				final AnimatorStateProxy proxy = new AnimatorStateProxy(animator, animation, self);
				self.set("instance", CoerceJavaToLua.coerce(proxy));
				self.set("createTransition", new TwoArgFunction()
				{
					@Override
					public LuaValue call(LuaValue self, LuaValue transition) 
					{
						AnimatorStateProxy next = (AnimatorStateProxy)transition.get("instance").checkuserdata(AnimatorStateProxy.class);
						LuaValue tself = tableOf();
						AnimatorTransitionProxy tproxy = new AnimatorTransitionProxy(next, tself);
						proxy.addTransition(tproxy);
						return tself;
					}					
				});	
				animator.addState(proxy.toString(),proxy);
				
				return self;
			}
		});		
		env.set( "Animator", library );
		return library;
	}
}
