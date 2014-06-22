package fp4g;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.data.define.Game;
import fp4g.data.libs.LibContainer;
import fp4g.exceptions.FP4GException;
import fp4g.exceptions.FP4GRuntimeException;
import fp4g.generator.Generator;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.log.Log;
import fp4g.log.info.GeneratorError;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;

public class Main
{
	private static String outDirectory;
	private static String inputFile;
	private static Options options = new Options();
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)  throws Exception 
	{		
		Thread.currentThread().setUncaughtExceptionHandler(new UncaughtExceptionHandler()
		{
			@Override
			public void uncaughtException(Thread t, Throwable e) 
			{
				if(e instanceof FP4GRuntimeException)
				{
					Log.Exception((FP4GRuntimeException)e, -1);					
					System.exit(1);
				}else
				if(e instanceof FP4GException)
				{
					Log.Exception((FP4GRuntimeException)e, -1);
					System.exit(1);
				}else
				{
					e.printStackTrace();
					System.exit(1);
				}
			}
		});
		
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

	private static void parseFile(String inputFile) 
	{
		try 
		{
			System.out.println(String.format("Reading from %s",inputFile));
			FP4GLexer lexer = new FP4GLexer(new ANTLRFileStream(inputFile));	
			CommonTokenStream tokens = new CommonTokenStream(lexer);		
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);
			
			
			Generator<?> generator = new JavaGenerator();
			LibContainer libs = generator.loadLibs();
			Game gameConf = new Game(libs);
			generator.setDefaults(gameConf);						
			
	    	System.out.println(String.format("Parsing: %s",inputFile));			
			ParseTree tree = p.program();
			
			if(tree != null)
			{
				try
				{
					FP4GDataVisitor visitor = new FP4GDataVisitor(gameConf);				
					visitor.visit(tree);
									
					generator.generate(options,gameConf, new File(outDirectory));
					System.out.println(String.format("Parsing complete: %s",inputFile));
				}
				catch(FP4GRuntimeException e)
				{
					Log.Exception(e, e.getLine());  
					System.out.println(String.format("Parsing incomplete: %s",inputFile));					
				}
			}
			else
			{
				System.out.println(String.format("Parsing incomplete: %s",inputFile));
			}		
		} 
		catch (IOException e) 
		{
			throw new FP4GRuntimeException(GeneratorError.CannotParseFile,"No se pudo leer: ".concat(inputFile),e);
		}
	}
	private static String help[] = {
		"*** Modo de uso ***",
		"",
		"FP4G [parametros] archivo.fp4g",
		"FP4G -h",
		"",
		"parametros:",
		"  -out directorio : Indica la salida del generador.",
		"  -p packageName  : Especifica el nombre del paquete (solo Java).",
		"  -h              : Muestra este menú.",
	};
	private static void ShowHelp() 
	{
		for(String line:help)
		{		
			System.out.println(line);
		}
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
			if(cmd.startsWith("-h"))
			{
				ShowHelp();
				return false;
			}else
			{
				inputFile = args[i];
			}
		}
		if(inputFile != null && outDirectory == null)
		{
			outDirectory = new File(inputFile).getParent();
			if(outDirectory == null)
			{
				outDirectory = ".";
			}			
		}		
		return inputFile != null;
	}

}
