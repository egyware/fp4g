package com.apollo.behaviors;

import com.apollo.BaseBehavior;
import com.apollo.messages.TimerActivedMessage;
import com.apollo.messages.TimerCanceledMessage;


/**
 * @author Edgardo
 *
 */
public final class TimerBehavior extends BaseBehavior
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
					//TODO poolable
					TimerActivedMessage message = new TimerActivedMessage();
					message.timer = index;
					onMessage(message);
					timers[index] = 0;
				}
				else
				{
					timers[index] = time;
				}
			}					
		}
	}
	
	public void setTimer(int index, int time)
	{
		index = (index<0)?0:(index >= timers.length)?timers.length-1:index;
		timers[index] = time * 0.001f;
	}
		
	public void cancelTimer(int index) 
	{
		index = (index<0)?0:(index >= timers.length)?timers.length-1:index;
		timers[index] = 0;	
		//TODO poolable
		TimerCanceledMessage message = new TimerCanceledMessage();
		message.timer = index;
		onMessage(message);
	}
}
