package com.egysoft.fp4g.net.client;

import com.egysoft.fp4g.client.messages.Reason;
import com.egysoft.fp4g.client.messages.RoomMessage;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;

public interface ClientMessageHandler 
{
	public void joinRoomResponse(int status, String name, IRoom room);
	public void leaveRoomResponse();
	public void loginResponse(Reason reason, String desc, IUser user);
	public void systemResponse(String message);
	public void roomMessage(RoomMessage message);
}
