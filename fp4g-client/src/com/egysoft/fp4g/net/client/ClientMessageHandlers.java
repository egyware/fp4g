package com.egysoft.fp4g.net.client;

import java.util.Iterator;
import java.util.LinkedList;

import com.egysoft.fp4g.client.messages.Reason;
import com.egysoft.fp4g.client.messages.RoomMessage;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;

public class ClientMessageHandlers implements ClientMessageHandler,Iterable<ClientMessageHandler>
{
	private LinkedList<ClientMessageHandler> handlers;
	public void add(ClientMessageHandler handler)
	{
		handlers.add(handler);
	}
	public void remove(ClientMessageHandler handler)
	{
		handlers.remove(handler);
	}
	
	@Override
	public Iterator<ClientMessageHandler> iterator() 
	{
		return handlers.iterator();
	}
	@Override
	public void joinRoomResponse(int status, String name, IRoom room) 
	{
		for(ClientMessageHandler h:handlers)
		{
			h.joinRoomResponse(status, name, room);
		}
	}
	@Override
	public void leaveRoomResponse() 
	{
		for(ClientMessageHandler h:handlers)
		{
			h.leaveRoomResponse();
		}		
	}
	@Override
	public void loginResponse(Reason reason, String desc, IUser user)
	{
		for(ClientMessageHandler h:handlers)
		{
			h.loginResponse(reason, desc, user);
		}		
	}
	@Override
	public void systemResponse(String message)
	{
		for(ClientMessageHandler h:handlers)
		{
			h.systemResponse(message);
		}		
	}
	@Override
	public void roomMessage(RoomMessage message)
	{
		for(ClientMessageHandler h:handlers)
		{
			h.roomMessage(message);
		}		
	}
}
