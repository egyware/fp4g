package fp4g.data.libs;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.DefineNotFoundException;

/**
 * Esta clase es una biblioteca, lamentablemente también se comporta como Define, pero sin serlo.
 * 
 * @author Edgardo
 *
 */
public class Lib extends LibDefine implements IDefine
{
	private final Map<String,Literal<?>> variables;
	
	public Lib()
	{
		super(null);
		variables = new HashMap<String,Literal<?>>();
	}
	
	@Override
	public DefineType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public On getOn(String messageName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOn(On on) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends Define> T getDefine(DefineType type, String name)
			throws DefineNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdd(Add add) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(String key, Literal<?> value)
	{
		variables.put(key, value);
	}
	
	@Override
	public Literal<?> get(String key) 
	{
		return variables.get(key);
	}
	
		
}
