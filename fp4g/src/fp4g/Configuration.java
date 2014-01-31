package fp4g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import fp4g.exceptions.FP4GRuntimeException;
import fp4g.log.info.Error;
import fp4g.log.info.Warn;

public final class Configuration implements Runnable
{
	private final static Properties properties;	
	public final static String JDK_HOME = "java.home";
	public final static String DEFAULT_PACKAGE = "default.package";
	public final static String DEFAULT_DEBUG   = "default.debug";
	
	
	private Configuration()
	{		
	}
	
	static
	{		
		Runtime.getRuntime().addShutdownHook(new Thread(new Configuration()));
		properties = new Properties();
		File file = new File("fp4g.properties");
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
			in = Configuration.class.getResourceAsStream("fp4g.properties");
		}
		
		try
		{
			properties.load(in);
		}
		catch (IOException e) 
		{
			throw new FP4GRuntimeException(Error.PropertiesCantLoad, "No se puede leer el archivo fp4g.properties");			
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
			File f = new File("fp4g.properties");		
			properties.store(new FileOutputStream(f), "Propiedades de FP4G");
		}
		catch (IOException e) 
		{
			throw new FP4GRuntimeException(Warn.PropertiesCantSave,e.getMessage(),e);
		}		
	}

	public static void setProperty(String key, String value) 
	{
		properties.setProperty(key, value);		
	}	

}
