package fp4g.generator.gdx;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.AddDefine;
import fp4g.data.DeclVar;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.On;
import fp4g.data.define.Entity;
import fp4g.exceptions.FP4GException;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Depend;
import fp4g.generator.Generator;
import fp4g.generator.gdx.models.EntityBuilderModel;
import fp4g.generator.gdx.models.EntityModel;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.OnModel;
import fp4g.generator.gdx.models.VarCodeModel;
import fp4g.generator.gdx.models.On.MethodHandlerModel;
import fp4g.log.info.Error;
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
		final Entity entity = (Entity)gameData;
		final JavaParamListBuilder paramBuilder = new JavaParamListBuilder(generator);
		final Template entityBuilderTempl = generator.getTemplate("EntityBuilder.ftl");
		final Template entityTempl        = generator.getTemplate("Entity.ftl");		
		
		final String entityPackage = String.format("%s.%s",generator.packageName,"entity");
		
		EntityModel entityModel = new EntityModel(entityPackage, entity.name);
		EntityBuilderModel buildModel = new EntityBuilderModel(entityPackage, String.format("%sBuilder",entity.name));
		
		JavaMetaSourceModel entityMeta  = entityModel.getMetaSource();
		JavaMetaSourceModel  buildMeta  = buildModel.getMetaSource();
		
		entityMeta.setJavadoc(JavaGenerator.autodoc);
		 buildMeta.setJavadoc(JavaGenerator.autodoc);
		 
		buildModel.setEntity(entityModel);
			
		
		List<On> entityBuild_onMessages = new LinkedList<On>();
				
		//agregar parametros de entrada
		if(entity.paramNameList != null)
		{
			List<VarCodeModel> pair = paramBuilder.build(entity.paramNameList, entity, buildMeta);			
			buildModel.setParams(pair);
		}
		
		//agregar behaviors
				
		List<HashMap<String,Object>> behaviors = new LinkedList<HashMap<String, Object>>();
		final Collection<AddDefine> entity_addBehaviors = entity.getAddDefines(DefineType.BEHAVIOR);
		for(AddDefine addBhvr:entity_addBehaviors)
		{
			HashMap<String,Object> bhvr = new HashMap<String, Object>();			
			bhvr.put("name", addBhvr.name);			
			
			//a�n usar� el varName
			StringBuilder varName = new StringBuilder();				
			varName.append(Generator.uncap_first(addBhvr.name));				
			bhvr.put("varName", varName.toString());
						
			if(addBhvr.params != null)
			{	
				List<String> params = new LinkedList<String>();
				for(Expresion expr: addBhvr.params)
				{
					params.add(generator.expresion(buildMeta,expr));
				}
				bhvr.put("params",params);				
			}			
			behaviors.add(bhvr);
		}
		
		buildModel.setBehaviors(behaviors);
		entityModel.setBehaviors(behaviors);
		
		//agregar eventos
		final Collection<On> entity_onMessages = entity.getOnMessages();
		if(entity_onMessages.size() > 0)
		{	
			//Obvio el code
			List<OnModel> onList = new LinkedList<OnModel>();			
			for(On on: entity_onMessages)
			{
				if(on.message == null)
				{
					throw new FP4GException(Error.MessageNotFound,String.format("No se encontr� el mensaje %s para la instrucci�n ON", on.name));
					//gracias a esta excepci�n aseguro que siempre on.message != null
				}
				
				//evitamos que los on_entity se pasen a la build entity.
				if(on.message.isFactory())
				{
					entityBuild_onMessages.add(on);
					continue;
				}
				
				OnModel onModel = OnModel.build(on, entity, generator, entityMeta);
				
				onList.add(onModel);
			}
			entityModel.setMessages(onList);
			
			//de aqui empiezan los mensajes para la factory
			List<OnModel> onListBuild = new LinkedList<OnModel>();			
			for(On on: entityBuild_onMessages)
			{
				OnModel onModel = OnModel.build(on, entity, generator, buildMeta);						
				
				onListBuild.add(onModel);
			}
			buildModel.setMessages(onListBuild);
			
			//revisar si tiene attachments, basta con uno..
			boolean hasAttachments = false;
			for(OnModel onModel:onList)
			{			
				for(MethodHandlerModel m: onModel.getMethodHandlers())
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
				entityMeta.addRequireSource("com.apollo.ApolloInputProcessor");
				entityModel.setHasAttachments(true);
			}						
		}
		
		if(entity.flags != null)
		{
			LinkedList<VarCodeModel> flags = new LinkedList<VarCodeModel>();
			for(DeclVar var:entity.flags)
			{
				if(var.initValue != null)
				{
					flags.add(new VarCodeModel(paramBuilder.translateType(var.type, entityMeta, entity),var.name,generator.expresion(entityMeta, var.initValue)));
				}
				else
				{
					flags.add(new VarCodeModel(paramBuilder.translateType(var.type, entityMeta, entity),var.name,null));
				}
			}
			entityModel.setFlags(flags);
		}
		
		
		//agregar imports!
		Depend dr = generator.resolveDependency(entity);
		dr.perform(entity, buildMeta);
		dr.perform(entity, entityMeta);
		
		if(entity_onMessages.size()>0)
		{	
			for(On on:entity_onMessages)
			{					
				Depend depende = generator.resolveDependency(on.message);
				if(depende != null)
				{
					depende.perform(on.message, entityMeta);
				}
			}				
		}		
		
		if(entityBuild_onMessages.size()>0)
		{	
			for(On on:entityBuild_onMessages)
			{					
				Depend depende = generator.resolveDependency(on.message);
				if(depende != null)
				{
					depende.perform(on.message, buildMeta);
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
		
		generator.createFile(generator.packageDir,String.format("entity/%sBuilder.java",entity.name),entityBuilderTempl,buildModel);
		generator.createFile(generator.packageDir,String.format("entity/%s.java",entity.name),entityTempl,entityModel);		
	}

	@Override
	public void usingCode(ICode gameData, File path) 
	{
		Entity entity = (Entity)gameData;
		
		generator.usingFile(generator.packageDir,String.format("entity/%sBuilder.java",entity.name));
		generator.usingFile(generator.packageDir,String.format("entity/%s.java",entity.name));	
		
		
	}

}
