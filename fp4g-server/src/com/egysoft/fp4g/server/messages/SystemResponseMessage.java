package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.IUser;

/**
 * Chat Message
 * @author Edgardo
 */
public class SystemResponseMessage
{
	public String message;
	public SystemResponseMessage(String message)
	{		
		this.message = message;
	}	
	
	public static SystemResponseMessage UserOffline(IUser user)
	{
		return new SystemResponseMessage(String.format("Usuario %s offline", user.getNickname()));
	}
}
