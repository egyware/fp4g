package com.egysoft.fp4g.server.messages;

import com.egysoft.fp4g.net.AuthSystem;
import com.egysoft.fp4g.server.FP4GServer;
import com.egysoft.fp4g.server.User;
import com.esotericsoftware.kryonet.Connection;

/**
 * Login Message
 * @author Edgardo
 */
public class LoginRequestMessage implements RequestMessageBase
{
	public int version;     ///!< Version de tu juego
	public String username; ///!< Tu username
	public byte[] password; ///!< password codificada en algo
	
	@Override
	public void processClientMessage(FP4GServer engine, User user) 
	{
		FP4GServer server = (FP4GServer)engine;		
		Connection connection = user.getConnection();
		AuthSystem authSystem = server.getAuthSystem();
		
		final int serverVersion = server.version();
		if(version != serverVersion)
		{
			user.sendTCP(LoginResponseMessage.Outdated(serverVersion));
			connection.close();
		}
		
		switch(authSystem.auth(user, username,password))
		{
		case Banned:
			user.sendTCP(LoginResponseMessage.BannedUsername());
			connection.close();	
			break;
		case Logged:
			user.sendTCP(LoginResponseMessage.YouAlreadyConnected());
			connection.close();
			break;
		case NotRegistered:
			user.sendTCP(LoginResponseMessage.MustRegister());
			connection.close();
			break;
		case WrongPassword:
			user.sendTCP(LoginResponseMessage.WrongPassword());
			connection.close();
			break;
		case Ok:
			user.sendTCP(LoginResponseMessage.AuthOk(user));
			break;
		default:
			break;		
		}
	}
}
