package fp4g.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import fp4g.data.Code;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator {	
	public static final String autodoc = "/**\n  * Autogenerado por FP4G\n  * [NO MODIFICAR]\n  */";
	public static String packageName = "";
	public static String packageNameDir = "";
	public static File packageDir;
	public static boolean isDebug;
	private static List<File> filesToCompile = new LinkedList<>();
	//generadores disponibles
	public enum Available {		
		Entity(EntityGenerator.class),Event(EventGenerator.class),Game(GameGenerator.class),GameState(GameStateGenerator.class),Goal(GoalGenerator.class);
		private Class<? extends Generator> generator;
		private Available(Class<? extends Generator> gen)
		{
			generator = gen;
		}
		public Generator NewInstance() throws InstantiationException, IllegalAccessException
		{
			return generator.newInstance();
		}
	}
	public static void generate(Map<String,Object> options,Code gameData, File path){
		
		packageName = (String) options.get("package");
		packageNameDir = packageName.replace('.', '/');
		packageDir = new File(path,packageNameDir);
		isDebug = (Boolean) options.get("debug");
		if(!packageDir.exists())
		{
			packageDir.mkdirs();
		}
		
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(Generator.class, "/fp4g/templates");
		cfg.setObjectWrapper(new DefaultObjectWrapper());		
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		//cfg.
		
		Class<?> clazz = gameData.getClass();		
		Available available =  Available.valueOf(clazz.getSimpleName());
				
		if(available != null)
		{
			try {
				Generator generator = available.NewInstance();
				generator.generateData(options,cfg,gameData, path);				
			} catch (InstantiationException e) {				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}	
		else
		{
			//TODO mostrar error
			throw new RuntimeException("Epa, generador incorrecto");
		}		
	}
	
	public static void compileFiles()
	{
		final String path = packageDir.getAbsolutePath();
		final int start = path.length()-packageNameDir.length();
		final String options[] = {
				"-classpath",
				"C:\\Users\\Edgardo\\Git\\fp4g-src\\Apollo\\bin;C:\\Users\\Edgardo\\personal\\Asteroids\\libs\\gdx.jar;"				
		};
		System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_25");
						
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(diagnostics,null,null);
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(filesToCompile);
		javaCompiler.getTask(null, fileManager, diagnostics, Arrays.asList(options), null, compilationUnits).call();
		
		for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
			String fileName = diagnostic.getSource().getName();
			if(fileName.length() > path.length() )
			{
				fileName = fileName.substring(start);
			}
			System.out.format("%3d: JavaError %s \"%s\"\n", diagnostic.getLineNumber(), fileName,diagnostic.getMessage(null));
		}        
	 
	    try {
			fileManager.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	

	protected static String uncap_first(String string)
	{
		StringBuilder uncap_string = new StringBuilder();
		uncap_string.append(Character.toLowerCase(string.charAt(0)));
		uncap_string.append(string.substring(1));
		return uncap_string.toString();
	}	

	public static void createFile(
			String name, 
			Template template,
			HashMap<String, Object> buildRoot)
	{				
		try {
			File file = new File(packageDir,name);
			Writer out = new FileWriter(file);
			template.process(buildRoot, out);
			System.out.println(String.format("Generado: %s/%s",packageNameDir,name));
			filesToCompile.add(file);
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (TemplateException e) {			
			e.printStackTrace();
		}	
	}
	
	protected abstract void generateData(Map<String, Object> options,Configuration cfg, Code gameData, File path) throws IOException;
}
