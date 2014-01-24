package fp4g.data.expresion.literals;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.NotAllowedOperatorException;

public class IntegerLiteral extends Literal<Integer> {
	private final Integer value;
	
	public IntegerLiteral(Integer value)
	{
		this.value = value;
	}
	
	@Override
	public Integer getValue() 
	{		
		return value;
	}

	@Override
	public IValue<?> sum(IValue<?> right) throws NotAllowedOperatorException 
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new IntegerLiteral(value.intValue() + ((Integer)other).intValue());
		}
		else
		if(other instanceof Float)
		{
			return new FloatLiteral(value.floatValue() + ((Float)other).floatValue());
		}
		else
		if(other instanceof String)
		{
			return new StringLiteral(value.toString().concat(other.toString()));
		}
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);
		}		
	}

	@Override
	public IValue<?> mult(IValue<?> right) throws NotAllowedOperatorException
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new IntegerLiteral(value.intValue() * ((Integer)other).intValue());
		}
		else
		if(other instanceof Float)
		{
			return new FloatLiteral(value.floatValue() * ((Float)other).floatValue());
		}		
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
		}
	}

	@Override
	public IValue<?> div(IValue<?> right) throws NotAllowedOperatorException
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new IntegerLiteral(value.intValue() / ((Integer)other).intValue());
		}
		else
		if(other instanceof Float)
		{
			return new FloatLiteral(value.floatValue() / ((Float)other).floatValue());
		}		
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
		}
	}

	@Override
	public IValue<?> sub(IValue<?> right) throws NotAllowedOperatorException
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new IntegerLiteral(value.intValue() - ((Integer)other).intValue());
		}
		else
		if(other instanceof Float)
		{
			return new FloatLiteral(value.floatValue() - ((Float)other).floatValue());
		}		
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
		}
	}

}
