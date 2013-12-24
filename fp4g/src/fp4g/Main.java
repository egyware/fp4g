package fp4g;

import java.io.File;
import java.io.IOException;
import java.lang.Thread.UncaughtExceptionHandler;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.data.define.Game;
import fp4g.generator.Generator;
import fp4g.generator.gdx.JavaGenerator;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;

public class Main {
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
				e.printStackTrace(System.err);
//				System.err.println(String.format("%s %s",e.getClass().getSimpleName(),e.getMessage()));
//				System.err.println(e.getStackTrace()[0]);
//				System.err.println(e.getStackTrace()[1]);
//				System.err.println(e.getStackTrace()[2]);
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

	private static void parseFile(String inputFile) {
		
		try {
			System.out.println(String.format("Reading from %s",inputFile));
			FP4GLexer lexer = new FP4GLexer(new ANTLRFileStream(inputFile));	
			CommonTokenStream tokens = new CommonTokenStream(lexer);		
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);
			
			
			Generator generator = new JavaGenerator();
			Game gameConf = new Game();
			generator.prepareGameData(gameConf);						
			
	    	System.out.println(String.format("Parsing: %s",inputFile));			
			ParseTree tree = p.program();
			
			if(tree != null)
			{
				FP4GDataVisitor visitor = new FP4GDataVisitor(gameConf);
				visitor.visit(tree);				
								
				generator.generate(options,gameConf, new File(outDirectory));
				System.out.println(String.format("Parsing complete: %s",inputFile));				
			}
			else
			{
				System.out.println(String.format("Parsing incomplete: %s",inputFile));
			}			
			
	        
			
		} catch (IOException e) {
			//TODO personalizar error
			e.printStackTrace();
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
		System.out.println(inputFile);
		System.out.println(outDirectory);
		return inputFile != null;
	}

}
