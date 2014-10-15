package com.egysoft.fp4g.server;

import java.util.Collection;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.esotericsoftware.kryonet.Connection;

public final class User implements IUser
{
	private Connection connection;
	private User(final Connection connection)
	{
		this.connection = connection; 
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNickname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId()
	{
		return connection.getID();
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
	}

	@Override
	public void sendUDP(Object object)
	{
		connection.sendUDP(object);	
	}
	
	public static User getAnonymousUser(int id, Connection connection)
	{
		return new User(connection);
	}

	@Override
	public Collection<IRoom> getRooms()
	{
		// TODO Auto-generated method stub
		return null;
	}

	public void setIdle(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	public Connection getConnection()
	{
		return connection;
	}

}
