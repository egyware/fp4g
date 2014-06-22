package com.egysoft.fp4g.server;

import com.egysoft.fp4g.server.messages.ConnectMessage;
import com.egysoft.fp4g.server.messages.DeltaMessage;
import com.egysoft.fp4g.server.messages.LoginMessage;
import com.egysoft.fp4g.server.messages.MessageBase;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.minlog.Log;
import static com.esotericsoftware.minlog.Log.*;
public class MessageListener extends Listener
{
	
	private final FP4GServer server;
	
	public MessageListener(FP4GServer fp4gServer) 
	{
		server = fp4gServer;
	}

	public void connected(Connection connection)
	{
		server.addClient(connection);	
	}
	
	public void disconnected(Connection connection)
	{
		server.removeClient(connection);		
	}
	
	public void received(Connection connection, Object object)
	{
		if(INFO) Log.trace(String.format("[Server] %s Recibido",object.getClass().getSimpleName()));
		if(object instanceof MessageBase)
		{
			MessageBase message = (MessageBase)object;
			switch(message.type)
			{
				case ConnectMessage:
					ConnectMessage connect = (ConnectMessage)message;
					server.checkClient(connection, connect);
					break;
				case LoginMessage:
					LoginMessage login = (LoginMessage)message;
					break;
				case DeltaMessage:
					DeltaMessage delta = (DeltaMessage)message;
					break;
				default:
					//TODO error, caso imposible							
			}
		}
		//TODO implementar el resto del handshake aqui
		//TODO como deltas y snapshots
		
	}
	
	public void idle(Connection connection)
	{
		//si no está logeado, se va!
		if(!server.isLogged(connection))
		{
			connection.close();
			return;
		}
		//enviar un mensaje a todos que esta conección está ausente
	}
}
