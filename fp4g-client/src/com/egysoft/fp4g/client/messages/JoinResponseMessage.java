package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.client.NetEngine;

public class JoinResponseMessage implements IResponseMessage
{
	public static final int ROOM_NOT_FOUND = 0;
	public static final int ROOM_FULL     = 1;
	public static final int ROOM_JOINED   = 2;
	public int status;
	public String name;
	public IRoom room;
	
	public String toString()
	{
		if(room == null)
		{
			return String.format("JoinResponseMessage: %d Room(%s)",status,name);
		}
		else
		{
			return String.format("JoinResponseMessage: %d Room(%s) %d/%d",status,name,room.getCountUsers(),room.getMaxUsers());
		}
	}

	@Override
	public void processMessage(NetEngine engine) 
	{
		engine.getClientMessageHandlers().joinRoomResponse(status, name, room);
	}
}
