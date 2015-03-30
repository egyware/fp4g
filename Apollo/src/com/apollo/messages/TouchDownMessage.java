package com.apollo.messages;

import com.apollo.Message;

public class TouchDownMessage extends Message 
{

	public int x;
	public int y;
	public int pointer;
	public int button;

	@Override
	public Class<? extends Message> getType() 
	{
		return TouchDownMessage.class;
	}

}
