package com.egysoft.fp4g.server;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import com.egysoft.fp4g.server.db.Database;
import com.egysoft.fp4g.server.db.User;
import com.egysoft.fp4g.server.messages.ConnectMessage;
import com.egysoft.fp4g.server.messages.ConnectResponseMessage;
import com.egysoft.fp4g.server.messages.DeltaMessage;
import com.egysoft.fp4g.server.messages.EntityData;
import com.egysoft.fp4g.server.messages.LoginMessage;
import com.egysoft.fp4g.server.messages.LoginResponseMessage;
import com.egysoft.fp4g.server.messages.Message;
import com.egysoft.fp4g.server.messages.MessageBase;
import com.egysoft.fp4g.server.messages.Reason;
import com.egysoft.fp4g.server.messages.SnapshotMessage;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

public class FP4GServer 
{
	private final Server server;
	private final Kryo kryo;
	private final Database db;	
	private final HashMap<Integer,Connection> unloggedClients;
	private Keys keys;
	//falta un mapa de id usuarios (posible sqlite)
	private final int version;
	
	
	public FP4GServer()
	{
		server = new Server();
		kryo   = server.getKryo();
		unloggedClients = new HashMap<Integer, Connection>();
		version = Integer.parseInt(Configuration.getProperty(Configuration.VERSION));
		db      = new Database(Configuration.getProperty(Configuration.DATABASE));		
	}
	
	public void init()
	{
		server.addListener(new MessageListener(this));
		kryo.register(Reason.class);		
		kryo.register(Message.class);		
		kryo.register(EntityData.class);		
		kryo.register(MessageBase.class);
		kryo.register(DeltaMessage.class);
		kryo.register(LoginMessage.class);		
		kryo.register(EntityData[].class);		
		kryo.register(ConnectMessage.class);
		kryo.register(SnapshotMessage.class);
		kryo.register(LoginResponseMessage.class);
		kryo.register(ConnectResponseMessage.class);
		
		db.init();
		keys = Keys.getInstance();
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
//		Database db = new Database("fp4g-server.db");
//		db.init();
//		List<User> list = db.select(User.class);
//		for(User user:list)
//		{
//			System.out.println(user);
//		}
//		List<Usermeta> list2 = db.selectQuery(Usermeta.class, "SELECT Usermetas.* FROM Usermetas LEFT JOIN Users ON Usermetas.user = Users.id WHERE users.id = 1");
//		for(Usermeta user:list2)
//		{
//			System.out.println(user);
//		}
	}

	public void addClient(Connection con)
	{
		unloggedClients.put(con.getID(), con);
		
	}

	public void removeClient(Connection con)
	{
		if(unloggedClients.remove(con.getID()) == null)
		{
			//loggedClients.remove();
		}		
	}

	public void checkClient(Connection connection, ConnectMessage connect)
	{
		//revisar la versión del juego
		if(connect.version != version)
		{
			server.sendToTCP(connection.getID(), ConnectResponseMessage.Outdated(version));
		}
		//checkar si existe en la base de datos
		List<User> users = db.selectQuery(User.class,"SELECT Users.* FROM Users WHERE user = ?", connect.name);
		if(users == null || users.isEmpty())
		{
			server.sendToTCP(connection.getID(), ConnectResponseMessage.MustRegister());
			return;
		}			
		server.sendToTCP(connection.getID(), ConnectResponseMessage.NiceVersion(keys.portablePublicKey()));
	}

	public boolean isLogged(Connection connection)
	{
		return true;
//		if(unloggedClients.containsKey(connection.getID()))
//		{
//			return false;
//		}
//		else
//		{
//			return true;
//		}	
		
	}
}
