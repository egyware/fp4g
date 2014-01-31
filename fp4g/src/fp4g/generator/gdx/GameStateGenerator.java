package fp4g.generator.gdx;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.classes.ManagerData;
import fp4g.data.Add;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.IValue;
import fp4g.data.define.Asset;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Manager;
import fp4g.data.expresion.ArrayList;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.CodeGenerator;
import fp4g.generator.Depend;
import fp4g.generator.Generator;
import fp4g.generator.gdx.models.AddModel;
import fp4g.generator.gdx.models.AssetModel;
import fp4g.generator.gdx.models.GameModel;
import fp4g.generator.gdx.models.GameStateModel;
import fp4g.generator.gdx.models.JavaCodeModel;
import fp4g.generator.gdx.models.ManagerModel;
import freemarker.template.Template;

public class GameStateGenerator extends CodeGenerator<JavaGenerator> {	
	
	private static final String EXTRA = "extra";
	private static final String DEBUG = "debug";

	public GameStateGenerator(JavaGenerator generator) 
	{
		super(generator);
	}
	
	
	@Override	
	public void generateCode(ICode gameData, File path) 
	throws Exception 
	{
		GameState state = (GameState)gameData;
		Game game = (Game)state.parent;
		
		Template temp = generator.getTemplate("GameState.ftl");
		
		GameStateModel gameStateModel = new GameStateModel();
		
		//class
		JavaCodeModel code = new JavaCodeModel();		
		code.pckg    = generator.packageName;
		code.name    = state.name;
		code.javadoc = JavaGenerator.autodoc;		
		gameStateModel.setCode(code);
		
		//game
		//TODO más adelante, si este modelo ya existe reutilizarlo de alguna manera entre generadores.
		GameModel gameModel = new GameModel();
		gameModel.setWidth(game.width);
		gameModel.setWidth(game.height);
		gameModel.setName(game.name);
		gameStateModel.setGame(gameModel);
		
		//manager, adds
		List<ManagerModel> managers = new LinkedList<ManagerModel>();
		for(Add manager:state.getAdd(DefineType.MANAGER))
		{
			Manager define = (Manager) manager.define;
			ManagerModel managerModel = new ManagerModel();
			
			managerModel.name = manager.name;
			ManagerData extras = null;
			if(define != null)
			{
				managerModel.priority = define.getPriority();
				//acá, buscar las cosas extras y añadirselas.
				IValue<?> extrasValue;
				if(generator.isDebug)
				{
					extrasValue = define.get(DEBUG);
					if(extrasValue == null)
					{
						extrasValue = define.get(EXTRA);
					}					
				}
				else
				{
					extrasValue = define.get(EXTRA);
				}
				 
				if(extrasValue != null)
				{
					extras = (ManagerData) extrasValue.getValue();
					
					managerModel.setMethod = extras.getSetMethod();
					managerModel.preInitialize = toList(extras.getPreInitialize());
					managerModel.postInitialize = toList(extras.getPostInitialize());
					managerModel.fields = toList(extras.getFields());
					managerModel.preUpdate = toList(extras.getPreUpdate());
					managerModel.postUpdate = toList(extras.getPostUpdate());
					
					//a pesar que va quedar general, para ambos casos solo use para la depuración
					ArrayList imports = extras.getImports();
					if(imports != null)
					{
						for(IValue<?> i:imports)
						{
							code.addImport(generator.expresion(code, i));
						}
					}					
				}				
				
			}
			
			
			if(manager.varName != null)
			{
				managerModel.varName = manager.varName;
			}
			else
			{	
				managerModel.varName = Generator.uncap_first(manager.name);				
			}
			
			
			if(manager.params != null)
			{
				List<String> params = new LinkedList<String>();
				if(extras != null)
				{
					ArrayList dparams = extras.getParams();
					if(dparams != null)
					{
						for(IValue<?> value:dparams)
						{
							params.add(generator.expresion(code, value));
						}
					}
				}
				for(Expresion expr: manager.params)
				{
					String result = generator.expresion(code,expr);
					if(result != null)
					{
						params.add(result);
					}
					//TODO: probablemente mostrar un error...
				}
				managerModel.params = params;				
			}
			else
			{  //si no hay, y existe parametros por defecto. Entonces usamos este				
				if(extras != null)
				{
					List<String> params = new LinkedList<String>();
					if(extras != null)
					{
						ArrayList dparams = extras.getParams();
						if(dparams != null)
						{
							for(IValue<?> value:dparams)
							{
								params.add(generator.expresion(code, value));
							}
						}
					}
					managerModel.params = params;
				}
			}
			managers.add(managerModel);
		}
		Collections.sort(managers);
		gameStateModel.setManagers(managers);
		
		 //agregamos todos las entidades definidas ens el game
        List<String> builders = new LinkedList<String>();
        final Collection<Entity> state_entities = game.getDefines(DefineType.ENTITY);
        if(state_entities != null && state_entities.size()>0)
        {
            for(Entity entity:state_entities)
            {
                builders.add(entity.name);
                //agregar imports
                code.imports.add(String.format("%s.entity.%sBuilder",generator.packageName,entity.name));                                                
            }
        }
        gameStateModel.setBuilders(builders);
        
        //add entities
		List<AddModel> entities = new LinkedList<AddModel>();
		final List<Add> state_addentities = state.getAdd(DefineType.ENTITY);
		for(Add entity:state_addentities)
		{			
			AddModel addEntity = new AddModel();
			addEntity.name = entity.name;						
			if(entity.varName != null)
			{
				addEntity.varName = entity.varName;
			}			
			if(entity.params != null)
			{
				List<String> params = new LinkedList<String>();
				for(Expresion expr: entity.params)
				{
					String result = generator.expresion(code,expr);
					if(result != null)
					{
						params.add(result);
					}
					//TODO: probablemente mostrar un error...
				}
				addEntity.params = params;
			}
			entities.add(addEntity);
		}
		gameStateModel.setEntities(entities);
		
		//agregar assets 
		int asset_number = 0;
		final List<AssetModel>  assets = new LinkedList<AssetModel>();
		final List<Add> assetsList = state.getAdd(DefineType.ASSET);			
		for(Add asset:assetsList)
		{			
			//Buscamos el dtefine para poder definir lo siguiente.
			Asset define = (Asset) asset.define;
			
			if(asset.varName == null)
			{
				asset.varName = String.format("asset_%d", asset_number++);
			}
			//ahora assetModel deberia tener: el tipo de textura, nombre recurso y parametros adicionales.
			List<String> params = new LinkedList<String>();
			Iterator<Expresion> it = asset.params.iterator();
			//sacamos el primer valor (siempre va tener uno, esto porque la gramatica de lo obliga.
			Expresion first = it.next();			
			String assetPath = generator.expresion(code,first);			
			for(;it.hasNext();)
			{
				Expresion expr = it.next();
				String result = generator.expresion(code,expr);
				if(result != null)
				{
					params.add(result);
				}
				//TODO: probablemente mostrar un error...
			}
			//TODO, no sé en que momento deberia usar la varName de add...
			AssetModel assetModel = new AssetModel(define, assetPath, params);
			
			assets.add(assetModel);
			
			try{
				Depend depend = generator.resolveDependency(define);
				depend.perform(define, code);
			}
			catch(DependResolverNotFoundException ex)
			{
				//TODO URGENTE ERROR CAPTURADO
			}
									
		}
		gameStateModel.setAssets(assets);

		
		try
		{
			Depend depend = generator.resolveDependency(state);
			depend.perform(state, code);
		}
		catch(DependResolverNotFoundException drnfe)
		{
			//TODO URGENTE ERROR CAPTURADO
		}
		
		for(Add manager:state.getAdd(DefineType.MANAGER))
		{
			if(manager.define != null)
			{
				try
				{
					Depend depend = generator.resolveDependency(manager.define);
					depend.perform(manager.define, code);
				}
				catch(DependResolverNotFoundException drnfe)
				{
					//TODO ERROR CAPTURADO
					//Log.Show(Warn.DependResolverNotFound,manager,manager.name);
					code.imports.add(String.format("com.apollo.managers.%sManager", manager.name));

				}
			}
			else
			{
				//TODO ERROR CAPTURADO				
				//Log.Show(Warn.MissingDefineAdd,manager,manager.name);
				
				code.imports.add(String.format("com.apollo.managers.%sManager", manager.name));
			}
		}
		
		if(state_addentities.size() > 0)
		{
			code.imports.add("com.apollo.Entity");
		}
		
		if(generator.isDebug)
		{
			code.addImport("com.badlogic.gdx.graphics.FPSLogger");
		}
		
		generator.createFile(path,String.format("%s.java",state.name), temp, gameStateModel);

	}

	private List<String> toList(ArrayList arrayList) throws CannotEvalException  
	{
		if(arrayList != null)
		{
			List<String> list = new LinkedList<String>();
			for(IValue<?> value:arrayList)
			{
				list.add(generator.expresion(null, value));
			}
			return list;
		}
		return null;
	}


	@Override
	public void usingCode(ICode gameData, File path) 
	{
		GameState state = (GameState)gameData;
		generator.usingFile(path,String.format("%s.java",state.name));
	}
	
}
