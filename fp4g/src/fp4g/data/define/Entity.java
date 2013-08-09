package fp4g.data.define;

import static fp4g.Log.Show;

import java.util.LinkedList;
import java.util.List;

import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ObjectType;
import fp4g.data.On;

public class Entity extends Define{	
	public List<Add> addBehaviors;
	
	
	public Entity(String name,Define parent) {
		super(ObjectType.ENTITY, name,parent);
		
		addBehaviors = new LinkedList<>();
	}
	
	@Override
	public void addADD(Add code) {
		switch(code.getType())
		{
		case ASSET:			
		case ENTITY:		
		case GAME:			
		case GOAL:			
		case MANAGER:			
		case STATE:
			Show(ErrType.NotExpectedType,code);
			break;
		case BEHAVIOR:	
			if(!isDefined(ObjectType.BEHAVIOR,code.name))
			{
				Show(WarnType.MissingDefineAdd,code);
			}
			addBehaviors.add(code);
			break;			
		default:
			break;		 
		}		
	}


	@Override
	public void addDefine(Define define) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addOn(On on) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDefined(ObjectType type,String name) {
		if(parent != null)
		{
			//preguntamos más arriba, debido que Entity no acepta definiciones ;)
			return parent.isDefined(type,name);
		}
		else
		{
			return false;
		}				
	}
	
//	public static class Define extends Entity
//	{
//		public Define(GameDataCommon parent, String name) {
//			super(parent, name);
//			behaviors = new LinkedList<>();
//			events = new LinkedList<>();			
//			parameters = new LinkedList<>();
//			variables = new LinkedList<>();
//			
//			variablesByName = new HashMap<>();
//			behaviorsByName = new HashMap<>();
//		}
//
//		public List<Behavior> behaviors;
//		public List<Event> events;
//		public List<Param> parameters;
//		public List<Var<?>> variables;
//		
//		public Map<String,Var<?>> variablesByName;
//		public Map<String,Behavior> behaviorsByName;
//		
//		
//
//		@Override
//		public Entity add() {	
//			//TODO copiar, clonar etc... revisar
//			return new Add(this.parent,this);
//		}
//
//		@Override
//		public void addBehavior(Behavior behavior) {			
//			behaviors.add(behavior);
//			behaviorsByName.put(behavior.name,behavior);			
//		}
//
//	}
//	public static class Add extends Entity
//	{
//		public Define definedBy;
//		public Add(GameDataCommon parent, Define define) {
//			super(parent, define.name);
//			definedBy = define;
//		}
//
//		@Override
//		public Entity add() {
//			return null;
//		}
//
//		@Override
//		public void addBehavior(Behavior behavior) {
//			throw new RuntimeException("Not implementado");
//			
//		}
//	}
//	public Behavior getDefinedBehavior(String name) {		
//		return parent.getDefinedBehavior(name);
//	}
//
//	public abstract void addBehavior(Behavior behavior);
		
}
