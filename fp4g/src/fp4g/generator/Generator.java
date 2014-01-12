package fp4g.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.TreeSet;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import fp4g.Options;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.data.define.Game;
import fp4g.data.expresion.FunctionCall;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.GeneratorException;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator {	
	protected abstract void initialize(File path,Options options,Configuration cfg);
	protected abstract void generateCode(Code gameData,File path);
	protected abstract void compileFiles(Collection<File> files); //TODO: compile file add throw some exception
	protected abstract Collection<File> getRequiredFiles(File path,File file);
	
	
	private TreeSet<File> filesToCompile = new TreeSet<File>();
	private Configuration cfg;
	
		
	public final void generate(Options options,Code gameData, File path){
		cfg = new Configuration();		
		cfg.setObjectWrapper(new DefaultObjectWrapper());		
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		
		//inicializar el generador		
		initialize(path,options,cfg);
		
		System.out.println("Generating...");        	
		//generar el codigo
		generateCode(gameData,path);
		System.out.println("Done!");
        
		System.out.println("Compilig...");
		//compilar archivos...
		compileFiles(filesToCompile);		
		System.out.println("Done!");
	}
	//functiones de utilidad proxies
	public Template getTemplate(String name) throws IOException
	{	
		return cfg.getTemplate(name);
	}
	
	
	public abstract <CodeModel> Expresion function(CodeModel model, FunctionCall fcall) throws  GeneratorException;
	public abstract <CodeModel> String   expresion(CodeModel model, Expresion expr) throws GeneratorException;
	
	
	
	//Funciones de utilidad
	public static String uncap_first(String string)
	{
		StringBuilder uncap_string = new StringBuilder();
		uncap_string.append(Character.toLowerCase(string.charAt(0)));
		uncap_string.append(string.substring(1));
		return uncap_string.toString();
	}
	
	public void usingFile(File path,String name)
	{
		File file = new File(path,name);
		System.out.println(String.format("Agregando: %s",name));
		filesToCompile.add(file);
		filesToCompile.addAll(getRequiredFiles(path,file));
	}
	
	public void createFile(File path,String name,Template template,Object buildRoot) throws Exception
	{	
		File file = new File(path,name);
		Writer out = new FileWriter(file);
		template.process(buildRoot, out);
		System.out.println(String.format("Generado: %s",name));
		
		filesToCompile.add(file);
	}
	
	public void loadLib(String libFileName,Game data)
	{
		try
		{
			FP4GLexer lexer = new FP4GLexer(new ANTLRFileStream(libFileName));	
			CommonTokenStream tokens = new CommonTokenStream(lexer);		
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);			
			
			ParseTree tree = p.gameLib();			
			if(tree != null)
			{
				FP4GDataVisitor visitor = new FP4GDataVisitor(data);
				visitor.visit(tree);
			}
			else
			{
				System.err.println("Biblioteca no cargada");
			}
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	public abstract void prepareGameData(Game gameConf);
	protected abstract Depend resolveDependency(Define define) throws DependResolverNotFoundException;
}
