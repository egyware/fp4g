package fp4g.data;


import java.util.LinkedList;
import java.util.List;

public abstract class Define extends Code{
	public ObjectType type;
	public String name;
	public List<Add> adds;
	public List<On> on;
	public List<Params> params;
	
	public Define(ObjectType type,String name)
	{
		this.type = type;
		this.name = name;
		adds = new LinkedList<>();
		on = new LinkedList<>();
		params = new LinkedList<>();
	}
		
	public ObjectType getType()
	{
		return type;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract void addADD(Add code);	
	public abstract void addDefine(Define define);
	public abstract void addOn(On on);

	public void addExpr(String key, Object value) {
		// TODO Auto-generated method stub
		
	}
}
