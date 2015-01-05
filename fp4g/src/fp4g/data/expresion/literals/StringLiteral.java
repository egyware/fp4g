package fp4g.data.expresion.literals;

import fp4g.core.IValue;
import fp4g.data.expresion.Literal;
import fp4g.data.operators.IAddable;
import fp4g.data.operators.IComparable;

public class StringLiteral extends Literal<String> implements IAddable, IComparable
{
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
	public BoolLiteral lessThan(IValue<?> right)	
	{
		if(value.compareTo(right.getValue().toString()) < 0)
		{
			return BoolLiteral.TRUE;
		}
		else
		{
			return BoolLiteral.FALSE;
		}		
	}

	@Override
	public BoolLiteral moreThan(IValue<?> right)	
	{
		if(value.compareTo(right.getValue().toString()) > 0)
		{
			return BoolLiteral.TRUE;
		}
		else
		{
			return BoolLiteral.FALSE;
		}
	}

	@Override
	public BoolLiteral equals(IValue<?> right)	
	{
		if(value.equals(right.getValue().toString()))
		{
			return BoolLiteral.TRUE;
		}
		else
		{
			return BoolLiteral.FALSE;
		}
	}

	@Override
	public IValue<?> add(IValue<?> right)
	{	
		return new StringLiteral(value.concat(right.getValue().toString()));
	}

}
