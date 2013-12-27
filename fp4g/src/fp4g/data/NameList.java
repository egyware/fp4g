package fp4g.data;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.data.expresion.Literal;



public class NameList implements Iterable<DeclVar>
{
	private final List<DeclVar> nameVars;
	public NameList()
	{
		nameVars = new LinkedList<DeclVar>();
	}
	public void add(VarType type, String name)
	{
		nameVars.add(new DeclVar(type,name));
	}
	public void add(VarType type, String name,Literal<?> initValue)
	{
		nameVars.add(new DeclVar(type,name,initValue));
	}
	@Override
	public Iterator<DeclVar> iterator() {
		return nameVars.iterator();
	}
}
