package fp4g.data.managers;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.Manager;
import fp4g.data.ObjectType;
import fp4g.data.On;

public class EntityManager extends Manager {

	public EntityManager() {
		super("EntityManager");		
	}

	@Override
	public void addAdd(Add code) {
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

	@Override
	public boolean isDefined(ObjectType type, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Define getDefine(ObjectType type, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public On getOn(String message) {
		// TODO Auto-generated method stub
		return null;
	}

}
