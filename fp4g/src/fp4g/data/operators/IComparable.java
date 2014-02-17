package fp4g.data.operators;

import fp4g.data.IValue;
import fp4g.data.expresion.literals.BoolLiteral;
import fp4g.exceptions.NotAllowedOperatorException;

public interface IComparable
{
	public BoolLiteral lessThan(IValue<?> right) throws NotAllowedOperatorException;
	public BoolLiteral moreThan(IValue<?> right) throws NotAllowedOperatorException;;
	public BoolLiteral equals(IValue<?> right) throws NotAllowedOperatorException;;
}