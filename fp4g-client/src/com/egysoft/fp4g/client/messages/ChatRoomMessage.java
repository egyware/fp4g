package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.IUser;

/**
 * Chat Message
 * @author Edgardo
 */
public class ChatRoomMessage extends RoomMessage
{
	public IUser from;	
	public String message;	
}
