package fp4g.data.expresion;

import fp4g.data.IValue;
import fp4g.data.operators.IAccessible;
import fp4g.exceptions.CannotEvalException;

/**
 * Esta clase corresponde a la operación Variable.propiedad.
 * @author Edgardo
 *
 */
public class VarDot extends VarId
{		
	public final static String current = "current";
	public final VarId property;		
	public VarDot(String name,VarId p)
	{
		super(name);
		property = p;
	}	
	
	@Override
	public IValue<?> eval(IValue<?> current) throws CannotEvalException 
	{		
		if(!(current instanceof IAccessible))
		{
			throw new CannotEvalException(CannotEvalException.Types.NotAllowedOperation,this,"Uno de los operandos de la expresión, no permite cierta operación get/getParent");
		}
		IValue<?> sub = null;			
		if(VarDot.current == varName)
		{
			sub = current;
		}else
		{				
			sub = ((IAccessible)current).get(varName);				
		}
		if(sub == null)
		{			
			throw new CannotEvalException(CannotEvalException.Types.VarNameNotFound, this, String.format("No se encontró la variable \"%s\"",varName));
		}
		return property.eval(sub);		
	}
}
