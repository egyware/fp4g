package com.egysoft.fp4g.server.messages;

/**
 * Mensaje que conecta al juego
 * @author Edgardo
 */
public class ConnectMessage extends MessageBase
{
	public ConnectMessage()
	{
		super(Message.ConnectMessage);	
	}
	public int version; ///!< Version del juego
	public String name; ///!< Tu nombre de usuario
	
}
