package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.server.FP4GServer;
import com.egysoft.fp4g.server.ServerRoom;
import com.egysoft.fp4g.server.User;

public class JoinRequestMessage implements RequestMessageBase
{
	public String name;	
	
	@Override
	public void processClientMessage(FP4GServer server, User user) 
	{
		ServerRoom room = server.getRoomByName(name);
		if(room == null) //no existe
		{
			user.sendTCP(JoinResponseMessage.RoomNotFound(name));
			return;
		}		
		if(room.getCountUsers() >= room.getMaxUsers())
		{
			user.sendTCP(JoinResponseMessage.RoomFull(room));
			return;
		}
		room.join(user);	
		user.sendTCP(JoinResponseMessage.Joined(room));
		
		
				
	}

}
