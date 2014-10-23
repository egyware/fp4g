package com.egysoft.fp4g.net;

import java.util.Collection;

public interface IRoom
{
	
	public Collection<IUser> getUsers();
	public int getCountUsers();
	public String getRoomName();	
		
	public void onJoin(IUser user);
	public void onLeave(IUser user);
	
	public void active(IUser user);
	public void idle(IUser user);
	
	public void sendTCP(Object object);
	public void sendUDP(Object object);
	public int getMaxUsers();
	
}
