package com.egysoft.fp4g.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class MessageListener extends Listener {
	private final FP4GServer server;
	
	public MessageListener(FP4GServer fp4gServer) {
		server = fp4gServer;
	}

	public void connected(Connection connection)
	{
		//TODO agregar los clientes conectados a una base de datos		
	}
	
	public void disconnected(Connection connection)
	{
		//TODO quitar los clientes conectados de la base de datos
	}
	
	public void received(Connection connection,Object object)
	{
		//TODO implementar el resto del handshake aqui
		//TODO como deltas y snapshots
		
	}
	
	public void idle(Connection connection)
	{
		//idle? :S
	}
}
