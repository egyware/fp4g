package fp4g.data;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.Pair;

public class NameList implements Iterable<Pair<String,String>>{
	public final List<Pair<String,String>> nameVars;
	public NameList()
	{
		nameVars = new LinkedList<>();
	}
	public void add(String name, String type)
	{
		nameVars.add(new Pair<>(name,type));
	}
	@Override
	public Iterator<Pair<String, String>> iterator() {
		return nameVars.iterator();
	}
}
