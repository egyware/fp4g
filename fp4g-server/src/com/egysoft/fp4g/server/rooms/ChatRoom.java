package com.egysoft.fp4g.server.rooms;

import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.server.ServerRoom;
import com.egysoft.fp4g.server.User;
import com.egysoft.fp4g.server.messages.RoomMessage;

public class ChatRoom extends ServerRoom
{
	public ChatRoom(String roomName)
	{
		super(roomName);	
	}
	
	@Override
	public void onJoin(IUser user)
	{		
	}

	@Override
	public void onLeave(IUser user)
	{	
	}

	@Override
	public void active(IUser user) 
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void idle(IUser user)
	{
		// TODO Auto-generated method stub
	}	
	
	@Override
	public void sendTCP(Object object) 
	{
		for(IUser user:users)
		{
			user.sendTCP(object);
		}		
	}

	@Override
	public void sendUDP(Object object) 
	{
		for(IUser user:users)
		{
			user.sendUDP(object);
		}		
	}

	@Override
	public int getCountUsers() 
	{
		return users.size();
	}

	@Override
	public void processRoomMessage(RoomMessage message, User user)
	{			
	}

}
