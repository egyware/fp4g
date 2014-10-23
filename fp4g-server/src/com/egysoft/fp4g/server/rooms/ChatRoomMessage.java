package com.egysoft.fp4g.server.rooms;

import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.server.messages.RoomMessage;

/**
 * Chat Message
 * @author Edgardo
 */
public class ChatRoomMessage extends RoomMessage
{
	public IUser from;	
	public String message;	
}
