/**
 * 
 */
package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.exceptions.NotAllowedOperatorException;

/**
 * @author Edgardo
 *
 */
public class DirectCode extends Expresion implements IValue<DirectCode> {
	public final String code;
	public DirectCode(String code)
	{
		this.code = code;
	}
	
	@Override
	public IValue<?> eval(IValue<?> define) 
	{
		return (IValue<?>) this;		
	}

	@Override
	public DirectCode getValue() 
	{
		return this;
	}

	@Override
	public IValue<?> get(String property) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValue<?> getParent() throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this, BinaryOp.Type.Sub);
	}

	@Override
	public IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this, BinaryOp.Type.Add);
	}

	@Override
	public IValue<?> mult(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this, BinaryOp.Type.Mult);
	}

	@Override
	public IValue<?> div(IValue<?> right) throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this, BinaryOp.Type.Div);
	}

	@Override
	public IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this, BinaryOp.Type.Sub);
	}	
}
