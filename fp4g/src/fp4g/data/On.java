/**
 * 
 */
package fp4g.data;

import java.util.LinkedList;
import java.util.List;

import fp4g.data.define.Message;
import fp4g.data.statements.Source;

/**
 * @author egyware
 *
 */
public class On extends Line
{
	public final String name;
	public final Message message;
	public final List<Source> sources;
	//ON (Message[:filter] (...source...))+
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
}
