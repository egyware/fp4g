package com.egysoft.fp4g.net;

import java.util.Collection;

public interface IUser 
{
	
	public String getUsername();
	public String getNickname();
	public int getId();
	public boolean isAnonymous();
	
	public void sendTCP(Object object);
	public void sendUDP(Object object);
	
	public Collection<IRoom> getRooms();

}
