package fp4g.data.expresion.literals;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.NotAllowedOperatorException;

public class ObjectLiteral extends Literal<Object> {
	private final Object value;
	
	public ObjectLiteral(Object value)
	{
		this.value = value;
	}
	
	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);		
	}

	@Override
	public IValue<?> mult(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}

	@Override
	public IValue<?> div(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}

	@Override
	public IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException 
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}


}
