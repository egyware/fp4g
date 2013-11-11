package fp4g.data.expresion;

import java.util.HashMap;
import java.util.Map;

import fp4g.data.Expresion;

public class ArrayExpr extends Expresion{
	private Map<String,Expresion> map;
	
	public ArrayExpr(String keys[],Expresion exprs[])
	{		
		map = new HashMap<>();
		for(int i=0;i<keys.length;i++)
		{
			map.put(keys[i], exprs[i]);
		}
	}
	
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
