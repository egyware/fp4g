package com.egysoft.fp4g.server;

import java.io.IOException;

import com.egysoft.fp4g.server.messages.ConnectMessage;
import com.egysoft.fp4g.server.messages.ResponseMessage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Server;

public class FP4GServer 
{
	private final Server server;
	private final Kryo kryo;
	//falta un mapa de id usuarios (posible sqlite)
	
	public FP4GServer()
	{
		server = new Server();
		kryo = server.getKryo();
	}
	
	public void init()
	{
		server.addListener(new MessageListener(this));
		kryo.register(ConnectMessage.class);
		kryo.register(ResponseMessage.class);		
	}
	
	public void start() throws IOException
	{
		server.bind(54555, 54777);
		server.start();
	}
	
	public static void main(final String ...args)
	{
		FP4GServer server = new FP4GServer();
		server.init();
		try 
		{
			server.start();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
