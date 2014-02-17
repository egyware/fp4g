package fp4g.data;

/**
 * Esta interface encapsula un valor cualesquiera en FP4G.
 *
 * 
 * @author Edgardo
 *
 * @param <T> Cualquier valor en FP4G incluso los nativos de Java.
 */
public interface IValue<T>
{
	public abstract T getValue();	
}
