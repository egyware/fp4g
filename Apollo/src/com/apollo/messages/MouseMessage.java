package com.apollo.messages;

import com.apollo.Message;
import com.apollo.MessageHandler;

public enum MouseMessage implements Message<MouseMessageHandler> {
	onPressButtonMouse,
	onReleaseButtonMouse,
	onMoveMouse,
	onDraggedMouse;
	

	@Override
	public Class<MouseMessageHandler> getClassHandler() 
	{		
		return MouseMessageHandler.class;
	}

	@Override
	public void dispatch(MessageHandler h, Object... args) {
		final MouseMessageHandler handler = (MouseMessageHandler)h;
		switch(this)
		{
		case onPressButtonMouse:
			handler.onPressButtonMouse((Integer)args[0], (Integer)args[1], (Integer)args[2],(Integer)args[3]);
			break;
		case onReleaseButtonMouse:
			handler.onReleaseButtonMouse((Integer)args[0], (Integer)args[1], (Integer)args[2],(Integer)args[3]);
			break;
		case onMoveMouse:
			handler.onMoveMouse((Integer)args[0], (Integer)args[1]);
			break;				
		case onDraggedMouse:
			handler.onDraggedMouse((Integer)args[0], (Integer)args[1],(Integer)args[3]);
			break;		
		}		
	}
}
