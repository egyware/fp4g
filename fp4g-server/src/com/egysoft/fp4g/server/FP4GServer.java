package com.egysoft.fp4g.server;

import static com.esotericsoftware.minlog.Log.INFO;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import com.egysoft.fp4g.net.AuthStatus;
import com.egysoft.fp4g.net.AuthSystem;
import com.egysoft.fp4g.net.FP4GSerialization;
import com.egysoft.fp4g.net.IRoom;
import com.egysoft.fp4g.net.IUser;
import com.egysoft.fp4g.net.serializers.CollectionSerializer;
import com.egysoft.fp4g.server.messages.JoinRequestMessage;
import com.egysoft.fp4g.server.messages.JoinResponseMessage;
import com.egysoft.fp4g.server.messages.LoginRequestMessage;
import com.egysoft.fp4g.server.messages.LoginResponseMessage;
import com.egysoft.fp4g.server.messages.Reason;
import com.egysoft.fp4g.server.messages.RequestMessageBase;
import com.egysoft.fp4g.server.rooms.ChatRoom;
import com.egysoft.fp4g.server.rooms.ChatRoomMessage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import com.esotericsoftware.minlog.Log;

public class FP4GServer
{
	private final Server server;
	private final Kryo kryo;	
	private final int version;
	private final HashMap<Connection,User> users;
	private final HashMap<String, ServerRoom> rooms;	
	
	private ServerListener listener;
	private AuthSystem authSystem;	
	
	
	public FP4GServer()
	{
		server = new Server(16384, 2048, new FP4GSerialization());
		kryo   = server.getKryo();		
		version = Integer.parseInt(Configuration.getProperty(Configuration.VERSION));
		users = new HashMap<Connection,User>();
		rooms = new HashMap<String, ServerRoom>();
	}
	
	public int version()
	{
		return version;
	}
	
	public AuthSystem getAuthSystem() 
	{
		return authSystem;
	}
	public void setAuthSystem(AuthSystem authSystem)
	{
		this.authSystem = authSystem;
	}

	
	public void init()
	{
		server.addListener(new MessageListener());
		kryo.register(byte[].class);
		kryo.register(Reason.class);
		kryo.register(Collection.class, new CollectionSerializer());
			
		kryo.register(IUser.class,new Serializer<IUser>(false,true) //no acepta nulos y es inmutable
		{
			@Override
			public IUser read(Kryo kryo, Input in, Class<IUser> clazz) 
			{
				int id = in.readInt();				
				return (id==0)?null:authSystem.getUserById(id);
			}

			@Override
			public void write(Kryo kryo, Output out, IUser data) 
			{
				out.writeInt(data.getId());
				out.writeString(data.getNickname());
				out.writeBoolean(data.isAnonymous());
				out.writeBoolean(data.isIdle());
				out.writeBoolean(data.isOnline());				
			}
			
		});
		kryo.register(IRoom.class, new Serializer<IRoom>(true){

			@Override
			public IRoom read(Kryo kryo, Input in, Class<IRoom> clazz)
			{
				String id = in.readString();
				return rooms.get(id);
			}

			@Override
			public void write(Kryo kryo, Output out, IRoom room) 
			{				
				out.writeString(room.getRoomName());
				out.writeInt(room.getMaxUsers());
				kryo.writeObject(out, room.getUsers());
			}			
		});
		
		kryo.register(LoginRequestMessage.class);
		kryo.register(LoginResponseMessage.class);
		kryo.register(JoinRequestMessage.class);
		kryo.register(JoinResponseMessage.class);
		
		//extras...
		kryo.register(ChatRoomMessage.class);
		
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
		server.setAuthSystem(new AuthSystem()
		{
			private HashMap<Integer,User> users = new HashMap<Integer,User>();
			
			@Override
			public AuthStatus auth(IUser iuser, String username, byte[] password) 
			{
				User user = (User)iuser;
				user.setUsername(username);
				user.setNickname(username);
				return AuthStatus.Ok;
			}

			@Override
			public boolean registerUser(IUser user, String username, byte[] password) 
			{			
				return true;
			}

			private int ids;
			@Override
			public User getAnonymousUser(Connection connection) 
			{
				int id = ++ids;
				User user = new User(connection);
				user.setId(id);
				users.put(id, user);
				return user;
			}

			@Override
			public User getUserById(int id) 
			{
				return users.get(id);
			}
			
		});		
		server.init();
		server.addRoom(new ChatRoom("ChatRoom"));
		try 
		{
			server.start();			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void addRoom(ServerRoom room) 
	{					
		rooms.put(room.getRoomName(), room);		
	}
	
	public ServerRoom getRoomByName(String name) 
	{
		return rooms.get(name);
	}

	public class MessageListener extends Listener
	{		
		public void connected(Connection connection)
		{			
			User newUser = authSystem.getAnonymousUser(connection);
			users.put(connection, newUser);
			if(listener != null) listener.connected(newUser);
		}
		
		public void disconnected(Connection connection)
		{				
			User user = users.remove(connection);
			if(user != null)
			{
				for(IRoom room: user.getRooms())
				{
					((ServerRoom)room).leave(user);
				}
				if(listener != null) listener.disconnected(user);
			}			
		}
		
		public void received(Connection connection, Object object)
		{
			User user = users.get(connection);
			if(INFO) Log.trace(String.format("[Server] %s Recibido",object.getClass().getSimpleName()));
			if(object instanceof RequestMessageBase)
			{				
				RequestMessageBase message = (RequestMessageBase)object;
				message.processClientMessage(FP4GServer.this,user);				
			}
			if(user.isIdle())
			{
				user.setIdle(false);
				for(IRoom room: user.getRooms())
				{
					room.active(user);
				}
			}
		}
		
		public void idle(Connection connection)
		{
			//esta funcion, se invoca también cuando un cliente se desconecta...
			User user = users.get(connection);
			if(user != null)
			{
				user.setIdle(true);
				for(IRoom room: user.getRooms())
				{
					room.idle(user);
				}
				if(listener != null) listener.idle(user);
			}
		}
	}

	
}
