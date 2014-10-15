package com.egysoft.fp4g.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration implements Runnable
{
	private final static Properties properties;	
	private final static String propertiesFile = "fp4g-server.properties";
	public final static String MOTD = "motd";
	public final static String PORT_UDP = "port.udp";
	public final static String PORT_TCP = "port.tcp";
	public final static String VERSION  = "game.version";
	public static final String DATABASE = "game.database";	
	
	private Configuration()
	{		
	}
	
	static
	{		
		Runtime.getRuntime().addShutdownHook(new Thread(new Configuration()));
		properties = new Properties();
		File file = new File(propertiesFile);
		InputStream in = null;
		if(file.exists())
		{
			try
			{
				in = new FileInputStream(file);
			}
			catch (FileNotFoundException e) 
			{
				//Uhmm no existe el archivo, bueno no importa... (esto nunca ocurrirá fijate en el if contenedor)
			}
		}		
		if(in == null)
		{
			in = Configuration.class.getResourceAsStream(propertiesFile);
		}
		
		try
		{
			properties.load(in);
		}
		catch (IOException e) 
		{
			throw new RuntimeException("No se puede leer el archivo fp4g-server.properties",e);			
		}		
	}
	
	
	public static String getProperty(String key)
	{
		return properties.getProperty(key);
	}
	
	public void run()
	{
		closeAndSave();		
	}
	
	public static void closeAndSave()
	{
		try {
			File f = new File(propertiesFile);		
			properties.store(new FileOutputStream(f), "Propiedades de FP4G-Server");
		}
		catch (IOException e) 
		{
			throw new RuntimeException("No se puede guardar",e);
		}		
	}

	public static void setProperty(String key, String value) 
	{
		properties.setProperty(key, value);		
	}	

}
