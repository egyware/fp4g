package fp4g.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;

import fp4g.Options;
import fp4g.data.Code;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator {	
	protected abstract void initialize(Options options,Configuration cfg);
	protected abstract void generateCode(Code gameData,File path);
	protected abstract void compileFiles(List<File> files); //TODO: compile file add throw some exception
	
	
	private List<File> filesToCompile = new LinkedList<>();
	private Configuration cfg;
		
	public final void generate(Options options,Code gameData, File path){
		cfg = new Configuration();		
		cfg.setObjectWrapper(new DefaultObjectWrapper());		
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		
		//inicializar el generador		
		initialize(options,cfg);
		
		//generar el codigo
		generateCode(gameData,path);
		
		//compilar archivos...
		compileFiles(filesToCompile);		
	}
	
	public Template getTemplate(String name) throws IOException
	{	
		return cfg.getTemplate(name);
	}
	
	//Funciones de utilidad
	public static String uncap_first(String string)
	{
		StringBuilder uncap_string = new StringBuilder();
		uncap_string.append(Character.toLowerCase(string.charAt(0)));
		uncap_string.append(string.substring(1));
		return uncap_string.toString();
	}
	
	public static void createFile(File path,String name,Template template,Object buildRoot) throws Exception
	{	
		File file = new File(path,name);
		Writer out = new FileWriter(file);
		template.process(buildRoot, out);
		System.out.println(String.format("Generado: %s",name));					
	}
}
