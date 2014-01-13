package fp4g.generator.gdx;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Add;
import fp4g.data.DeclVar;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.On;
import fp4g.data.define.Entity;
import fp4g.data.vartypes.BasicType;
import fp4g.data.vartypes.CustomType;
import fp4g.exceptions.UnknowException;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Depend;
import fp4g.generator.Generator;
import fp4g.generator.gdx.models.JavaCodeModel;
import fp4g.generator.gdx.models.OnModel;
import fp4g.generator.gdx.models.OnModel.MethodHandlerModel;
import fp4g.generator.gdx.models.ParamCodeModel;
import freemarker.template.Template;

public class EntityGenerator extends CodeGenerator<JavaGenerator> {

	public EntityGenerator(JavaGenerator generator) {
		super(generator);
	}

	private static File entityPackageDir;

	@Override	
	public void generateCode(ICode gameData, File path) 	 
	throws Exception
	{
		Entity entity = (Entity)gameData;		
		Template entityBuilderTempl = generator.getTemplate("EntityBuilder.ftl");
		Template entityTempl        = generator.getTemplate("Entity.ftl");
		
		HashMap<String,Object> buildRoot = new HashMap<String, Object>();	
		HashMap<String,Object> entityRoot = new HashMap<String, Object>();
		
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
			List<ParamCodeModel> pair = new LinkedList<ParamCodeModel>();
			for(DeclVar par: entity.paramNameList)
			{
				//TODO esto debe ir en otro lugar.
				String name;
				if(par.type instanceof BasicType)
				{
					switch((BasicType)par.type)
					{
					case Bool:
						name = "Boolean";
						break;
					case Entity:
						name = "Entity";
						break;
					case Number:
						name = "Number";
						break;
					case String:
						name = "Name";
						break;
					default:
						throw new UnknowException("Estado no valido del generador");
					}
				}
				else
				{
					CustomType custom = (CustomType)par.type;
					Define define = entity.getDefine(custom.name);
					generator.resolveDependency(define).perform(define, modelEntity);
					name = custom.name;
				}
				ParamCodeModel param;
				if(par.initValue != null)
				{
					param = new ParamCodeModel(name, par.name,generator.expresion(modelBuild, par.initValue));
				}
				else
				{
					param = new ParamCodeModel(name,par.name);
				}								
				pair.add(param);
			}
			buildRoot.put("params",pair);
		}
		
		//agregar behaviors
				
		List<HashMap<String,Object>> behaviors = new LinkedList<HashMap<String, Object>>();
		final Collection<Add> entity_addBehaviors = entity.getAdd(DefineType.BEHAVIOR);
		for(Add addBhvr:entity_addBehaviors)
		{
			HashMap<String,Object> bhvr = new HashMap<String, Object>();			
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
				List<String> params = new LinkedList<String>();
				for(Expresion expr: addBhvr.params)
				{
					String result = generator.expresion(modelBuild,expr);
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
			//TODO esta clase tiene demasiada responsabilidad con respecto a lo que debe hacer.
			//TODO Se está volviendo un caos agregar o quitar codigo de esta misma.
			//por cada on! que es lo que necesitaré
			//La categoria del mensaje Key,Contact,Life, etc..
			//Obvio el code
			List<OnModel> onList = new LinkedList<OnModel>();
			for(On on: entity_onMessages)
			{
				onList.add(new OnModel(on,generator,modelEntity));
			}
			entityRoot.put("messages", onList);
			
			//revisar si tiene attachments, basta con uno..
			boolean hasAttachments = false;
			for(OnModel onModel:onList)
			{
				for(MethodHandlerModel m:onModel.getMethodHandlers())
				{
					if(m.isAttach())
					{
						hasAttachments = true;
						break;
					}					
				}
				if(hasAttachments)
				{					
					break;
				}
			}	
			if(hasAttachments)
			{	
				modelEntity.addImport("com.apollo.ApolloInputProcessor");
				entityRoot.put("hasAttachments", true);
			}
			else
			{
				entityRoot.put("hasAttachments", false);
			}			
		}
		
		//agregar imports!
		Depend dr = generator.resolveDependency(entity);
		dr.perform(entity, modelBuild);
		dr.perform(entity, modelEntity);
		
		//TODO no todo es perfecto en la vida, no todo sale como lo planeo. Espero que esto no se aplique al generador.
		modelBuild.addImport(String.format("%s.Utils",generator.packageName));
		
		if(entity_onMessages.size()>0)
		{	
			for(On on:entity_onMessages)
			{					
				Depend depende = generator.resolveDependency(on.message);
				if(depende != null)
				{
					depende.perform(on.message, modelEntity);
				}
			}				
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

	@Override
	public void usingCode(ICode gameData, File path) 
	{
		Entity entity = (Entity)gameData;
		
		generator.usingFile(generator.packageDir,String.format("entity/%sBuilder.java",entity.name));
		generator.usingFile(generator.packageDir,String.format("entity/%s.java",entity.name));	
		
		
	}

}
