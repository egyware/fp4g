package fp4g.data.expresion;

import fp4g.data.IValue;

public interface Map
{
	public void set(String key, IValue<?> value);
	public IValue<?> get(String key);
}
