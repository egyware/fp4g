package fp4g.data.expresion.literals;

import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.NotAllowedOperatorException;

public class BoolLiteral extends Literal<Boolean> 
{
	private final Boolean bool;
	
	public BoolLiteral(Boolean bool)
	{
		this.bool = bool;
	}
	@Override
	public Boolean getValue() 
	{		
		return bool;
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
