package fp4g.data.expresion;


/**
 * Define un set/get personalizado
 * @author Edgardo
 *
 */
public interface CustomMap 
{
	public void set(String k,Literal<?> v);
	public Literal<?> get(String k);
}
