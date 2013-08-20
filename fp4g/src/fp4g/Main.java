package fp4g;

import java.io.IOException;
import java.util.HashMap;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;

import fp4g.data.define.Game;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;

public class Main {
	private static String outDirectory = ".";
	private static String inputFile;
	private static HashMap<String,Object> options = new HashMap<>();
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		options.put("package", "game"); //por defecto
		options.put("debug", false); //por defecto
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
				
		try {
			FP4GLexer lexer = new FP4GLexer(new ANTLRFileStream(inputFile));	
			CommonTokenStream tokens = new CommonTokenStream(lexer);		
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);
			
			
			Game gameConf = new Game();
	    	gameConf.name = "GameApp";
	    	gameConf.width = 640;
	    	gameConf.height = 480;
	    	gameConf.debug = false;
			
			
			FP4GDataVisitor visitor = new FP4GDataVisitor(gameConf);
			visitor.visit(p.program());
			
			
		} catch (IOException e) {
			//TODO personalizar error
			e.printStackTrace();
		}
		
	
//			  FileInputStream fis = new FileInputStream(inputFile);
//			  FastPrototyping4Game parser = new FastPrototyping4Game(fis);
//		      System.out.println(String.format("Reading from %s",inputFile));      
//		      try
//		      {
//		    	Game gameConf = new Game();
//		    	gameConf.name = "GameApp";
//		    	gameConf.width = 640;
//		    	gameConf.height = 480;
//		    	gameConf.debug = false;
//		    	
////		    	gameConf.addDefine(new RenderManager());
////		    	gameConf.addDefine(new EntityManager());
////		    	gameConf.addDefine(new SoundManager());
////		    	gameConf.addDefine(new PhysicsManager());
//		    	
//		        //agregar componentes		    	
////		        String components[][] = 
////		        	{
////		        		{"BodyBehavior"},
////		        		{"spatial.Spatial"},
////		        		{"SpriteBehavior","spatial.Spatial"},		        			        		
////		        	};	        
////		        for(String c[]:components)
////		        {
////		        	if(c.length == 1)
////		        	{
////		        		gameConf.addBehavior(c[0]);
////		        	}
////		        	else
////		        	{
////		        		gameConf.addBehavior(c[0],c[1]);
////		        	}
////		        }
//
//		        System.out.println(String.format("Parsing: %s",inputFile));
//		        parser.game(gameConf);
//		        System.out.println(String.format("Parsing complete: %s",inputFile));
//		        
//		        System.out.println("Generating...");
//		        Generator.generate(options,gameConf, new File(outDirectory));
//		        System.out.println("...Ok!");		        
//	        
//		      }
//		      catch (Exception e)
//		      {
//		        System.out.println("NOK.");
//		        System.out.println(e.getMessage());
//		        e.printStackTrace();
//		      }
//		      catch (Error e)
//		      {
//		        System.out.println("Oops.");
//		        System.out.println(e.getMessage());
//		        e.printStackTrace();
//		      }
//		      fis.close();
//		}
//		catch (FileNotFoundException fileNotFound) 
//		{			
//			fileNotFound.printStackTrace();
//		}
//		catch (IOException io)
//		{			 
//			io.printStackTrace();
//		}
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
				options.put("package", args[++i]);
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
