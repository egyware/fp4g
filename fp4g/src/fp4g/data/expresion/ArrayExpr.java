package fp4g.data.expresion;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Expresion;

public class ArrayExpr extends Expresion{
	private Map<String,Expresion> map;
	public ArrayExpr()
	{
		map = new HashMap<>();
	}
	
	public void set(String key,Expresion value)
	{
		map.put(key, value);
	}
	
	public Expresion get(String key)
	{
		return map.get(key);
	}
}
