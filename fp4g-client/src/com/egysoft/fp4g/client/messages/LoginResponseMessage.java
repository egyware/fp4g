package com.egysoft.fp4g.client.messages;

import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.net.client.NetEngine;

public class LoginResponseMessage implements IResponseMessage
{
	public IUser user; //!< Si se logro logear con exito
	public Reason reason; ///!< Razon de la respuesta
	public String reasonText;///!< Texto de la respuesta	
	
	public String toString()
	{
		return String.format("LoginResponseMessage: %s(%s)",reasonText,reason.name());
	}

	@Override
	public void processMessage(NetEngine engine) 
	{
		if(Reason.AuthOk == reason)
		{
			engine.setUset(user);
		}
		engine.getClientMessageHandlers().loginResponse(reason, reasonText, user);
	}
}
