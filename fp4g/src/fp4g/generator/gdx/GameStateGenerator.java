package fp4g.generator.gdx;

import java.io.File;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import fp4g.classes.ManagerData;
import fp4g.data.DefineType;
import fp4g.data.Expresion;
import fp4g.data.ICode;
import fp4g.data.IValue;
import fp4g.data.add.AddAsset;
import fp4g.data.add.AddDefine;
import fp4g.data.define.Asset;
import fp4g.data.define.Entity;
import fp4g.data.define.Game;
import fp4g.data.define.GameState;
import fp4g.data.define.Manager;
import fp4g.data.expresion.ArrayList;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DependResolverNotFoundException;
import fp4g.generator.Depend;
import fp4g.generator.Generator;
import fp4g.generator.gdx.models.AddModel;
import fp4g.generator.gdx.models.AssetModel;
import fp4g.generator.gdx.models.GameFragment;
import fp4g.generator.gdx.models.GameStateModel;
import fp4g.generator.gdx.models.JavaMetaSourceModel;
import fp4g.generator.gdx.models.ManagerModel;
import fp4g.log.Log;
import fp4g.log.info.CannotEval;
import fp4g.log.info.Warn;
import freemarker.template.Template;

public class GameStateGenerator extends JavaCodeGenerator
{	
	
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
		
		//modelo para todo el archivo completo
		GameStateModel gameStateModel = new GameStateModel(generator.packageName,state.name);
		gameStateModel.getMetaSource().setJavadoc(JavaGenerator.autodoc);
		JavaMetaSourceModel meta = gameStateModel.getMetaSource();
		
		//game		
		GameFragment gameModel = new GameFragment();
		gameModel.setWidth(game.width);
		gameModel.setWidth(game.height);
		gameModel.setName(game.name);
		gameStateModel.setGame(gameModel);
		
		//manager, adds
		List<ManagerModel> managers = new LinkedList<ManagerModel>();
		for(AddDefine manager:state.getAddDefines(DefineType.MANAGER))
		{
			Manager define = (Manager) manager.define;
			ManagerModel managerModel = new ManagerModel();
			
			if(define != null)
			{
				IValue<?> managerClass = define.get("managerClass");
				if(managerClass != null)
				{
					managerModel.name = managerClass.getValue().toString();
				}
				else
				{
					managerModel.name = manager.name;
				}
			}
			else
			{
				managerModel.name = manager.name;
			}
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
							meta.addRequireSource(generator.expresion(meta, i));
						}
					}					
				}				
				
			}
			
			managerModel.varName = Generator.uncap_first(manager.name);				
			
			
			
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
							params.add(generator.expresion(meta, value));
						}
					}
				}
				for(Expresion expr: manager.params)
				{
					params.add(generator.expresion(meta,expr));					
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
								params.add(generator.expresion(meta, value));
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
                meta.addRequireSource(String.format("%s.entity.%sBuilder",generator.packageName,entity.name));                                                
            }
        }
        gameStateModel.setBuilders(builders);
        
        //add entities
		List<AddModel> entities = new LinkedList<AddModel>();
		final List<AddDefine> state_addentities = state.getAddDefines(DefineType.ENTITY);
		for(AddDefine entity:state_addentities)
		{			
			AddModel addEntity = new AddModel();
			addEntity.name = entity.name;
			if(entity.params != null)
			{
				List<String> params = new LinkedList<String>();
				for(Expresion expr: entity.params)
				{					
					params.add(generator.expresion(meta,expr));					
				}
				addEntity.params = params;
			}
			entities.add(addEntity);
		}
		gameStateModel.setEntities(entities);
		
		//agregar assets
		final List<AssetModel>  assets = new LinkedList<AssetModel>();
		final Collection<AddAsset> assetsList = state.getAddAssets();		
		for(AddAsset add:assetsList)
		{			
			//Buscamos el dtefine para poder definir lo siguiente.
			Asset define = add.asset;
			
			//ahora assetModel deberia tener: el tipo de textura, nombre recurso y parametros adicionales.
			String assetPath = add.resource;
			
			HashMap<String,String> params = new HashMap<String,String>();
			
			IValue<?> groupNameValue = define.get("groupName");			
			String groupName = (groupNameValue!=null)?groupNameValue.getValue().toString():null;
			
			//ahora los parametros están en un IMap, el problema es como recorro un IMap?
			AddAsset parent = add.getParent();
			if(parent != null) //está dentro de un grupo
			{
				if(groupName != null)
				{
					params.put(groupName,String.format("\"%s\"", parent.resource));
				}
				else
				{
					Log.Show(CannotEval.IncomplatibleTypes,add,"No se esperaba este asset en un grupo.");
				}
			}
			
			if(add.values != null)
			{
				for(Entry<String, IValue<?>> entry: add.values.entrySet())
				{
					params.put(entry.getKey(), generator.expresion(meta,entry.getValue()));				
				}
			}
			AssetModel assetModel = new AssetModel(define, assetPath, params);
			
			assets.add(assetModel);
			
			try
			{
				Depend depend = generator.resolveDependency(define);
				depend.perform(define, meta);
			}
			catch(DependResolverNotFoundException ex)
			{
				Log.Exception(ex, define.getLine());
			}
									
		}
		gameStateModel.setAssets(assets);

		
		try
		{
			Depend depend = generator.resolveDependency(state);
			depend.perform(state, meta);
		}
		catch(DependResolverNotFoundException ex)
		{
			Log.Exception(ex, state.getLine());
		}
		
		for(AddDefine manager:state.getAddDefines(DefineType.MANAGER))
		{
			if(manager.define != null)
			{
				try
				{
					Depend depend = generator.resolveDependency(manager.define);
					depend.perform(manager.define, meta);
				}
				catch(DependResolverNotFoundException drnfe)
				{
					Log.Exception(drnfe, manager.getLine());
					meta.addRequireSource(String.format("com.apollo.managers.%s", manager.name));
				}
			}
			else
			{
				Log.Show(Warn.MissingDefineAdd, manager.getLine(),"Se asumirá que existe un Define asociado.");				
				meta.addRequireSource(String.format("com.apollo.managers.%s", manager.name));
			}
		}
		
		if(state_addentities.size() > 0)
		{
			meta.addRequireSource("com.apollo.Entity");
		}
		
		if(generator.isDebug)
		{
			meta.addRequireSource("com.badlogic.gdx.graphics.FPSLogger");
		}
		
		meta.addRequireSource("com.apollo.Assets");
		
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
