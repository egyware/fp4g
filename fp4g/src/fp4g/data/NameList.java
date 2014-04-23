package fp4g.data;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NameList implements Iterable<DeclVar>
{
	private final List<DeclVar> nameVars;
	public NameList()
	{
		nameVars = new LinkedList<DeclVar>();
	}
	
	public void add(DeclVar declVar)
	{
		nameVars.add(declVar);
	}
	
	public void add(VarType type, String name)
	{
		nameVars.add(new DeclVar(type,name));
	}
	public void add(VarType type, String name,IValue<?> initValue)
	{
		nameVars.add(new DeclVar(type,name,initValue));
	}
	
	public int size()
	{
		return nameVars.size();
	}
	
	@Override
	public Iterator<DeclVar> iterator() {
		return nameVars.iterator();
	}
}
