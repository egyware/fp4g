package fp4g;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import fp4g.data.Define;
import fp4g.data.IScope;
import fp4g.data.MapScope;
import fp4g.data.FactoryType;
import fp4g.new_generator.Generator;
import fp4g.generator.Utils;
import fp4g.new_data.Game;
import fp4g.new_data.managers.EntityManager;
import fp4g.new_data.managers.PhysicsManager;
import fp4g.new_data.managers.RenderManager;
import fp4g.new_data.managers.SoundManager;
import fp4g.parser.FastPrototyping4Game;
import fp4g.parser.ParseException;

public class Main {
	private static String outDirectory = ".";
	private static String inputFile;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)  throws ParseException {
		if(params(args))
		{
			if(inputFile == null)
			{
				System.err.println("Error: Se esperaba un archivo");
				ShowHelp();			
			}else
			{
				parseFile(inputFile);			
			}
		}
	}

	private static void parseFile(String inputFile) {
		try 
		{			
			  FileInputStream fis = new FileInputStream(inputFile);
			  FastPrototyping4Game parser = new FastPrototyping4Game(fis);
		      System.out.println(String.format("Reading from %s",inputFile));      
		      try
		      {
		    	Game gameConf = new Game();
		    	gameConf.name = "GameApp";
		    	gameConf.width = 640;
		    	gameConf.height = 480;
		    	gameConf.debug = false;
		    	
		    	gameConf.addManager("RenderSystem", new RenderManager());
		    	gameConf.addManager("EntitySystem", new EntityManager());
		    	gameConf.addManager("SoundSystem",  new SoundManager());
		    	gameConf.addManager("PhysicsSystem",new PhysicsManager());
		    	
		        //agregar componentes		    	
		        String components[][] = 
		        	{
		        		{"BodyBehavior"},
		        		{"spatial.Spatial"},
		        		{"SpriteBehavior","spatial.Spatial"},		        			        		
		        	};	        
		        for(String c[]:components)
		        {
		        	if(c.length == 1)
		        	{
		        		gameConf.addBehavior(c[0]);
		        	}
		        	else
		        	{
		        		gameConf.addBehavior(c[0],c[1]);
		        	}
		        }

		        System.out.println(String.format("Parsing: %s",inputFile));
		        parser.game(gameConf);
		        System.out.println(String.format("Parsing complete: %s",inputFile));
		        
		        System.out.println("Generating...");
		        Generator.generate(gameConf, new File(outDirectory));
		        System.out.println("...Ok!");		        
	        
		      }
		      catch (Exception e)
		      {
		        System.out.println("NOK.");
		        System.out.println(e.getMessage());
		        e.printStackTrace();
		      }
		      catch (Error e)
		      {
		        System.out.println("Oops.");
		        System.out.println(e.getMessage());
		        e.printStackTrace();
		      }
		      fis.close();
		}
		catch (FileNotFoundException fileNotFound) 
		{			
			fileNotFound.printStackTrace();
		}
		catch (IOException io)
		{			 
			io.printStackTrace();
		}
	}

	private static void ShowHelp() {
		//TODO [egyware] por hacer...
		System.out.println("Por hacer....");		
	}

	/**
	 * Opciones para configurar el compilador
	 * -p package Nombre del paquete a generar
	 * -out directory Directorio de salida
	 * -c componentes pendiente
	 * -m managers pendiente
	 * @param args
	 */
	private static boolean params(String[] args) {
		final int size = args.length;
		for(int i = 0; i < size; i++)
		{
			final String cmd = args[i];
			if(cmd.startsWith("-p"))
			{
				Utils.gamePackageName = args[++i];				
			}else
			if(cmd.startsWith("-out"))
			{
				outDirectory = args[++i];
			}else
			if(cmd.startsWith("-out"))
			{
				outDirectory = args[++i];
			}else
			if(cmd.startsWith("-h"))
			{
				ShowHelp();
				return false;
			}else
			{
				inputFile = args[i];
			}
		}
		return inputFile != null;		
	}

}
