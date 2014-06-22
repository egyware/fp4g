package com.egysoft.fp4g.server.messages;

/**
 * Chat Message
 * @author Edgardo
 */
public class ChatMessage extends MessageBase
{
	public ChatMessage()
	{
		super(Message.ChatMessage);
	}
	public String to; ///!< Null para todos
	public String message;	
}
