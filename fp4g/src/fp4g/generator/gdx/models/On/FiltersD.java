package fp4g.generator.gdx.models.On;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fp4g.generator.Model;

public class FiltersD implements Model, Iterable<FiltersC>
{
	//que necesito acá. Por cada FilterS necesito:
	//Una lista de conjunciones
	private final LinkedList<FiltersC> conjunciones;
	
	public FiltersD()
	{
		conjunciones = new LinkedList<FiltersC>();
	}
	
	public List<FiltersC> getFiltersC()
	{
		return conjunciones;
	}

	@Override
	public Iterator<FiltersC> iterator()
	{
		return conjunciones.iterator();
	}
}