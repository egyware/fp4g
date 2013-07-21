package fp4g.new_generator;

import java.io.File;
import java.io.IOException;

import fp4g.new_data.IGameData;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

public abstract class Generator {	
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
	public static void generate(IGameData gameData, File path){
		
		
		Configuration cfg = new Configuration();	
		// Specify the data source where the template files come from. Here I set a
		// plain directory for it, but non-file-system are possible too:
		cfg.setClassForTemplateLoading(Generator.class, "/fp4g/templates");
			
		// Specify how templates will see the data-model. This is an advanced topic...
		// for now just use this:
		cfg.setObjectWrapper(new DefaultObjectWrapper());
		
		// Set your preferred charset template files are stored in. UTF-8 is
		// a good choice in most applications:
		cfg.setDefaultEncoding("UTF-8");
		
		// Sets how errors will appear. Here we assume we are developing HTML pages.
		// For production systems TemplateExceptionHandler.RETHROW_HANDLER is better.
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		
		// At least in new projects, specify that you want the fixes that aren't
		// 100% backward compatible too (these are very low-risk changes as far as the
		// 1st and 2nd version number remains):
		cfg.setIncompatibleImprovements(new Version(2, 3, 20));
		Available available =  Available.valueOf(gameData.getClass().getSimpleName());
		if(available != null)
		{
			try {
				Generator generator = available.NewInstance();
				generator.generateData(cfg,gameData, path);				
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
	protected abstract void generateData(Configuration cfg, IGameData gameData, File path) throws IOException, TemplateException ;
}
