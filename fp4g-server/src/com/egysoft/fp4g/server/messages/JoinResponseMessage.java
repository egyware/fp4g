package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.server.ServerRoom;

public class JoinResponseMessage 
{
	public static final int ROOM_NOT_FOUND = 0;
	public static final int ROOM_FULL     = 1;
	public static final int ROOM_JOINED   = 2;
	public int status;
	public String name;
	public IRoom room;

	public JoinResponseMessage(int status, String name) 
	{
		this.name = name;
		this.status = status;
	}

	public JoinResponseMessage(int status, ServerRoom room) 
	{
		this.room = room;
		this.name = room.getRoomName();
		this.status = status;
	}

	public static JoinResponseMessage RoomNotFound(String name) 
	{
		return new JoinResponseMessage(ROOM_NOT_FOUND,name);
	}

	public static JoinResponseMessage RoomFull(ServerRoom room)
	{
		return new JoinResponseMessage(ROOM_FULL,room);
	}

	public static JoinResponseMessage Joined(ServerRoom room) 
	{
		return new JoinResponseMessage(ROOM_JOINED,room);
	}

}
