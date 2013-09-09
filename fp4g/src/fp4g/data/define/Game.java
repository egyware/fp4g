package fp4g.data.define;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Behavior;
import fp4g.data.Define;
import fp4g.data.Manager;
import fp4g.data.ObjectType;
import fp4g.data.On;
import static fp4g.Log.Show;
import static fp4g.Log.ErrType;
import static fp4g.Log.WarnType;
import static fp4g.Log.InfoType;
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends Define  {	
	public int width = 640;
	public int height = 480;
	public boolean debug = false;
	
	//datos que contiene un juego, todo esto es visto de manera global

	//defines listas
	public List<GameState> states;
	public List<Entity> entities;	
	public List<Goal> goals;	
	
	//defines mapas
	public Map<String,Manager> managersByName;
	public Map<String,Entity> entitiesByName;
	public Map<String,Behavior> behaviorsByName;
	public Map<String,Goal> goalsByName;
	//public Map<String,GameState> statesByName;
	
	//adds? como serán, aun no los he definido todavia
	public List<Add> addStates; //solo se aceptan states y goals!
	public List<Add> addGoals; 
	
	public Game()
	{
		super(ObjectType.GAME,"game");
		states = new LinkedList<>();
		entities = new LinkedList<>();		
		goals = new LinkedList<>();	
		
		managersByName = new HashMap<>();		
		entitiesByName = new HashMap<>();
		behaviorsByName = new HashMap<>();
		goalsByName     = new HashMap<>();
		//statesByName = new HashMap<>();
		
		addStates = new LinkedList<>();
		addGoals = new LinkedList<>();
	}
	
//	/**
//	 * @param name
//	 * @param manager
//	 */
//	public void addManager(String name,Manager manager)
//	{
//		managersByName.put(name, manager);
//	}

//	/**
//	 * @param name
//	 */
//	public void addBehavior(String name) {
//		addBehavior(name,(String)null);
//	}
//	/**
//	 * @param name
//	 * @param parentName
//	 */
//	public void addBehavior(String name,String parentName) {
//		Behavior bhvr = new Behavior();
//		bhvr.name = name;
//		if(parentName != null)
//		{
//			Behavior parent = behaviorsByName.get(parentName);
//			if(parent != null)
//			{
//				Show(WarnType.ParentBehaviorNull);
//			}
//			bhvr.parent = parent;
//		}	
//		addBehavior(name,bhvr);
//	}
//	/**
//	 * @param name
//	 * @param bhvr
//	 */
//	public void addBehavior(String name,Behavior bhvr)
//	{
//		behaviorsByName.put(name, bhvr);
//	}
//	/**
//	 * @param entity
//	 */
//	public void addEntity(Entity entity)
//	{
//		entities.add(entity);
//		entitiesByName.put(entity.name, entity);
//	}
//	
//	/**
//	 * Agrega y clasifica los valores que se van leyendo
//	 * @param name Nombre del dato 
//	 * @param value Valor del dato
//	 */
//	/**
//	 * @param name
//	 * @param value
//	 */
//	public void add(String name,Object value)
//	{		
//		if(value instanceof Behavior)
//		{
//			addBehavior(name,(Behavior)value);
//		}
//	}	
//	/**
//	 * @param state
//	 */
//	public void addGameState(GameState state)
//	{
//		gameStates.add(state);		
//	}
//
//	/**
//	 * @param name
//	 * @return
//	 */
//	public Manager getDefinedManager(String name) {
//		return managersByName.get(name);		
//	}
//	//@Override
//	/**
//	 * @param name
//	 * @return
//	 */
//	public Behavior getDefinedBehavior(String name) {	
//		return behaviorsByName.get(name);
//	}
//
//	/**
//	 * @param name
//	 * @return
//	 */
//	public Entity getDefinedEntity(String name) {
//		return entitiesByName.get(name);
//	}

	@Override
	public void addAdd(Add code) {
		switch(code.getType())
		{	
			case MANAGER:
			case GAME:
			case ENTITY:
			case BEHAVIOR:
				Show(ErrType.NotExpectedType,code);
				break;
			case GOAL:
				addGoals.add(code);
				break;
			case STATE:
				addStates.add(code);
				break;
			default:
				break;		
		}
		//System.out.println(code.name);
	}

	@Override
	public void addDefine(Define define) {
		switch(define.getType())
		{
			case GAME:
			case ASSET:
			case MANAGER:
			case BEHAVIOR:			
				Show(ErrType.NotExpectedType,define);
				break;			
			case ENTITY:
				entities.add((Entity) define);
				entitiesByName.put(define.getName(), (Entity) define);
				break;			
			case GOAL:
				goals.add((Goal) define);
				goalsByName.put(define.getName(), (Goal) define);
				break;
			case STATE:
				states.add((GameState) define);
				//statesByName.put(define.getName(), (GameState) define);
				break;
			default:
				break;		
		}		
	}

	@Override
	public void addOn(On on) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDefined(ObjectType type,String name) {
		switch(type)
		{		
		case BEHAVIOR:
			return behaviorsByName.containsValue(name);			
		case ENTITY:
			return entitiesByName.containsValue(name);
		case GOAL:
			return goalsByName.containsValue(name);			
		case MANAGER:
			return managersByName.containsValue(name);
		//case STATE:
			//return statesByName.containsValue(name);
		default:			
			return false;		
		}		
	}

	
	
}
