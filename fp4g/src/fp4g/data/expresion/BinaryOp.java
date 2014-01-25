package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.IncompatibleTypesException;

public class BinaryOp extends Expresion{
	public static enum Type
	{
		Add,
		Sub,
		Div,
		Mult
	}
	public final Type type;
	public final Expresion left;
	public final Expresion right;
	public BinaryOp(Type type,Expresion left,Expresion right)
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
		try
		{		
			//obtener el mayor autocasting posible byte->short->int->long , float->double
			//¿Como obtener el mayor autocasting posible?
			//1.- No se pueden comparar clases a menos que estén metidas en un map
			//2.- Hacer todas las combinaciones posibles tampoco me hace gracia.
			//3.- Hacer que los literables tengan sus propias funciones de sumar y restar.
			//3.1.- No me hace mucha gracia no saber para donde hacer autocasting, aunque este delagado a los literales.
			//3.2.- Lo bueno es que desaparece una incognita, bueno probaré.
			switch(type)
			{
			case Add:
				return leftR.sum(rightR);
			case Div:
				return leftR.div(rightR);				
			case Mult:
				return leftR.mult(rightR);				
			case Sub:
				return leftR.sub(rightR);
			default:
				return null;
			}
		}
		catch(ClassCastException e)
		{
			throw new IncompatibleTypesException(e,this);
		}		
	}
}
