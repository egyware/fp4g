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

import fp4g.data.Code;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GameGenerator extends Generator {

	@Override
	protected void generateData(Map<String,Object> options,Configuration cfg,Code gameData, File path) throws IOException, TemplateException {
		Game game = (Game)gameData;
		
		Template temp = cfg.getTemplate("GameManager.ftl"); 	
		
		HashMap<String,Object> root = new HashMap<>();
		HashMap<String,Object> clazz = new HashMap<>();
		clazz.put("package", packageName);
		clazz.put("name",game.name);
		root.put("class",clazz);
		root.put("autodoc", autodoc);
		root.put("width", game.width);
		root.put("height", game.height);
		//agregar imports!
		
		{
			List<String> imports = new LinkedList<>();
			String arrayImports[] = new String[]
			{
					"com.apollo.managers.GameManager",					
			};
			//Arrays.sort(arrayImports);
			Collections.addAll(imports, arrayImports);
			clazz.put("imports", imports);
		}
		
		// TODO falta ${start_state}
		
		Generator.createFile(String.format("%s.java",game.name), temp,root);
		
		//generar Assets...
		{
			List<String> imports = new LinkedList<>();
			String arrayImports[] = new String[]
			{				
				"com.apollo.managers.graphics.Sprite",
				"com.apollo.managers.graphics.SpriteLoader",
				"com.badlogic.gdx.assets.AssetManager",
				"com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver",
			};
			Arrays.sort(arrayImports);
			Collections.addAll(imports, arrayImports);
			HashMap<String,Object> assetsRoot = new HashMap<>();
			HashMap<String,Object> assetsClazz = new HashMap<>();
			assetsClazz.put("package", packageName);
			assetsClazz.put("imports", imports);
			assetsRoot.put("class",assetsClazz);
			assetsRoot.put("autodoc", autodoc);			
			
			Generator.createFile("Assets.java",cfg.getTemplate("Assets.ftl"), assetsRoot);
		}
		
		
		for(Entity entity: game.entities)
		{
			Generator.generate(options, entity, path);
		}
		for(GameState state: game.states)
		{
			Generator.generate(options, state, path);
		}		
	}

}
