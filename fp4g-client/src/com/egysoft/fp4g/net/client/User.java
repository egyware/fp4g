package com.egysoft.fp4g.net.client;

import java.util.Collection;
import java.util.LinkedList;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;

public final class User implements IUser
{
	private final LinkedList<IRoom> rooms;	
	
	private String nickname;
	private final int id;
	private boolean anonymous;	
	private boolean online;
	private boolean idle;
	
	public User(final int id)
	{
		this.id = id;
		rooms = new LinkedList<IRoom>();
	}
	
	@Override
	public String getNickname() 
	{
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	@Override
	public int getId()
	{
		return id;
	}

	@Override
	public boolean isAnonymous()
	{
		return anonymous;
	}

	@Override
	public Collection<IRoom> getRooms()
	{
		return rooms;
	}
	
	public void join(IRoom room)
	{
		rooms.add(room);
	}
	public void leave(IRoom room)
	{
		rooms.remove(room);
	}	

	public void setIdle(boolean idle)
	{
		this.idle = idle;		
	}
	
	@Override
	public boolean isOnline()
	{
		return online;
	}
	
	@Override
	public boolean isIdle()
	{
		return idle;
	}

	@Override
	public void sendTCP(Object object) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void sendUDP(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setAnonymous(boolean anonymous) 
	{
		this.anonymous = anonymous;		
	}

	public void setOnline(boolean online) 
	{
		this.online = online;
	}


	

}
