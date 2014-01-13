package fp4g.runner;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import com.esotericsoftware.reflectasm.FieldAccess;

public class Main 
{
	public static void main(String[] args) 
	{
		if(args.length < 2)
		{
			System.out.println("Modo de uso: Runner path class");
			return;
		}		
		
		RunnerClassLoader loader = null;
		try 
		{
			URL urls[] = new URL[]
			{
				new File(args[0]).toURI().toURL()	
			};
					
			loader = new RunnerClassLoader(urls, ClassLoader.getSystemClassLoader());
			Class<?> appClass  = loader.loadClass(args[1]);
			Class<?> confClass = loader.loadClass("com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration");
			Class<?> bindClass = loader.loadClass("com.badlogic.gdx.backends.lwjgl.LwjglApplication");

			Object instanceConf = confClass.newInstance();
			FieldAccess confField = FieldAccess.get(confClass);
			
			confField.set(instanceConf, "title", String.format("FP4G - %s",appClass.getSimpleName()));
			
			confField.set(instanceConf, "useGL20", true);
			confField.set(instanceConf, "width", 640);
			confField.set(instanceConf, "height", 480);
			confField.set(instanceConf, "resizable", false);
			
			Constructor<?> constructor = bindClass.getConstructor(appClass,confClass);
			
			constructor.newInstance(appClass.newInstance(), instanceConf);
			
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
		finally
		{
			try 
			{
				if(loader != null)	loader.close();
			}
			catch (IOException e)
			{				
				e.printStackTrace();
			}
		}
				
	}		
	
}