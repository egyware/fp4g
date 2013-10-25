package fp4g.data.define;

import static fp4g.Log.Show;
import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.On;
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends Define  {	
	public int width = 640;
	public int height = 480;
	public boolean debug = false;
	public String startState;
	
	public Game()
	{
		super(DefineType.GAME,"game");	
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
	public void setAdd(Add code) {
		switch(code.getType())
		{	
			case MANAGER:
			case GAME:
			case ENTITY:
			case BEHAVIOR:
				Show(ErrType.NotExpectedType,code);
				break;
			case GOAL:
				super.setAdd(code);
				break;
			case STATE:
				super.setAdd(code);
				break;
			default:
				Show(ErrType.UnknowError,code);
				break;		
		}		
	}
	/**
	 * Bypass para los managers
	 * @param manager
	 */
	public void setManager(Manager manager)
	{	
		super.setDefine(manager);		
	}
	
	@Override
	public void setDefine(Define define) {
		switch(define.getType())
		{
			case GAME:
			case ASSET:
			case MANAGER:
			case BEHAVIOR:			
				Show(ErrType.NotExpectedType,define);
				break;			
			case ENTITY:
				super.setDefine(define);				
				break;			
			case GOAL:
				super.setDefine(define);
				break;
			case STATE:
				super.setDefine(define);				
				break;
			case MESSAGE:
				super.setDefine(define);
				break;
			default:
				Show(ErrType.UnknowError,define);
				break;		
		}		
	}

	@Override
	public void setOn(On on) {
		Show(ErrType.NotExpectedOn,on);		
	}

	public void setStart(String state) {
		startState = state;		
	}	
}
