package com.egysoft.fp4g.client.messages;

/**
 * Login Message
 * @author Edgardo
 */
public class LoginRequestMessage
{
	public int version;     ///!< Version de tu juego
	public String username; ///!< Tu username
	public byte[] password; ///!< password codificada en algo
	public static LoginRequestMessage CreateLoginRequest(int version, String user, String pass) 
	{
		LoginRequestMessage login = new LoginRequestMessage();
		login.version = version;
		login.username = user;
		login.password = pass.getBytes();
		return login;
	}
	
	
}
