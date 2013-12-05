package fp4g.runner;

import java.io.File;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Runner 
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		if(args.length < 2)
		{
			System.out.println("Modo de uso: FP4G path fileName");
			return;
		}
		FileClassLoader fileClassLoader = new FileClassLoader(ClassLoader.getSystemClassLoader(),new File(args[0]));
		Class<?> appClass = fileClassLoader.loadClass(args[1]);
		
		//TODO M�s adelante leer alguna especie de archivo de arranque y wea
	
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "FP4G - GameApp";
		cfg.useGL20 = false;
		cfg.width = 640;
		cfg.height = 480;		
		
		new LwjglApplication((ApplicationListener) appClass.newInstance(),cfg);
		
	}	
		
}