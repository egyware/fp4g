package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.operators.IAddable;
import fp4g.data.operators.IComparable;
import fp4g.data.operators.IDivisible;
import fp4g.data.operators.IMultipliable;
import fp4g.data.operators.ISubtractable;
import fp4g.exceptions.CannotEvalException;

public class BinaryOp implements Expresion
{
	public static enum OperatorType
	{
		Add,
		Sub,
		Div,
		Mult,
		LessThan,
		MoreThan,
		Equal;
	}
	
	public final OperatorType type;
	public final Expresion left;
	public final Expresion right;
	public BinaryOp(OperatorType type,Expresion left,Expresion right)
	{
		this.type = type;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public IValue<?> eval(IValue<?> define) throws CannotEvalException 
	{
		IValue<?>  leftR  = left.eval(define);
		IValue<?>  rightR = right.eval(define);		
		
		//obtener el mayor autocasting posible byte->short->int->long , float->double
		//¿Como obtener el mayor autocasting posible?
		//1.- No se pueden comparar clases a menos que estén metidas en un map
		//2.- Hacer todas las combinaciones posibles tampoco me hace gracia.
		//3.- Hacer que los literables tengan sus propias funciones de sumar y restar.
		//3.1.- No me hace mucha gracia no saber para donde hacer autocasting, aunque este delagado a los literales.
		//3.2.- Lo bueno es que desaparece una incognita, bueno probaré.
		//3.3.- Se vuelve muy tedioso al considera muchas cosas que son del mismo tipo, por ejemplo hoy agregé dos operadores y tengo que implementarlos en todas las clases hijas.
		//4.- Utilizar un map, tampoco es divertido por lo que habia dicho antes. Entonces que diablos hago, para mejorar este problema.
		//4.1.- Pensemos lo que hizo java: Java tiene dos interfaces que son utiles a la hora de comparar, como por ejemplo comparable y la otra no recuedo bien el nombre pero era para saber si eran iguales.
		//4.2.- Entonces podria implementar eso: IValue.Sumable, IValue.Containrable, IValue.Comparable (xD nombres qls)
		
		// notita: simplifique el uso de las excepciones  
		
		switch(type)
		{
		case Add:
			if(leftR instanceof IAddable  && rightR instanceof IAddable)
			{
				return ((IAddable)leftR).add(rightR);
			}
			else
			{					
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}				
		case Div:
			if(leftR instanceof IDivisible  && rightR instanceof IDivisible)
			{
				return ((IDivisible)leftR).div(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}
		case Mult:
			if(leftR instanceof IMultipliable  && rightR instanceof IMultipliable)
			{
				return ((IMultipliable)leftR).mult(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}
		case Sub:
			if(leftR instanceof ISubtractable  && rightR instanceof ISubtractable)
			{
				return ((ISubtractable)leftR).sub(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}
		case LessThan:
			if(leftR instanceof IComparable  && rightR instanceof IComparable)
			{
				return ((IComparable)leftR).lessThan(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}				
		case MoreThan:
			if(leftR instanceof IComparable  && rightR instanceof IComparable)
			{
				return ((IComparable)leftR).moreThan(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}
		case Equal:
			if(leftR instanceof IComparable  && rightR instanceof IComparable)
			{
				return ((IComparable)leftR).equals(rightR);
			}
			else
			{
				throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
			}				
		default:
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation, this,"Operación no valida para ".concat(type.name()));
		}		
	}
}
