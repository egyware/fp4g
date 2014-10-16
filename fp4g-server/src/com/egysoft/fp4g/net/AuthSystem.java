package com.egysoft.fp4g.net;

public interface AuthSystem 
{
	AuthStatus auth(IUser user, String username, byte[] password);
	boolean registerUser(IUser user, String username, byte[] password);	
}
