package fp4g.data.define;

import fp4g.NotAllowed;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.data.On;
import fp4g.data.expresion.Literal;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.data.expresion.literals.IntegerLiteral;
import fp4g.data.libs.LibContainer;
/**
 * Esta clase contendrá todos los datos necesarios para construir un juego
 * @author Edgardo
 *
 */
public class Game extends Define
{	
	public int width = 640;
	public int height = 480;
	public boolean debug = false;
	public GameState startState;
	
	public Game(LibContainer lc)
	{
		super(DefineType.GAME,"game",lc);		
	}
	
	public void set(String key, Literal<?> value)
	{
		if(key.equalsIgnoreCase("width"))
		{
			width = ((Integer)value.getValue()).intValue();
		}
		else
		if(key.equalsIgnoreCase("height"))
		{
			width = ((Integer)value.getValue()).intValue();
		}
		else
		if(key.equalsIgnoreCase("debug"))
		{
			debug = ((Boolean)value.getValue()).booleanValue();
		}
		else
		{
			super.set(key, value);
		}
	}
	
	public IValue<?> get(String key)
	{
		if(key.equalsIgnoreCase("width"))
		{
			return new IntegerLiteral(width);
		}
		else
		if(key.equalsIgnoreCase("height"))
		{
			return new IntegerLiteral(height);
		}
		else
		if(key.equalsIgnoreCase("debug"))
		{
			return new BoolLiteral(debug);
		}
		else
		{
			return super.get(key);
		}
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
			case GOAL:
				super.setAdd(code);
				break;
			case STATE:
				super.setAdd(code);
				break;			
			default:
				throw new NotAllowedException(NotAllowed.NotExpectedAdd, code,"No se esperaba estos tipos en Game");					
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
	public void setDefine(IDefine define) {
		switch(define.getType())
		{
			
			case ASSET:
				super.setDefine(define);
				break;
			case BEHAVIOR:
				super.setDefine(define);
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
				throw new NotAllowedException(NotAllowed.NotExpectedAdd, define,String.format("No se esperaba el define \"%s\" en Game",define.getName()));		
		}		
	}

	@Override
	public void setOn(On on) {
		throw new NotAllowedException(NotAllowed.NotExpectedOn, on, "No se esperaba una instrucción ON en Game");		
	}

	public void setStart(GameState state) {
		startState = state;		
	}	
}
