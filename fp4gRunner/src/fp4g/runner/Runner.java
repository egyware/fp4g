package fp4g.runner;

import java.lang.Thread.UncaughtExceptionHandler;

import org.lwjgl.opengl.Display;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Runner 
{
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
//		if(args.length < 1)
//		{
//			System.out.println("Modo de uso: Runner class");
//			return;
//		}
		//FileClassLoader fileClassLoader = new FileClassLoader(ClassLoader.getSystemClassLoader(),new File(args[0]));
		//Class<?> appClass = fileClassLoader.loadClass(args[1]);
		//Class<?> appClass = ClassLoader.getSystemClassLoader().loadClass(args[0]);
		
		//TODO M�s adelante leer alguna especie de archivo de arranque y wea
	
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		
		//cfg.title = String.format("FP4G - %s",appClass.getSimpleName());
		cfg.useGL20 = false;
		cfg.width = 640;
		cfg.height = 480;		
				
		
		//new LwjglApplication((ApplicationListener) appClass.newInstance(),cfg);
		
		LwjglApplication a = new LwjglApplication(new ApplicationListener()
		{

			@Override
			public void create() {
				Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler()
				{

					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println("OH!!!");
						Display.destroy();
						e.printStackTrace();
					}
					
				});
				
			}

			@Override
			public void dispose() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void pause() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void render() {
				throw new RuntimeException(" lol ");
				
			}

			@Override
			public void resize(int arg0, int arg1) {
				
				
			}

			@Override
			public void resume() {
				// TODO Auto-generated method stub
				
			}
		}
		,cfg);
		System.out.println();		
		
	}		
	
}
