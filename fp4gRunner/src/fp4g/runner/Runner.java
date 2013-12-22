package fp4g.runner;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.CustomLwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Runner 
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		if(args.length < 1)
		{
			System.out.println("Modo de uso: Runner class");
			return;
		}		
		
		Class<?> appClass = Class.forName(args[0]);
			
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		cfg.title = String.format("FP4G - %s",appClass.getSimpleName());
		cfg.useGL20 = false;
		cfg.width = 640;
		cfg.height = 480;		
				
		
		new CustomLwjglApplication((ApplicationListener) appClass.newInstance(),cfg);
		
				
	}		
	
}