package fp4g.data.define;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.GameDataCommon;
import fp4g.data.ObjectType;
import fp4g.data.On;

public class Entity extends Define{	
	public GameDataCommon parent;
	public String name;
	//public abstract Entity add();
	
	
	public Entity(String name) {
		super(ObjectType.ENTITY, name);		 
	}
	
//	public Entity(GameDataCommon parent,String name){
//		this.name = name;
//		this.parent = parent;
//	}

	@Override
	public void addADD(Add code) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addDefine(Define define) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addOn(On on) {
		// TODO Auto-generated method stub
		
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
