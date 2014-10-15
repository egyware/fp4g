package com.egysoft.fp4g.net;

import com.egysoft.fp4g.server.User;

public interface IRoom
{
	public void update(float delta);
	
	public String getRoomName();
	public void join(IUser user);
	public void leave(IUser user);
	public void idle(User user);
}
