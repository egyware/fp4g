package com.egysoft.fp4g.server.db;

/**
 * POCO para almacenar los datos de un usuario.
 * @author Edgardo
 *
 */
public final class User 
{
	private int id;
	private String user;
	private String nickname;
	private long lastseen;
	
	public User()
	{		
	}

	public final int getId() {
		return id;
	}

	public final String getUser() {
		return user;
	}

	public final String getNickname() {
		return nickname;
	}

	public final String getLastSeen() 
	{
		return null;
	}
	public final long lastSeen() 
	{
		return lastseen;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final void setUser(String user) {
		this.user = user;
	}

	public final void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public final void setLastseen(String lastSeen) 
	{	
	}
	public final void setPassword(String password)
	{		
	}
	
	public String toString()
	{
		return String.format("User: %15s, nickname = %15s, lastseen = %d", user, nickname, lastseen);
	}
}
