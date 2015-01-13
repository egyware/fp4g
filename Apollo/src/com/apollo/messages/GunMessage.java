package com.apollo.messages;

import com.apollo.IMessage;
import com.apollo.IMessageReceiver;

public enum GunMessage implements IMessage<GunMessageHandler> 
{
	onShotGun,
	onReloadGun,
	onChangeBulletGun,
	;

	@Override
	public void dispatch(IMessageReceiver h, Object... args)
	{
		final GunMessageHandler handler = (GunMessageHandler)h;
		switch(this)
		{		
		case onReloadGun:
			handler.onReloadGun(((Number)args[0]).intValue());
			break;
		case onShotGun:
			handler.onShotGun(((Number)args[0]).floatValue(),((Number)args[1]).floatValue(),((Number)args[2]).floatValue());
			break;
		case onChangeBulletGun:
			handler.onChangeBulletGun((String)args[0]);
			break;
		}
		
	}

	@Override
	public Class<GunMessageHandler> getClassHandler() 
	{
		return GunMessageHandler.class;		
	}

}
