package fp4g.data.expresion;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;

/**
 * Esta clase corresponde a la operación Variable.propiedad.
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
		//a que define accedo si no me sé el tipo?
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
				//TODO Log.Show(ErrType.VarNameNotFound, this, varName);
				Log.Show(ErrType.VarNameNotFound, varName);
				throw new CannotEvalException(this);
			}
		}
		if(sub == null)
		{			
			//TODO Log.Show(ErrType.VarNameNotFound, current, varName);
			Log.Show(ErrType.VarNameNotFound, varName);
			throw new CannotEvalException(this);
		}
		return property.eval(sub);
	}
}
