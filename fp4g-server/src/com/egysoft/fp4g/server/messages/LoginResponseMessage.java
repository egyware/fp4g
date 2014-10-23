package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.IUser;

public class LoginResponseMessage
{
	public IUser user; ///!< Usuario
	public Reason reason; ///!< Razon de la respuesta
	public String reasonText;///!< Texto de la respuesta	
	
	public static LoginResponseMessage Outdated(int version) 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason = Reason.Outdated;
		message.reasonText = String.format("Debes actualizar tu juego a la versi�n %d", version);
		return message;
	}

	public static LoginResponseMessage AuthOk(IUser user) 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.user = user;
		message.reason     = Reason.AuthOk;
		message.reasonText = "Ah sido autentificado";		
		return message;
	}

	public static LoginResponseMessage WrongPassword()
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.IncorrectPassword;
		message.reasonText = "Usuario no existe o contrase�a incorrecta";		
		return message;
	}

	public static LoginResponseMessage MustRegister() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.UserNotFound;
		message.reasonText = "No est� registrado";		
		return message;
	}

	public static LoginResponseMessage YouAlreadyConnected() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.UserLogged;
		message.reasonText = "Ya est� conectado �Ha sido hackeado?";		
		return message;
	}

	public static LoginResponseMessage BannedUsername() 
	{
		LoginResponseMessage message = new LoginResponseMessage();
		message.reason     = Reason.Banned;
		message.reasonText = "Usuario baneado";		
		return message;
	}
}
