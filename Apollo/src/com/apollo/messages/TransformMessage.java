package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageReciever;

public enum TransformMessage implements Message<TransformMessageHandler>
{
	onTranslateTransform,
	onRotateTransform;

	@Override
	public Class<TransformMessageHandler> getClassHandler() 
	{		
		return TransformMessageHandler.class;
	}

	@Override
	public void dispatch(MessageReciever h, Object... args) {
		final TransformMessageHandler handler = (TransformMessageHandler)h;
		switch(this)
		{		
		case onRotateTransform:
			handler.onRotateTransform(((Number)args[0]).floatValue());
			break;		
		case onTranslateTransform:
			handler.onTranslateTransform(((Number)args[0]).floatValue(), ((Number)args[1]).floatValue());
			break;	
		}		
	}
}
