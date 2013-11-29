package fp4g.generator.gdxgenerator;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Pair;
import fp4g.classes.MessageMethod;
import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;
import fp4g.data.define.Entity;
import fp4g.data.expresion.ArrayMap;
import fp4g.data.expresion.Literal;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Generator;
import fp4g.generator.models.Depend;
import fp4g.generator.models.JavaCodeModel;
import fp4g.generator.models.OnModel;
import fp4g.generator.models.ParamCodeModel;
import freemarker.template.Template;

public class EntityGenerator extends CodeGenerator<JavaGenerator> {

	public EntityGenerator(JavaGenerator generator) {
		super(generator);
	}

	private static File entityPackageDir;

	@Override
	@SuppressWarnings("unchecked")	
	public void generateCode(Code gameData, File path) 	 
	throws Exception
	{
		Entity entity = (Entity)gameData;		
		Template entityBuilderTempl = generator.getTemplate("EntityBuilder.ftl");
		Template entityTempl        = generator.getTemplate("Entity.ftl");
		
		HashMap<String,Object> buildRoot = new HashMap<>();	
		HashMap<String,Object> entityRoot = new HashMap<>();
		
		JavaCodeModel modelBuild = new JavaCodeModel();
		modelBuild.pckg = String.format("%s.%s",generator.packageName,"entity");
		modelBuild.name = String.format("%sBuilder",entity.name);;
		modelBuild.javadoc = JavaGenerator.autodoc;
		
		JavaCodeModel modelEntity = new JavaCodeModel();
		modelEntity.pckg = String.format("%s.%s",generator.packageName,"entity");
		modelEntity.name = entity.name;
		modelEntity.javadoc = JavaGenerator.autodoc;
		
		buildRoot.put("class",modelBuild);
		buildRoot.put("entity", modelEntity);
		entityRoot.put("class", modelEntity);				
				
		//agregar parametros de entrada
		if(entity.paramNameList != null)
		{
			//lo veo un poco consumidor de recursos, pero bueno...
			List<ParamCodeModel> pair = new LinkedList<>();
			for(Pair<String,String> par: entity.paramNameList)
			{
				//TODO más adelante, talvez especificar el tipo por defecto.
				ParamCodeModel param = new ParamCodeModel(par.a,par.b);				
				pair.add(param);
			}
			buildRoot.put("params",pair);
		}
		
		//agregar behaviors
				
		List<HashMap<String,Object>> behaviors = new LinkedList<>();
		final Collection<Add> entity_addBehaviors = entity.getAdd(DefineType.BEHAVIOR);
		for(Add addBhvr:entity_addBehaviors)
		{
			HashMap<String,Object> bhvr = new HashMap<>();			
			bhvr.put("name", addBhvr.name);			
			if(addBhvr.varName != null)
			{
				bhvr.put("varName", addBhvr.varName);
			}
			else
			{
				StringBuilder varName = new StringBuilder();				
				varName.append(Generator.uncap_first(addBhvr.name));				
				bhvr.put("varName", varName.toString());
			}			
			if(addBhvr.params != null)
			{	
				List<String> params = new LinkedList<>();
				for(Expresion expr: addBhvr.params)
				{
					String result = generator.expresion(addBhvr,modelBuild,expr);
					if(result != null)
					{
						params.add(result);
					}
					//TODO: probablemente mostrar un error...
				}
				bhvr.put("params",params);				
			}			
			behaviors.add(bhvr);
		}
		
		buildRoot.put("behaviors", behaviors);
		entityRoot.put("behaviors", behaviors);
		
		//agregar eventos
		final Collection<On> entity_onMessages = entity.getOnMessages();
		if(entity_onMessages.size() > 0)
		{
			//por cada on! que es lo que necesitaré
			//La categoria del mensaje Key,Contact,Life, etc..
			//Obvio el code
			List<OnModel> onList = new LinkedList<>();
			for(On on: entity_onMessages)
			{
				onList.add(new OnModel(on));
			}
			entityRoot.put("messages", onList);
		}
		
		//agregar imports!
		{
			String arrayImports[] = new String[]
					{
						"com.apollo.EntityBuilder",
						"com.apollo.Entity",			
						"com.apollo.World",
						String.format("%s.Utils", generator.packageName)						
					};
			//imports para el builder
			List<String> imports = new LinkedList<>();
			Collections.addAll(imports, arrayImports);		
			for(Add addBhvr:entity_addBehaviors)
			{
				imports.add(String.format("com.apollo.components.%s",addBhvr.name));
			}
			Collections.sort(imports);
			modelBuild.imports.addAll(imports);			
		}
		
		{
			String arrayImports[] = new String[]
			{
					"com.apollo.Entity",			
					"com.apollo.World",
					"com.apollo.Behavior",
					"com.apollo.utils.Bag",
					"java.util.HashMap",
					"java.util.Map"
			};
			//TODO deberia haber una clase que haga todo esto junto. Y que la relación no sea a un objeto. Si no a la clase.
			//imports para el builder
			List<String> imports = new LinkedList<>();
			Collections.addAll(imports, arrayImports);		
			for(Add addBhvr:entity_addBehaviors)
			{
				imports.add(String.format("com.apollo.components.%s",addBhvr.name));
			}
			if(entity_onMessages.size()>0)
			{				
				imports.add("com.apollo.MessageReceiver");
				for(On on:entity_onMessages)
				{					
					Depend<Define> depende = generator.resolveDependency(on.message);
					if(depende != null)
					{
						depende.perform(on.message,entityRoot, modelEntity);
					}
				}
			}
			Collections.sort(imports);
			modelEntity.imports.addAll(imports);
		}
		
		if(entityPackageDir == null)
		{
			entityPackageDir = new File(generator.packageDir, "entity");
			if(!entityPackageDir.exists())
			{
				entityPackageDir.mkdir();
			}
		}
		generator.addJavaCode(entity, modelBuild);
		generator.createFile(generator.packageDir,String.format("entity/%sBuilder.java",entity.name),entityBuilderTempl,buildRoot);
		generator.createFile(generator.packageDir,String.format("entity/%s.java",entity.name),entityTempl,entityRoot);		
	}

}
