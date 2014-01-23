package fp4g.generator.gdx;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.DefineType;
import fp4g.data.ICode;
import fp4g.data.define.Behavior;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.generator.CodeGenerator;
import fp4g.generator.gdx.models.PropertiesModel;
import freemarker.template.Template;

public class GameGenerator extends CodeGenerator<JavaGenerator> {

	public GameGenerator(JavaGenerator generator) {
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception 
	{
		Game game = (Game)gameData;
		
		Template temp               = generator.getTemplate("GameManager.ftl"); 	
		
		
		//aqui probaré la nueva forma de tratar los datos
		{
			//tengo la plantilla
			Template propertiesTemplate = generator.getTemplate("properties.ftl");
			//ahora necesito el modelo
			PropertiesModel propertiesModel = new PropertiesModel();

			//ahora cargo el modelo con datos. De alguna forma
			propertiesModel.setClassName(generator.packageName.concat(".").concat(game.name));
			propertiesModel.setTitle("FP4G - ".concat(game.name));
			propertiesModel.setWidth(game.width);
			propertiesModel.setHeight(game.height);
			propertiesModel.setResizable(false);
			propertiesModel.setResizable(true);
			
			//genero
			generator.createFile(generator.sourceDir,"game.properties",propertiesTemplate, propertiesModel);			
			
			
		}
		
		HashMap<String,Object> root = new HashMap<String, Object>();
		HashMap<String,Object> clazz = new HashMap<String, Object>();
		clazz.put("package", generator.packageName);
		clazz.put("name",game.name);
		root.put("class",clazz);
		root.put("autodoc", JavaGenerator.autodoc);
		root.put("width", game.width);
		root.put("height", game.height);
		//agregar imports!
		
		{
			List<String> imports = new LinkedList<String>();
			String arrayImports[] = new String[]
			{
				"com.apollo.managers.GameManager"				
			};
			//Arrays.sort(arrayImports);
			Collections.addAll(imports, arrayImports);
			clazz.put("imports", imports);
		}
		
		if(game.startState != null)
		{			
			root.put("start_state", game.startState.getName());
		}
		
		generator.createFile(path,String.format("%s.java",game.name), temp,root);
		
		//generar Assets...
		{
			List<String> imports = new LinkedList<String>();
			String arrayImports[] = new String[]
			{					
				"com.apollo.managers.graphics.Sprite",
				"com.apollo.managers.graphics.SpriteLoader",
				"com.badlogic.gdx.assets.AssetLoaderParameters",
				"com.badlogic.gdx.assets.AssetManager",
				"com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver",
				"com.badlogic.gdx.graphics.Texture",
				"com.badlogic.gdx.graphics.g2d.TextureRegion",				
				"com.badlogic.gdx.physics.box2d.CircleShape",
				"com.badlogic.gdx.physics.box2d.PolygonShape",
				"com.badlogic.gdx.physics.box2d.FixtureDef",
				
			};
			Arrays.sort(arrayImports);
			Collections.addAll(imports, arrayImports);
			HashMap<String,Object> assetsRoot = new HashMap<String, Object>();
			HashMap<String,Object> assetsClazz = new HashMap<String, Object>();
			assetsClazz.put("package", generator.packageName);
			assetsClazz.put("imports", imports);
			assetsRoot.put("class",assetsClazz);
			assetsRoot.put("autodoc", JavaGenerator.autodoc);			
			
			generator.createFile(path,"Utils.java",generator.getTemplate("Utils.ftl"), assetsRoot);
		}
		
		
		final Collection<Entity> game_entities = game.getDefines(DefineType.ENTITY);
		if(game_entities != null)
		{
			for(Entity entity: game_entities)
			{
				generator.generateCode(entity, path);
			}
		}
		final Collection<GameState> game_states = game.getDefines(DefineType.STATE);
		if(game_states != null)
		{
			for(GameState state: game_states)
			{
				generator.generateCode(state, path);
			}
		}
		final Collection<Behavior> behaviors = game.getDefines(DefineType.BEHAVIOR);
		if(behaviors != null)
		{
			for(Behavior behavior: behaviors)
			{
				generator.generateCode(behavior, path);
			}
		}
	}

	@Override
	public void usingCode(ICode gameData, File path)
	{
		Game game = (Game)gameData;
		generator.usingFile(path,String.format("%s.java",game.name));
		generator.usingFile(path,"Utils.java");
	}
	
}
