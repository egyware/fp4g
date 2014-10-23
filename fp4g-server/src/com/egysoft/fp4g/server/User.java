package com.egysoft.fp4g.server;

import java.util.Collection;
import java.util.LinkedList;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.esotericsoftware.kryonet.Connection;

public final class User implements IUser
{
	private final LinkedList<IRoom> rooms;
	private final Connection connection;
	
	private String username;
	private String nickname;
	private int id;	
	
	public User(final Connection connection)
	{
		this.connection = connection;
		rooms = new LinkedList<IRoom>();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;		
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
	public void setId(int id) 
	{
		this.id = id;
	}

	@Override
	public boolean isAnonymous() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendTCP(Object object) 
	{
		connection.sendTCP(object);
		System.out.println(connection);
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

	public void setIdle(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public Connection getConnection()
	{
		return connection;
	}

	@Override
	public boolean isOnline() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void sendUDP(Object object)
	{
		connection.sendUDP(object);	
	}

	@Override
	public boolean isIdle() {
		// TODO Auto-generated method stub
		return false;
	}


	

}
