/**
 * 
 */
package fp4g.data;
import static fp4g.Log.Show;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fp4g.Log;
import fp4g.Log.ErrType;
import fp4g.Log.WarnType;
import fp4g.classes.MessageMethod;
import fp4g.data.define.Message;
import fp4g.data.expresion.ClassMap;

/**
 * @author egyware
 *
 */
public class On extends Code
{
	private static final Pattern methodValue = Pattern.compile("([a-z]+)([A-Z0-9][a-zA-Z0-9]*)?");
	public final String name;
	public final Message message;
	public final List<Source> sources;
	//On Message[:filter]  [...source...]
	public On(Message message) 
	{
		this.message = message;
		this.name = message.name;
		sources = new LinkedList<Source>();
	}
	/**
	 * En caso que no exista un mensaje predefinido
	 * @param name
	 */
	public On(String name) 
	{
		this.message = null;
		this.name = name;
		sources = new LinkedList<Source>();
	}
	
	public Source addSource(Statements statements)
	{
		Source source = new Source(statements);
		sources.add(source);
		return source;
	}	
	
	public final class Source
	{	
		public final List<Filter> filters;
		public final Statements statements;
		public Source(Statements statements)
		{
			this.filters = new LinkedList<Filter>();
			this.statements = statements;
		}
		
		@SuppressWarnings("unchecked")
		public void addFilter(List<String> listFilter)
		{
			//chequeamos que todos los filtros existan y que est�n definidos
			Filter filter = new Filter(listFilter.size());			
			for(String elementFilter:listFilter)
			{
				//extraer el metodo
				Matcher m = methodValue.matcher(elementFilter);
				String methodName = null,value = null;  
				
				if(m.matches())
				{
					methodName = m.group(1);
					value      = m.group(2);
					if(value != null && value.length() == 0)
					{
						value = null;
					}
				}				
				else
				{
					Show(WarnType.UnformatedFilter,elementFilter);
					methodName = elementFilter.toLowerCase();
				}
				
				ClassMap<MessageMethod> cm = (ClassMap<MessageMethod>) message.get(methodName);
				MessageMethod method = cm.getValue();
				if(method != null)
				{
					//setiando, los datos para que no webee m�s tarde (este mensaje no tiene validez, cambie algunas cosas y ya ni recuerdo porque dije eso)
					filter.add(method, value);					
				}
				else
				{
					Log.Show(ErrType.FilterMethodMissing);					
				}
			}
			filters.add(filter);
		}
	}
	public final static class Filter
	{	
		public final MessageMethod methods[]; //podria ser una lista de expresiones...
		public final String values[];
		private int lenght;
		public Filter(final int size)
		{					
			methods = new MessageMethod[size];
			values = new String[size];
		}		
		public void add(MessageMethod method, String value)
		{
			methods[lenght] = method;
			values[lenght] = value;
			lenght++;
		}
		public int lenght()
		{
			return lenght;
		}
	}
}
