package fp4g.data.expresion;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Expresion;
import fp4g.data.IDefine;
import fp4g.data.IValue;
import fp4g.exceptions.CannotEvalException;

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
		if(parent == this)
		{
			if(container.getParent() == null)
			{
				//TODO Log.Show(ErrType.VarNameNotFound,define,varName);
				Log.Show(ErrorType.VarNameNotFound,varName);
			}
			return container.getParent();	
		}else
		if(current == this)
		{
			return container;
		}else
		{
			IValue<?> value = container.get(varName);
			if(value == null)
			{
				//TODO Log.Show(ErrType.VarNameNotFound,define,varName);
				Log.Show(ErrorType.VarNameNotFound,varName);
			}
			return value;
		}
	}
}
