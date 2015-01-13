package com.apollo.filters;

import com.apollo.IMessageFilter;
import com.apollo.IMessageFilterReceiver;

public enum LifeMessageFilter implements IMessageFilter<LifeMessageFilterHandler> 
{
	onDamageLife, 
	onHealLife,
	onDeathLife;

	@Override
	public boolean dispatch(IMessageFilterReceiver h, Object... args) 
	{
		final LifeMessageFilterHandler handler = (LifeMessageFilterHandler)h;
		switch(this)
		{
		case onDamageLife:
			return handler.onDamageLife(((Number)args[0]).intValue());			
		case onHealLife:
			return handler.onHealLife(((Number)args[0]).intValue());			
		case onDeathLife:
			return handler.onDeathLife();		
		}
		//imposible
		return false;
				
	}
}
