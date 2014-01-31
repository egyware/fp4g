package fp4g.data.expresion;

import fp4g.CannotEval;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;

/**
 * Esta clase corresponde a la operaci�n Variable.propiedad.
 * @author Edgardo
 *
 */
public class VarDot extends VarId
{		
	public final static String parent = "parent";
	public final static String current = "current";
	public final VarId property;
	public VarDot(VarId p)
	{		
		super(parent);
		property = p;
	}	
	public VarDot(String name,VarId p)
	{
		super(name);
		property = p;
	}	
	
	@Override
	public IValue<?> eval(IValue<?> current) throws CannotEvalException 
	{		
		//a que define accedo si no me s� el tipo?
		IValue<?> sub = null;
		if(VarDot.parent == varName)
		{
			sub = current.getParent();
		}else
		if(VarDot.current == varName)
		{
			sub = current;
		}else
		{
			if(current instanceof Map)
			{
				sub = ((Map)current).get(varName);				
			}
			else
			{
				throw new CannotEvalException(CannotEval.VarNameNotFound,this, String.format("No se encontro la variable \"%s\"",varName));
			}
		}
		if(sub == null)
		{			
			throw new CannotEvalException(CannotEval.VarNameNotFound,this, String.format("No se encontro la variable \"%s\"",varName));
		}
		return property.eval(sub);
	}
}
