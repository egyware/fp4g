package fp4g.new_data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static fp4g.Log.Show;
import static fp4g.Log.ErrType;
import static fp4g.Log.WarnType;
import static fp4g.Log.InfoType;
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends GameDataCommon {
	public String name;
	public int width = 640;
	public int height = 480;
	public boolean debug = false;
	
	//datos que contiene un juego, todo esto es visto de manera global
	public List<GameState> gameStates;
	public List<Entity> entities;	
	public List<Goal> goals;
	public List<Event> events;	
	public List<Param> parameters;
	
	public Map<String,Manager> managersByName;
	public Map<String,Entity> entitiesByName;
	public Map<String,Behavior> behaviorsByName;
	public Map<String,Goal> goalsByName;
	
	public Game()
	{
		gameStates = new LinkedList<GameState>();
		entities = new LinkedList<Entity>();		
		goals = new LinkedList<Goal>();		
		parameters = new LinkedList<Param>();
		
		managersByName = new HashMap<String,Manager>();		
		entitiesByName = new HashMap<String,Entity>();
		behaviorsByName = new HashMap<String,Behavior>();
		goalsByName     = new HashMap<String,Goal>();
	}
	
	public void addManager(String name,Manager manager)
	{
		managersByName.put(name, manager);
	}

	public void addBehavior(String name) {
		addBehavior(name,(String)null);
	}
	public void addBehavior(String name,String parentName) {
		Behavior bhvr = new Behavior();
		bhvr.name = name;
		if(parentName != null)
		{
			Behavior parent = behaviorsByName.get(parentName);
			if(parent != null)
			{
				Show(WarnType.ParentBehaviorNull);
			}
			bhvr.parent = parent;
		}	
		addBehavior(name,bhvr);
	}
	public void addBehavior(String name,Behavior bhvr)
	{
		behaviorsByName.put(name, bhvr);
	}
	
	/**
	 * Agrega y clasifica los valores que se van leyendo
	 * @param name Nombre del dato 
	 * @param value Valor del dato
	 */
	public void add(String name,Object value)
	{		
		if(value instanceof Behavior)
		{
			addBehavior(name,(Behavior)value);
		}
	}	
	public void addGameState(GameState state)
	{
		gameStates.add(state);		
	}

	public Manager getDefinedManager(String name) {
		return managersByName.get(name);		
	}
	@Override
	public Behavior getDefinedBehavior(String name) {	
		return behaviorsByName.get(name);
	}

	public Entity getDefinedEntity(String name) {
		return entitiesByName.get(name);
	}

	
	
}
