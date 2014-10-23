package com.egysoft.fp4g.net.client;

import java.util.Collection;
import java.util.LinkedList;

import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;

public class Room implements IRoom 
{
	private final LinkedList<IUser> users = new LinkedList<IUser>();
	private final String roomName;
	private int maxUsers;
	
	public Room(String roomName) 
	{
		this.roomName = roomName;
	}

	@Override
	public Collection<IUser> getUsers() 
	{
		return users;
	}

	@Override
	public int getCountUsers() 
	{
		return users.size();
	}

	@Override
	public String getRoomName() 
	{
		return roomName;
	}

	@Override
	public void onJoin(IUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLeave(IUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void active(IUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void idle(IUser user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendTCP(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sendUDP(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getMaxUsers() 
	{
		return maxUsers;
	}

	public void setMaxUsers(int maxUsers) 
	{
		this.maxUsers = maxUsers;
	}

	public void setUsers(Collection<IUser> users) 
	{
		this.users .clear();
		this.users.addAll(users);
	}
}
