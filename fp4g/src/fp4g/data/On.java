/**
 * 
 */
package fp4g.data;

import java.util.LinkedList;
import java.util.List;

import fp4g.Log;
import fp4g.Log.ErrType;

/**
 * @author egyware
 *
 */
public class On extends Code{
	public final String name;
	public final Define message;
	public final List<Source> sources;
	//On Message[:filter]  [...source...]
	public On(Define message) 
	{
		this.message = message;
		this.name = message.name;
		sources = new LinkedList<>();
	}
	/**
	 * En caso que no exista un mensaje predefinido
	 * @param name
	 */
	public On(String name) 
	{
		this.message = null;
		this.name = name;
		sources = new LinkedList<>();
	}
	
	//TODO falta el codigo del evento.
	public Source addSource()
	{
		Source source = new Source();
		sources.add(source);
		return source;
	}	
	
	public final class Source
	{		
		public final List<Filter> filters;
		public Source()
		{
			this.filters = new LinkedList<>();
		}
		
		public void addFilter(List<String> listFilter)
		{
			//chequeamos que todos los filtros existan y que estén definidos
			Filter filter = new Filter(listFilter);
			int i = 0;
			for(String elementFilter:listFilter)
			{
				if(message.isSet(elementFilter))
				{
					//setiando, los datos para que no webee más tarde
					filter.data[i++] = message.get(elementFilter);
				}
				else
				{
					Log.Show(ErrType.FilterMissing);
					return;
				}
			}
			filters.add(filter);
		}
	}
	public final static class Filter
	{
		public final String filters[];
		public final Object data[]; //podria ser una lista de expresiones...
		public Filter(List<String> filters)
		{
			final int size = filters.size();
			this.filters = new String[size];
			this.data = new Object[size];
			filters.toArray(this.filters);
		}		
	}
}
