package com.apollo.messages;

import com.apollo.Message;

public class TouchDraggedMessage extends Message 
{
	public int x;
	public int y;
	public int pointer;	

	@Override
	public Class<? extends Message> getType() 
	{
		return TouchDraggedMessage.class;
	}

}
