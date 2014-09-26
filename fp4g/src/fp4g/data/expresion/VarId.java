package fp4g.data.expresion;

import fp4g.data.Expresion;
import fp4g.data.IValue;
import fp4g.data.operators.IAccessible;
import fp4g.exceptions.CannotEvalException;

/*
 * Una expresión que indica que se ha usado una variable.
 */
public class VarId implements Expresion
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
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation,this,"Uno de los operandos de la expresión, no permite cierta operación get/getParent");
		}
		
		IAccessible contenedor = (IAccessible)container;			
		if(current == this)
		{
			return container;
		}else
		{
			IValue<?> value = contenedor.get(varName);
			if(value == null)
			{
				throw new CannotEvalException(CannotEvalException.Types.VarNameNotFound, this, String.format("No se encontró la variable \"%s\"",varName));
			}
			return value;
		}		
	}
}
