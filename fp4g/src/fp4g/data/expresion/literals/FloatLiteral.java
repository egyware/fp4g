package fp4g.data.expresion.literals;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.expresion.BinaryOp;
import fp4g.data.expresion.Literal;
import fp4g.data.operators.IAddable;
import fp4g.data.operators.IComparable;
import fp4g.data.operators.IDivisible;
import fp4g.data.operators.IMultipliable;
import fp4g.data.operators.ISubtractable;
import fp4g.exceptions.CannotEvalException;

public class FloatLiteral extends Literal<Float> implements  IAddable, ISubtractable, IMultipliable, IDivisible, IComparable
{
	private final Float value;
	
	public FloatLiteral(Float value)
	{
		this.value = value;
	}
	
	@Override
	public Float getValue() 
	{		
		return value;
	}

	@Override
	public IValue<?> add(IValue<?> right) 
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new FloatLiteral(value.floatValue() + ((Integer)other).floatValue());
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Add));
		}		
	}

	@Override
	public IValue<?> mult(IValue<?> right)
	{
		Object other = right.getValue();
		if(other instanceof Integer)
		{
			return new FloatLiteral(value.floatValue() * ((Integer)other).floatValue());
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
			return new FloatLiteral(value.floatValue() / ((Integer)other).floatValue());
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
			return new FloatLiteral(value.floatValue() - ((Integer)other).floatValue());
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
			return (value.floatValue() < ((Number)other).floatValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
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
			return (value.floatValue() > ((Number)other).floatValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}			
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s", BinaryOp.OperatorType.Sub));
		}
	}

	@Override
	public BoolLiteral equals(IValue<?> right)	 
	{
		Object other = right.getValue();
		if(other instanceof Number)
		{
			return (value.floatValue() == ((Number)other).floatValue())?BoolLiteral.TRUE: BoolLiteral.FALSE;
		}			
		else
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, (Expresion)this, String.format("Operacion no valida para %s",BinaryOp.OperatorType.Sub));
		}
	}

}
