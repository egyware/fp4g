package fp4g.data.expresion.literals;

import fp4g.core.Expresion;
import fp4g.core.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.data.operators.IAddable;
import fp4g.data.operators.IComparable;
import fp4g.data.operators.IDivisible;
import fp4g.data.operators.IMultipliable;
import fp4g.data.operators.ISubtractable;
import fp4g.exceptions.CannotEvalException;

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
	public IValue<?> add(IValue<?> right) 
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s", BinaryOp.OperatorType. Add));
		}		
	}

	@Override
	public IValue<?> mult(IValue<?> right)
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Mult));
		}
	}

	@Override
	public IValue<?> div(IValue<?> right)
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Div));
		}
	}

	@Override
	public IValue<?> sub(IValue<?> right)
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Sub));
		}
	}

	@Override
	public BoolLiteral lessThan(IValue<?> right)	 
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() < ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Sub));
		}
	}

	@Override
	public BoolLiteral moreThan(IValue<?> right)	
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() > ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Sub));
		}
	}

	@Override
	public BoolLiteral equals(IValue<?> right)	
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.intValue() == ((Number)other).intValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}				
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Sub));
		}
	}

}
