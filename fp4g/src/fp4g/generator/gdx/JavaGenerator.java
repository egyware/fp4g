package fp4g.generator.gdx;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import fp4g.IO;
import fp4g.Options;
import fp4g.classes.DependResolvers;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.ILine;
import fp4g.data.IValue;
import fp4g.data.Statements;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Goal;
import fp4g.data.define.Message;
import fp4g.data.expresion.CustomClassMap;
import fp4g.data.expresion.FunctionCall;
import fp4g.data.libs.LibContainer;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.exceptions.FP4GException;
import fp4g.exceptions.GeneratorException;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Depend;
import fp4g.generator.Generator;
import fp4g.generator.StatementModel;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.log.Log;
import fp4g.log.info.GeneratorError;
import fp4g.log.info.Warn;
import freemarker.template.Configuration;

public class JavaGenerator extends Generator<JavaMetaSourceModel> 
{	
	public static final String autodoc = "/**\n  * Autogenerado por FP4G\n  * [NO MODIFICAR]\n  */";
	public String packageName = "";
	public String packageNameDir = "";
	public File packageDir;	
	public File binaryDir;
	public File sourceDir;
	public final JavaExpresionGenerator exprGen;
	public final JavaFunctionGenerator funcGen;
	public final JavaStatementBuilder stmntBuilder;
	
	public final Map<Class<? extends Code>,Class<? extends CodeGenerator<JavaMetaSourceModel, JavaGenerator>>> generators;
	
	public DependResolvers resolvers;
	
	public JavaGenerator()
	{
		generators = new HashMap<Class<? extends Code>,Class<? extends CodeGenerator<JavaMetaSourceModel, JavaGenerator>>>(10,1);				
		
		exprGen = new JavaExpresionGenerator(this);
		funcGen = new JavaFunctionGenerator(this);
		stmntBuilder = new JavaStatementBuilder(this);
	}
	
	
	private Pattern pattern = Pattern.compile("(import\\s+(static\\s+)?([a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*)(\\.\\*)?)|(([A-Z][a-zA-Z0-9]*)(\\s[^\n\r])+[a-zA-Z0-9]+)");
	protected Collection<File> getRequiredFiles(File path, File filename)
	{		
		try
		{
			TreeSet<File> list = new TreeSet<File>();			
			FileInputStream fis = new FileInputStream(filename);
			byte data[] = new byte[fis.available()];
			fis.read(data);
			fis.close();
			String string = new String(data);
			Matcher results = pattern.matcher(string);
			while(results.find())
			{
				String clazz = results.group(3);				
				if(clazz != null)
				{
					if(clazz.startsWith("com.apollo.components")||clazz.startsWith(packageName))
					{
						File file = new File(path,clazz.replace('.', File.separatorChar).concat(".java"));
						if(file.exists())
						{
							list.add(file);
						}
					}
				}
				else
				{
					//TODO optimizar: Hace muchas consultas repetitivas...
					clazz = results.group(7);
					File file = new File(packageDir, clazz.concat(".java"));					
					if(file.exists())
					{
						list.add(file);
					}
				}
			}
			return list;			
		}
		catch(IOException e)
		{
			Log.Show(Warn.IOException,e.getMessage());
		}
		return Collections.emptyList();
	}
	
	@Override	
	protected void initialize(File path,Options options,Configuration cfg)
	{
		packageName = (String) options.get("package");
		packageNameDir = packageName.replace('.', '/');
		
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
		
		cfg.setClassForTemplateLoading(JavaGenerator.class, "templates");
		
		generators.put(GameState.class, GameStateGenerator.class);
		generators.put(Entity.class,    EntityGenerator.class);
		generators.put(Game.class,      GameGenerator.class);
		generators.put(Goal.class,      GoalGenerator.class);
		generators.put(Behavior.class,  BehaviorGenerator.class);
		generators.put(Message.class,   MessageGenerator.class);
				
	}

	@Override
	protected void generateCode(ICode gameData, File path) throws GeneratorException 
	{		
		Class<? extends CodeGenerator<JavaMetaSourceModel, JavaGenerator>> codegen = generators.get(gameData.getClass());
		
		if(codegen != null)
		{
			try{
				Constructor<? extends CodeGenerator<JavaMetaSourceModel,JavaGenerator>> constructor = codegen.getConstructor(JavaGenerator.class);
				CodeGenerator<JavaMetaSourceModel,JavaGenerator> generator = constructor.newInstance(this);
				if(gameData.isGenerable()) //se puede contruir?
				{
					generator.generateCode(gameData, packageDir);
				}
				else if(gameData.isUsable()) //si no, utilizamos su codigo :B
				{
					generator.usingCode(gameData, packageDir);
				}
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
			throw new GeneratorException(GeneratorError.CriticalErrorGeneratorNotFound, String.format("El generador para \"%s\" no se encontró",gameData.getClass().getSimpleName()));			
		}		
	}
	
	@Override
	protected void compileFiles(Collection<File> files)
	throws GeneratorException	
	{
		final String path = packageDir.getAbsolutePath();
		final int start = path.length()-packageNameDir.length();
		final String cp[] = {
				"libs/apollo-fp4g.jar",
				"libs/gdx.jar"
			};				
			  
		final String options[] = {
				"-cp",
				implode(cp,File.pathSeparatorChar),
				"-d",				
				binaryDir.getAbsolutePath(),
				"-Xlint:deprecation",
				"-Xlint:unchecked",
		};
			
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		if(javaCompiler == null)
		{
			javaCompiler = findJDK();
			if(javaCompiler == null)
			{	
				throw new GeneratorException(GeneratorError.CompilerNotFound, "Compilador no encontrado");			
			}

		}
		
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
		StandardJavaFileManager fileManager = javaCompiler.getStandardFileManager(diagnostics,null,null);
		Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
		javaCompiler.getTask(null, fileManager, diagnostics, Arrays.asList(options), null, compilationUnits).call();
		
		
		for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
			JavaFileObject source = diagnostic.getSource();
			if(source != null)
			{
				String fileName = source.getName();
				if(fileName.length() > path.length() )
				{
					fileName = fileName.substring(start);
				}
				System.out.format("%3d: JavaError %s \n%s\n", diagnostic.getLineNumber(), fileName,diagnostic.getMessage(null));
			}
			else
			{
				System.out.format("%3d: JavaError %s\n", diagnostic.getLineNumber(), diagnostic.getMessage(null));
			}
		}        
	 
	    try {
			fileManager.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}
		
	}

	private String implode(String[] cp, char d) 
	{
		final StringBuilder builder = new StringBuilder();
		final List<String> list = Arrays.asList(cp);
		for(Iterator<String> it = list.iterator(); it.hasNext();)
		{
			builder.append(it.next());
			if(it.hasNext())
			{
				builder.append(d);
			}
		}				
		return builder.toString();
	}

	private JavaCompiler findJDK() 
	{
		JavaCompiler javaCompiler = null;
		
		String java_home = fp4g.Configuration.getProperty(fp4g.Configuration.JDK_HOME);
		if(java_home != null)
		{
			System.setProperty(fp4g.Configuration.JDK_HOME, java_home);
			//intentamos de nuevo :)
			javaCompiler = ToolProvider.getSystemJavaCompiler();
		}
		
		//aún no hemos encontrado el JDK,sigamos buscando
		if(javaCompiler == null)
		{
			//asumiendo que estamos en windows			
			try 
			{
				String out = run("java.exe","-version");
												
				//TODO expresión regular plz
				final String verToken = "version";
				final int offset = out.indexOf(verToken)+verToken.length()+2;
				final String version = out.substring(offset,out.indexOf('"',offset));
				
				//buscar en windows
				File jdkDir;
				jdkDir = new File(String.format("C:/Program Files/Java/JDK%s",version));
				if(!jdkDir.exists())
				{
					jdkDir = new File(String.format("C:/Program Files (x86)/Java/JDK%s",version));
				}
				
				if(jdkDir.exists())
				{
					System.setProperty("java.home", jdkDir.getCanonicalPath());					
				}
				
				//try again...
				javaCompiler = ToolProvider.getSystemJavaCompiler();
				//solo si podemos encontrarlo, no nos ilusionemos antes
				if(javaCompiler != null && jdkDir.exists())
				{
					fp4g.Configuration.setProperty("java.home",jdkDir.getCanonicalPath());
				}
			}
			catch (IOException e) 
			{				
				e.printStackTrace();
			}
			catch (InterruptedException e) 
			{			
				e.printStackTrace();
			}
		}
		
		
		
		//sigue siendo null
		if(javaCompiler == null)
		{		
			try
			{
				File jdkDir = null;
				String text = run("cmd","/c where javac");
				String split[] = text.split("[\n\r]+");
				for(String s: split)
				{
					jdkDir = new File(s,"../..");
					if(jdkDir.exists())
					{
						System.setProperty("java.home", jdkDir.getCanonicalPath());
						javaCompiler = ToolProvider.getSystemJavaCompiler();
						if(javaCompiler != null)
						{
							//YAY lo encontramos :D
							break;
						}
					}
				}
				//solo si podemos encontrarlo, no nos ilusionemos antes
				if(javaCompiler != null)
				{
					fp4g.Configuration.setProperty("java.home",jdkDir.getCanonicalPath());
				}
			}
			catch (IOException e)
			{			
				e.printStackTrace();
			}
			catch (InterruptedException e) 
			{			
				e.printStackTrace();
			}
		}
		
		
		return javaCompiler;
	}

	private String run(String ...args) throws InterruptedException, IOException 
	{
		ProcessBuilder ps = new ProcessBuilder(args);
		ps.redirectErrorStream(true);
		
		Process java_version = ps.start();
		
		java_version.waitFor();
		
		String text = "";
		Scanner scan = null;
		try
		{
			scan = new Scanner(java_version.getInputStream());		
			while(scan.hasNextLine())
			{
				text += scan.nextLine();
			}
		}		
		finally
		{
			if(scan != null)scan.close();
		}
		return text;
	}

	@Override
	public Expresion function(JavaMetaSourceModel model, FunctionCall fcall) throws CannotEvalException
	{		
		return funcGen.generate(model,fcall);
	}

	@Override
	public String expresion(JavaMetaSourceModel model,Expresion expr) throws CannotEvalException
	{
		return exprGen.generate(model,expr);
	}
	public <CodeModel> String expresion(CodeModel model,IValue<?> expr) throws CannotEvalException
	{
		return exprGen.generate((JavaMetaSourceModel) model,expr);
	}
	
	public void setDefaults(Game gameConf)
	{
		gameConf.name = "GameApp";
    	gameConf.width = 640;
    	gameConf.height = 480;
    	gameConf.debug = false;
	}
	
	public LibContainer loadLibs() 
	{
		loadLib("libs/fp4g.lib");
		loadLib("libs/fp4g.messages.lib");
    	
    	//TODO Posible error.
    	CustomClassMap map = (CustomClassMap)libContainer.get("resolvers");
    	resolvers = (DependResolvers)map.getValue();

    	  //agregar componentes		    	
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
    	return libContainer;
	}
	
	@Override	
	public Depend resolveDependency(Define define) throws DependResolverNotFoundException 
	{
		if(define == null)
		{
			throw new DependResolverNotFoundException("El define es null");
		}
		else		
		{
			return resolvers.getResolver(define);
		}		
	}

	@Override
	protected void copyFiles(Collection<File> files) 
	{
		try 
		{
			final String src = sourceDir.getCanonicalPath();
		 
			for(File file:files)
			{
				String relativePath = file.getCanonicalPath().substring(src.length()+1);
				IO.copy(file, new File(binaryDir,relativePath));
			}			
		} 
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
	}

	//TODO por mientras lo vamos a llamar así...
	@Override	
	public List<StatementModel> generateStatements(JavaMetaSourceModel model, ILine container, Statements statements) throws FP4GException 
	{
		return stmntBuilder.generateStatements(model,container, statements);
	}	

}
