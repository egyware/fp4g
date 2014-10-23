package fp4g.runner;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.esotericsoftware.reflectasm.FieldAccess;

public class Main 
{
	public static void main(String[] args) 
	{
		if(args.length < 1)
		{
			System.out.println("Modo de uso: Runner path [class]");
			return;
		}		
		
		
	    RunnerClassLoader loader = null;
	    Properties properties = null;
	    String gameClass = null;
	    String[] classPath = null;	    	    
		try 
		{
			URL urls[] = new URL[]
			{
				new File(args[0]).toURI().toURL(),
				new URL("file:libs/gdx.jar"),
				new URL("file:libs/gdx-natives.jar"),				
				new URL("file:libs/gdx-backend-lwjgl.jar"),				
				new URL("file:libs/gdx-backend-lwjgl-natives.jar"),
				new URL("file:libs/gdx-box2d.jar"),
				new URL("file:libs/gdx-box2d-natives.jar"),
				new URL("file:libs/apollo-fp4g.jar")
			};
			loader = new RunnerClassLoader(urls);
			
			//cargar propiedades
			InputStream in = loader.getResourceAsStream("game.properties");
			if(in != null)
			{
				try 
				{
					properties = new Properties();
					properties.load(in);
					String cp = properties.getProperty("game.classpath");
					if(cp != null) classPath = cp.split(File.pathSeparator);
					for(String path: classPath)
					{
						loader.addURL(new URL(String.format("file:libs/%s",path)));
					}
					gameClass = properties.getProperty("game.class");					
				}
				catch (IOException e) 
				{
					System.err.println("Peligro: No se encontró game.properties");
					properties = null;
				}				
			}
			//sobreescribe la propiedad
			if(args.length >=2)
			{
				gameClass = args[1];
			}
			
			if(gameClass == null)
			{
				System.err.println("Error: No se encontró y/o especifico un juego");
				return;
			}
			
			Class<?> appClass     = loader.loadClass(gameClass);
			Class<?> confClass    = loader.loadClass("com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration");
			Class<?> bindClass    = loader.loadClass("com.badlogic.gdx.backends.lwjgl.LwjglApplication");
			Class<?> appInterface = loader.loadClass("com.badlogic.gdx.ApplicationListener"); 
			
			Object instanceConf = confClass.newInstance();
			FieldAccess confField = FieldAccess.get(confClass);
			
			if(properties != null)
			{
				confField.set(instanceConf, "title", properties.getProperty("game.title"));
				
				confField.set(instanceConf, "useGL30", Boolean.parseBoolean(properties.getProperty("game.useGL30")));
				confField.set(instanceConf, "width",   Integer.parseInt(properties.getProperty("game.width")));
				confField.set(instanceConf, "height",  Integer.parseInt(properties.getProperty("game.height")));
				confField.set(instanceConf, "resizable", Boolean.parseBoolean(properties.getProperty("game.resizable")));
			}
			else
			{
				confField.set(instanceConf, "title", String.format("FP4G - %s",appClass.getSimpleName()));
				
				confField.set(instanceConf, "useGL30", true);
				confField.set(instanceConf, "width", 640);
				confField.set(instanceConf, "height", 480);
				confField.set(instanceConf, "resizable", false);
			}
			
			Constructor<?> constructor = bindClass.getConstructor(appInterface, confClass);
			
			Object o = appClass.newInstance();
//			for(Class<?> i :appClass.getSuperclass().getInterfaces())
//			{
//				System.out.println(i.getSimpleName());
//				System.out.println(appInterface.isInstance(o));
//			}			
//			System.out.println(appInterface.getSimpleName());
			
			constructor.newInstance(o, instanceConf);
			
		}
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch (NoSuchMethodException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SecurityException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InstantiationException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvocationTargetException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}		
	
}