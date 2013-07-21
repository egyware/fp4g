package fp4g.new_data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.data.IScope;

public abstract class GameState extends GameDataCommon{
	public String name;
	
	public List<Entity> entities;
	public List<Pair<String,Entity>> entitiesWithPar;	

	public List<Goal> goals;
	public List<Pair<String,Goal>> goalsWithPar;
	
	public List<Manager> managers;
	public List<Pair<String,Manager>> managersWithPar;
	
	public Map<String,Manager> managersDefined;	
	public Map<String,Entity> entitiesDefined;
	public Map<String,Behavior> behaviorsDefined;
	
	private Game game;

	 
	
	public GameState(Game game,String name)
	{
		this.game = game;
		this.name = name;
		
		entities = new LinkedList<>();
		goals = new LinkedList<>();
		managers = new LinkedList<>();
		entitiesWithPar = new LinkedList<>();
		goalsWithPar = new LinkedList<>();
		managersWithPar = new LinkedList<>();
		
		managersDefined = new HashMap<>();
		entitiesDefined = new HashMap<>();
		behaviorsDefined = new HashMap<>();
	}
	
	@Override
	public Manager getDefinedManager(String name)
	{
		Manager find = managersDefined.get(name);
		if(find == null)
		{
			find = game.getDefinedManager(name);
		}
		return find;
	}
	@Override
	public Entity getDefinedEntity(String name)
	{
		Entity find = entitiesDefined.get(name);
		if(find == null)
		{
			find = game.getDefinedEntity(name);
		}
		return find;
	}
	@Override
	public Behavior getDefinedBehavior(String name)
	{
		Behavior find = behaviorsDefined.get(name);
		if(find == null)
		{
			find = game.getDefinedBehavior(name);
		}
		return find;
	}
	
	public void addManager(Manager manager,String key)
	{
		if(key != null)
		{
			managersWithPar.add(new Pair<String, Manager>(key,manager));
		}
		else
		{
			managers.add(manager);
		}
	}
	public void addEntity(Entity entity,String key)
	{
		if(key != null)
		{
			entitiesWithPar.add(new Pair<String, Entity>(key,entity));
		}
		else
		{
			entities.add(entity);
		}
	}
	public void addGoal(Goal goal,String key)
	{
		if(key != null)
		{
			goalsWithPar.add(new Pair<String, Goal>(key,goal));
		}
		else
		{
			goals.add(goal);
		}
	}
	public void add(String name,Object value)
	{
		throw new RuntimeException("No implementado aún");
	}
	
	public static class Custom extends GameState
	{

		public Custom(Game game, String name) {
			super(game, name);
		}
		
		
	}
	public static class Generated extends GameState
	{
		
		public Generated(Game game, String name) {
			super(game, name);
		}

		public List<Entity> entities;
		public List<Behavior> behaviors;
		public List<Goal> goals;
		public List<Event> events;
		public List<Manager> systems;
		public List<Var<?>> variables;
		public List<Param> parameters;
		
		//aceso rapido a los datos
		public Map<String,Entity> entitiesByName;
		public Map<String,Behavior> behaviorsByName;
		public Map<String,Goal> goalsByName;
		public Map<String,Event> eventsByName;
		public Map<String,Manager> systemsByName;
		public Map<String,Var<?>> variablesByName;
		
		//acceso a todos los datos
		public IScope scope;
	}
}
