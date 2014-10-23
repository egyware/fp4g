package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.client.NetEngine;


/**
 * Chat Message
 * @author Edgardo
 */
public class SystemResponseMessage implements IResponseMessage
{
	public String message;
	public SystemResponseMessage(String message)
	{		
		this.message = message;
	}
	
	@Override
	public void processMessage(NetEngine engine) 
	{
		engine.getClientMessageHandlers().systemResponse(message);		
	}
}
