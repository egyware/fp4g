package fp4g.data.libs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Add;
import fp4g.data.Code;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.ILib;
import fp4g.data.IValue;
import fp4g.data.On;
import fp4g.data.expresion.BinaryOp;
import fp4g.exceptions.DefineNotFoundException;
import fp4g.exceptions.NotAllowedOperatorException;

public class LibContainer extends Code implements ILib, IDefine
{
	public final List<Lib> libs;
	
	public LibContainer()
	{	
		libs = new LinkedList<Lib>();		
	}
	
	public void addLib(Lib lib) {
		libs.add(lib);		
	}

	@Override
	public <T extends IDefine> T findDefine(String defineName) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IDefine> T findDefine(DefineType defineType,String defineName) 
	{		
		for(Lib lib:libs)
		{
			T define = lib.findDefine(defineType,defineName);
			if(define != null)
			{
				return define;
			}			
		}
		return null;
	}

	@Override
	public <T extends IDefine> Collection<T> getDefines(DefineType defineType) 
	{
		List<T> list = new LinkedList<T>();
		for(Lib lib:libs)
		{
			Collection<T> collection = lib.getDefines(defineType);
			if(collection != null)
			{
				list.addAll(collection);
			}
		}
		return list;
	}

	@Override
	public <T extends IDefine> boolean isSetDefine(DefineType type, String name) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	
	@Override
	public IValue<?> get(String key)
	{
		for(Lib lib:libs)
		{
			IValue<?> value = lib.get(key);
			if(value != null) return value;
		}
		return null;
	}
	
	//IDefine implements
	
	@Override
	public IValue<?> getWithoutDefines(String key) 
	{
		for(Lib lib:libs)
		{
			IValue<?> value = lib.getWithoutDefines(key);
			if(value != null) return value;
		}
		return null;
	}
	
	@Override
	public void set(String key, IValue<?> value) 
	{
		//TODO throw exception, never called
	}

	@Override
	public DefineType getType()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() 
	{
		return LibContainer.class.getSimpleName();
	}

	@Override
	public On getOn(String messageName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDefine getParent()
	{
		return null;
	}

	@Override
	public <T extends IDefine> void setDefine(T define) 
	{
		// TODO Auto-generated method stub		
	}

	@Override
	public void setOn(On on) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName)
	throws DefineNotFoundException 
	{
		for(Lib lib:libs)
		{
			T define = lib.findDefine(defineName);
			if(define != null) return define;
		}
		throw new DefineNotFoundException(defineName);
	}

	@Override
	public <T extends Define> T getDefine(DefineType type, String name)
	throws DefineNotFoundException 
	{
		for(Lib lib:libs)
		{
			T define = lib.findDefine(type,name);
			if(define != null) return define;
		}
		throw new DefineNotFoundException(type,name);
	}

	@Override
	public void setAdd(Add add) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public IDefine getValue() 
	{	
		return this;
	}
	
	public IValue<?> sum(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Add);
	}
	
	public IValue<?> mult(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Mult);
	}
	
	public IValue<?> div(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Div);
	}
	
	public IValue<?> sub(IValue<?> right)
	throws NotAllowedOperatorException
	{
		throw new NotAllowedOperatorException(this,BinaryOp.OperatorType.Sub);
	}
	
		
}
