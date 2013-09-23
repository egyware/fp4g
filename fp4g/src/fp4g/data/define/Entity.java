package fp4g.data.define;

import static fp4g.Log.Show;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.ObjectType;
import fp4g.data.On;

public class Entity extends Define{	
	public final List<Add> addBehaviors;
	public final List<On> onMessages;
	public final Map<String,On> onMessagesByName;
	
	
	public Entity(String name,Define parent) {
		super(ObjectType.ENTITY, name,parent);
		
		addBehaviors = new LinkedList<>();
		onMessages = new LinkedList<>();
		onMessagesByName = new HashMap<>();
	}
	
	@Override
	public void addAdd(Add code) {
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
		onMessages.add(on);
		onMessagesByName.put(on.name,on);
	}
	
	@Override
	public On getOn(String name)
	{		
		return onMessagesByName.get(name);
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

	@Override
	public Define getDefine(ObjectType type, String name) {
		if(parent != null)
		{
			//preguntamos más arriba, debido que Entity no acepta definiciones ;)
			return parent.getDefine(type,name);
		}
		else
		{
			return null;
		}			
	}
		
}
