package fp4g.data.expresion.literals;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.NotAllowedOperatorException;

public class StringLiteral extends Literal<String> {
	private final String value;
	
	public StringLiteral(String value)
	{
		this.value = value;
	}
	
	@Override
	public String getValue() 
	{		
		return value;
	}

	@Override
	public IValue<?> sum(IValue<?> right) 
	{
		Object other = right.getValue();
		return new StringLiteral(value.concat(other.toString()));		
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
