package fp4g.data.expresion;

import java.util.HashMap;

import fp4g.exceptions.NotAllowedOperatorException;

// tambi�n deberia ser literal
public final class ArrayMap extends Literal<Map> implements Map{
	private final java.util.Map<String,Literal<?>> map;
	
	public ArrayMap(String keys[],Literal<?> exprs[])
	{		
		map = new HashMap<String, Literal<?>>();		
		for(int i=0;i<keys.length;i++)
		{
			map.put(keys[i], exprs[i]);
		}
	}
	
	public ArrayMap()
	{
		map = new HashMap<String, Literal<?>>();
	}
	
	public Literal<?> get(String key)
	{
		return map.get(key);		
	}

		@Override
	public void set(String key, Literal<?> value) {
		map.put(key, value);
	}

	@Override
	public Map getValue() {
		return this;
	}
	
	@Override
	public Literal<?> sum(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);		
	}

	@Override
	public Literal<?> mult(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}

	@Override
	public Literal<?> div(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}

	@Override
	public Literal<?> sub(Literal<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}

}
