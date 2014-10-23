package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.client.ClientMessageHandlers;
import com.egysoft.fp4g.net.client.NetEngine;

/**
 * Chat Message
 * @author Edgardo
 */
public abstract class RoomMessage implements IResponseMessage
{			
	public IRoom room;
	
	public void processMessage(NetEngine engine)
	{
		ClientMessageHandlers handler = engine.getClientMessageHandlers();
		handler.roomMessage(this);
	}
}
