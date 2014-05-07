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
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.define.Game;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.libs.Lib;
import fp4g.data.libs.LibContainer;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.GeneratorException;
import fp4g.log.Log;
import fp4g.parser.FP4GDataVisitor;
import fp4g.parser.FP4GLexer;
import fp4g.parser.FP4GParser;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator<M extends MetaSourceModel> {	
	protected abstract void initialize(File path,Options options,Configuration cfg);
	protected abstract void generateCode(ICode gameData,File path) throws GeneratorException;
	protected abstract void compileFiles(Collection<File> files) throws GeneratorException; 
	protected abstract Collection<File> getRequiredFiles(File path,File file);
	protected abstract void copyFiles(Collection<File> files);
	
	protected final LibContainer libContainer = new LibContainer();
	private TreeSet<File> filesToCompile = new TreeSet<File>();
	private TreeSet<File> filesToCopy = new TreeSet<File>();
	private Configuration cfg;
	
		
	public final void generate(Options options,ICode gameData, File path){
		cfg = new Configuration();		
		cfg.setObjectWrapper(new DefaultObjectWrapper());		
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		
		//inicializar el generador		
		initialize(path,options,cfg);
		
		System.out.println("Generating...");        	
		//generar el codigo
		try
		{
			generateCode(gameData,path);
		}
		catch(GeneratorException ge)
		{
			Log.Exception(ge, 0);
			return;
		}
		System.out.println("Done!");
        
		System.out.println("Compilig...");
		//compilar archivos...
		try
		{
			compileFiles(filesToCompile);
		}
		catch(GeneratorException ge)
		{
			Log.Exception(ge, 0);
			return;
		}

		//copy files
		copyFiles(filesToCopy);
		System.out.println("Done!");
	}
	
	//functiones de utilidad proxies
	public Template getTemplate(String name) throws IOException
	{	
		return cfg.getTemplate(name);
	}
	
	
	public abstract Expresion function(M model, FunctionCall fcall) throws CannotEvalException;
	public abstract String   expresion(M model, Expresion expr) throws CannotEvalException;
	
	
	
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
		
		if(name.endsWith("java"))
		{		
			filesToCompile.add(file);
		}
		else
		{
			filesToCopy.add(file);
		}
	}
	
	public void loadLib(String libFileName)
	{
		try
		{
			Lib lib = new Lib();
			FP4GLexer lexer = new FP4GLexer(new ANTLRFileStream(libFileName));	
			CommonTokenStream tokens = new CommonTokenStream(lexer);		
			FP4GParser p = new FP4GParser(tokens);		
			p.setBuildParseTree(true);			
			
			ParseTree tree = p.gameLib();			
			if(tree != null)
			{
				FP4GDataVisitor visitor = new FP4GDataVisitor(lib);
				visitor.visit(tree);
			}
			else
			{
				System.err.println("Biblioteca no cargada");
			}
			libContainer.addLib(lib);
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
	}
	
	public abstract LibContainer loadLibs();
	public abstract void setDefaults(Game gameConf);
	protected abstract Depend resolveDependency(Define define) throws DependResolverNotFoundException;
	
}
