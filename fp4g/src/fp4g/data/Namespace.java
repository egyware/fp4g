package fp4g.data;

import java.util.Collection;

import fp4g.data.expresion.BinaryOp;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.NotAllowedOperatorException;

public class Namespace implements IDefine
{
	private final DefineType type;
	private final IDefine parent;
	
	public Namespace(DefineType type,IDefine parent)
	{			
		this.type = type;
		this.parent = parent;
	}

	@Override
	public <T extends IDefine> T findDefine(String defineName) 
	{
		return parent.findDefine(type, defineName);
	}

	@Override
	public <T extends IDefine> T findDefine(DefineType defineType, String defineName) 
	{
		if(type != defineType)
		{
			return null;
		}
		else
		{
			return parent.findDefine(type,defineName);
		}
	}

	@Override
	public <T extends IDefine> Collection<T> getDefines(DefineType defineType) 
	{
		if(type != defineType)
		{
			return null;
		}
		else
		{
			return parent.getDefines(type);
		}
	}

	@Override
	public <T extends IDefine> boolean isSetDefine(DefineType defineType, String defineName) 
	{
		if(type != defineType)
		{
			return false;
		}
		else
		{
			return parent.isSetDefine(type,defineName);
		}
	}

	@Override
	public void setLine(int line) 
	{			
	}

	@Override
	public int getLine() 
	{
		return parent.getLine(); 
	}

	@Override
	public void setBuild(boolean b) 
	{		
	}

	@Override
	public boolean canBuild() 
	{
		return false;
	}

	@Override
	public DefineType getType() 
	{
		return parent.getType();
	}

	@Override
	public String getName() 
	{
		return parent.getName();
	}

	@Override
	public On getOn(String messageName) 
	{
		return parent.getOn(messageName);
	}

	@Override
	public IDefine getParent() 
	{
		return parent;
	}

	@Override
	public <T extends IDefine> void setDefine(T define) 
	{
		parent.setDefine(define);			
	}

	@Override
	public void setOn(On on) 
	{
		parent.setOn(on);			
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName)
	throws DefineNotFoundException 
	{
		T define = findDefine(defineName);
		if(define == null)
		{
			throw new DefineNotFoundException(defineName);
		}
		return define;
	}

	@Override
	public <T extends Define> T getDefine(DefineType defineType, String defineName)
	throws DefineNotFoundException 
	{
		if(type != defineType)
		{
			throw new DefineNotFoundException(defineName);
		}
		T define = getDefine(defineType, defineName);
		if(define == null)
		{
			throw new DefineNotFoundException(defineName);
		}
		return define;
	}

	@Override
	public void setAdd(Add add) 
	{
		parent.setAdd(add);			
	}

	@Override
	public void set(String key, IValue<?> eval) 
	{
		parent.set(key, eval);
	}
	
	@Override
	public IValue<?> get(String key) 
	{	
		Define define = findDefine(key);
		if(define != null)
		{
			return define;
		}
		return parent.getWithoutDefines(key);
	}
	
	@Override
	public IValue<?> getWithoutDefines(String key) 
	{	
		return parent.getWithoutDefines(key);
	}
	
	//IDefine implements

	@Override
	public IDefine getValue() 
	{
		return this;
	}

	
	public IValue<?> sum(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Add);
	}
	
	public IValue<?> mult(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Mult);
	}
	
	public IValue<?> div(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Div);
	}
	
	public IValue<?> sub(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.Type.Sub);
	}

}