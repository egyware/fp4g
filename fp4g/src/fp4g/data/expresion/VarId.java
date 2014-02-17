package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.operators.IAccessible;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.NotAllowedOperatorException;
import fp4g.log.info.CannotEval;

/*
 * Una expresión que indica que se ha usado una variable.
 */
public class VarId extends Expresion
{
	public static final VarId parent = new VarId("parent");
	public static final VarId current = new VarId("current");
	public final String varName;
	public VarId(String name)
	{
		this.varName = name;
	}
	
	//TODO talvez seria bueno hacer que value get tuviese los valores puesto de current y parent
	@Override
	public IValue<?> eval(IValue<?> container) throws CannotEvalException 
	{
		if(!(container instanceof IAccessible))
		{
			throw new CannotEvalException(CannotEval.NotAllowedOperation,this,"Uno de los operandos de la expresión, no permite cierta operación get/getParent");
		}
		try
		{
			IAccessible contenedor = (IAccessible)container;
			if(parent == this)
			{
				if(contenedor.getParent() == null)
				{
					throw new CannotEvalException(CannotEval.VarNameNotFound,this,String.format("No se puede acceder al contenedor superior de la variable \"%s\"",varName));
				}
				return contenedor.getParent();	
			}else
			if(current == this)
			{
				return container;
			}else
			{
				IValue<?> value = contenedor.get(varName);
				if(value == null)
				{
					throw new CannotEvalException(CannotEval.VarNameNotFound,this,String.format("No se encontró la variable \"%s\"",varName));
				}
				return value;
			}
		}
		catch(NotAllowedOperatorException e)
		{
			throw new CannotEvalException(CannotEval.NotAllowedOperation,this,"Uno de los operandos de la expresión, no permite cierta operación",e);
		}
	}
}
