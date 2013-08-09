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
import fp4g.data.Add;
import fp4g.data.Behavior;
import fp4g.data.Code;
import fp4g.data.IGameData;
import fp4g.data.define.Entity;
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
		
		//agregar behaviors
				
		List<String> behaviors = new LinkedList<>(); 
		for(Add addBhvr:entity.addBehaviors)
		{
			//TODO falta usar variable
			//TODO falta usar parametros
			behaviors.add(addBhvr.name);
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
//		if(entity instanceof Entity.Define)
//		{
//			Entity.Define define = (Entity.Define)entity;
//			for(Behavior bhvr:define.behaviors)
//			{
//				imports.add(String.format("com.apollo.components.%s",bhvr.name));
//			}			
//		}
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
