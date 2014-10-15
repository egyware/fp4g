package com.egysoft.fp4g.server;

import java.io.IOException;

import java.util.HashMap;

import com.egysoft.fp4g.net.IEngine;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.net.AuthSystem;
import com.egysoft.fp4g.server.messages.LoginResponseMessage;
import com.egysoft.fp4g.server.messages.DeltaMessage;
import com.egysoft.fp4g.server.messages.EntityData;
import com.egysoft.fp4g.server.messages.LoginMessage;
import com.egysoft.fp4g.server.messages.Message;
import com.egysoft.fp4g.server.messages.MessageBase;
import com.egysoft.fp4g.server.messages.Reason;
import com.egysoft.fp4g.server.messages.SnapshotMessage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

import static com.esotericsoftware.minlog.Log.*;

public class FP4GServer implements IEngine 
{
	private final Server server;
	private final Kryo kryo;
	private ServerListener listener;
	private final int version;
	private final HashMap<Connection,User> users;
	
	
	public FP4GServer()
	{
		server = new Server();
		kryo   = server.getKryo();		
		version = Integer.parseInt(Configuration.getProperty(Configuration.VERSION));
		users = new HashMap<Connection,User>();		
	}
	
	public int version()
	{
		return version;
	}
	
	public AuthSystem getAuthSystem() {
		// TODO Auto-generated method stub
		return null;
	}	

	
	public void init()
	{
		server.addListener(new MessageListener());
		kryo.register(Reason.class);		
		kryo.register(Message.class);		
		kryo.register(EntityData.class);		
		kryo.register(MessageBase.class);
		kryo.register(DeltaMessage.class);
		kryo.register(LoginMessage.class);		
		kryo.register(EntityData[].class);
		kryo.register(SnapshotMessage.class);
		kryo.register(LoginResponseMessage.class);		
		
	}
	
	public void start() throws IOException
	{ 
		int updPort = Integer.parseInt(Configuration.getProperty(Configuration.PORT_UDP));
		int tcpPort = Integer.parseInt(Configuration.getProperty(Configuration.PORT_TCP));
		server.start();
		server.bind(tcpPort, updPort);				
	}
	
	public static void main(final String ...args)
	{
		FP4GServer server = new FP4GServer();
		server.init();
		try 
		{
			server.start();			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}



	
	public class MessageListener extends Listener
	{
		
		public void connected(Connection connection)
		{			
			User newUser = User.getAnonymousUser(0, connection);
			users.put(connection, newUser);
			if(listener == null) listener.connected(newUser);
		}
		
		public void disconnected(Connection connection)
		{				
			IUser user = users.remove(connection);
			for(IRoom room: user.getRooms())
			{
				room.leave(user);
			}
			if(listener == null) listener.disconnected(user);
		}
		
		public void received(Connection connection, Object object)
		{
			IUser user = users.get(connection);
			if(INFO) Log.trace(String.format("[Server] %s Recibido",object.getClass().getSimpleName()));
			if(object instanceof MessageBase)
			{
				MessageBase message = (MessageBase)object;
				message.processMessage(FP4GServer.this,user);				
			}
		}
		
		public void idle(Connection connection)
		{
			User user = users.get(connection);
			user.setIdle(true);
			for(IRoom room: user.getRooms())
			{
				room.idle(user);
			}
			if(listener == null) listener.idle(user);
		}
	}
}
