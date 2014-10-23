package com.egysoft.fp4g.server;

import java.util.Collection;
import java.util.LinkedList;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.server.messages.RoomMessage;

public abstract class ServerRoom implements IRoom 
{
	protected final LinkedList<IUser> users = new LinkedList<IUser>();
	private final String roomName;	
	private int maxUsers = Integer.MAX_VALUE;	
	
	public ServerRoom(String roomName)
	{		
		this.roomName = roomName;
	}

	@Override
	public Collection<IUser> getUsers() 
	{
		return users;
	}
	
	public void join(User user)
	{
		user.join(this);
		users.add(user);
		onJoin(user);
	}
	public void leave(User user) 
	{
		user.leave(this);
		users.remove(user);
		onLeave(user);
	}
	
	public final void setMaxUsers(int i)
	{
		maxUsers = i;
	}
	
	@Override
	public final int getMaxUsers() 
	{		
		return maxUsers;
	}
	
	@Override
	public final String getRoomName() 
	{
		return roomName;
	}
	
	public abstract void processRoomMessage(RoomMessage roomMessage, User user);	
	
}
