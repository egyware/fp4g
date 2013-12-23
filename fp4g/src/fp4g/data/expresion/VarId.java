package fp4g.data.expresion;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.data.Define;
import fp4g.data.Expresion;
import fp4g.exceptions.CannotEvalException;

/*
 * Una expresión que indica que se ha usado una variable.
 */
public class VarId extends Expresion{
	public static final VarId parent = new VarId("parent");
	public static final VarId current = new VarId("current");
	public final String varName;
	public VarId(String name)
	{
		this.varName = name;
	}
	
	@Override
	public Literal<?> eval(Define define) throws CannotEvalException 
	{
		if(parent == this)
		{
			if(define.parent == null)
			{
				Log.Show(ErrType.VarNameNotFound,define,varName);
			}
			return new CustomClassMap(define.parent);	
		}else
		if(current == this)
		{
			return new CustomClassMap(define);
		}else
		{
			Literal<?> value = define.get(varName);
			if(value == null)
			{
				Log.Show(ErrType.VarNameNotFound,define,varName);
			}
			return value;
		}
	}
}
