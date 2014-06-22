package com.egysoft.fp4g.server.messages;

public class ConnectResponseMessage extends MessageBase
{
	public ConnectResponseMessage()
	{
		super(Message.ConnectResponseMessage);		
	}
	public Reason reason; ///!< Razon de la respuesta
	public String reasonText;///!< Texto de la respuesta
	public String publicKey; ///!< LLave publica
	
	public static ConnectResponseMessage Outdated(int version) 
	{
		ConnectResponseMessage message = new ConnectResponseMessage();
		message.reason = Reason.Outdated;
		message.reasonText = String.format("Debes actualizar tu juego a la versi�n %d", version);
		return message;
	}

	public static ConnectResponseMessage NiceVersion(String publicKey) 
	{
		ConnectResponseMessage message = new ConnectResponseMessage();
		message.reason     = Reason.Ok;
		message.reasonText = "Todo Ok";
		message.publicKey  = publicKey;
		return message;
	}

	public static ConnectResponseMessage WrongPassword()
	{
		ConnectResponseMessage message = new ConnectResponseMessage();
		message.reason     = Reason.IncorrectPassword;
		message.reasonText = "Usuario no existe o contrase�a incorrecta";		
		return message;
	}

	public static ConnectResponseMessage MustRegister() 
	{
		ConnectResponseMessage message = new ConnectResponseMessage();
		message.reason     = Reason.UserNotFound;
		message.reasonText = "No est� registrado";		
		return message;
	}
}
