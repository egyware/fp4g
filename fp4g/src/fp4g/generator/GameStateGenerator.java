package fp4g.generator;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class GameStateGenerator extends Generator {

	@Override
	protected void generateData(Map<String,Object> options,Configuration cfg, Code gameData, File path)
	throws IOException, TemplateException {
		GameState state = (GameState)gameData;
		Game game = (Game)state.parent;
		
		Template temp = cfg.getTemplate("GameState.ftl"); 
		List<String> imports = new LinkedList<>();
		HashMap<String,Object> root = new HashMap<>();		
		HashMap<String,Object> clazz = new HashMap<>();
		HashMap<String,Object> gamez = new HashMap<>();
		clazz.put("package", packageName);
		clazz.put("name",state.name);		
		gamez.put("width", game.width);
		gamez.put("height", game.height);
		gamez.put("name", game.name);
		root.put("class",clazz);
		root.put("game", gamez);
		root.put("autodoc", autodoc);
		root.put("debug", isDebug);
		
		List<Map<String, Object>> managers = new LinkedList<>();
		for(Add manager:state.getAdd(DefineType.MANAGER))
		{
			Map<String,Object> mngr = new HashMap<>(2);
			mngr.put("name", manager.name);
			if(manager.varName != null)
			{
				mngr.put("varName", manager.varName);
			}
			else
			{								
				mngr.put("varName", uncap_first(manager.name));
			}
			if(manager.params != null)
			{
				throw new RuntimeException("No implementado");
			}
			managers.add(mngr);
		}
		root.put("managers", managers);
		
		//agregamos todos las entidades definidas en el game
		List<String> entityBuilders = new LinkedList<>();
		final Collection<Entity> state_entities = game.getDefines(DefineType.ENTITY);
		for(Entity entity:state_entities)
		{
			entityBuilders.add(entity.name);
			//agregar imports
			imports.add(String.format("%s.entity.%sBuilder",packageName,entity.name));
			
		}
		root.put("entityBuilders", entityBuilders);
		
		List<Map<String, Object>> entities = new LinkedList<>();
		final List<Add> state_addentities = state.getAdd(DefineType.ENTITY);
		for(Add entity:state_addentities)
		{
			Map<String,Object> mngr = new HashMap<>(2);
			mngr.put("name", entity.name);
			if(entity.varName != null)
			{
				mngr.put("varName", entity.varName);
			}			
			if(entity.params != null)
			{
				throw new RuntimeException("No implementado");
			}
			entities.add(mngr);
		}
		root.put("entities", entities);
		
		String arrayImports[] = new String[]
		{
				"com.apollo.World",
				"com.apollo.managers.GameManager",
				"com.apollo.managers.GameState",
				"com.badlogic.gdx.Gdx",
				"com.badlogic.gdx.graphics.GL10",
				"com.badlogic.gdx.graphics.OrthographicCamera"
		};
		Arrays.sort(arrayImports);
		Collections.addAll(imports, arrayImports);
		if(state_addentities.size() > 0)
		{
			imports.add("com.apollo.Entity");
		}
		Collections.sort(imports);
		clazz.put("imports", imports);		
		
		Generator.createFile(String.format("%s.java",state.name), temp, root);
	}
}
