package com.apollo.managers;

import com.apollo.Message;
import com.apollo.MessageHandler;
import com.apollo.utils.ImmutableBag;
import com.egysoft.fp4g.client.messages.Reason;
import com.egysoft.fp4g.client.messages.RoomMessage;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.net.client.ClientMessageHandler;
import com.egysoft.fp4g.net.client.NetEngine;
import com.egysoft.fp4g.net.client.Room;

public abstract class NetworkManager extends Manager implements ClientMessageHandler
{	
	protected final Room room;	
	protected final NetEngine engine;	
	
	public NetworkManager(NetEngine engine, Room room)
	{
		this.room =  room;
		this.engine = engine;
		engine.addClientMessageHandler(this);
	}
	
	public void update(float delta)
	{
	}
	

	@Override
	public ImmutableBag<MessageHandler> getMessageHandler(Message<?> message) 
	{	
		return null;
	}

	@Override
	public void onMessage(Message<? extends MessageHandler> message,Object... args) 
	{			
	}

	@Override
	public <T extends Message<?>> void addEventHandler(Message<?> messageType,MessageHandler listener) 
	{			
	}

	@Override
	public <T extends Message<?>> void removeEventHandler(Message<?> messagetType, MessageHandler listener) 
	{			
	}

	@Override
	public void joinRoomResponse(int status, String name, IRoom room) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void leaveRoomResponse() 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void loginResponse(Reason reason, String desc, IUser user) 
	{
	}

	@Override
	public void systemResponse(String message)
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void roomMessage(RoomMessage message)
	{
		//si es el mismo room =P
		if(room == message.room)
		{	
			System.out.println(message.getClass().getSimpleName());
		}		
	}
}
