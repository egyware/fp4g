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

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Options;
import fp4g.classes.MessageMethod;
import fp4g.classes.MessageMethods;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Goal;
import fp4g.data.define.Manager;
import fp4g.data.define.Message;
import fp4g.data.expresion.ClassMap;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.FunctionCall;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Generator;
import fp4g.generator.models.Depend;
import fp4g.generator.models.JavaCodeModel;
import fp4g.generator.models.KeyMessageDepend;
import freemarker.template.Configuration;

public class JavaGenerator extends Generator {	
	public static final String autodoc = "/**\n  * Autogenerado por FP4G\n  * [NO MODIFICAR]\n  */";
	public String packageName = "";
	public String packageNameDir = "";
	public File packageDir;
	public boolean isDebug;
	public File binaryDir;
	public File sourceDir;
	public final JavaExpresionGenerator exprGen;
	public final JavaFunctionGenerator funcGen;
	public final Map<Define,JavaCodeModel> parDefineJavaCode;
	
	public final Map<Class<? extends Code>,Class<? extends CodeGenerator<JavaGenerator>>> generators;
	
	public final HashMap<Define,Depend<? extends Define>> dependencias;
	
	public JavaGenerator()
	{
		generators = new HashMap<Class<? extends Code>, Class<? extends CodeGenerator<JavaGenerator>>>(10,1);
		parDefineJavaCode = new HashMap<Define, JavaCodeModel>(10);
		dependencias = new HashMap<Define, Depend<? extends Define>>();
		
		exprGen = new JavaExpresionGenerator(this);
		funcGen = new JavaFunctionGenerator(this);
	}
	
	@Override	
	protected void initialize(File path,Options options,Configuration cfg)
	{
		packageName = (String) options.get("package");
		packageNameDir = packageName.replace('.', '/');
		isDebug = (Boolean) options.get("debug");
		
		sourceDir = new File(path,"src");
		if(!sourceDir.exists())
		{
			sourceDir.mkdirs();
		}
		binaryDir = new File(path,"build");
		if(!binaryDir.exists())
		{
			binaryDir.mkdirs();
		}
		//creamos la carpeta
		packageDir = new File(sourceDir,packageNameDir);	
		if(!packageDir.exists())
		{
			packageDir.mkdirs();
		}		
		
		cfg.setClassForTemplateLoading(JavaGenerator.class, "/fp4g/templates");
		
		generators.put(GameState.class, GameStateGenerator.class);
		generators.put(Entity.class,    EntityGenerator.class);
		generators.put(Game.class,      GameGenerator.class);
		generators.put(Goal.class,      GoalGenerator.class);
				
	}

	
	@Override
	protected void generateCode(Code gameData, File path) 
	{
		if(!gameData.canBuild())
		{
			return; //nope, no debo contruir este objeto
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
			Log.Show(ErrType.CriticalErrorGeneratorNotFound,gameData);
			throw new RuntimeException("Epa, generador incorrecto");
		}		
	}
	
	@Override
	protected void compileFiles(List<File> files)
	{
		final String path = packageDir.getAbsolutePath();
		final int start = path.length()-packageNameDir.length();
		final String cp = "libs/apollo-fp4g.jar;libs/reflectasm-fp4g.jar;libs/gdx.jar";		
			  
		final String options[] = {
				"-cp",
				cp,
				"-d",				
				binaryDir.getAbsolutePath()								
		};
				
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
			System.out.format("%3d: JavaError %s \n%s\n", diagnostic.getLineNumber(), fileName,diagnostic.getMessage(null));
		}        
	 
	    try {
			fileManager.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	@Override
	public <CodeModel> Expresion function(CodeModel model,	FunctionCall fcall) {		
		return funcGen.generate((JavaCodeModel)model,fcall);
	}

	@Override
	public <CodeModel> String expresion(CodeModel model,Expresion expr) {
		return exprGen.generate((JavaCodeModel) model,expr);
	}
	
	public void addJavaCode(Define define,JavaCodeModel value)	
	{
		parDefineJavaCode.put(define, value);
	}

	
	public void prepareGameData(Game gameConf) 
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
    	MessageMethod press = new MessageMethod(keyMessage);
    	press.setMethodName("press");
    	press.setValueReplace("Input.Keys.%s == key");
    	press.setParams("int key");
    	press.setAttachInputProcessor(true);
    	keyMessage.set("press", new ClassMap(press)); //nombre del metodo
    	
    	MessageMethod release = new MessageMethod(keyMessage);
    	release.setMethodName("release");
    	release.setValueReplace("Input.Keys.%s == key");
    	release.setParams("int key");
    	press.setAttachInputProcessor(true);
    	keyMessage.set("release", new ClassMap(release)); //nombre del metodo
    	
    	//Agregar todos los metodos 
    	MessageMethods methods = new MessageMethods();
    	methods.add(press);
    	methods.add(release);
    	
    	gameConf.set("methods", new CustomClassMap(methods));
    	
    	gameConf.setDefine(keyMessage);     	
    	dependencias.put(keyMessage, new KeyMessageDepend());
    	
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
	@Override
	@SuppressWarnings("unchecked")	
	protected <T extends Define> Depend<T> resolveDependency(Define define) {
		if(define == null)
		{
			return null;
		}
		else
		if(define instanceof Entity)
		{
			//TODO por hacer
			return null;
		}
		else
		{
			return (Depend<T>) dependencias.get(define);
		}		
	}



}
