/**
 * 
 */
package com.apollo.components;

import com.apollo.BaseBehavior;
import com.apollo.messages.TimerMessage;
import com.apollo.messages.TimerMessageHandler;

/**
 * @author Edgardo
 *
 */
public final class TimerBehavior extends BaseBehavior implements TimerMessageHandler
{
	public final float timers[]; 
	public TimerBehavior()
	{
		this(5);
	}
	
	public TimerBehavior(final int n)
	{	
		timers = new float[(n<=0)?1:n];
	}	
	
	public static TimerBehavior build()
	{	
		return new TimerBehavior();		
	}
	
	public static TimerBehavior build(Number timers)
	{	
		return new TimerBehavior(timers.intValue());		
	}	
		
	@Override
	public void update(float delta)
	{	
		for(int index = 0; index < timers.length; index ++)
		{
			float time = timers[index];
			if(time > 0)
			{
				time -= delta;
				if(time <= 0)
				{
					owner.onMessage(TimerMessage.onActiveTimer, index);
					timers[index] = 0;
				}
				else
				{
					timers[index] = time;
				}
			}					
		}
	}
	
	@Override
	public void initialize()
	{
		owner.addEventHandler(TimerMessage.onSetTimeTimer, this);
		owner.addEventHandler(TimerMessage.onCancelTimer, this);		
	}
	
	@Override
	public void uninitialize()
	{
		owner.removeEventHandler(TimerMessage.onSetTimeTimer, this);
		owner.removeEventHandler(TimerMessage.onCancelTimer, this);		
	}
	
	@Override
	public void onActiveTimer(int index) 
	{
		// DO NOTHING
	}
	
	@Override
	public void onSetTimeTimer(int index, int time)
	{
		index = (index<=0)?1:(index >= timers.length)?timers.length-1:index;
		timers[index] = time * 0.001f;
	}
	@Override
	public void onCancelTimer(int index) 
	{
		index = (index<=0)?1:(index >= timers.length)?timers.length-1:index;
		timers[index] = 0;	
	}
}
