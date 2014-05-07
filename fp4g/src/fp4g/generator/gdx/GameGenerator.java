package fp4g.generator.gdx;

import java.io.File;
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
import fp4g.data.define.Message;
import fp4g.exceptions.GeneratorException;
import fp4g.generator.CodeGenerator;
import fp4g.generator.gdx.models.GameFragment;
import fp4g.generator.gdx.models.GameModel;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.PropertiesFragment;
import freemarker.template.Template;

public class GameGenerator extends CodeGenerator<JavaGenerator> 
{

	public GameGenerator(JavaGenerator generator) {
		super(generator);		
	}

	@Override
	public void generateCode(ICode gameData, File path) throws Exception 
	{
		Game game = (Game)gameData;
		
		Template temp               = generator.getTemplate("GameManager.ftl"); 	
		
		
		//aqui probaré la nueva forma de tratar los datos
		//06-05-2014: Si, se ve mucho más ordenado así. Estoy implementando de apoco esto en otros generadores.
		{
			//tengo la plantilla
			Template propertiesTemplate = generator.getTemplate("properties.ftl");
			//ahora necesito el modelo
			PropertiesFragment propertiesModel = new PropertiesFragment();

			//ahora cargo el modelo con datos. De alguna forma
			propertiesModel.setClassName(generator.packageName.concat(".").concat(game.name));
			propertiesModel.setTitle("FP4G - ".concat(game.name));
			propertiesModel.setWidth(game.width);
			propertiesModel.setHeight(game.height);
			propertiesModel.setUseGL20(game.shaders);
			propertiesModel.setResizable(false);			
			
			//genero
			generator.createFile(generator.sourceDir,"game.properties",propertiesTemplate, propertiesModel);
		}
		
		GameModel gameModel = new GameModel(generator.packageName, game.name);
		JavaMetaSourceModel clazz = gameModel.getMetaSource();
		
		clazz.setJavadoc(JavaGenerator.autodoc);
		
		gameModel.setWidth(game.width);
		gameModel.setHeight(game.height);

		//agregar imports!		
		{
			List<String> imports = new LinkedList<String>();
			String arrayImports[] = new String[]
			{
				"com.apollo.GameManager",
				"com.apollo.Assets",
			};
			//Arrays.sort(arrayImports);
			Collections.addAll(imports, arrayImports);
			clazz.addRequireSource(arrayImports);
		}
		
		if(game.startState != null)
		{			
			gameModel.setStartState(game.startState.getName());
		}
		
		generator.createFile(path,String.format("%s.java",game.name), temp,gameModel);
		
		generateOthers(game, path);
	}
	
	@Override
	public void usingCode(ICode gameData, File path)
	throws Exception
	{
		Game game = (Game)gameData;
		generator.usingFile(path,String.format("%s.java",game.name));
		
		generateOthers(game, path);
		
	}
	


	private void generateOthers(Game game, File path) throws GeneratorException
	{
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
		final Collection<Message> messages = game.getDefines(DefineType.MESSAGE);
		if(messages != null)
		{
			for(Message message: messages)
			{
				generator.generateCode(message, path);
			}
		}
		
	}
	
}
