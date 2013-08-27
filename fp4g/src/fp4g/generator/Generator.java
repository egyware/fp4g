package fp4g.generator;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import fp4g.data.Code;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator {	
	public static final String autodoc = "/**\n  * Autogenerado por FP4G\n  * [NO MODIFICAR]\n  */";
	public static String packageName = "";
	public static String packageNameDir = "";
	public static File packageDir;
	public static boolean isDebug;
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
			} catch (TemplateException e) {				
				e.printStackTrace();
			}
		}	
		else
		{
			//TODO mostrar error
			throw new RuntimeException("Epa, generador incorrecto");
		}
		
	}
	
	protected static String uncap_first(String string)
	{
		StringBuilder uncap_string = new StringBuilder();
		uncap_string.append(Character.toLowerCase(string.charAt(0)));
		uncap_string.append(string.substring(1));
		return uncap_string.toString();
	}
	protected abstract void generateData(Map<String, Object> options,Configuration cfg, Code gameData, File path) throws IOException, TemplateException ;	
}
