package fp4g.generator.gdxgenerator;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import fp4g.Options;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Goal;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.expresion.ArrayExpr;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.expresion.Literal;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Generator;
import fp4g.generator.models.Depend;
import fp4g.generator.models.JavaCodeModel;
import freemarker.template.Configuration;

public class JavaGenerator extends Generator {	
	public static final String autodoc = "/**\n  * Autogenerado por FP4G\n  * [NO MODIFICAR]\n  */";
	public String packageName = "";
	public String packageNameDir = "";
	public File packageDir;
	public boolean isDebug;
	public final JavaExpresionGenerator exprGen;
	public final JavaFunctionGenerator funcGen;
	public final Map<Define,JavaCodeModel> parDefineJavaCode;
	
	public final Map<Class<? extends Code>,Class<? extends CodeGenerator<JavaGenerator>>> generators;
	
	public final HashMap<Define,Depend> dependencias = new HashMap<>();
	
	public JavaGenerator()
	{
		generators = new HashMap<>(10,1);
		parDefineJavaCode = new HashMap<>(10);
		
		generators.put(GameState.class, GameStateGenerator.class);
		generators.put(Entity.class,    EntityGenerator.class);
		//generators.put(Event.class,     EventGenerator.class);
		generators.put(Game.class,      GameGenerator.class);
		generators.put(Goal.class,      GoalGenerator.class);
		
		exprGen = new JavaExpresionGenerator(this);
		funcGen = new JavaFunctionGenerator(this);
	}
	
	@Override	
	protected void initialize(Options options,Configuration cfg)
	{
		packageName = (String) options.get("package");
		packageNameDir = packageName.replace('.', '/');
		isDebug = (Boolean) options.get("debug");
		
		cfg.setClassForTemplateLoading(JavaGenerator.class, "/fp4g/templates");
				
	}

	
	@Override
	protected void generateCode(Code gameData, File path) 
	{
		//creamos la carpeta
		if(packageDir == null)
		{
			packageDir = new File(path,packageNameDir);	
			if(!packageDir.exists())
			{
				packageDir.mkdirs();
			}
		}
		
		//----
		Class<? extends CodeGenerator<JavaGenerator>> codegen = generators.get(gameData.getClass());
		
		if(codegen != null)
		{
			try{
				Constructor<? extends CodeGenerator<JavaGenerator>> constructor = codegen.getConstructor(JavaGenerator.class);
				CodeGenerator<? extends JavaGenerator> generator = constructor.newInstance(this);
				generator.generateCode(gameData, packageDir);
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
		else
		{
			//TODO mostrar error
			throw new RuntimeException("Epa, generador incorrecto");
		}		
	}
	
	@Override
	protected void compileFiles(List<File> files)
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
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
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

	@Override
	public <CodeModel> Expresion function(Code parent, CodeModel model,	FunctionCall fcall) {		
		return funcGen.generate(parent, (JavaCodeModel)model,fcall);
	}

	@Override
	public <CodeModel> String expresion(Code parent, CodeModel model,Expresion expr) {
		return exprGen.generate(parent, (JavaCodeModel) model,expr);
	}
	
	public void addJavaCode(Define define,JavaCodeModel value)	
	{
		parDefineJavaCode.put(define, value);
	}

	public static void fillWithUsefulData(Game gameConf) 
	{
		gameConf.name = "GameApp";
    	gameConf.width = 640;
    	gameConf.height = 480;
    	gameConf.debug = false;
    	gameConf.setManager(new JavaRenderManager());
    	gameConf.setManager(new JavaEntityManager());
    	gameConf.setManager(new JavaSoundManager());
    	gameConf.setManager(new JavaPhysicsManager());
    	
    	Message keyMessage = new Message("Key",gameConf);
    	String keys[] = {"key","value","compare"};
    	Expresion value[] = {new Literal<String>("key"),new Literal<String>("Keyboard.A"), new Literal<String>("equals")};
    	keyMessage.set("pressA", new ArrayExpr(keys,value));
    	
    	gameConf.setDefine(keyMessage);
    	/*DEFINE MESSAGE Key
    	[
    		SET pressA     = {field= "key", value="Keyboard.A",     compare="equals"};
    		SET pressA     = {field= "key", value="Keyboard.B",     compare="equals"};
    		SET pressLeft  = {field= "key", value="Keyboard.Left",  compare="equals"};
    		SET pressRight = {field= "key", value="Keyboard.Right", compare="equals"};
    		SET pressUp    = {field= "key", value="Keyboard.Up",    compare="equals"};
    		SET pressDown  = {field= "key", value="Keyboard.Down",  compare="equals"};
    		SET pressSpace = {field= "key", value="Keyboard.Space", compare="equals"};
    	]*/
//        //agregar componentes		    	
////    String components[][] = 
////    	{
////    		{"BodyBehavior"},
////    		{"spatial.Spatial"},
////    		{"SpriteBehavior","spatial.Spatial"},		        			        		
////    	};	        
////    for(String c[]:components)
////    {
////    	if(c.length == 1)
////    	{
////    		gameConf.addBehavior(c[0]);
////    	}
////    	else
////    	{
////    		gameConf.addBehavior(c[0],c[1]);
////    	}
////    }
	}
	
	private static class JavaRenderManager extends Manager
	{
		public JavaRenderManager() {
			super("GdxRenderManager",1);		
		}
	}
	private static class JavaEntityManager extends Manager 
	{
		public JavaEntityManager() 
		{
			super("EntityManager",3);		
		}		
	}
	private static class JavaPhysicsManager extends Manager 
	{

		public JavaPhysicsManager() {
			super("PhysicsManager",2);		
		}		
	}
	private static class JavaSoundManager extends Manager {

		public JavaSoundManager() {
			super("SoundManager",4);
		}
	}



}
