package fp4g.data;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.Pair;


//TODO agregar más adelante parametros por defecto
public class NameList implements Iterable<Pair<VarType,String>>{
	public final List<Pair<VarType,String>> nameVars;
	public NameList()
	{
		nameVars = new LinkedList<Pair<VarType, String>>();
	}
	public void add(VarType type, String name)
	{
		nameVars.add(new Pair<VarType, String>(type,name));
	}
	@Override
	public Iterator<Pair<VarType, String>> iterator() {
		return nameVars.iterator();
	}
}
