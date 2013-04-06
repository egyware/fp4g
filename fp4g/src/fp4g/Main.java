package fp4g;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import fp4g.data.Define;
import fp4g.data.Scope;
import fp4g.data.Type;
import fp4g.generator.Generator;
import fp4g.generator.Utils;
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
		        Scope global = new Scope();
		        global.set("RenderSystem" ,new Define("GdxRenderManager",Type.SYSTEM,new Scope(),1));
		        global.set("EntitySystem" ,new Define("EntityManager"   ,Type.SYSTEM,new Scope(),2));
		        global.set("SoundSystem"  ,new Define("SoundManager"    ,Type.SYSTEM,new Scope(),3));
		        global.set("PhysicsSystem",new Define("PhysicsManager"  ,Type.SYSTEM,new Scope(),4));
		        	
	
		        global.set("name","GameApp");
		        global.set("width",640);
		        global.set("height",480);
		        global.set("debug",false);
		        
		        //agregar componentes
		        String components[][] = 
		        	{
		        		{"SpriteBehavior","spatial.Spatial"},
		        		{"PlatformBodyBehavior","BodyBehavior"},
		        		{"CitizenBodyBehavior","BodyBehavior"},		        				        		
		        		{"PlayerBodyBehavior","BodyBehavior"},
		        		{"DestroyerBodyBehavior","BodyBehavior"},
		        	};	        
		        for(String c[]:components)
		        {
		        	global.set(c[0],new Define(c[0],Type.BEHAVIOR,new Scope()));
		        	Utils.setFamilyComponents(c[0],c[1]);
		        }
		        
		        System.out.println("Parsing ...");
		        Scope game = parser.game(global); 
		        System.out.println("...Ok!");
		        Generator gen = new Generator(game);
		        System.out.println("Generating...");
		        gen.generate(outDirectory);
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
