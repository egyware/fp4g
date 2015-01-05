package fp4g.data.operators;

import fp4g.core.IValue;
import fp4g.data.expresion.literals.BoolLiteral;

public interface IComparable
{
	public BoolLiteral lessThan(IValue<?> right);
	public BoolLiteral moreThan(IValue<?> right);
	public BoolLiteral equals(IValue<?> right);
}