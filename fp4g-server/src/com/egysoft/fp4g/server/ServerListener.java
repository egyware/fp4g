package com.egysoft.fp4g.server;

import com.egysoft.fp4g.net.IUser;

public interface ServerListener
{
	public void connected(IUser user);
	public void disconnected(IUser user);
	public void idle(User user);	
	
}
