package fp4g.data.define;

import static fp4g.Log.Show;

import java.util.LinkedList;
import java.util.List;

import fp4g.Log.ErrType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ObjectType;
import fp4g.data.On;

public class GameState extends Define{
	public List<Add> addEntities;
	public List<Add> addManagers;

	public GameState(String name,Define parent) {
		super(ObjectType.STATE, name,parent);
		
		addEntities = new LinkedList<>();
		addManagers = new LinkedList<>();
	}
	
	@Override
	public void addAdd(Add code) {
		switch(code.getType())
		{
		case ASSET:		
		case BEHAVIOR:
		case GAME:
		case STATE:
			Show(ErrType.NotExpectedType,code);
			break;
		case ENTITY:
			addEntities.add(code);
			break;
		case GOAL:
			//TODO: No implementado aún
			throw new RuntimeException("No implementado");
			//break;
		case MANAGER:
			addManagers.add(code);
			break;
		default:
			Show(ErrType.UnknowError,code);
			break;			
		}		
	}

	@Override
	public void addDefine(Define define) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No implementado");
	}

	@Override
	public void addOn(On on) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No implementado");
	}

	@Override
	public boolean isDefined(ObjectType type, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Define getDefine(ObjectType type, String name) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No implementado");		
	}

	@Override
	public On getOn(String message) {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public static class Custom extends GameState
//	{
//
//		public Custom(Game game, String name) {
//			super(game, name);
//		}
//		
//		
//	}
//	public static class Generated extends GameState
//	{
//		
//		public Generated(Game game, String name) {
//			super(game, name);
//		}
//
//		public List<Entity> entities;
//		public List<Behavior> behaviors;
//		public List<Goal> goals;
//		public List<Event> events;
//		public List<Manager> systems;
//		public List<Var<?>> variables;
//		public List<Param> parameters;
//		
//		//aceso rapido a los datos
//		public Map<String,Entity> entitiesByName;
//		public Map<String,Behavior> behaviorsByName;
//		public Map<String,Goal> goalsByName;
//		public Map<String,Event> eventsByName;
//		public Map<String,Manager> systemsByName;
//		public Map<String,Var<?>> variablesByName;
//		
//		//acceso a todos los datos
//		public IScope scope;
//	}
}
