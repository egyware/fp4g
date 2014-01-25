package fp4g.data;

import fp4g.exceptions.NotAllowedOperatorException;


/**
 * Esta interface encapsula un valor cualesquiera en FP4G.
 * 
 * La interface permite realizar operaciones basicas como sumar y restar siempre y cuando el tipo encapsulado lo permita.
 * 
 * @author Edgardo
 *
 * @param <T> Cualquier valor en FP4G incluso los nativos de Java.
 */
public interface IValue<T>
{
	public abstract T getValue();
	
	
	public abstract IValue<?> get(String property); 
	public abstract IValue<?> getParent() throws NotAllowedOperatorException;
	public abstract IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException;
	public abstract IValue<?> mult(IValue<?> right)throws NotAllowedOperatorException;
	public abstract IValue<?> div(IValue<?> right) throws NotAllowedOperatorException;
	public abstract IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException;
}
