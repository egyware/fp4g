package fp4g.data.expresion;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.IDefine;
import fp4g.exceptions.CannotEvalException;
import fp4g.exceptions.DefineNotFoundException;

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
	public Literal<?> eval(IDefine define) throws CannotEvalException 
	{		
		//a que define accedo si no me sé el tipo?
		IDefine sub;
		if(VarDot.parent == varName)
		{
			sub = define.getParent();
		}else
		if(VarDot.current == varName)
		{
			sub = define;
		}else
		{
			try {
				sub = define.getDefine(varName);
			} catch (DefineNotFoundException e) {
				Log.Show(ErrType.VarNameNotFound, define, varName);
				throw new CannotEvalException(e,this);
			}
		}
		if(sub == null)
		{			
			Log.Show(ErrType.VarNameNotFound, define, varName);
			throw new CannotEvalException(this);
		}
		return property.eval(sub);
	}
}
