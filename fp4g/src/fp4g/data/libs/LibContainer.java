package fp4g.data.libs;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.Add;
import fp4g.data.Define;
import fp4g.data.DefineType;
import fp4g.data.IDefine;
import fp4g.data.On;
import fp4g.data.define.Manager;
import fp4g.data.expresion.Literal;
import fp4g.exceptions.DefineNotFoundException;


public class LibContainer implements IDefine
{
	public final List<LibDefine> libs;
	
	public LibContainer()
	{	
		libs = new LinkedList<LibDefine>();		
	}
	
	public void addLib(LibDefine lib) {
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
		for(LibDefine lib:libs)
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
		for(LibDefine lib:libs)
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
	public <T extends IDefine> boolean isSetDefine(DefineType type, String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLine(int line) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLine() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBuild(boolean b) 
	{
		//nunca se compilará
	}

	@Override
	public boolean canBuild() 
	{	
		//nunca se compilará
		return false;
	}

	@Override
	public DefineType getType() 
	{
		//TODO tipo nulo?
		return null;
	}

	@Override
	public String getName() 
	{
		return LibContainer.class.getSimpleName();
	}

	@Override
	public On getOn(String messageName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends IDefine> void setDefine(T define) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setOn(On on) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T extends IDefine> T getDefine(String defineName) throws DefineNotFoundException 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Define> T getDefine(DefineType type, String name)
			throws DefineNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdd(Add add) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void set(String key, Literal<?> value) 
	{
		//TODO nada? error!!
	}

	@Override
	public Literal<?> get(String key)
	{
		for(LibDefine lib:libs)
		{
			Literal<?> value = lib.get(key);
			if(value != null) return value;
		}
		return null;
	}

	@Override
	public IDefine getParent() 
	{
		return null;
	}

	public void setManager(Manager manager)
	{
		setDefine(manager);
	}
		
}
