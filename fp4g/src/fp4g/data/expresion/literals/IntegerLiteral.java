package fp4g.data.expresion.literals;

import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.data.operators.IAddable;
import fp4g.data.operators.IComparable;
import fp4g.data.operators.IDivisible;
import fp4g.data.operators.IMultipliable;
import fp4g.data.operators.ISubtractable;
import fp4g.exceptions.NotAllowedOperatorException;

public class IntegerLiteral extends Literal<Integer>
implements IAddable, ISubtractable, IMultipliable, IDivisible, IComparable
{
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
	public IValue<?> add(IValue<?> right) throws NotAllowedOperatorException 
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
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Add);
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
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Mult);
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
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Div);
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
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Sub);
		}
	}

	@Override
	public BoolLiteral lessThan(IValue<?> right)
	throws NotAllowedOperatorException 
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() < ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Sub);
		}
	}

	@Override
	public BoolLiteral moreThan(IValue<?> right)
	throws NotAllowedOperatorException 
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() > ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Sub);
		}
	}

	@Override
	public BoolLiteral equals(IValue<?> right)
	throws NotAllowedOperatorException 
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() == ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Sub);
		}
	}

}
