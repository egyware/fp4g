package com.egysoft.fp4g.net.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collection;
import java.util.HashMap;

import com.egysoft.fp4g.client.messages.ChatRoomMessage;
import com.egysoft.fp4g.client.messages.CreateJoinRequestMessage;
import com.egysoft.fp4g.client.messages.IResponseMessage;
import com.egysoft.fp4g.client.messages.JoinRequestMessage;
import com.egysoft.fp4g.client.messages.JoinResponseMessage;
import com.egysoft.fp4g.client.messages.LoginRequestMessage;
import com.egysoft.fp4g.client.messages.LoginResponseMessage;
import com.egysoft.fp4g.client.messages.Reason;
import com.egysoft.fp4g.net.FP4GSerialization;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.net.serializers.CollectionSerializer;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

public class NetEngine 
{
	private final ClientMessageHandlers messageHandlers = new ClientMessageHandlers();
	private final Client client;
	private final Kryo kryo;
	private User me;
	private HashMap<Integer, User> users = new HashMap<Integer,User>();
	private HashMap<String,Room> rooms = new HashMap<String,Room>();
	
	
	public NetEngine()
	{
		client = new Client(8192, 2048, new FP4GSerialization());
		kryo = client.getKryo();
	}
	
	public void init()
	{		
		kryo.setRegistrationRequired(false);
		kryo.register(byte[].class);		
		kryo.register(Reason.class);
		kryo.register(Collection.class, new CollectionSerializer());
			
		kryo.register(IUser.class,new Serializer<IUser>(false,true) //no acepta nulos y es inmutable
		{
			@Override
			public IUser read(Kryo kryo, Input in, Class<IUser> clazz) 
			{
				int id = in.readInt();				
				User user = users.get(id);
				if(user == null)
				{
					user = new User(id);
					users.put(id, user);
				}
				user.setNickname(in.readString());
				user.setAnonymous(in.readBoolean());
				user.setIdle(in.readBoolean());
				user.setOnline(in.readBoolean());
				return user;
			}
	
			@Override
			public void write(Kryo kryo, Output out, IUser data) 
			{
				out.writeInt(data.getId());				
			}
			
		});
		kryo.register(IRoom.class, new Serializer<IRoom>(true){ //acepta nulos
	
			@Override
			@SuppressWarnings("unchecked")			
			public IRoom read(Kryo kryo, Input in, Class<IRoom> clazz)
			{
				String id = in.readString();
				Room room = rooms.get(id);
				if(room == null)
				{
					room = new Room(id);
					rooms.put(id, room);
				}
				room.setMaxUsers(in.readInt());
				room.setUsers((Collection<IUser>)kryo.readObject(in,Collection.class));
				return room;				
			}
	
			@Override
			public void write(Kryo kryo, Output out, IRoom room) 
			{				
				out.writeString(room.getRoomName());							
			}			
		});
		
		kryo.register(LoginRequestMessage.class);
		kryo.register(LoginResponseMessage.class);
		kryo.register(JoinRequestMessage.class);
		kryo.register(CreateJoinRequestMessage.class);
		kryo.register(JoinResponseMessage.class);
		
		//extras...
		kryo.register(ChatRoomMessage.class);
		
		client.start();
		
		client.addListener(new ClientListener());
	}
	
	public void connect(String host, int tcp_port, int udp_port) throws UnknownHostException, IOException
	{
		client.connect(5000, InetAddress.getByName(host), tcp_port, udp_port);
	}
	
	private class ClientListener extends Listener
	{
		public void received(Connection connection, Object object)
		{
			if(object instanceof IResponseMessage)
			{
				((IResponseMessage) object).processMessage(NetEngine.this);
			}			
		}
	}

	//private area
	public void setUset(IUser user) 
	{
		me = (User)user;
	}
	
	public IUser getMe()
	{
		return me;
	}

	public ClientMessageHandlers getClientMessageHandlers()
	{
		return messageHandlers ;
	}
	public void addClientMessageHandler(ClientMessageHandler handler)
	{
		messageHandlers.add(handler);
	}
	public void removeClientMessageHandler(ClientMessageHandler handler)
	{
		messageHandlers.remove(handler);
	}
	
	public boolean isConnected()
	{
		return client.isConnected();
	}
	public void disconnect()
	{
		client.close();
	}

	public void sendTCP(Object object)
	{
		client.sendTCP(object);
	}
	public void sendUDP(Object object)
	{
		client.sendUDP(object);
	}
}
