package fp4g.generator.gdxgenerator;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Generator;
import fp4g.generator.models.AssetModel;
import fp4g.generator.models.Depend;
import fp4g.generator.models.JavaCodeModel;
import freemarker.template.Template;

public class GameStateGenerator extends CodeGenerator<JavaGenerator> {	
	
	private static HashMap<String,Map<String,Object>> mngrData;
	static
	{
		mngrData = new HashMap<>();
		
		HashMap<String,Object> entityMngrData = new HashMap<>();
		entityMngrData.put("setMethod", "EntityManager");
		
		HashMap<String,Object> renderMngrData = new HashMap<>();		
		
		renderMngrData.put("preupdate",Arrays.asList("batch.setProjectionMatrix(camera.combined)","batch.begin()"));
		renderMngrData.put("postupdate",Arrays.asList("batch.end()"));		
		renderMngrData.put("fields", Arrays.asList("OrthographicCamera camera","SpriteBatch batch"));
		renderMngrData.put("imports",Arrays.asList("com.badlogic.gdx.graphics.g2d.SpriteBatch"));
				
		mngrData.put("EntityManager", entityMngrData);
		mngrData.put("GdxRenderManager", renderMngrData);
	}
	
	public GameStateGenerator(JavaGenerator generator) 
	{
		super(generator);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void generateCode(Code gameData, File path) 
	throws Exception {
		GameState state = (GameState)gameData;
		Game game = (Game)state.parent;
		
		Template temp = generator.getTemplate("GameState.ftl"); 
		HashMap<String,Object> root = new HashMap<>();	
		
		HashMap<String,Object> gamez = new HashMap<>();
		TreeSet<AssetModel>  assets = new TreeSet<>();
		JavaCodeModel modelClass = new JavaCodeModel();
		modelClass.pckg    = generator.packageName;
		modelClass.name    = state.name;
		modelClass.javadoc = JavaGenerator.autodoc;
			
		gamez.put("width",  game.width);
		gamez.put("height", game.height);
		gamez.put("name", game.name);
		root.put("class",modelClass);
		root.put("game", gamez);
		root.put("debug", generator.isDebug);
		root.put("assets", assets);
		
		List<Map<String, Object>> managers = new LinkedList<>();
		for(Add manager:state.getAdd(DefineType.MANAGER))
		{
			Map<String,Object> mngr = new HashMap<>(2);
			mngr.put("name", manager.name);
			//ac�, buscar las cosas extras y a�adirselas.
			Map<String,Object> extras = mngrData.get(manager.name);
			if(extras != null)
			{
				mngr.putAll(extras);
				
				//si existe alg�n dato adicional a importar,se lo a�adimos a los imports
				List<String> imports = (List<String>) extras.get("imports");
				if(imports != null)
				{
					modelClass.imports.addAll(imports);
				}
				
			}
			
			if(manager.varName != null)
			{
				mngr.put("varName", manager.varName);
			}
			else
			{								
				mngr.put("varName", Generator.uncap_first(manager.name));
			}
			if(manager.params != null)
			{
				List<String> params = new LinkedList<>();
				for(Expresion expr: manager.params)
				{
					String result = generator.expresion(manager,modelClass,expr);
					if(result != null)
					{
						params.add(result);
					}
					//TODO: probablemente mostrar un error...
				}
				mngr.put("params",params);
			}
			managers.add(mngr);
			//import
			modelClass.imports.add(String.format("com.apollo.managers.%s", manager.name));
		}
		root.put("managers", managers);
		
		//agregamos todos las entidades definidas en el game
		List<String> entityBuilders = new LinkedList<>();
		final Collection<Entity> state_entities = game.getDefines(DefineType.ENTITY);
		for(Entity entity:state_entities)
		{
			entityBuilders.add(entity.name);
			//agregar imports
			modelClass.imports.add(String.format("%s.entity.%sBuilder",generator.packageName,entity.name));
			
			Depend dependencias = generator.getDependences(entity);
			for(AssetModel model:dependencias.assets)
			{
				modelClass.imports.add(model.type.importClass);
			}
			assets.addAll(dependencias.assets);		
		}
		root.put("entityBuilders", entityBuilders);
		
		List<Map<String, Object>> entities = new LinkedList<>();
		final List<Add> state_addentities = state.getAdd(DefineType.ENTITY);
		for(Add entity:state_addentities)
		{
			Map<String,Object> ent = new HashMap<>(2);
			ent.put("name", entity.name);
			if(entity.varName != null)
			{
				ent.put("varName", entity.varName);
			}			
			if(entity.params != null)
			{
				List<String> params = new LinkedList<>();
				for(Expresion expr: entity.params)
				{
					String result = generator.expresion(entity,modelClass,expr);
					if(result != null)
					{
						params.add(result);
					}
					//TODO: probablemente mostrar un error...
				}
				ent.put("params",params);
			}
			entities.add(ent);
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
		modelClass.imports.addAll(Arrays.asList(arrayImports));
		if(state_addentities.size() > 0)
		{
			modelClass.imports.add("com.apollo.Entity");
		}
						
		generator.addJavaCode(state, modelClass);
		generator.createFile(path,String.format("%s.java",state.name), temp, root);
	}
	
}
