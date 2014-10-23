package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.server.FP4GServer;
import com.egysoft.fp4g.server.ServerRoom;
import com.egysoft.fp4g.server.User;

/**
 * Chat Message
 * @author Edgardo
 */
public abstract class RoomMessage implements RequestMessageBase
{			
	public ServerRoom room;
	
	public void processClientMessage(final FP4GServer server,final User user)
	{
		room.processRoomMessage(this,user);
	}
	
	
}
