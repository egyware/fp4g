package com.teamnayn.ceditor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Program 
{
	public static void main(String[] args) 
	{
		final ClassLoader loader = Program.class.getClassLoader();
		final File file = new File("game.properties");
		
		InputStream in = null;
		Properties properties = null;
		if(file.exists())
		{
			try
			{
				in = new FileInputStream(file);
			}
			catch(IOException ie) { /*ignorar*/ }
		}
		if(in == null)
		{
			in = loader.getResourceAsStream("game.properties");
		}
		
		try 
		{	properties = new Properties();			
			properties.load(in);									
		}
		catch (Exception e) { /*ignorar*/ }				
					
		if(properties != null)
		{
			properties = new Properties();
			properties.setProperty("width", "640");
			properties.setProperty("height", "400");
		}
		
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CEDITOR 0.147";
		cfg.useGL30 = false;
		cfg.width  = Integer.parseInt(properties.getProperty("width"));
		cfg.height = Integer.parseInt(properties.getProperty("height"));
		
		new LwjglApplication(new Ceditor(), cfg);
	}
}
