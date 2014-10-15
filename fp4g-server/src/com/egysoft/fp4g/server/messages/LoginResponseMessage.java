package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.IEngine;
import com.egysoft.fp4g.net.IUser;

public class LoginResponseMessage extends MessageBase
{
	public LoginResponseMessage()
	{
		super(Message.ConnectResponseMessage);		
	}
	public Reason reason; ///!< Razon de la respuesta
	public String reasonText;///!< Texto de la respuesta	
	
	public static LoginResponseMessage Outdated(int version) 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason = Reason.Outdated;
		message.reasonText = String.format("Debes actualizar tu juego a la versión %d", version);
		return message;
	}

	public static LoginResponseMessage AuthOk() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.AuthOk;
		message.reasonText = "Ah sido autentificado";		
		return message;
	}

	public static LoginResponseMessage WrongPassword()
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.IncorrectPassword;
		message.reasonText = "Usuario no existe o contraseña incorrecta";		
		return message;
	}

	public static LoginResponseMessage MustRegister() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.UserNotFound;
		message.reasonText = "No está registrado";		
		return message;
	}

	public static LoginResponseMessage YouAlreadyConnected() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.UserLogged;
		message.reasonText = "Ya está conectado ¿Ha sido hackeado?";		
		return message;
	}

	public static LoginResponseMessage BannedUsername() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.Banned;
		message.reasonText = "Usuario baneado";		
		return message;
	}

	@Override
	public void processMessage(IEngine engine, IUser user)
	{
		// TODO dar error
		
	}
}
