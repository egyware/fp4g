package fp4g.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.Pair;
import fp4g.data.Add;
import fp4g.data.Behavior;
import fp4g.data.Code;
import fp4g.data.Expresion;
import fp4g.data.define.Entity;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.VarId;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class EntityGenerator extends Generator {

	private static File entityPackageDir;

	@Override
	protected void generateData(Map<String,Object> options,Configuration cfg, Code gameData, File path) 
	throws IOException, TemplateException
	{
		Entity entity = (Entity)gameData;		
		Template temp = cfg.getTemplate("EntityBuilder.ftl");	
		
		HashMap<String,Object> root = new HashMap<>();
		HashMap<String,Object> clazz = new HashMap<>();
		clazz.put("package", String.format("%s.%s",packageName,"entity"));
		clazz.put("name",entity.name);
		root.put("class",clazz);
		root.put("autodoc", autodoc);
		
		//agregar parametros de entrada
		if(entity.list != null)
		{
			//lo veo un poco consumidor de recursos, pero bueno...
			List<Map<String,Object>> pair = new LinkedList<>();
			for(Pair<String,String> par: entity.list)
			{
				Map<String,Object> el = new HashMap<String,Object>(2);
				el.put("name", par.a);
				el.put("type", par.b);
				pair.add(el);
			}
			root.put("params",pair);
		}
		
		//agregar behaviors
				
		List<HashMap<String,Object>> behaviors = new LinkedList<>(); 
		for(Add addBhvr:entity.addBehaviors)
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
				varName.append(addBhvr.name.toLowerCase().charAt(0));
				varName.append(addBhvr.name.substring(1));
				bhvr.put("varName", varName.toString());
			}			
			if(addBhvr.params != null)
			{	
				List<String> params = new LinkedList<>();
				for(Expresion expr: addBhvr.params)
				{					
					if(expr instanceof VarId)
					{					
						params.add(((VarId) expr).varName);
					}
					if(expr instanceof Literal)
					{					
						params.add(((Literal) expr).value.toString());
					}
				}
				bhvr.put("params",params);				
			}			
			behaviors.add(bhvr);
		}
		
		root.put("behaviors", behaviors);
		//agregar imports!		
		List<String> imports = new LinkedList<>();
		String arrayImports[] = new String[]
		{
			"com.apollo.EntityBuilder",
			"com.apollo.Entity",
			"com.apollo.World"
		};
		Arrays.sort(arrayImports);
		Collections.addAll(imports, arrayImports);
		
		for(Add addBhvr:entity.addBehaviors)
		{
			imports.add(String.format("com.apollo.components.%s",addBhvr.name));
		}
		clazz.put("imports", imports);		
		
		if(entityPackageDir == null)
		{
			entityPackageDir = new File(packageDir, "entity");
			if(!entityPackageDir.exists())
			{
				entityPackageDir.mkdir();
			}
		}
		Writer out = new FileWriter(new File(entityPackageDir,String.format("%sBuilder.java",entity.name)));
		temp.process(root, out);  
		System.out.println(String.format("Generado: %s/entity/%sBuilder.java",packageNameDir, entity.name));
		
	}

}
