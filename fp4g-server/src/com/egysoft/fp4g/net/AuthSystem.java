package com.egysoft.fp4g.net;

import com.egysoft.fp4g.server.User;
import com.esotericsoftware.kryonet.Connection;

public interface AuthSystem 
{
	AuthStatus auth(IUser user, String username, byte[] password);	
	boolean registerUser(IUser user, String username, byte[] password);
	User getAnonymousUser(Connection connection);
	User getUserById(int id);
		
}
