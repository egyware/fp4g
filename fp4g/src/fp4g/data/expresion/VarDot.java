package fp4g.data.expresion;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Define;

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
	public Literal<?> eval(Define define) 
	{		
		//a que define accedo si no me sé el tipo?
		Define sub;
		if(VarDot.parent == varName)
		{
			sub = define.parent;
		}else
		if(VarDot.current == varName)
		{
			sub = define;
		}else
		{
			sub = define.getDefine(varName);
		}
		if(sub == null)
		{
			Log.Show(ErrType.VarNameNotFound, define, varName);
		}
		return property.eval(sub);
	}
}
