package fp4g.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static fp4g.Log.Show;
import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Pair;
import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.On;
import fp4g.data.On.Filter;
import fp4g.data.On.Source;
import fp4g.data.define.Entity;
import fp4g.data.expresion.ArrayExpr;
import fp4g.data.expresion.Literal;
import fp4g.generator.models.JavaCodeModel;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EntityGenerator extends Generator {

	private static File entityPackageDir;

	@Override
	@SuppressWarnings("unchecked")
	protected void generateData(Map<String,Object> options,Configuration cfg, Code gameData, File path) 
	throws IOException
	{
		Entity entity = (Entity)gameData;		
		Template entityBuilderTempl = cfg.getTemplate("EntityBuilder.ftl");
		Template entityTempl        = cfg.getTemplate("Entity.ftl");
		
		HashMap<String,Object> buildRoot = new HashMap<>();	
		HashMap<String,Object> entityRoot = new HashMap<>();
		
		JavaCodeModel modelBuild = new JavaCodeModel();
		modelBuild.pckg = String.format("%s.%s",packageName,"entity");
		modelBuild.name = String.format("%sBuilder",entity.name);;
		modelBuild.javadoc = autodoc;
		
		JavaCodeModel modelEntity = new JavaCodeModel();
		modelEntity.pckg = String.format("%s.%s",packageName,"entity");
		modelEntity.name = entity.name;
		modelEntity.javadoc = autodoc;
		
		buildRoot.put("class",modelBuild);
		buildRoot.put("entity", modelEntity);
		entityRoot.put("class", modelEntity);				
		
				
		//agregar parametros de entrada
		if(entity.paramNameList != null)
		{
			//lo veo un poco consumidor de recursos, pero bueno...
			List<Map<String,Object>> pair = new LinkedList<>();
			for(Pair<String,String> par: entity.paramNameList)
			{
				Map<String,Object> el = new HashMap<String,Object>(2);
				el.put("name", par.a);
				el.put("type", par.b);
				pair.add(el);
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
				varName.append(uncap_first(addBhvr.name));				
				bhvr.put("varName", varName.toString());
			}			
			if(addBhvr.params != null)
			{	
				List<String> params = new LinkedList<>();
				for(Expresion expr: addBhvr.params)
				{
					String result = ExpresionGenerator.generate(modelBuild,expr);
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
		if(entity_onMessages.size()>0)
		{
			List<HashMap<String,Object>> messages = new LinkedList<>();
			for(On on:entity_onMessages)
			{
				HashMap<String,Object> message = new HashMap<>();
				LinkedList<HashMap<String,Object>> sources = new LinkedList<>();				
				message.put("name", on.name);
				message.put("sources", sources);				 
				for(Source source:on.sources)
				{
					HashMap<String,Object> map = new HashMap<>();
					if(source.filters.size()> 0)
					{
						StringBuilder filterString = new StringBuilder();					
						for(Iterator<Filter> iterator = source.filters.iterator();iterator.hasNext();)
						{
							Filter filter = iterator.next();
							final int size = filter.data.length;
							filterString.append("(");
							for(int i=0;i<size;i++)
							{
								//talvez no sea la mejor manera de extraer los datos
								ArrayExpr array = (ArrayExpr)filter.data[i];
								//TODO asegurarse que sea unn string literal								
								Literal<String> fieldName  = (Literal<String>)array.get("field");
								Literal<String> compareName= (Literal<String>)array.get("compare");
								Literal<String> valueName  = (Literal<String>)array.get("value");
																
								filterString.append("message.");
								filterString.append(fieldName.value);
								
								ExpresionGenerator.CompareExpresion compare = ExpresionGenerator.CompareExpresion.valueOf(compareName.value);
								if(compare != null)									
								{
									filterString.append(' ');
									filterString.append(compare.operator);
									filterString.append(' ');
								}
								else
								{	
									//TODO mejorar el metodo para encontrar el operator
									if(on.message != null)
									{
										Log.Show(ErrType.UnknowError,on.message);
									}
									Log.Show(ErrType.UnknowError,"Error, se debia encontrar un operator valido");
									filterString.append(" == ");								
								}
								
								filterString.append(valueName.value);
								
								if(i+1 < size)
								{
									filterString.append(" && ");
								}
								
							}
							if(iterator.hasNext())
							{
								filterString.append(") || ");
							}
							else
							{
								filterString.append(")");
							}
						}
						//agregar filtros...
						map.put("filter", filterString.toString());
					}
					//TODO agregar codigo
					map.put("code","//TODO codigo...");					
					
					sources.add(map);					
				}							
				messages.add(message);
			}
			entityRoot.put("messages",messages);
		}
		
		//agregar imports!
		{
			String arrayImports[] = new String[]
					{
						"com.apollo.EntityBuilder",
						"com.apollo.Entity",			
						"com.apollo.World",
						String.format("%s.Utils", packageName)						
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
			//imports para el builder
			List<String> imports = new LinkedList<>();
			Collections.addAll(imports, arrayImports);		
			for(Add addBhvr:entity_addBehaviors)
			{
				imports.add(String.format("com.apollo.components.%s",addBhvr.name));
			}
			if(entity_onMessages.size()>0)
			{
				imports.add("com.apollo.messages.MessageReceiver");
				for(On on:entity_onMessages)
				{
					imports.add(String.format("com.apollo.messages.%sMessage",on.name));
				}
			}
			Collections.sort(imports);
			modelEntity.imports.addAll(imports);
		}
		
		if(entityPackageDir == null)
		{
			entityPackageDir = new File(packageDir, "entity");
			if(!entityPackageDir.exists())
			{
				entityPackageDir.mkdir();
			}
		}
		Generator.createFile(String.format("entity/%sBuilder.java",entity.name),entityBuilderTempl,buildRoot);
		Generator.createFile(String.format("entity/%s.java",entity.name),entityTempl,entityRoot);		
	}

}
