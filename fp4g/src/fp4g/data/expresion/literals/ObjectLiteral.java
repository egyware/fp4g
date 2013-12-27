package fp4g.data.expresion.literals;

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
