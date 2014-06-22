package com.egysoft.fp4g.server.messages;

/**
 * Login Message
 * @author Edgardo
 */
public class LoginResponseMessage extends MessageBase
{
	public LoginResponseMessage() 
	{
		super(Message.LoginResponseMessage);
	}
	public Reason reason; ///!< Razon que no pudo logearse
	public String reasonText; ///!< Texto
	//de ahora en adelante, empezará a enviar snapshot y deltas.	
}
