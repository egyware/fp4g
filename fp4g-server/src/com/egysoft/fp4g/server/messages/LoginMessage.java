package com.egysoft.fp4g.server.messages;

/**
 * Login Message
 * @author Edgardo
 */
public class LoginMessage extends MessageBase
{
	public LoginMessage()
	{
		super(Message.LoginMessage);
	}
	public String username; ///!< Tu username
	public byte[] password; ///!< password codificada en algo
}
