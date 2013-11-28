package fp4g.data.expresion;

public interface Map {
	public Literal<?> set(String key, Literal<?> value);
	public Literal<?> get(String key);
}
